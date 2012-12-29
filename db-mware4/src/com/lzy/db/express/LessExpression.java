package com.lzy.db.express;

import java.util.Date;

public class LessExpression extends AbstractCompareExpression {
	public LessExpression(String key, String value){
		set(key, value);
	}
	public LessExpression(String key, long value){
		set(key, value);
	}
	public LessExpression(String key, int value){
		set(key, value);
	}
	public LessExpression(String key, Date value){
		set(key, value);
	}
	public LessExpression(String key, double value){
		set(key, value);
	}
	public LessExpression(String key, float value){
		set(key, value);
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return "<";
	}
}
