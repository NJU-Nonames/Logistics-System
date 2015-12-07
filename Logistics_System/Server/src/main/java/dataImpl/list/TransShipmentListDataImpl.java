package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.list.TransShipmentListPO;
import utility.CheckType;
import data.DataJDBCConnection;
import dataservice.list.TransShipmentListDataService;

public class TransShipmentListDataImpl extends UnicastRemoteObject implements TransShipmentListDataService,Serializable {

	public TransShipmentListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(TransShipmentListPO transShipmentListPO)
			throws RemoteException {
		String sql="insert into transshipmentlist values ('"+transShipmentListPO.getTransitDocNumber()+"','"+transShipmentListPO.getDate()+"','"+transShipmentListPO.getFlightNumber()+"','"+transShipmentListPO.getDeparturePlace()+"','"+
			transShipmentListPO.getDestination()+"','"+transShipmentListPO.getContainerNumber()+"','"+transShipmentListPO.getSupercargoMan()+"',"+transShipmentListPO.getPrice()+",'"+transShipmentListPO.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		int num=transShipmentListPO.getBarcodes().size();
		for(int i=0;i<num;i++)
		{
			String sql2="insert into transshipmentlist_barcode values (primarykey,'"+transShipmentListPO.getBarcodes().get(i)+"','"+transShipmentListPO.getTransitDocNumber()+"')";
			DataJDBCConnection.update(sql2);
		}
		
	}

	public void delete(String transShipmentListID) throws RemoteException {
		String sql="delete from transshipmentlist where id='"+transShipmentListID+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from transshipmentlist_barcode where id='"+transShipmentListID+"'";
		DataJDBCConnection.update(sql2);
		
	}

	public void update(TransShipmentListPO transShipmentListPO)
			throws RemoteException {
		this.delete(transShipmentListPO.getTransitDocNumber());
		this.add(transShipmentListPO);
		
	}

	public TransShipmentListPO find(String id) throws RemoteException {
		TransShipmentListPO transshipmentlist=null;
		String sql="select * from transshipmentlist where id='"+id+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		String sql2="select * from transshipmentlist_barcode where id='"+id+"'";
		ResultSet rs2=DataJDBCConnection.find(sql2);
		try {
			rs.next();
			ArrayList<String> barcodes=new ArrayList<String>();
			while(rs2.next())
			{
				barcodes.add(rs2.getString("barcode"));
			}
			transshipmentlist=new TransShipmentListPO(rs.getString("timee"), rs.getString("id"), rs.getString("flightnumber"), rs.getString("departureplace"), rs.getString("destination"), rs.getString("containernumber"), rs.getString("supercargo"), barcodes, rs.getDouble("price"),CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("查找失败");
			return null;
		}
		return transshipmentlist;
	}

	public ArrayList<TransShipmentListPO> showAll(String time1, String time2)
			throws RemoteException {
		String sql="select * from transshipmentlist where timee<='"+time2+"' and timee>='"+time1+"'";
		ArrayList<TransShipmentListPO> transshipmentlist=new ArrayList<TransShipmentListPO>();
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				transshipmentlist.add(this.find(rs.getString("id")));
			}
			
		} catch (SQLException e) {
			System.out.println("有毒，没操作成");
			return transshipmentlist;
		}
		return transshipmentlist;
	}

	public ArrayList<TransShipmentListPO> showAllByAgency(String agencyID)
			throws RemoteException {
		String sql="select * from transshipmentlist where id like '"+agencyID+"%'";
		ArrayList<TransShipmentListPO> transshipmentlist=new ArrayList<TransShipmentListPO>();
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				transshipmentlist.add(this.find(rs.getString("id")));
			}
			
		} catch (SQLException e) {
			System.out.println("有毒，没操作成");
			return transshipmentlist;
		}
		return transshipmentlist;
	}

}
