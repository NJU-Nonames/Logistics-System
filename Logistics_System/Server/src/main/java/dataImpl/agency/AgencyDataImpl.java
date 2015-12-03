package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.agency.AgencyPO;
import po.agency.StaffPO;
import utility.Position;
import data.DataJDBCConnection;
import dataservice.agency.AgencyDataService;

public class AgencyDataImpl  extends UnicastRemoteObject implements AgencyDataService,Serializable {

	public AgencyDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salaryManage(Position position, String salary)
			throws RemoteException {
		String sql="update staff set wage='"+salary+"' where postion='"+position+"'";
		DataJDBCConnection.update(sql);
		
	}

	public void add(AgencyPO agency) throws RemoteException {
		String sql1="insert into agency values('"+agency.getAgencyNum()+"','"+agency.getAgencyName()+"')";
		DataJDBCConnection.update(sql1);
		for(int i=0;i<agency.getStaffList().size();i++)
		{
			StaffPO staff=agency.getStaffList().get(i);
			new StaffDataImpl().add(staff);;
		}
		
	}

	public void delete(String agencyNum) throws RemoteException {
		String sql="delete from agency where agencyId='"+agencyNum+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from staff where agencyId='"+agencyNum+"'";
		DataJDBCConnection.update(sql2);
		
	}

	public void update(AgencyPO agency) throws RemoteException {
		this.delete(agency.getAgencyNum());
		this.add(agency);
		
	}

	public AgencyPO find(String id) throws RemoteException {
		String sql="select * from agency where agencyId='"+id+"'";
		AgencyPO agency=null;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		
		try {
			rs.next();
			ArrayList<StaffPO> staffList=new ArrayList<StaffPO>();
			sql="select * from staff where agencyId='"+id+"'";
			ResultSet rs2=(ResultSet) DataJDBCConnection.find(sql);
			while(rs2.next())
			{
				staffList.add(new StaffDataImpl().find(rs2.getString("id")));
			}
			agency=new AgencyPO(rs.getString("agencyName"), rs.getString("agencyId"), staffList);
		} catch (SQLException e) {
			System.out.println("未找到该员工");
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
				if(this.find(rs.getString("agencyId"))!=null)
					agencyList.add(this.find(rs.getString("agencyId")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return agencyList;
	}

	
	

}
