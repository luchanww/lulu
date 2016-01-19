package com.atguigu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;
/*
 * ����JDBC�Ĺ����ࡣ
 * ��ȡ�����ļ������ݿ�������е�һ������
 */
public class JDBCTools {
	/*public static void release(ResultSet rs, Statement statement,Connection conn)
	{
		if(rs!=null){
			try{
				rs.close();
			}catch(Exception e){
				e.printStackTrace();
				
			}
		}
		if(statement!=null){
			try{
				statement.close();
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		if(conn !=null){
		try{
			conn.close();
		}catch(Exception e2){
			e2.printStackTrace();	
		}
		}
	}
	
	
	
	*/public static void release(Statement  statement,Connection conn)
	{
		if(statement!=null){
			try{
				statement.close();
			}catch(Exception e2){
				e2.printStackTrace();
				
			}
		}
		if(conn !=null){
		try{
			conn.close();
		}catch(Exception e2){
			e2.printStackTrace();
			
		}
		}
	}
	
	public static Connection getConnection() throws IOException, ClassNotFoundException, SQLException{
		Properties properties=new Properties();
		InputStream in=
				JDBCTools.class.getClass().getClassLoader().getResourceAsStream("jdbc.properties"); 
		properties.load(in);
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String jdbcUrl=properties.getProperty("jdbcUrl");
		String driver=properties.getProperty("driver");
		
		Class.forName(driver);
		return DriverManager.getConnection(jdbcUrl,user,password);
		
		
	}
	
}
