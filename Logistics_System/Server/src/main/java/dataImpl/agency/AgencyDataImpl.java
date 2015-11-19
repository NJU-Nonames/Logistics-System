package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.agency.AgencyPO;
import po.agency.StaffPO;
import data.DataJDBCConnection;
import dataservice.agency.AgencyDataService;

public class AgencyDataImpl  extends UnicastRemoteObject implements AgencyDataService,Serializable {

	public AgencyDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salaryManage(String postion, String salary)
			throws RemoteException {
		String sql="update staff set wage='"+salary+"' where postion='"+postion+"'";
		DataJDBCConnection.update(sql);
		
	}

	public void add(AgencyPO agency) throws RemoteException {
		String sql1="insert into agency values('"+agency.getAgencyNum()+"','"+agency.getAgencyName()+"')";
		DataJDBCConnection.update(sql1);
		for(int i=0;i<agency.getStaffList().size();i++)
		{
			StaffPO staff=agency.getStaffList().get(i);
			String sql="insert into staff values("+staff.getId()+",'"+staff.getName()+"','"+staff.getSex()+"','"+staff.getPostion()
					+"','"+staff.getIDNum()+"','"+staff.getWorkingstarttime()+"','"+staff.getPhoneNum()+"','"+staff.getWage()+"',"+staff.getAgencyId()+")";
			DataJDBCConnection.update(sql);
		}
		
	}

	public void delete(String agencyNum) throws RemoteException {
		String sql="delete from agency where agencyId="+agencyNum;
		DataJDBCConnection.update(sql);
		sql="delete from staff where agencyId="+agencyNum;
		DataJDBCConnection.update(sql);
		
	}

	public void update(AgencyPO agency) throws RemoteException {
		this.delete(agency.getAgencyNum());
		this.add(agency);
		
	}

	public AgencyPO find(String id) throws RemoteException {
		String sql="select * from agency where agencyId="+id;
		AgencyPO agency=null;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		
		try {
			rs.next();
			ArrayList<StaffPO> staffList=new ArrayList<StaffPO>();
			sql="select from staff where agencyid="+id;
			ResultSet rs2=(ResultSet) DataJDBCConnection.find(sql);
			while(rs2.next())
			{
				staffList.add(new StaffPO(rs2.getString("name"), rs2.getString("sex"), rs2.getString("postion"), rs2.getString("idNumber"), rs2.getString("workingstarttime"), rs2.getString("phoneNum"), rs2.getString("wage"), rs2.getString("agencyId"), rs2.getString("id")));
			}
			agency=new AgencyPO(rs.getString("agencyName"), rs.getString("agencyId"), staffList);
		} catch (SQLException e) {
			return null;
		}
		return agency;
	}

	public ArrayList<AgencyPO> showAll() throws RemoteException {
		String sql="select * from agency";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		ArrayList<AgencyPO> agencyList=new ArrayList<AgencyPO>();
		try {
			while(rs.next())
			{
				agencyList.add(this.find(rs.getString("agencyId")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agencyList;
	}

	
	

}
