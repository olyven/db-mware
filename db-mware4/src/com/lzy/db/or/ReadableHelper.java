package com.lzy.db.or;

import com.lzy.db.IRetriever;
import com.lzy.db.RetrieverFactory;
import com.lzy.db.exception.OperationException;
import com.lzy.db.express.ConditionExpression;
import com.lzy.db.express.EqualExpression;
import com.lzy.db.orderby.OrderByExpression;
import com.lzy.db.session.DBSession;
import com.lzy.db.table.ViewObject;
import com.lzy.util.ObjectList;
import com.lzy.util.ObjectPage;

public class ReadableHelper {
	protected ViewObject vwObj;
	public ReadableHelper(ViewObject vwObj){
		this.vwObj = vwObj;
	}
	@SuppressWarnings("rawtypes")
	public ObjectList list(DBSession session, ConditionExpression cndtExp, OrderByExpression orderExp)throws OperationException{
		RetrieverFactory factory = new RetrieverFactory();
		IRetriever retriever = factory.create(vwObj, cndtExp, orderExp);
		return (ObjectList)retriever.retrieve(session);
	}
	@SuppressWarnings("rawtypes")
	public ObjectPage list(DBSession session, int page, int max, ConditionExpression cndtExp, OrderByExpression orderExp)throws OperationException{
		RetrieverFactory factory = new RetrieverFactory();
		IRetriever retriever = factory.create(vwObj,page, max, cndtExp, orderExp);
		return (ObjectPage)retriever.retrieve(session);
	}
	@SuppressWarnings("rawtypes")
	public Object findByKey(DBSession session, long keyValue)throws OperationException{
		String key = vwObj.getKey();
		ObjectList ol = list(session, new EqualExpression(key, keyValue), null);
		if(ol.size()>0){
			return ol.get(0);
		}
		return null;
	}
}
