
package dataImpl.system;
import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.system.SystemLogPO;
import data.DataJDBCConnection;
import dataservice.system.SystemLogDataService;

/**
 * @author 这菜咸了
 * 该类为远程对象的实现类,需要继承unicastRemoteObject
 */
public class SystemLogDataImpl extends UnicastRemoteObject implements SystemLogDataService,Serializable{

	public SystemLogDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	private static final long serialVersionUID = 1L;


	public ArrayList<SystemLogPO> showAll(String time1,String time2) {
	    String sql="select * from systemlog where logtime>='"+time1+"' and logtime<='"+time2+"'";
	    ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
	    ArrayList<SystemLogPO> list=new ArrayList<SystemLogPO>();
	    SystemLogPO systemLog;
	    try {
			while(rs.next()){
				systemLog=new SystemLogPO(rs.getString("logtime"), rs.getString("content"), rs.getString("admin"));
				list.add(systemLog);
			}
		} catch (SQLException e) {
			System.out.println("未找到。");
			return list;
			//e.printStackTrace();
		}
	    return list;
	}

	public void add(SystemLogPO systemLog) {
		System.out.println("连接成功");
		String sql="insert into systemlog values (`primary`,'"+systemLog.getTime()+"','"+systemLog.getUser()+"','"+systemLog.getContent()+"')";
		DataJDBCConnection.update(sql);
		
	}

}
