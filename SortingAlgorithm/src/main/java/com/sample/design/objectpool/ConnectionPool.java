package com.sample.design.objectpool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ConnectionPool<R extends IReusableObject> implements IObjectPool<R> {

	private final Lock l = new ReentrantLock();
	private final IReusableObjectFactory<R> reusableObjectFactory;
	private final Long MAX_EXPIRY;

	private final LinkedHashMap<R, Long> freeObjects = new LinkedHashMap<>();
	private final HashMap<R, Long> usedObjects = new HashMap<>();
	private final long POOL_SIZE;

	public ConnectionPool(IReusableObjectFactory<R> reusableObjectFactory, long POOL_SIZE, final Long MAX_EXPIRY) {
		super();
		this.reusableObjectFactory = reusableObjectFactory;
		this.POOL_SIZE = POOL_SIZE;
		this.MAX_EXPIRY = MAX_EXPIRY;
	}

	@Override
	public synchronized R get() {
		try {
			l.lock();
			if (freeObjects.size() > 0) {
				final Set<Entry<R, Long>> entrySet = freeObjects.entrySet();
				final Iterator<Entry<R, Long>> iterator = entrySet.iterator();
				while (iterator.hasNext()) {
					final Map.Entry<R, Long> entry = iterator.next();
					final R pooledObject = entry.getKey();
					if (pooledObject.isValid() && !isEntryExpired(entry)) {
						return pooledObject;
					} else {
						iterator.remove();
					}
				}
			}
			this.refresh();
			return this.get();
		} finally {
			l.unlock();
		}
	}

	@Override
	public synchronized void refresh() {
		try {
			l.lock();
			this.freeObjects.clear();
			this.usedObjects.clear();
			while (freeObjects.size() < POOL_SIZE) {
				freeObjects.put(reusableObjectFactory.createObject(), currentTime());
			}
		} finally {
			l.unlock();
		}
	}

	@Override
	public void release(R reusableObject) {
		try {
			l.lock();
			final Long objectTimeStamp = usedObjects.remove(reusableObject);
			if (objectTimeStamp != null) {
				freeObjects.put(reusableObject, currentTime());
			}
			reusableObject.close();
		} catch (final Exception e) {
			System.out.println("Failed to close the pooled object " + reusableObject);
		} finally {
			l.unlock();
		}
	}

	private long currentTime() {
		return System.currentTimeMillis();
	}

	private boolean isEntryExpired(Map.Entry<R, Long> entry) {
		return currentTime() - entry.getValue() > MAX_EXPIRY;
	}

}
