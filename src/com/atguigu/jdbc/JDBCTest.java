/*2增删数据表操作
  package com.atguigu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.Statement;

public class JDBCTest {
 @Test
 public void testStatement() throws SQLException, IOException, ClassNotFoundException
 {
	 Connection conn=getConnection2();
 //String sql="insert into first values(1001,'you',now());";
	 String sql="delete  from first where ID=1000;";
	 System.out.println(sql);
  java.sql.Statement statemen= conn.createStatement();
 //Statement statement=conn.createStatement() ;
 statemen.executeUpdate(sql);
 statemen.close();
 conn.close();
 
 
 }	
 @Test
	public void testGetConnection2() throws IOException, ClassNotFoundException, SQLException{
		System.out.println( getConnection2());
	}

	public Connection getConnection2() throws IOException, ClassNotFoundException, SQLException{
		Properties properties=new Properties();
		InputStream in=
			    this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"); 
		properties.load(in);
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String jdbcUrl=properties.getProperty("jdbcUrl");
		String driver=properties.getProperty("driver");
		
		Class.forName(driver);
		return DriverManager.getConnection(jdbcUrl,user,password);
		
		
	}
	
}*/
 
 /*2 package com.atguigu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class JDBCTest {
	public void update(String sql) 
 {
	 
		Connection conn=null;
		Statement statement=null;
		try {
			conn=getConnection2();
			statement= (Statement) conn.createStatement();
		 statement.executeUpdate(sql);
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
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
 }

	
	 
 

 @Test
	public void testGetConnection2() throws IOException, ClassNotFoundException, SQLException{
		System.out.println( getConnection2());
	}

	public Connection getConnection2() throws IOException, ClassNotFoundException, SQLException{
		Properties properties=new Properties();
		InputStream in=
			    this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"); 
		properties.load(in);
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String jdbcUrl=properties.getProperty("jdbcUrl");
		String driver=properties.getProperty("driver");
		
		Class.forName(driver);
		return DriverManager.getConnection(jdbcUrl,user,password);
		
		
	}
}*/


package com.atguigu.jdbc;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import org.junit.Test;

import com.mysql.jdbc.ResultSet;
import com.mysql.jdbc.Statement;

public class JDBCTest {
	
	
	public void update(String sql) 
	 {
		 
			Connection conn=null;
			Statement statement=null;
			try {
				conn=JDBCTools.getConnection();
				statement= (Statement) conn.createStatement();
			 statement.executeUpdate(sql);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			JDBCTools.release(statement,conn);
		}
		}
	 
	@Test
	public void testGetConnection2() throws IOException, ClassNotFoundException, SQLException{
		System.out.println( getConnection2());
	}

	public Connection getConnection2() throws IOException, ClassNotFoundException, SQLException{
		Properties properties=new Properties();
		InputStream in=
			    this.getClass().getClassLoader().getResourceAsStream("jdbc.properties"); 
		properties.load(in);
		String user=properties.getProperty("user");
		String password=properties.getProperty("password");
		String jdbcUrl=properties.getProperty("jdbcUrl");
		String driver=properties.getProperty("driver");
		
		Class.forName(driver);
		return DriverManager.getConnection(jdbcUrl,user,password);
		
		
	}
}
  /* ResultSet:结果集，封装了使用JDBC进行查询工作的结果
  * 1.调用Statement对象的executeQuery(sql)	可以得到结果集
  * 2ResultSet返回的实际上就是一张数据表，有一个指正指向数据表的第一样的前面
  * 可以调用next()方法检测下一行是否有效，若有效该方法返回true，且指针下移，相当于
  * Iterator对象的hasNext（）和next（）方法的结合体
  * 当指针对拉到一行时，可以通过调动GETXxx（index)或getXxx(columnName)
  * 获取每一列的值，例如：getInt（1),getString("name")
  * ResultSet当然也需要进行关闭
  */
	
	
	/*@Test
 public void testResultSet(){
	//获取ID=1000的first数据表的记录，并打印 
	 
		//1获取数据库
		Connection conn=null;
		Statement statement=null;
		ResultSet rs=null;
		try{
			conn=JDBCTools.getConnection();
			statement=(Statement) conn.createStatement();
		String sql="select * from first where ID=1000;";
		rs=(ResultSet) statement.executeQuery(sql); 
		if(rs.next()){
			int ID=rs.getInt(1);
			String email=rs.getString(3);
			Date time=rs.getDate(4);
			System.out.println(ID);
			System.out.println(email);
			System.out.println(time);
		}
		
		
		}catch(Exception e){
			e.printStackTrace();
		}finally{
			JDBCTools.release(rs, statement, conn);
		}*/
 
 

