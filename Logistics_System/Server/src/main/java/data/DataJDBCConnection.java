package data;
import java.sql.*;

public class DataJDBCConnection {
	
	private static final String PORT="3306";
	
	private static final String NAME="logistics";
	
	private static final String ADMIN="root";
	
	private static final String PASSWORD="";
	
	private static Connection connect;
	
	public static Connection getConnection(){
		 try {
			 Class.forName("com.mysql.jdbc.Driver"); 
	              //加载MYSQL JDBC驱动程序   
	          
	          connect = DriverManager.getConnection( "jdbc:mysql://localhost:"+PORT+"/"+NAME,ADMIN,PASSWORD);
	          
	         System.out.println("Success loading Mysql Driver!");
	        }
	        catch (Exception e) {
	          System.out.print("Error loading Mysql Driver!");
	          e.printStackTrace();
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
			rs=stmt.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		return rs;
		
	}
	
	
}
