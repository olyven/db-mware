package com.lzy.db.express;

public class NullExpression extends AbstractCompareExpression {
	public NullExpression(String key){
		this.key = key;
		this.value = "IS NULL";
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return " ";
	}

}
