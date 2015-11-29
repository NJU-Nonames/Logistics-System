package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.list.OrderListPO;
import utility.CheckType;
import utility.ExpressType;
import utility.PkgType;
import data.DataJDBCConnection;
import dataservice.list.OrderListDataService;

public class OrderListDataImpl extends UnicastRemoteObject implements OrderListDataService,Serializable {

	public OrderListDataImpl() throws RemoteException {
		super();
	}

	public void add(OrderListPO orderList) {
		String sql="insert into orderlist values ('"+orderList.getSenderName()+"','"+orderList.getSenderAddress()+"','"+orderList.getSenderTeleNumber()+"','"+orderList.getReceiverName()+"','"+
	                orderList.getReceiverAddress()+"','"+orderList.getReceiverTeleNumber()+"',"+orderList.getNumber()+","+orderList.getWeight()+","+orderList.getVolume()+",'"+
				    orderList.getName()+"','"+orderList.getCategory()+"',"+orderList.getPackPrice()+",'"+orderList.getPkgType()+"','"+orderList.getBarCode()+"','"+orderList.getDepartTime()+"','"+orderList.getArriveTime()+"','"+orderList.getCheckType()+"')";
		for(int i=0;i<orderList.getPkgState().size();i++)
		{
			String state=orderList.getPkgState().get(i);
			String sql2="insert into orderpath values ('"+orderList.getBarCode()+"','"+state+"')";
			DataJDBCConnection.update(sql2);
		}
		DataJDBCConnection.update(sql);
	}

	public void delete(String ID) {
		String sql="delete from orderlist where barCode='"+ID+"'";
		DataJDBCConnection.update(sql);
		String sql2="delete from orderpath where barcode='"+ID+"'";
		DataJDBCConnection.update(sql2);
		
	}

	public void update(OrderListPO orderList) {
		this.delete(orderList.getBarCode());
        this.add(orderList);		
	}

	public OrderListPO find(String id) {
		String sql="select * from orderlist where barCode='"+id+"'";
		OrderListPO orderList=null; 
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			orderList=new OrderListPO(rs.getString("senderName"), rs.getString("senderAddress"), rs.getString("senderTeleNumber"), rs.getString("receiverName"), rs.getString("receiverAddress"), rs.getString("receiverTeleNumber"), rs.getString("number"), rs.getDouble("weight"), rs.getDouble("volume"), rs.getString("name"), ExpressType.valueOf(rs.getString("category")), null, rs.getDouble("packPrice"), rs.getString("barCode"),PkgType.valueOf( rs.getString("PkgType")), rs.getString("departTime"), rs.getString("arriveTime"),CheckType.valueOf(rs.getString("checkstate")));
			String sql2="select * from orderpath where barcode='"+id+"'";
			ResultSet rs2=(ResultSet) DataJDBCConnection.find(sql2);
			ArrayList<String> path=null;
			while(rs2.next())
			{
				path=new ArrayList<String>();
				path.add(rs2.getString("content"));
			}
			orderList.setPkgState(path);
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("操作失败 未找到");
			//return null;
		}
		return orderList;
	}

	public ArrayList<OrderListPO> showAll(String time1, String time2) {
		String sql="select * from orderlist where departTime>='"+time1+"' and departTime<='"+time2+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		ArrayList<OrderListPO> orderlist=new ArrayList<OrderListPO>();
		try {
			while(rs.next())
			{
				orderlist.add(this.find(rs.getString("barCode")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
			//System.out.println("操作失败 未找到");
			//return null;
		}
		return orderlist;
	}

}
