package com.lzy.db.util;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;


public class FieldAttribute {
	private Map<String,String> fas = new HashMap<String,String>();
	private Map<String,String> afs = new HashMap<String,String>();
	public Set<String> getFields(){
		return fas.keySet();
	}
	public Set<String> getAttrs(){
		return afs.keySet();
	}
	public String attr2Field(String attr){
		return afs.get(attr);
	}
	public String field2Attr(String field){
		return fas.get(field);
	}
	//当属性名与字段名相同时，只需要提供字段名
	public void addFieldAttr(String fieldName){
		addFieldAttr(fieldName, fieldName);
	}
	//当属性名与字段名不相同时，则需要提供字段名和属性名
	public void addFieldAttr(String fieldName, String attrName){
		//如果字段名已存在,且属性名不同时，则更新属性名
		fas.put(fieldName, attrName);
		afs.put(attrName, fieldName);
	}
}
