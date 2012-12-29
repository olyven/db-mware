package com.lzy.db.retrieve;

import com.lzy.db.IRetriever;
import com.lzy.db.exception.OperationException;
import com.lzy.db.table.IRecordFetcher;
import com.lzy.db.util.SQLExecuteTool;
import com.lzy.db.util.SQLStringMaker;

public abstract class AbstractRetriever implements IRetriever {
	protected static SQLExecuteTool tool = new SQLExecuteTool();
	protected static SQLStringMaker sql = new SQLStringMaker();
	protected IRecordFetcher fetcher;
	public AbstractRetriever(IRecordFetcher fetcher){
		this.fetcher = fetcher;
	}
	protected abstract String sql()throws OperationException;
}
