package com.lzy.db.orderby;

import com.lzy.db.util.FieldAttribute;

public class AscOrder implements OrderBy {
	private String name;
	public AscOrder(String name){
		this.name = name;
	}
	@Override
	public String orderString(FieldAttribute fieldAttr) {
		// TODO Auto-generated method stub
		String tmp = fieldAttr.attr2Field(name);
		if(tmp!=null && tmp.trim().length()>0){
			return tmp.trim() + " asc";
		}else{
			return "";
		}
	}
}
