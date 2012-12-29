package com.lzy.db.session;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import com.lzy.db.exception.SessionException;

public abstract class DBSession implements ISession {
	protected String DBUrl="";
	private Connection connection = null;
	private boolean auto = false;
	private PreparedStatement stmt = null;
	private ResultSet rs = null;
	public DBSession(String url){
		this.DBUrl = url;
	}
	
	protected abstract Connection createConnection()throws SQLException;
	
	public void open()throws SessionException{
		try{
			connection = createConnection();
		}catch(SQLException e){
			throw new SessionException(e.getMessage());
		}
	}
	
	public void close(){
		if(null != connection){
			try{connection.close(); connection=null;}catch(SQLException e){}
		}
	}
	
	public void begin()throws SessionException{
		try{
			auto = connection.getAutoCommit();
			connection.setAutoCommit(false);
		}catch(SQLException e){
			throw new SessionException(e.getMessage());
		}
	}
	
	public void commit()throws SessionException{
		try{
			connection.commit();
			connection.setAutoCommit(auto);
		}catch(SQLException e){
			throw new SessionException(e.getMessage());
		}
	}
	
	public void rollback()throws SessionException{
		try{
			connection.rollback();
			connection.setAutoCommit(auto);
		}catch(SQLException e){
			throw new SessionException(e.getMessage());
		}
	}
	
	public ResultSet query(String sql)throws SQLException{
		stmt = connection.prepareStatement(sql);
		stmt.execute();
		rs = stmt.getResultSet();
		return rs;
	}
	
	public void realse(){
		try{
			if(rs!=null){
				rs.close();
				rs = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		try{
			if(stmt!=null){
				stmt.close();
				stmt = null;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
	
	public void execute(String sql)throws SQLException{
		stmt = connection.prepareStatement(sql);
		stmt.execute();
	}
	
	public long nextId(String tbName)throws SQLException{
		CallableStatement stm = null;
		try{
			stm = connection.prepareCall("{?=call NEXTVAL(?)}");
			stm.registerOutParameter(1, Types.BIGINT);
			stm.setString(2, tbName);
			stm.execute();
			return stm.getLong(1);
		}catch(SQLException e){
			e.printStackTrace();
			throw e;
		}finally{
			try{
				if(stm!=null){stm.close();stm=null;}
			}catch(SQLException e){e.printStackTrace();}
		}
	}
}