package com.lzy.db.table;

import java.sql.ResultSet;

import com.lzy.db.exception.OperationException;

public interface IRecordFetcher {
	public Object fetch(ResultSet rs)throws OperationException;
}
