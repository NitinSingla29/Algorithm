package com.sample.design.objectpool;

public class OracleDBConnection extends Connection {

	private final IObjectPool<OracleDBConnection> connectionPool;
	private boolean closed;

	public OracleDBConnection(final IObjectPool<OracleDBConnection> connectionPool) {
		this.connectionPool = connectionPool;
	}

	@Override
	public void close() throws Exception {
		if (isValid()) {
			closed = true;
			System.out.println("Closing db connection : " + this);
		}
	}

	@Override
	public boolean isValid() {
		return !closed;
	}

	@Override
	protected IObjectPool<OracleDBConnection> getConnectionPool() {
		return connectionPool;
	}
}
