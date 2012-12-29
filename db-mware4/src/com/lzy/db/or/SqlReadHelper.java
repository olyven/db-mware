package com.lzy.db.or;

import com.lzy.db.IRetriever;
import com.lzy.db.RetrieverFactory;
import com.lzy.db.exception.OperationException;
import com.lzy.db.express.ConditionExpression;
import com.lzy.db.orderby.OrderByExpression;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.SqlObject;
import com.lzy.util.ObjectList;
import com.lzy.util.ObjectPage;

public class SqlReadHelper {
	protected SqlObject sqlObj;
	public SqlReadHelper(SqlObject sqlObj){
		this.sqlObj = sqlObj;
	}
	@SuppressWarnings("rawtypes")
	public ObjectList list(DBSession session, ConditionExpression cndtExp, OrderByExpression orderExp)throws OperationException{
		RetrieverFactory factory = new RetrieverFactory();
		IRetriever retriever = factory.create(sqlObj);
		return (ObjectList)retriever.retrieve(session);
	}
	@SuppressWarnings("rawtypes")
	public ObjectPage list(DBSession session, int page, int max, ConditionExpression cndtExp, OrderByExpression orderExp)throws OperationException{
		RetrieverFactory factory = new RetrieverFactory();
		IRetriever retriever = factory.create(sqlObj,page, max);
		return (ObjectPage)retriever.retrieve(session);
	}
}
