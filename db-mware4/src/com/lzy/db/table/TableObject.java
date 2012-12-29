package com.lzy.db.table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;

import com.lzy.db.exception.OperationException;
import com.lzy.db.util.FieldValue;


public class TableObject extends ViewObject implements Object2FieldValue {
	
	public TableObject(String className, String tbName, String idName) {
		super(className, tbName, idName);
		// TODO Auto-generated constructor stub
	}
	
	

	//如果不采用反射，可以重载该方法
	@Override
	public FieldValue fieldValue(Object obj)throws OperationException {
		// TODO Auto-generated method stub
		Field[] fields = obj.getClass().getDeclaredFields();
		FieldValue fv = new FieldValue();
		try{
			for(Field field:fields){
				String methodName = "get"+ field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
				Method method = obj.getClass().getDeclaredMethod(methodName, (Class[])null);
				String typeName = field.getType().getName();
				String tbField = this.attr2Field(field.getName());
				if(tbField==null || tbField.equals(""))throw new OperationException("该对象属性没有对应的数据库表字段");
				if(typeName.endsWith("String")){
					String temp = (String)method.invoke(obj, (Object[])null);
					temp.replace("'", "\\'");
					fv.add(tbField, temp);
				}else if(typeName.endsWith("int") || typeName.endsWith("Integer")){
					fv.add(tbField, (Integer)method.invoke(obj, (Object[])null));
				}else if(typeName.endsWith("long") || typeName.endsWith("Long")){
					fv.add(tbField, (Long)method.invoke(obj, (Object[])null));
				}else if(typeName.endsWith("Date")){
					fv.add(tbField, (Date)method.invoke(obj, (Object[])null));
				}else if(typeName.endsWith("bool") || typeName.endsWith("Boolean")){
					fv.add(tbField, (Boolean)method.invoke(obj, (Object[])null));
				}else if(typeName.endsWith("float") || typeName.endsWith("Float")){
					fv.add(tbField, (Float)method.invoke(obj, (Object[])null));
				}else if(typeName.endsWith("double") || typeName.endsWith("Double")){
					fv.add(tbField, (Double)method.invoke(obj, (Object[])null));
				}else{
					throw new OperationException("获取属性值失败");
				}
			}
			return fv;
		}catch(Exception e){e.printStackTrace();throw new OperationException(e.getMessage());}
	}
		
}
