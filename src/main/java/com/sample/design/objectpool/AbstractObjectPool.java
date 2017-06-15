package com.sample.design.objectpool;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public abstract class AbstractObjectPool<R extends IReusableObject> implements IObjectPool<R> {

	private final Lock l = new ReentrantLock();

	@Override
	public synchronized R get() {
		try {
			l.lock();
			final R validFreeObject = getValidFreeObject();
			if (validFreeObject != null) {
				return validFreeObject;
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
			clearFreeObject();
			clearUsedObjects();
			refillPool();
		} finally {
			l.unlock();
		}
	}

	@Override
	public void release(R reusableObject) {
		try {
			l.lock();
			freeObject(reusableObject);
			reusableObject.close();
		} catch (final Exception e) {
			System.out.println("Failed to close the pooled object " + reusableObject);
		} finally {
			l.unlock();
		}
	}

	protected abstract void clearFreeObject();

	protected abstract void clearUsedObjects();

	protected abstract void freeObject(R objectToFree);

	protected abstract R getValidFreeObject();

	protected abstract void refillPool();
}
