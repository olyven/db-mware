package com.lzy.db.express;

import java.util.Date;

public class MoreEqualExpression extends AbstractCompareExpression {
	public MoreEqualExpression(String key, String value){
		set(key, value);
	}
	public MoreEqualExpression(String key, long value){
		set(key, value);
	}
	public MoreEqualExpression(String key, int value){
		set(key, value);
	}
	public MoreEqualExpression(String key, Date value){
		set(key, value);
	}
	public MoreEqualExpression(String key, double value){
		set(key, value);
	}
	public MoreEqualExpression(String key, float value){
		set(key, value);
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return ">=";
	}
}
