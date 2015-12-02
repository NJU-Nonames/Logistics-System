package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.agency.StaffPO;
import po.system.UserPO;
import utility.Position;
import utility.UserType;
import data.DataJDBCConnection;
import dataservice.agency.StaffDataService;

public class StaffDataImpl extends UnicastRemoteObject implements StaffDataService,Serializable {

	public StaffDataImpl() throws RemoteException {
		super();
	}

	public void add(StaffPO staff) throws RemoteException {
		String sql="insert into staff values('"+staff.getId()+"','"+staff.getName()+"','"+staff.getSex()+"','"+staff.getPostion()
				+"','"+staff.getIDNum()+"','"+staff.getWorkingtime()+"','"+staff.getPhoneNum()+"','"+staff.getWage()+"',"+staff.getAgencyName()+"','"+staff.getAgencyId()+"')";
		DataJDBCConnection.update(sql);
		
	}

	public void delete(String id) throws RemoteException {
		String sql="delete from staff where id='"+id+"'";
		DataJDBCConnection.update(sql);
		
	}

	public void update(StaffPO staff) throws RemoteException {
		this.delete(staff.getId());
		this.add(staff);
		
	}

	public StaffPO find(String id) throws RemoteException {
		String sql="select * from staff where id='"+id+"'";
		ResultSet rs2=(ResultSet) DataJDBCConnection.find(sql);
		StaffPO staff=null;
		try {
			rs2.next();
			staff=new StaffPO(rs2.getString("name"), rs2.getString("sex"),Position.valueOf(rs2.getString("position")), rs2.getString("idNumber"), rs2.getString("workingstarttime"), rs2.getString("phoneNum"), rs2.getString("wage"), rs2.getString("agencyName"), rs2.getString("id"),rs2.getString("agencyid"));
			
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("查询失败");
			//return null;
		}
		return staff;
	}

	public ArrayList<StaffPO> findbyname(String name) throws RemoteException {
		String sql="select * from staff where name='"+name+"'";
		ResultSet rs2=(ResultSet) DataJDBCConnection.find(sql);
		ArrayList<StaffPO> staff=new ArrayList<StaffPO>();
		try {
			while(rs2.next()){
				staff.add(new StaffPO(rs2.getString("name"), rs2.getString("sex"),Position.valueOf(rs2.getString("position")), rs2.getString("idNumber"), rs2.getString("workingstarttime"), rs2.getString("phoneNum"), rs2.getString("wage"), rs2.getString("agencyName"), rs2.getString("id"),rs2.getString("agencyid")));
			}
		} catch (SQLException e) {
			return staff;
		}
		return staff;
	}


}
