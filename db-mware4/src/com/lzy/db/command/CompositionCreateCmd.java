package com.lzy.db.command;

import com.lzy.db.ICommand;
import com.lzy.db.exception.OperationException;
import com.lzy.db.table.RelationshipObject;

public class CompositionCreateCmd implements ICommand {

	public CompositionCreateCmd(RelationshipObject rsObj) {
		super(rsObj);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return null;
	}

}
