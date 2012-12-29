package com.lzy.db.retrieve;

import com.lzy.db.exception.OperationException;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.IRecordFetcher;

public abstract class PageRetriever extends AbstractRetriever {
	private int page;
	private int max;
	public PageRetriever(int page, int max, IRecordFetcher fetcher){
		super(fetcher);
		this.page = page;
		this.max = max;
	}
	@Override
	public Object retrieve(DBSession session)throws OperationException{
		// TODO Auto-generated method stub
		return tool.sqlSearch(session, fetcher, page, max, sql());
	}
}
