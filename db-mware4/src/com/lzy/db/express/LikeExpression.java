package com.lzy.db.express;


public class LikeExpression extends AbstractCompareExpression {
	public LikeExpression(String key, String value){
		set(key, value);
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return " like ";
	}

}
