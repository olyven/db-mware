package com.lzy.db.retrieve;

import com.lzy.db.exception.OperationException;
import com.lzy.db.express.ConditionExpression;
import com.lzy.db.orderby.OrderByExpression;
import com.lzy.db.table.ViewObject;

public class TvPageRetriever extends PageRetriever {
	private ViewObject vwObj;
	private ConditionExpression cndtExp;
	private OrderByExpression orderExp;
	public TvPageRetriever(ViewObject vwObj, int page, int max, ConditionExpression cndtExp, OrderByExpression orderExp) {
		super(page, max, vwObj);
		// TODO Auto-generated constructor stub
		this.vwObj= vwObj;
		this.cndtExp = cndtExp;
		this.orderExp = orderExp;
	}

	@Override
	protected String sql() throws OperationException {
		// TODO Auto-generated method stub
		return sql.select(vwObj, cndtExp, orderExp);
	}

}
