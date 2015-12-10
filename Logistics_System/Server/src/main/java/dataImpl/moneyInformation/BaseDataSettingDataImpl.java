package dataImpl.moneyInformation;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.ResultSet;
import po.agency.AgencyPO;
import po.agency.BankAccountPO;
import po.agency.StaffPO;
import po.agency.TruckPO;
import po.repertory.RepertoryInfoPO;
import data.DataJDBCConnection;
import dataImpl.agency.StaffDataImpl;
import dataservice.moneyInformation.BaseDataSettingDataService;

public class BaseDataSettingDataImpl extends UnicastRemoteObject implements BaseDataSettingDataService,Serializable {

	public BaseDataSettingDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init(String time) throws RemoteException {
		//清空原始表单信息
		String sql="truncate table agency_init";
		DataJDBCConnection.update(sql);
		sql="truncate table staff_init";
		DataJDBCConnection.update(sql);
		sql="truncate table bankaccount_init";
		DataJDBCConnection.update(sql);
		sql="truncate table repertoryinfo_init";
		DataJDBCConnection.update(sql);
		sql="truncate table truck_init";
		//复制新表的内容和旧表一致
		
		sql="insert into agency_init select * from agency";
		DataJDBCConnection.update(sql);
		sql="insert into staff_init select * from staff";
		DataJDBCConnection.update(sql);
		sql="insert into bankaccount_init select * from bankaccount";
		DataJDBCConnection.update(sql);
		sql="insert into repertoryinfo_init select * from repertoryinfo";
		DataJDBCConnection.update(sql);
		sql="insert into truck_init select * from truck";
		DataJDBCConnection.update(sql);
		
		sql="truncate table inittime";
		DataJDBCConnection.update(sql);
		sql="insert into inittime values (countt,'"+time+"')";
		DataJDBCConnection.update(sql);
	}

	public ArrayList<BankAccountPO> findBaseAccount() throws RemoteException {
		ArrayList<BankAccountPO> accountlist =new ArrayList<BankAccountPO>();
		BankAccountPO bankaccount;
		String sql="select * from bankaccount_init";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				bankaccount=new BankAccountPO(rs.getString("name"), rs.getString("number"), Double.parseDouble(rs.getString("money")));
				accountlist.add(bankaccount);
			}

		} catch (SQLException e) {
			return null;
		}
		return accountlist;
	}

	public ArrayList<AgencyPO> findBaseAgency() throws RemoteException {
		String sql="select * from agency_init";
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

	public AgencyPO find(String id) throws RemoteException {
		String sql="select * from agency_init where agencyId='"+id+"'";
		AgencyPO agency=null;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		
		try {
			rs.next();
			ArrayList<StaffPO> staffList=new ArrayList<StaffPO>();
			sql="select * from staff_init where agencyId='"+id+"'";
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
	
	
	public ArrayList<TruckPO> findBaseTruck() throws RemoteException {
		String sql="select * from truck_init";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		ArrayList<TruckPO> truckList=new ArrayList<TruckPO>();
		TruckPO truck;
		try {
			while(rs.next()){
				truck=new TruckPO(rs.getString("vehiclecode"), rs.getString("platenumber"), rs.getString("serviceTimeLimit"));
			    truckList.add(truck);
			}
		} catch (SQLException e) {
			return truckList;
		}
		return truckList;
	}

	public ArrayList<RepertoryInfoPO> findBaseRepertory()
			throws RemoteException {
		ArrayList<RepertoryInfoPO> repertoryinfo=new ArrayList<RepertoryInfoPO>();
		String sql="select * from repertoryinfo_init";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
				repertoryinfo.add(new RepertoryInfoPO(rs.getString("id"), rs.getString("areanumber"), rs.getString("rownumber"), rs.getString("framenumber"), rs.getString("placenumber"), rs.getString("goodid")));
		} catch (SQLException e) {
			System.out.println("查询失败");
			return repertoryinfo;
		}
		
		return repertoryinfo;
	}

	public String getTime() throws RemoteException {
		String sql="select * from inittime";
		String result=null;
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			result=rs.getString("timee");
		} catch (SQLException e) {
			return null;
			//e.printStackTrace();
		}
		return result;
	}

	


}
