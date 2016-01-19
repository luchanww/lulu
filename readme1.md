#连接数据库
##段落
`package com.atguigu.jdbc`。
package com.atguigu.jdbc;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.SQLException;
import java.util.Properties;
import org.junit.Test;
public class JDBCTest {
public Connection getConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException{
	
	String driverClass=null;
	String jdbcUrl=null;
	String user=null;
	String password=null;
	//读取类路径下的jdbc.properties文件
	 InputStream in=
		    getClass().getClassLoader().getResourceAsStream("jdbc.properties"); 
	Properties properties=new Properties();
	properties.load(in);
	driverClass=properties.getProperty("driver");
	jdbcUrl=properties.getProperty("jdbcUrl");
	user=properties.getProperty("user");
	password=properties.getProperty("password");
	Driver driver=(Driver)Class.forName(driverClass).newInstance();
	Properties info=new Properties();
	info.put("user", user);
	info.put("password", password);
	Connection connection=driver.connect(jdbcUrl, info);
	return connection;
	}
	@Test
	public void testGetConnection() throws InstantiationException, IllegalAccessException, ClassNotFoundException, SQLException, IOException
	{
		System.out.println(getConnection());	
		}
	}


