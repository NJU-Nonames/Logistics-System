package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.list.HallArrivalListPO;
import po.repertory.GoodsInfoPO;
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
	    hallArrivalListPO.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		int num=hallArrivalListPO.getGoodsInfoPO().size();
		for(int i=0;i<num;i++)
		{
             String sql2="insert into hallarrivallist_goodinfo values (primarykey,'"+hallArrivalListPO.getGoodsInfoPO().get(i).getBarcode()+"','"+hallArrivalListPO.getGoodsInfoPO().get(i).getState()+"','"+hallArrivalListPO.getGoodsInfoPO().get(i).getDeparturePlace()+"','"+hallArrivalListPO.getId()+"')";			
		     DataJDBCConnection.update(sql2);
		}
	}

	public void delete(String hallArrivalListID) throws RemoteException {
		String sql="delete from hallarrivallist where id='"+hallArrivalListID+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from hallarrivallist_goodinfo where id='"+hallArrivalListID+"'";
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
			String sql2="select * from hallarrivallist_goodinfo where id='"+id+"'";
			ResultSet rs2=DataJDBCConnection.find(sql2);
			ArrayList<GoodsInfoPO> barcode=new ArrayList<GoodsInfoPO>();
			while(rs2.next()){
				barcode.add(new GoodsInfoPO(rs2.getString("barcode"),GoodsState.valueOf(rs2.getString("state")),rs2.getString("departureplace")));
			}
			hallarrivallist=new HallArrivalListPO(id, rs.getString("timee"), rs.getString("transfernumber"), barcode, CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
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
			System.out.println("操作失败 未找到");
			return hallArrivalList;
		}
		return hallArrivalList;
	}

	public ArrayList<HallArrivalListPO> showAllByAgency(String agencyID)
			throws RemoteException {
		ArrayList<HallArrivalListPO> hallArrivalList=new ArrayList<HallArrivalListPO>();
		String sql="select * from hallarrivallist where id like '"+agencyID+"%'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next()){
				HallArrivalListPO hallArrivallist=this.find(rs.getString("id"));
				hallArrivalList.add(hallArrivallist);
			}
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
			return hallArrivalList;
		}
		return hallArrivalList;
	}

	
}
