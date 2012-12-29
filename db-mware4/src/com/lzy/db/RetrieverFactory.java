package com.lzy.db;

import com.lzy.db.express.ConditionExpression;
import com.lzy.db.orderby.OrderByExpression;
import com.lzy.db.retrieve.SqlListRetriever;
import com.lzy.db.retrieve.SqlPageRetriever;
import com.lzy.db.retrieve.TvListRetriever;
import com.lzy.db.retrieve.TvPageRetriever;
import com.lzy.db.table.SqlObject;
import com.lzy.db.table.ViewObject;

public class RetrieverFactory {
	public IRetriever create(SqlObject sqlObj, int page, int max){
		return new SqlPageRetriever(sqlObj, page, max);
	}
	public IRetriever create(ViewObject vwObj, int page, int max, ConditionExpression cndtExp, OrderByExpression orderExp){
		return new TvPageRetriever(vwObj, page, max, cndtExp, orderExp);
	}
	public IRetriever create(SqlObject sqlObj){
		return new SqlListRetriever(sqlObj);
	}
	public IRetriever create(ViewObject vwObj, ConditionExpression cndtExp, OrderByExpression orderExp){
		return new TvListRetriever(vwObj, cndtExp, orderExp);
	}
}
