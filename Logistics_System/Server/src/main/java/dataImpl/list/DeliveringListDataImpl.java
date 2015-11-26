package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.list.DeliveringListPO;
import utility.CheckType;
import data.DataJDBCConnection;
import dataservice.list.DeliveringListDataService;

public class DeliveringListDataImpl extends UnicastRemoteObject implements DeliveringListDataService,Serializable {

	public DeliveringListDataImpl() throws RemoteException {
		super();
		
	}

	public void add(DeliveringListPO deliveringList) throws RemoteException{
		String sql="insert into deliveringlist values ('"+deliveringList.getId()+"','"+deliveringList.getDate()+"','"+deliveringList.getDeliveryMan()+"','"+deliveringList.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		for(int i=0;i<deliveringList.getBarCode().size();i++){
			String sql2="insert into deliveringlist_barcode values ('"+deliveringList.getBarCode().get(i)+"','"+deliveringList.getId()+"')";
		    DataJDBCConnection.update(sql2);
		}
	}

	public void delete(String deliveringListID) throws RemoteException {
		String sql="select from deliveringlist where id='"+deliveringListID+"'";
		DataJDBCConnection.update(sql);
		String sql2="select from deliveringlist_barcode where id='"+deliveringListID+"'";
		DataJDBCConnection.update(sql2);
		
	}

	public void update(DeliveringListPO deliveringList) throws RemoteException{
		this.delete(deliveringList.getId());
		this.add(deliveringList);
	}

	public DeliveringListPO find(String id) throws RemoteException{
		String sql="select * from deliveringlist where id='"+id+"'";
		DeliveringListPO deliveringlist=null;
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			String sql2="select * from deliveringlist_barcode where id='"+id+"'";
			ResultSet rs2=DataJDBCConnection.find(sql2);
			ArrayList<String> barcode=new ArrayList<String>();
			while(rs2.next()){
				barcode.add(rs2.getString("barcode"));
			}
			deliveringlist=new DeliveringListPO(id, rs.getString("timee"), barcode, rs.getString("deliveryman"), CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
			return null;
		}
		return deliveringlist;
	}

	public ArrayList<DeliveringListPO> showAll(String time1, String time2) throws RemoteException{
		ArrayList<DeliveringListPO> deliveringList=new ArrayList<DeliveringListPO>();
		String sql="select * from deliveringlist where timee<='"+time2+"' and timee>='"+time1+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next()){
				DeliveringListPO deliveringlist=this.find(rs.getString("id"));
				deliveringList.add(deliveringlist);
			}
		} catch (SQLException e) {
			System.out.println("操作失败 未找到");
			return null;
		}
		return deliveringList;
	}

	

}
