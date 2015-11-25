package dataImpl.moneyInformation;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.moneyInfomation.MoneyOutListPO;
import utility.CheckType;
import utility.CostClause;
import data.DataJDBCConnection;
import dataservice.moneyInformation.MoneyOutListDataService;

public class MoneyOutListDataImpl extends UnicastRemoteObject implements MoneyOutListDataService,Serializable {

	public MoneyOutListDataImpl() throws RemoteException {
		super();
	}

	public void add(MoneyOutListPO moneyOutList) throws RemoteException {
		String sql="insert into moneyoutlist values ('"+moneyOutList.getId()+"','"+moneyOutList.getDate()+"',"+moneyOutList.getMoney()+",'"+moneyOutList.getPayer()+"','"+moneyOutList.getAccountNum()+"','"+moneyOutList.getClause()+"','"+moneyOutList.getNote()+"','"+moneyOutList.getCheckType()+"')";
	    DataJDBCConnection.update(sql);
	}

	public void delete(String moneyOutListID) throws RemoteException {
		String sql="delete from moneyoutlist where id='"+moneyOutListID+"'";
		 DataJDBCConnection.update(sql);
	
	}

	public void update(MoneyOutListPO moneyOutList) throws RemoteException {
		this.delete(moneyOutList.getId());
		this.add(moneyOutList);
		
	}

	public MoneyOutListPO findOnID(String id) throws RemoteException {
		MoneyOutListPO moneyOutList=null;
		String sql="select * from moneyoutlist where id='"+id+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			moneyOutList=new MoneyOutListPO(id, rs.getString("timee"), rs.getDouble("money"), rs.getString("payer"), rs.getString("accountNum"), CostClause.valueOf(rs.getString("clause")), rs.getString("note"),CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			return null;
		}
		return moneyOutList;
	}

	public MoneyOutListPO findOnTime(String time) throws RemoteException {
		MoneyOutListPO moneyOutList=null;
		String sql="select * from moneyoutlist where timee='"+time+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			moneyOutList=new MoneyOutListPO(rs.getString("id"), rs.getString("timee"), rs.getDouble("money"), rs.getString("payer"), rs.getString("accountNum"), CostClause.valueOf(rs.getString("clause")), rs.getString("note"),CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			return null;
		}
		return moneyOutList;
	}

	public ArrayList<MoneyOutListPO> showAll(String start_day, String end_day)
			throws RemoteException {
		ArrayList<MoneyOutListPO> moneyOutList=new ArrayList<MoneyOutListPO>();
		String sql="select * from moneyoutlist where timee<='"+end_day+"' and timee>='"+start_day+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				MoneyOutListPO moneyoutlist=this.findOnID(rs.getString("id"));
				moneyOutList.add(moneyoutlist);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moneyOutList;
	}

	
}
