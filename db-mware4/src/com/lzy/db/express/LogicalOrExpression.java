package com.lzy.db.express;


public class LogicalOrExpression extends AbstractLogicalExpression {
	
	public LogicalOrExpression(ConditionExpression a, ConditionExpression b) {
		super(a, b);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	protected String oparation() {
		// TODO Auto-generated method stub
		return "or";
	}
}
