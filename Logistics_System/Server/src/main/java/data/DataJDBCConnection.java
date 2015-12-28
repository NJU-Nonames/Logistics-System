package data;

import java.sql.*;

import mainServer.ServerUI;

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
			 ServerUI.getFrame().myPanel.add("Success load Mysql Driver!\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection(){
//		if(connect!=null)
//			return connect;
		//初始化
		 try {
			 Class.forName("com.mysql.jdbc.Driver"); 
	              //加载MYSQL JDBC驱动程序   
	          
	          connect = DriverManager.getConnection( "jdbc:mysql://localhost:"+PORT+"/"+NAME+"?useUnicode=true&characterEncoding=UTF-8",ADMIN,PASSWORD);
	         // ServerUI.getFrame().myPanel.add("Success load Mysql Driver!\n");
	        }
	        catch (Exception e) {
	          ServerUI.getFrame().myPanel.add("Error load Mysql Driver!\n");
	        }
		return connect;
	
	}
	
	/**
	 * 实现增删改功能
	 * @param sql
	 */
	public static void update(String sql){
		connect = DataJDBCConnection.getConnection();
		try {
			PreparedStatement prestmt=connect.prepareStatement(sql);
			prestmt.execute();
			ServerUI.getFrame().myPanel.add("Execute :"+sql+"\n");
		} catch (SQLException e) {
			ServerUI.getFrame().myPanel.add("Error   :"+e.getMessage()+"\n");
		} 
	}
	
	public static ResultSet find(String sql){
		connect=DataJDBCConnection.getConnection();
		ResultSet rs=null;
		try {
			Statement stmt=connect.createStatement();
			rs=(ResultSet) stmt.executeQuery(sql);
			 ServerUI.getFrame().myPanel.add("Find    :"+sql+"\n");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			ServerUI.getFrame().myPanel.add("Error   :"+e.getMessage()+"\n");
		} 
		return rs;
		
	}
	
	
}
