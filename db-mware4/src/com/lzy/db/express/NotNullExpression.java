package com.lzy.db.express;


public class NotNullExpression extends AbstractCompareExpression {
	
	public NotNullExpression(String key){
		this.key=key;
		this.value = "IS NOT NULL";
	}
	@Override
	protected String getOperation() {
		// TODO Auto-generated method stub
		return " ";
	}

}
