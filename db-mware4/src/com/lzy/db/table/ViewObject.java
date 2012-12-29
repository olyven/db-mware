package com.lzy.db.table;

public class ViewObject extends RecordFetcher{
	private String tbName;
	private String idName;
	public ViewObject(String className, String tbName, String idName) {
		super(className);
		// TODO Auto-generated constructor stub
		this.tbName = tbName;
		this.idName = idName;
	}
	public String getKey(){
		return attr2Field(idName);
	}
	public String getName(){
		return tbName;
	}

}
