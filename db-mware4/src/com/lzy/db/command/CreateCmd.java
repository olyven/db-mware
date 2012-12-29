package com.lzy.db.command;

import com.lzy.db.exception.OperationException;
import com.lzy.db.table.TableObject;
import com.lzy.db.util.FieldValue;

public class CreateCmd extends AbstractCmd {
	private FieldValue fieldValue;
	public CreateCmd(TableObject tbObj, FieldValue fieldValue){
		super(tbObj);
		this.fieldValue = fieldValue;
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return sql.insert(tbObj, fieldValue);
	}

}
