package com.lzy.db.retrieve;

import com.lzy.db.exception.OperationException;
import com.lzy.db.table.SqlObject;

public class SqlPageRetriever extends PageRetriever {
	private SqlObject sqlObj;
	public SqlPageRetriever(SqlObject sqlObj, int page, int max) {
		super(page, max, sqlObj);
		// TODO Auto-generated constructor stub
		this.sqlObj = sqlObj;
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return sqlObj.getSql();
	}

}
