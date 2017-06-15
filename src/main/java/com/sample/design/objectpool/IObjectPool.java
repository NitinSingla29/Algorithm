package com.sample.design.objectpool;

/**
 * It represent an object pool
 *
 * @author nitin.singla
 *
 */
public interface IObjectPool<R extends IReusableObject> {

	R get();

	void refresh();

	void release(R reusableObject);
}
