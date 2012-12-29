package com.lzy.db.express;

import java.util.Date;

public class EqualExpression extends AbstractCompareExpression {
	public EqualExpression(String key, String value){
		set(key, value);
	}
	public EqualExpression(String key, long value){
		set(key, value);
	}
	public EqualExpression(String key, int value){
		set(key, value);
	}
	public EqualExpression(String key, Date value){
		set(key, value);
	}
	public EqualExpression(String key, double value){
		set(key, value);
	}
	public EqualExpression(String key, float value){
		set(key, value);
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return "=";
	}
}
