package com.lzy.db.retrieve;

import com.lzy.db.exception.OperationException;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.IRecordFetcher;

public abstract class ListRetriever extends AbstractRetriever {
	public ListRetriever(IRecordFetcher fetcher) {
		super(fetcher);
		// TODO Auto-generated constructor stub
	}

	@Override
	public Object retrieve(DBSession session) throws OperationException {
		// TODO Auto-generated method stub
		return tool.sqlSearch(session, fetcher, sql());
	}
}
