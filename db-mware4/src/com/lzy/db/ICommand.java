package com.lzy.db;

import com.lzy.db.exception.OperationException;
import com.lzy.db.session.DBSession;

public interface ICommand {
	void execute(DBSession session)throws OperationException;
}
