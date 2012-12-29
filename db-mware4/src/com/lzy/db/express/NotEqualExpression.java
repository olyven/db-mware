package com.lzy.db.express;

import java.util.Date;

public class NotEqualExpression extends AbstractCompareExpression {
	public NotEqualExpression(String key, String value){
		set(key, value);
	}
	public NotEqualExpression(String key, long value){
		set(key, value);
	}
	public NotEqualExpression(String key, int value){
		set(key, value);
	}
	public NotEqualExpression(String key, Date value){
		set(key, value);
	}
	public NotEqualExpression(String key, double value){
		set(key, value);
	}
	public NotEqualExpression(String key, float value){
		set(key, value);
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return "<>";
	}
}
