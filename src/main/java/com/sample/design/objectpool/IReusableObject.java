package com.sample.design.objectpool;

public interface IReusableObject extends AutoCloseable {
	boolean isValid();

	void release();
}
