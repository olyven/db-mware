package com.lzy.db.test;

import java.lang.reflect.Field;

public class Test2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Field[] fields = Test.class.getDeclaredFields();
		for(Field field:fields){
			System.out.println(field.getType().getName());
		}
		System.out.println(Test.class.getInterfaces()[0].getName());
	}

}
