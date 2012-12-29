package com.lzy.db.express;

import com.lzy.db.util.FieldAttribute;

public abstract class AbstractLogicalExpression implements LogicalExpression {
	protected ConditionExpression a;
	protected ConditionExpression b;
	public AbstractLogicalExpression(ConditionExpression a, ConditionExpression b){
		this.a = a;
		this.b = b;
	}
	public String expression(FieldAttribute fieldAttr){
		return "("+a.expression(fieldAttr)+")"+oparation()+"("+b.expression(fieldAttr)+")";
	}
	protected abstract String oparation();
}
