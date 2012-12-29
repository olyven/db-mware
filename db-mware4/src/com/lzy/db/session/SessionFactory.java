package com.lzy.db.session;

public class SessionFactory {
	public static DBSession createTDBSession(String url){
		return new TDBSession(url);
	}
	
	public static DBSession createLDBSession(String url){
		return new LDBSession(url);
	}
}
