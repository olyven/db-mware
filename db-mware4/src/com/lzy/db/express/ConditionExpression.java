package com.lzy.db.express;

import com.lzy.db.util.FieldAttribute;

public interface ConditionExpression {
	String expression(FieldAttribute fieldAttr);
}
