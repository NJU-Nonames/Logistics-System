package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.list.TransArrivalListPO;
import po.repertory.GoodsInfoPO;
import utility.CheckType;
import utility.GoodsState;
import data.DataJDBCConnection;
import dataservice.list.TransArrivalListDataService;

public class TransArrivalListDataImpl extends UnicastRemoteObject implements TransArrivalListDataService,Serializable {

	public TransArrivalListDataImpl() throws RemoteException {
		super();
	}

	public void add(TransArrivalListPO transArrivalListPO)
			throws RemoteException {
		String sql="insert into transarrivallist values ('"+transArrivalListPO.getId()+"','"+transArrivalListPO.getTransferNumber()+"','"+transArrivalListPO.getCenterNumber()+"','"+transArrivalListPO.getDate()+"','"+transArrivalListPO.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		int num=transArrivalListPO.getGoodsInfoPOs().size();
		for(int i=0;i<num;i++){
			GoodsInfoPO good=transArrivalListPO.getGoodsInfoPOs().get(i);
			String sql2="insert into transarrivallist_goodinfo values (primarykey,'"+good.getBarcode()+"','"+good.getState()+"','"+good.getDeparturePlace()+"','"+transArrivalListPO.getId()+"')";
			DataJDBCConnection.update(sql2);
		
		}
	}

	public void delete(String transArrivalListID) throws RemoteException {
		String sql="delete from transarrivallist where id='"+transArrivalListID+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from transarrivallist_goodinfo where id='"+transArrivalListID+"'";
		DataJDBCConnection.update(sql2);
		
	}

	public void update(TransArrivalListPO transArrivalListPO)
			throws RemoteException {
		this.delete(transArrivalListPO.getId());
		this.add(transArrivalListPO);
		
	}

	public TransArrivalListPO find(String id) throws RemoteException {
		TransArrivalListPO transarrivallist=null;
		String sql="select * from transarrivallist where id='"+id+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		String sql2="select * from transarrivallist_goodinfo where id='"+id+"'";
		ResultSet rs2=DataJDBCConnection.find(sql2);
		try {
			ArrayList<GoodsInfoPO> goodsinfo=new ArrayList<GoodsInfoPO>();
			while(rs2.next())
			{
				goodsinfo.add(new GoodsInfoPO(rs2.getString("barcode"), GoodsState.valueOf(rs2.getString("state")), rs2.getString("departureplace")));
			}
			transarrivallist=new TransArrivalListPO(id, rs.getString("transfernumber"), rs.getString("centernumber"), rs.getString("timee"), goodsinfo, CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
			return null;
		}
		
		return transarrivallist;
	}

	public ArrayList<TransArrivalListPO> showAll(String time1, String time2)
			throws RemoteException {
		ArrayList<TransArrivalListPO> transarrivallist=new ArrayList<TransArrivalListPO>();
		String sql="select * from transarrivallist where timee<='"+time2+"' and timee>='"+time1+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next()){
				transarrivallist.add(this.find(rs.getString("id")));
			}
		} catch (SQLException e) {
			System.out.println("操作失败");
			return null;
		}
		return transarrivallist;
	}

	public ArrayList<TransArrivalListPO> showAllByAgency(String agencyID)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
