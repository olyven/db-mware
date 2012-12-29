package com.lzy.db.express;

import java.util.Date;

public class MoreExpression extends AbstractCompareExpression {
	public MoreExpression(String key, String value){
		set(key, value);
	}
	public MoreExpression(String key, long value){
		set(key, value);
	}
	public MoreExpression(String key, int value){
		set(key, value);
	}
	public MoreExpression(String key, Date value){
		set(key, value);
	}
	public MoreExpression(String key, double value){
		set(key, value);
	}
	public MoreExpression(String key, float value){
		set(key, value);
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return ">";
	}
}
