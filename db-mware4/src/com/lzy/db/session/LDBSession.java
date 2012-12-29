package com.lzy.db.session;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class LDBSession extends DBSession {
	public LDBSession(String url){
		super(url);
	}
	@Override
	protected Connection createConnection() throws SQLException {
		// TODO Auto-generated method stub
		try{
			Class.forName("com.mysql.jdbc.Driver");
			return DriverManager.getConnection(DBUrl);
		}catch(ClassNotFoundException e){
			throw new SQLException(e.getMessage());
		}
	}
}

/**
 * 
MySQL的JDBC URL格式：

jdbc:mysql//[hostname][:port]/[dbname][?param1=value1][&param2=value2]….

示例：jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password

常见参数：

user 用户名

password 密码

autoReconnect 联机失败，是否重新联机（true/false）

maxReconnect 尝试重新联机次数

initialTimeout 尝试重新联机间隔

maxRows 传回最大行数

useUnicode 是否使用Unicode字体编码（true/false）

characterEncoding 何种编码（GB2312/UTF-8/…）

relaxAutocommit 是否自动提交（true/false）

capitalizeTypeNames 数据定义的名称以大写表示

建立连接对象

String url="jdbc:mysql://localhost:3306/sample_db?user=root&password=your_password";

Connection con = DriverManager.getConnection(url);
 */
