package com.lzy.db.orderby;

import com.lzy.db.util.FieldAttribute;

public class DescOrder implements OrderBy {
	private String name;
	public DescOrder(String name){
		this.name = name;
	}
	@Override
	public String orderString(FieldAttribute fieldAttr) {
		// TODO Auto-generated method stub
		String tmp = fieldAttr.attr2Field(name);
		if(tmp!=null && tmp.trim().length()>0){
			return tmp.trim() + " desc";
		}else{
			return "";
		}
	}
}
