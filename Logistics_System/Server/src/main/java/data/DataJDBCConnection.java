package data;
import java.sql.*;

public class DataJDBCConnection {
	
	private static final String PORT="3306";
	
	private static final String NAME="logistics";
	
	private static final String ADMIN="root";
	
	private static final String PASSWORD="";
	
	private static Connection connect;
	
	public static void init(){
		 try {
	              //加载MYSQL JDBC驱动程序   
	          
	          connect = DriverManager.getConnection( "jdbc:mysql://localhost:"+PORT+"/"+NAME,ADMIN,PASSWORD);
	          
	         System.out.println("Success loading Mysql Driver!");
	        }
	        catch (Exception e) {
	          System.out.print("Error loading Mysql Driver!");
	          e.printStackTrace();
	        }
	
	}
	
	 public static ResultSet getResultSet(String operate)
	 {
		 
		 Statement stmt = null;
	    
	     try {
	    	 Class.forName("com.mysql.jdbc.Driver"); 
	    	 connect=DriverManager.getConnection( "jdbc:mysql://localhost:"+PORT+"/"+NAME,ADMIN,PASSWORD);
	     
	      System.out.println("Success connect Mysql server!");
	     stmt = connect.createStatement();
	      
		                                                           
		   }catch(SQLException e){
			   e.printStackTrace();
		   } catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		    ResultSet rs = null;
		    try {
				rs=stmt.executeQuery(operate);
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    
	    return rs;
	  
	 }
	
}
