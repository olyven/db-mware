package com.lzy.db.util;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Any2String {
	public String toString(String value){
		return "'"+value+"'";
	}
	public String toString(Integer value){
		return value+"";
	}
	public String toString(Long value){
		return value+"";
	}
	public String toString(Date value){
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return "'"+sdf.format(value)+"'";
	}
	public String toString(Float value){
		return value+"";
	}
	public String toString(Double value){
		return value+"";
	}
	public String toString(Boolean value){
		return value?"1":"0";
	}
}
