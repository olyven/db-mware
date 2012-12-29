package com.lzy.db.util;

import java.util.Set;

import com.lzy.db.exception.OperationException;
import com.lzy.db.express.ConditionExpression;
import com.lzy.db.orderby.OrderByExpression;
import com.lzy.db.table.RelationshipObject;
import com.lzy.db.table.TableObject;
import com.lzy.db.table.ViewObject;

public class SQLStringMaker {
	public String insert(TableObject tbObj, FieldValue fieldValue)throws OperationException{
		String sql = "INSERT INTO " + tbObj.getName() + "(" + fieldValue.fieldString() + ")VALUES(" + fieldValue.valueString() + ")";
		System.out.println(sql);
		return sql;
	}	
	
	public String delete(TableObject tbObj, ConditionExpression conditionExp)throws OperationException{
		String sql = "DELETE FROM " + tbObj.getName() + sqlWhereMaker(tbObj, conditionExp);
		System.out.println(sql);
		return sql;
	}
	
	public String update(TableObject tbObj, FieldValue fieldValue, ConditionExpression conditionExp)throws OperationException{
		String sql = "UPDATE " + tbObj.getName() + " SET " + fieldValue.fieldEqValueString() + sqlWhereMaker(tbObj, conditionExp);
		System.out.println(sql);
		return sql;
	}
	
	public String select(ViewObject vwObj, ConditionExpression conditionExp, OrderByExpression orderByExp)throws OperationException{
		String sql = "SELECT "+ formatFields(vwObj) + " FROM " + vwObj.getName() + sqlWhereMaker(vwObj,conditionExp) + orderByMaker(vwObj, orderByExp);
		System.out.println(sql);
		return sql;
	}
	
	public String select(RelationshipObject rsObj, long mKeyValue)throws OperationException{
		TableObject sdObj = rsObj.getScondaryTable();
		String sql = "SELECT "+ formatFields("a", rsObj) + " FROM " + rsObj.getScondaryTable().getName() + " a, " +rsObj.getName() + " b "+
		" WHERE " + "a."+sdObj.attr2Field(sdObj.getKey()) + "=" + "b."+rsObj.attr2Field(rsObj.getSKey()) + " AND b."+rsObj.attr2Field(rsObj.getMKey())+"="+mKeyValue;
		System.out.println(sql);
		return sql;
	}
	
	private String formatFields(String prefix, RelationshipObject rsObj){
		Set<String> fields = rsObj.getScondaryTable().getFields();
		String rslt = "";
		for(String field:fields){
			rslt += prefix + "." + field + ",";
		}
		if(rslt.equals("")){
			return "*";
		}else{
			return rslt.substring(0, rslt.length()-1);
		}
	}
	
	private String formatFields(ViewObject vwObj){
		Set<String> fields = vwObj.getFields();
		String rslt = "";
		for(String field:fields){
			rslt += field + ",";
		}
		if(rslt.equals("")){
			return "*";
		}else{
			return rslt.substring(0, rslt.length()-1);
		}
	}
	
	private String sqlWhereMaker(ViewObject vwObj, ConditionExpression expression){
		if(expression==null)return "";
		String cdt = expression.expression(vwObj);
		if(cdt.length()>0){
			return " WHERE " + cdt;
		}else{
			return "";
		}
	}
	
	private String orderByMaker(ViewObject vwObj, OrderByExpression orderByExpression){
		if(orderByExpression==null)return "";
		String orderString = orderByExpression.orderString(vwObj);
		if(orderString.length()>0){
			return " ORDER BY " + orderString;
		}else{
			return "";
		}
	}
}
