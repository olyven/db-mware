package com.lzy.db.or;

import java.sql.SQLException;

import com.lzy.db.CommandFactory;
import com.lzy.db.ICommand;
import com.lzy.db.exception.OperationException;
import com.lzy.db.express.EqualExpression;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.TableObject;
import com.lzy.db.util.FieldValue;

public class WritableHelper extends ReadableHelper {
	private TableObject tbObj;
	public WritableHelper(TableObject tbObj){
		super(tbObj);
		this.tbObj = tbObj;
	}
	public long create(DBSession session, Object obj)throws OperationException{
		CommandFactory factory = new CommandFactory();
		FieldValue fv = tbObj.fieldValue(obj);
		long id = createKeyValue(session);
		fv.add(tbObj.getKey(), id);
		ICommand cmd = factory.create(tbObj, fv);
		cmd.execute(session);
		return id;
	}
	public void remove(DBSession session, long keyValue)throws OperationException{
		CommandFactory factory = new CommandFactory();
		ICommand cmd = factory.create(tbObj, new EqualExpression(tbObj.getKey(), keyValue));
		cmd.execute(session);
	}
	public void modify(DBSession session, Object obj)throws OperationException{
		CommandFactory factory = new CommandFactory();
		FieldValue fv = tbObj.fieldValue(obj);
		String key = tbObj.getKey();
		long value = 0;
		try{
			value = Long.parseLong(fv.value(key));
		}catch(NumberFormatException e){
			e.printStackTrace();
			throw new OperationException("主键为非法值");
		}
		ICommand cmd = factory.create(tbObj, fv, new EqualExpression(key, value));
		cmd.execute(session);
	}
	private long createKeyValue(DBSession session)throws OperationException{
		try{
			return session.nextId(tbObj.getName());
		}catch(SQLException e){
			e.printStackTrace();
			throw new OperationException(e.getMessage());
		}
	}
}
