package com.sample.design.objectpool;

@SuppressWarnings({ "rawtypes", "unchecked" })
public abstract class Connection implements IReusableObject {

	@Override
	public void close() throws Exception {
		System.out.println("Closing connection : " + this);
	}

	@Override
	public void release() {
		getConnectionPool().release(this);
	}

	protected abstract IObjectPool getConnectionPool();
}
