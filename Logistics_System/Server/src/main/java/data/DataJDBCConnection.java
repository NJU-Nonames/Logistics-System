package data;

import java.sql.*;

import mainServer.ServerFrame;

import com.mysql.jdbc.ResultSet;

import config.XMLReader;

public class DataJDBCConnection {
	
	private static final String PORT=XMLReader.loadjdbcconfig().getPort();
	
	private static final String NAME=XMLReader.loadjdbcconfig().getName();
	
	private static final String ADMIN=XMLReader.loadjdbcconfig().getAdmin();
	
	private static final String PASSWORD=XMLReader.loadjdbcconfig().getPassword();
	
	private static Connection connect;
	
	public static void init(){
		connect=DataJDBCConnection.getConnection();
		try {
			PreparedStatement prestmt=connect.prepareStatement("set names gbk");
			prestmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
		 try {
			 Class.forName("com.mysql.jdbc.Driver"); 
	              //加载MYSQL JDBC驱动程序   
	          
	          connect = DriverManager.getConnection( "jdbc:mysql://localhost:"+PORT+"/"+NAME+"?useUnicode=true&characterEncoding=UTF-8",ADMIN,PASSWORD);
	          
	          ServerFrame.getFrame().myPanel.add("Success loading Mysql Driver!\n");
	        }
	        catch (Exception e) {
	          ServerFrame.getFrame().myPanel.add("Error load Mysql Driver!\n");
	        }
		return connect;
	
	}
	
	/**
	 * 实现增删改功能
	 * @param sql
	 */
	public static void update(String sql){
		connect=DataJDBCConnection.getConnection();
		try {
			PreparedStatement prestmt=connect.prepareStatement(sql);
			prestmt.execute();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public static ResultSet find(String sql){
		connect=DataJDBCConnection.getConnection();
		ResultSet rs=null;
		try {
			Statement stmt=connect.createStatement();
			rs=(ResultSet) stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
		
	}
	
	
}
