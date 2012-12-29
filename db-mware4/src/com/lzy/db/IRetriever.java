package com.lzy.db;

import com.lzy.db.exception.OperationException;
import com.lzy.db.session.DBSession;

public interface IRetriever {
	Object retrieve(DBSession session)throws OperationException;
}
