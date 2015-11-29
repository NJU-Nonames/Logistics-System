/**
 * 2015年11月13日
 *author:
 *description:
 */
package dataImpl.system;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.system.UserPO;
import utility.UserType;
import data.DataJDBCConnection;
import dataservice.system.UserDataService;


/**
 * @author 谭期友
 *
 */
public class UserDataImpl extends UnicastRemoteObject implements UserDataService,Serializable{

	public UserDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * 因为UserDataService接口继承了Serializable接口才有这个
	 */
	private static final long serialVersionUID = -2473929898619936668L;

	//test 测试
//	public static void main(String args[]){
//		UserDataService userdata;
//		try {
//			userdata = new UserDataImpl();
//			//userdata.add(new UserPO("tangdaye","1343223",UserType.CENTER_CLERK,"123332214"));
//			//userdata.delete("123332212");
//			//userdata.update(new UserPO("tangdaye","133323",UserType.CENTER_CLERK,"1000032214"));
//			System.out.println(userdata.showAll().get(2).getId());
//		} catch (RemoteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
	
	public void add(UserPO user) {
		String operate="insert into User values ("+user.getId()+",'"+user.getAdmin()+"','"+user.getPassword()+"','"+user.getPosition()+"');";
		DataJDBCConnection.update(operate);
	}

	public void delete(String admin) {
		String operate="delete from User where admin='"+admin+"'";
		DataJDBCConnection.update(operate);
	}

	/* (non-Javadoc)
	 * @see dataservice.system.UserDataService#update(po.system.UserPO)
	 *　需要默认id不被改变，即每个人的工号是固定的
	 */
	public void update(UserPO user) {
		this.delete(user.getAdmin());
		this.add(user);
		
	}

	public UserPO findonId(String id) {
	   //数据库操作，如果不存在返回null，否则返回UserPO
		UserPO user=null;
		String sql="select * from User where id="+id;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
				
		try {
			rs.next();
			user=new UserPO(rs.getString("admin"), rs.getString("pass"), UserType.valueOf(rs.getString("Idtype")),id);
		} catch (SQLException e) {
			return null;
		}	
				
		return user;
	}

	public UserPO findonAdmin(String admin) {
		//数据库操作，如果不存在返回null，否则返回UserPO
		UserPO user=null;
		String sql="select * from User where admin='"+admin+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		
		try {
			rs.next();
			user=new UserPO(admin, rs.getString("pass"), UserType.valueOf(rs.getString("Idtype")), rs.getString("id"));
		} catch (SQLException e) {
			return null;
		}
				
		return user;
	}

	public ArrayList<UserPO> showAll() {
		UserPO user=null;
		ArrayList<UserPO> list=new ArrayList<UserPO>();
		String sql="select * from User";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		
		try {
			while(rs.next()){
				user=new UserPO(rs.getString("admin"), rs.getString("pass"), UserType.valueOf(rs.getString("Idtype")), rs.getString("id"));
				list.add(user);
			}
		} catch (SQLException e) {
			return list;
		}
		return list;
	}

}
