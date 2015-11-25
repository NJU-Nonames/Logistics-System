package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;
import po.list.HallArrivalListPO;
import utility.CheckType;
import utility.GoodsState;
import data.DataJDBCConnection;
import dataservice.list.HallArrivalListDataService;

public class HallArrivalListDataImpl extends UnicastRemoteObject implements HallArrivalListDataService,Serializable {

	public HallArrivalListDataImpl() throws RemoteException {
		super();
	}

	public void add(HallArrivalListPO hallArrivalListPO) throws RemoteException {
		String sql="insert into hallarrivallist values ('"+hallArrivalListPO.getId()+"','"+hallArrivalListPO.getDate()+"','"+hallArrivalListPO.getTransferNumber()+"','"+
	     hallArrivalListPO.getFrom()+"','"+hallArrivalListPO.getState()+"','"+hallArrivalListPO.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		int num=hallArrivalListPO.getBarCodes().size();
		for(int i=0;i<num;i++)
		{
             String sql2="insert into hallarrivallist_barcode values ('"+hallArrivalListPO.getBarCodes().get(i)+"','"+hallArrivalListPO.getId()+"')";			
		     DataJDBCConnection.update(sql2);
		}
	}

	public void delete(String hallArrivalListID) throws RemoteException {
		String sql="delete from hallarrivallist where id='"+hallArrivalListID+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from hallarrivallist_barcode where id='"+hallArrivalListID+"'";
		DataJDBCConnection.update(sql2);
	}

	public void update(HallArrivalListPO hallArrivalListPO)
			throws RemoteException {
		this.delete(hallArrivalListPO.getId());
		this.add(hallArrivalListPO);
		
	}

	public HallArrivalListPO find(String id) throws RemoteException {
		String sql="select * from hallarrivallist where id='"+id+"'";
		HallArrivalListPO hallarrivallist=null;
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			String sql2="select * from hallarrivallist_barcode where id='"+id+"'";
			ResultSet rs2=DataJDBCConnection.find(sql2);
			ArrayList<String> barcode=new ArrayList<String>();
			while(rs2.next()){
				barcode.add(rs2.getString("barcode"));
			}
			hallarrivallist=new HallArrivalListPO(id, rs.getString("timee"), rs.getString("transfernumber"), rs.getString("fromplace"), GoodsState.valueOf(rs.getString("state")), barcode, CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			return null;
		}
		return hallarrivallist;
	}

	public ArrayList<HallArrivalListPO> showAll(String time1, String time2)
			throws RemoteException {
		ArrayList<HallArrivalListPO> hallArrivalList=new ArrayList<HallArrivalListPO>();
		String sql="select * from hallarrivallist where timee<='"+time2+"' and timee>='"+time1+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next()){
				HallArrivalListPO hallArrivallist=this.find(rs.getString("id"));
				hallArrivalList.add(hallArrivallist);
			}
		} catch (SQLException e) {
			return null;
		}
		return hallArrivalList;
	}

	
}
