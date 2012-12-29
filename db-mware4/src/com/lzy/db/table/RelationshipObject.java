package com.lzy.db.table;

public class RelationshipObject extends TableObject {
	private String mKey;
	private String sKey;
	private TableObject tbObj;
	public RelationshipObject(String className, String tbName, String idName, String mKey, String sKey, TableObject tbObj) {
		super(className, tbName, idName);
		// TODO Auto-generated constructor stub
		this.mKey = mKey;
		this.sKey = sKey;
		this.tbObj = tbObj;
	}
	public TableObject getScondaryTable(){
		return tbObj;
	}
	public String getMKey(){
		return mKey;
	}
	public String getSKey(){
		return sKey;
	}
}
