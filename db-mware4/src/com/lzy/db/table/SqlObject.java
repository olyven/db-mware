package com.lzy.db.table;


public class SqlObject extends RecordFetcher{
	private String sql;
	public SqlObject(String className, String sql) {
		super(className);
		// TODO Auto-generated constructor stub
		this.sql = sql;
	}
	
	public String getSql(){
		return sql;
	}
}
