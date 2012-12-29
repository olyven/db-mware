package com.lzy.db.command;

import com.lzy.db.exception.OperationException;
import com.lzy.db.express.ConditionExpression;
import com.lzy.db.table.TableObject;
import com.lzy.db.util.FieldValue;

public class UpdateCmd  extends AbstractCmd{
	private FieldValue fieldValue;
	private ConditionExpression cndt;
	public UpdateCmd(TableObject tbObj, FieldValue fieldValue, ConditionExpression cndt){
		super(tbObj);
		this.fieldValue = fieldValue;
		this.cndt = cndt;
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return sql.update(tbObj, fieldValue, cndt);
	}

}
