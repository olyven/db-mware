package com.lzy.app.bz;

import com.lzy.db.exception.OperationException;
import com.lzy.db.exception.SessionException;
import com.lzy.db.session.ISession;
import com.lzy.util.Result;
import com.lzy.util.impl.ResultImpl;

public abstract class AbstractBz {
	public Result service(){
		ResultImpl r = new ResultImpl();
		ISession session = getSession();
		try{
			session.open();
			session.begin();
			r.setObject(execute(session));
			session.commit();
			return r;
		}catch(SessionException e){
			e.printStackTrace();
			r.setId(1);
			r.setMessage("数据库操作失败！");
			return r;
		}catch(OperationException e){
			e.printStackTrace();
			try{
				session.rollback();
			}catch(SessionException e2){e2.printStackTrace();}
			r.setId(2);
			r.setMessage(e.getMessage());
			return r;
		}finally{
			session.close();
		}
	}
	
	protected abstract Object execute(ISession session)throws OperationException;
	
	protected abstract ISession getSession();
}
