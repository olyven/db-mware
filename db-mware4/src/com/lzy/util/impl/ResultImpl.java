package com.lzy.util.impl;

import com.lzy.util.ObjectList;
import com.lzy.util.ObjectPage;
import com.lzy.util.Result;

public class ResultImpl implements Result {
	private int id=0;
	private String message="";
	private Object object=null;
	@Override
	public int getId(){
		return id;
	}
	@Override
	public String getMessage(){
		return message;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public void setObject(Object object) {
		this.object = object;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> T  getObject(){
		try{
			return object!=null? (T)object:null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> ObjectList<T> getObjectList(){
		try{
			return object!=null? (ObjectList<T>)object:null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public <T> ObjectPage<T> getObjectPage(){
		try{
		return object!=null? (ObjectPage<T>)object:null;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
