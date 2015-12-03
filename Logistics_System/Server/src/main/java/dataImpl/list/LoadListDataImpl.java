package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.list.LoadListPO;
import utility.CheckType;
import data.DataJDBCConnection;
import dataservice.list.LoadListDataService;

public class LoadListDataImpl extends UnicastRemoteObject implements LoadListDataService,Serializable {

	public LoadListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(LoadListPO loadListPO) throws RemoteException {
		String sql="insert into loadlist values ('"+loadListPO.getTransportationNumber()+"','"+loadListPO.getDate()+"','"+loadListPO.getTransportationNumber()+"','"+loadListPO.getDestination()
				+"','"+loadListPO.getCarNumber()+"','"+loadListPO.getGuardMan()+"','"+loadListPO.getSupercargoMan()+"','"+loadListPO.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		int num=loadListPO.getBarcodes().size();
		for(int i=0;i<num;i++)
		{
             String sql2="insert into loadlist_barcode values (primarykey,'"+loadListPO.getBarcodes().get(i)+"','"+loadListPO.getTransportationNumber()+"')";			
		     DataJDBCConnection.update(sql2);
		}

	}

	public void delete(String ID) throws RemoteException {
		String sql="delete from loadlist where transportationNumber='"+ID+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from loadlist_barcode where transportationNumber="+ID+"'";
		DataJDBCConnection.update(sql2);
		
	}

	public void update(LoadListPO loadListPO) throws RemoteException {
		this.delete(loadListPO.getTransportationNumber());
		this.add(loadListPO);
		
	}

	public LoadListPO find(String id) throws RemoteException {
		String sql="select * from loadlist where transportationNumber='"+id+"'";
		LoadListPO loadlist=null;
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			String sql2="select * from loadlist_barcode where transportationNumber='"+id+"'";
			ResultSet rs2=DataJDBCConnection.find(sql2);
			ArrayList<String> barcode=new ArrayList<String>();
			while(rs2.next()){
				barcode.add(rs2.getString("barcode"));
			}
			loadlist=new LoadListPO(rs.getString("transportationNumber"), rs.getString("timee"), rs.getString("hallnumber"), rs.getString("destination"), rs.getString("carnumber"), rs.getString("guardman"), rs.getString("supercargoman"), barcode, CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
			return null;
		}
		return loadlist;
	}

	public ArrayList<LoadListPO> showAll(String time1, String time2)
			throws RemoteException {
		ArrayList<LoadListPO> loadList=new ArrayList<LoadListPO>();
		String sql="select * from loadlist where timee<='"+time2+"' and timee>='"+time1+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				loadList.add(this.find(rs.getString("transportationNumber")));
			}
			
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
			return loadList;
		}
		return loadList;
	}

	public ArrayList<LoadListPO> showAllByAgency(String agencyID)
			throws RemoteException {
		ArrayList<LoadListPO> loadList=new ArrayList<LoadListPO>();
		String sql="select * from loadlist where transportationNumber like '"+agencyID+"%'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				loadList.add(this.find(rs.getString("transportationNumber")));
			}
			
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
			return loadList;
		}
		return loadList;
	}



}
