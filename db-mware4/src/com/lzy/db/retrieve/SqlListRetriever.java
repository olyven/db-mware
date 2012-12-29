package com.lzy.db.retrieve;

import com.lzy.db.exception.OperationException;
import com.lzy.db.table.SqlObject;

public class SqlListRetriever extends ListRetriever {
	private SqlObject sqlObj;
	public SqlListRetriever(SqlObject sqlObj) {
		super(sqlObj);
		// TODO Auto-generated constructor stub
		this.sqlObj = sqlObj;
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return sqlObj.getSql();
	}

}
