package com.lzy.db.command;

import com.lzy.db.exception.OperationException;
import com.lzy.db.express.ConditionExpression;
import com.lzy.db.table.TableObject;

public class DeleteCmd extends AbstractCmd {
	private ConditionExpression cndt;
	public DeleteCmd(TableObject tbObj, ConditionExpression cndt){
		super(tbObj);
		this.cndt = cndt;
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return sql.delete(tbObj, cndt);
	}

}
