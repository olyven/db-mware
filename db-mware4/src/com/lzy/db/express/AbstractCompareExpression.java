package com.lzy.db.express;

import java.util.Date;

import com.lzy.db.util.Any2String;
import com.lzy.db.util.FieldAttribute;

public abstract class AbstractCompareExpression implements CompareExpression {
	protected String op;
	protected String key;
	protected String value;
	private Any2String any = new Any2String();
	@Override
	public String expression(FieldAttribute fieldAttr) {
		// TODO Auto-generated method stub
		return fieldAttr.attr2Field(key) + getOperation() + value;
	}
	
	protected abstract String getOperation();
	
	protected void set(String key, String value){
		this.key = key;
		this.value = any.toString(value);
	}
	protected void set(String key, Long value){
		this.key = key;
		this.value = any.toString(value);
	}
	protected void set(String key, Integer value){
		this.key = key;
		this.value = any.toString(value);
	}
	protected void set(String key, Date value){
		this.key = key;
		this.value = any.toString(value);
	}
	protected void set(String key, Double value){
		this.key = key;
		this.value = any.toString(value);
	}
	protected void set(String key, Float value){
		this.key = key;
		this.value = any.toString(value);
	}
	protected void set(String key, Boolean value){
		this.key = key;
		this.value = any.toString(value);
	}
}
