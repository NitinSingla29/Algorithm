package com.sample.design.objectpool;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ObjectPool<R extends IReusableObject> extends AbstractObjectPool<R> implements IObjectPool<R> {

	private final LinkedHashMap<R, Long> freeObjects = new LinkedHashMap<>();
	private final Long MAX_EXPIRY;

	private final long POOL_SIZE;
	private final IReusableObjectFactory<R> reusableObjectFactory;
	private final HashMap<R, Long> usedObjects = new HashMap<>();

	public ObjectPool(IReusableObjectFactory<R> reusableObjectFactory, long POOL_SIZE, final Long MAX_EXPIRY) {
		super();
		this.reusableObjectFactory = reusableObjectFactory;
		this.POOL_SIZE = POOL_SIZE;
		this.MAX_EXPIRY = MAX_EXPIRY;
	}

	@Override
	protected void clearFreeObject() {
		this.freeObjects.clear();

	}

	@Override
	protected void clearUsedObjects() {
		this.usedObjects.clear();
	}

	@Override
	protected void freeObject(R reusableObject) {
		final Long objectTimeStamp = getUsedObjects().remove(reusableObject);
		if (objectTimeStamp != null) {
			getFreeObjects().put(reusableObject, currentTime());
		}
	}

	@Override
	protected R getValidFreeObject() {
		if (getFreeObjects().size() > 0) {
			final Set<Entry<R, Long>> entrySet = getFreeObjects().entrySet();
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
		return null;
	}

	protected boolean isEntryExpired(Map.Entry<R, Long> entry) {
		return currentTime() - entry.getValue() > MAX_EXPIRY;
	}

	@Override
	protected void refillPool() {
		while (getFreeObjects().size() < POOL_SIZE) {
			getFreeObjects().put(reusableObjectFactory.createObject(), currentTime());
		}
	}

	private long currentTime() {
		return System.currentTimeMillis();
	}

	private LinkedHashMap<R, Long> getFreeObjects() {
		return freeObjects;
	}

	private HashMap<R, Long> getUsedObjects() {
		return usedObjects;
	}

}
