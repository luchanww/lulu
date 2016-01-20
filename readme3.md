# 第一标题

## 第二标题

段落。

`package com.atgugui.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class Review2 {
/*
 * ResultSet封装JDBC的查询结果
 */@Test
	public void testResultSet(){
		Connection connection=null;
		Statement statement=null;
		ResultSet resultset=null;
		try{
			connection=getConnection();
			statement=(Statement) connection.createStatement();
			String sql="select *from first;";
			resultset=(ResultSet) statement.executeQuery(sql);
		while(resultset.next()){
			int ID=resultset.getInt(1);
			String email=resultset.getString(2);
			Date time=resultset.getDate(3);
		System.out.print(ID);
		System.out.print(email);
		System.out.print(time);
		System.out.println();
		
		}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			//6关闭数据库
			releaseDB(resultset,statement,connection);
		}
		//1 获取数据库连接
		//2调用Connection对象的createStatement()方法获取statement对象
		//3准备SQL语句
	
	
	
	}

private void releaseDB(Object resultSet, java.sql.Statement statement,
		Connection connection) {
	// TODO Auto-generated method stub
	
}
public void releaseDB(ResultSet resultSet,Statement statement
		,Connection connection){
	if(resultSet!=null){
		try{
			resultSet.close();
		}catch(SQLException e){
			e.printStackTrace();
		} 
		
	}
	if(statement!=null){
		try{
			statement.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
		
	}
	if(connection!=null){
		try{
			connection.close();
		}catch(SQLException e){
			e.printStackTrace();
		}
	}
}

	
	
	@Test
public void testGetConnection2() throws ClassNotFoundException, SQLException, IOException {
	
		Connection connection = getConnection();
		
	System.out.println(connection);	
		
}
	public Connection getConnection() throws IOException,
			ClassNotFoundException, SQLException {
		Properties properties=new Properties();
		 InputStream in=getClass().getClassLoader()
				    .getResourceAsStream("jdbc.properties"); 
		properties.load(in);
		 
		 //1 准备获取链接的4个字符串
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String jdbcUrl=properties.getProperty("jdbcUrl") ;
		String driverClass=properties.getProperty("driverClass");
		//2加载驱动	
		Class.forName(driverClass);
		//3调用DriverManager.getConnnection(jdbcUrl,user,password);
		
		Connection connection= (Connection) DriverManager.getConnection(jdbcUrl, user, password);//getConnection(jdbcUrl,user,password);
		
		return connection;
	}}

`
