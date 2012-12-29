package com.lzy.db.session;

import com.lzy.db.exception.SessionException;

public interface ISession {
	void close();
	void open()throws SessionException;
	void rollback()throws SessionException;
	void commit()throws SessionException;
	void begin()throws SessionException;
}
