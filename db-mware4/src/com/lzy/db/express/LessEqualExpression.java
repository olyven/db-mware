package com.lzy.db.express;

import java.util.Date;

public class LessEqualExpression extends AbstractCompareExpression {
	public LessEqualExpression(String key, String value){
		set(key, value);
	}
	public LessEqualExpression(String key, long value){
		set(key, value);
	}
	public LessEqualExpression(String key, int value){
		set(key, value);
	}
	public LessEqualExpression(String key, Date value){
		set(key, value);
	}
	public LessEqualExpression(String key, double value){
		set(key, value);
	}
	public LessEqualExpression(String key, float value){
		set(key, value);
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return "<=";
	}
}
