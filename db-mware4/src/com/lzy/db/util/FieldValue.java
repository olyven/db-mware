package com.lzy.db.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import com.lzy.db.exception.OperationException;

public class FieldValue {
	private Map<String,String> fvs = new HashMap<String,String>();
	private Any2String any = new Any2String();
	//以逗号“，”分开的值字符串
		public String valueString()throws OperationException{
			String rslt = "";
			Set<String> fields = fvs.keySet(); //请注意，值序列顺序必须与字段序列顺序一致，参考（1）
			for(String field:fields){
				if(fvs.get(field)!=null){
					rslt += fvs.get(field)+",";
				}
			}
			if(rslt.length()>0){
				return rslt.substring(0, rslt.length()-1);
			}else{
				return "";
			}
		}
		//以逗号“，”分开的字段名字符串
		public String fieldString()throws OperationException{		
			String rslt = "";
			Set<String> fields = fvs.keySet(); //请注意，字段顺序必须与值序列顺序一致，参考（2）
			for(String field:fields){
				rslt += field+",";
			}
			if(rslt.length()>0){
				return rslt.substring(0, rslt.length()-1);
			}else{
				return "";
			}
		}
		//以逗号“，”分开的字段列付值字符串
		public String fieldEqValueString()throws OperationException{
			Set<String> fields = fvs.keySet();
			String rslt = "";
			for(String field:fields){
				rslt += field + "=" + fvs.get(field) + ",";
			}
			if(rslt.length()>0){
				return rslt.substring(0, rslt.length()-1);
			}else{
				return "";
			}
		}
		public FieldValue clear(){
			fvs.clear();
			return this;
		}
		public FieldValue add(String fieldName, Long value){
			fvs.put(fieldName, any.toString(value));
			return this;
		}
		public FieldValue add(String fieldName, Integer value){
			fvs.put(fieldName, any.toString(value));
			return this;
		}
		public FieldValue add(String fieldName, Date value){
			fvs.put(fieldName, any.toString(value));
			return this;
		}
		public FieldValue add(String fieldName, String value){
			fvs.put(fieldName, any.toString(value));
			return this;
		}
		public FieldValue add(String fieldName, Boolean value){
			fvs.put(fieldName, any.toString(value));
			return this;
		}
		public FieldValue add(String fieldName, Float value){
			fvs.put(fieldName, any.toString(value));
			return this;
		}
		public FieldValue add(String fieldName, Double value){
			fvs.put(fieldName, any.toString(value));
			return this;
		}
		public String value(String fieldName){
			String temp = fvs.get(fieldName);
			if(temp.substring(0, 1).equals("'")&&temp.substring(temp.length()-1, temp.length()).equals("'")){
				return temp.substring(1, temp.length()-1);
			}
			return temp;
		}
}
