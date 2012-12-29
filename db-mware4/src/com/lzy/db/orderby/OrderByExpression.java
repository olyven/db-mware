package com.lzy.db.orderby;

import com.lzy.db.util.FieldAttribute;
import com.lzy.util.ObjectList;
import com.lzy.util.impl.ObjectListImp;

public class OrderByExpression implements OrderBy{
	ObjectList<OrderBy> orders = new ObjectListImp<OrderBy>();
	public OrderByExpression add(OrderBy order){
		orders.add(order);
		return this;
	}
	@Override
	public String orderString(FieldAttribute fieldAttr) {
		// TODO Auto-generated method stub
		String orderString = "";
		for(OrderBy order:orders){
			String temp = order.orderString(fieldAttr).trim();
			if(!temp.equals("")){
				orderString += temp + ",";
			}
		}
		return orderString.substring(0, orderString.length()-1);
	}
}
