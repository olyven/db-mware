package com.lzy.db.table;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.ResultSet;

import com.lzy.db.exception.OperationException;
import com.lzy.db.util.FieldAttribute;



public class RecordFetcher extends FieldAttribute implements IRecordFetcher{
	private String className;

	public RecordFetcher(String className) {
		this.className = className;
	}

	/**
	 * 通过反射实现对象序列化，即把一条记录转换成相应对象
	 * 如果不采用反射，可以重载该方法
	 */
	public Object fetch(ResultSet rs)throws OperationException{
		try {
			Object obj = getObject();
			Field[] fields = obj.getClass().getDeclaredFields();
			for(Field field:fields){
				String fieldName = attr2Field(field.getName());
				if(fieldName==null || fieldName.equals("")){
					throw new OperationException("Cant not found attribute("+field.getName()+") in field-attribute map");
				}
				String methodName = "set"+ field.getName().substring(0,1).toUpperCase() + field.getName().substring(1);
				Method method = obj.getClass().getDeclaredMethod(methodName, field.getType());
				String typeName = field.getType().getName();
				if(typeName.endsWith("String")){
					String temp = rs.getString(fieldName);
					if(temp!=null)temp.replace("\\'", "'");
					method.invoke(obj, temp);
				}else{
					method.invoke(obj, rs.getObject(fieldName));
				}
			}
			return obj;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new OperationException(e.getMessage());
		}
	}

	private Object getObject() throws OperationException {
		try {
			return Class.forName(className).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw new OperationException(e.getMessage());
		} 
	}
	
}
