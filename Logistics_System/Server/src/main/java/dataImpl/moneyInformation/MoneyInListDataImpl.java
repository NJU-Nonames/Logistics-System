package dataImpl.moneyInformation;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.moneyInfomation.MoneyInListPO;
import utility.CheckType;
import data.DataJDBCConnection;
import dataservice.moneyInformation.MoneyInListDataService;

public class MoneyInListDataImpl extends UnicastRemoteObject implements MoneyInListDataService,Serializable {

	public MoneyInListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(MoneyInListPO moneyInList) throws RemoteException {
		String sql="insert into moneyinlist values ('"+moneyInList.getId()+"','"+moneyInList.getDate()+"',"+moneyInList.getMoneySum()+",'"+moneyInList.getStaffId()+"','"+moneyInList.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		for(int i=0;i<moneyInList.getBarcode().size();i++)
		{
			String sql2="insert into moneyinlist_barcode values (primarykey,'"+moneyInList.getBarcode().get(i)+"','"+moneyInList.getId()+"')";
			DataJDBCConnection.update(sql2);
		}
	}

	public void delete(String moneyInListID) throws RemoteException {
		String sql="delete from moneyinlist where id='"+moneyInListID+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from moneyinlist_barcode where id='"+moneyInListID+"'";
		DataJDBCConnection.update(sql2);
	
	}

	public void update(MoneyInListPO moneyInList) throws RemoteException {
		this.delete(moneyInList.getId());
		this.add(moneyInList);
	}

	public MoneyInListPO findOnID(String id) throws RemoteException {
		String sql="select * from moneyinlist where id='"+id+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		MoneyInListPO moneyInList=null;
		try {
			rs.next();
			ArrayList<String> barcode=new ArrayList<String>();
			String sql2="select * from moneyinlist_barcode where id='"+id+"'";
			ResultSet rs2=(ResultSet) DataJDBCConnection.find(sql2);
			while(rs2.next())
			{
				barcode.add(rs2.getString("barcode"));
			}
			moneyInList=new MoneyInListPO(id, rs.getString("timee"), rs.getDouble("moneySum"), rs.getString("staffId"), barcode,CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			return null;
		}
		
		return moneyInList;
	}

	public MoneyInListPO findOnTime(String time) throws RemoteException {
		String sql="select * from moneyinlist where timee='"+time+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		MoneyInListPO moneyInList=null;
		try {
			rs.next();
			ArrayList<String> barcode=new ArrayList<String>();
			String sql2="select * from moneyinlist_barcode where id='"+rs.getString("id")+"'";
			ResultSet rs2=(ResultSet) DataJDBCConnection.find(sql2);
			while(rs2.next())
			{
				barcode.add(rs2.getString("barcode"));
			}
			moneyInList=new MoneyInListPO(rs.getString("id"), time, rs.getDouble("moneySum"), rs.getString("staffId"), barcode,CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			return null;
		}
		
		return moneyInList;
	}

	public ArrayList<MoneyInListPO> showAll(String start_day, String end_day)
			throws RemoteException {
		ArrayList<MoneyInListPO> moneyInList=new ArrayList<MoneyInListPO>();
		String sql="select * from moneyinlist where timee>='"+start_day+"' and timee <='"+end_day+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			while(rs.next()){
				MoneyInListPO moneyinlist=this.findOnID(rs.getString("id"));
				moneyInList.add(moneyinlist);
			}
		} catch (SQLException e) {
			return null;
		}
		return moneyInList;
	}



	

}
