package org.gpf.util;

import java.sql.Connection;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

/**
 * 连接数据库和关闭数据库连接-使用数据库连接池
 * @author gaopengfei
 * @date 2015-5-24 下午4:47:29
 */
public class DBConnection {

	String DSNAME = "java:comp/env/jdbc/mybatisrobot";
	private Connection conn = null;
	
	/**
	 * 在构造器中使用jndi从context.xml中加载Tomcat数据源，并实例化Connection对象
	 */
	public DBConnection() {
		try {
			Context ctx = new InitialContext();
			DataSource ds = (DataSource) ctx.lookup(DSNAME);
			conn = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 得到数据库连接
	 */
	public final Connection getConnection(){
		return conn;
	}
	
	/**
	 * 关闭数据库连接
	 */
	public void closeConnection(){
		
		if(conn!=null)
			try {
				conn.close();
				conn = null;
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	public static void main(String[] args) {
		
		Connection conn = new DBConnection().getConnection();
		if(conn !=null)	System.out.println("数据库连接成功！");
		else 			System.out.println("数据库连接失败！");
	}
}
