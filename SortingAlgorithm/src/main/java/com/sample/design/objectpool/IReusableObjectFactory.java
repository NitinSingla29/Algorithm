package com.sample.design.objectpool;

public interface IReusableObjectFactory<R extends IReusableObject> {
	R createObject();
}
