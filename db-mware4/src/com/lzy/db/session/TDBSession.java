package com.lzy.db.session;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TDBSession extends DBSession {
	public TDBSession(String url) {
		super(url);
		// TODO Auto-generated constructor stub
	}

	@Override
	protected Connection createConnection() throws SQLException {
		// TODO Auto-generated method stub
		try{
			DataSource ds = null;
			InitialContext ctx = new InitialContext();
			ds = (DataSource)ctx.lookup(DBUrl);
			return ds.getConnection();
		}catch(NamingException e){
			throw new SQLException(e.getMessage());
		}
	}
}
