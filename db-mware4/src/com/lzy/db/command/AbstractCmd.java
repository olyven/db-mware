package com.lzy.db.command;

import com.lzy.db.ICommand;
import com.lzy.db.exception.OperationException;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.TableObject;
import com.lzy.db.util.SQLExecuteTool;
import com.lzy.db.util.SQLStringMaker;

public abstract class AbstractCmd implements ICommand {
	private static SQLExecuteTool tool = new SQLExecuteTool();
	protected static SQLStringMaker sql = new SQLStringMaker();
	protected TableObject tbObj;
	public AbstractCmd(TableObject tbObj){
		this.tbObj = tbObj;
	}
	@Override
	public void execute(DBSession session) throws OperationException {
		// TODO Auto-generated method stub
		tool.execute(session, sql());
	}
	protected abstract String sql()throws OperationException;

}
