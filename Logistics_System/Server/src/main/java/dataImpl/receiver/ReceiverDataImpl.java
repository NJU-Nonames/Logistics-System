package dataImpl.receiver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

import com.mysql.jdbc.ResultSet;

import po.receiver.ReceiverPO;
import data.DataJDBCConnection;
import dataservice.receiver.ReceiverDataService;

public class ReceiverDataImpl extends UnicastRemoteObject implements ReceiverDataService,Serializable {

	public ReceiverDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(ReceiverPO receiver) {
		String sql="insert into receiver values ('"+receiver.getName()+"','"+receiver.getTime()+"')";
		DataJDBCConnection.update(sql);
		
	}

	public ReceiverPO findOnName(String name) {
		ReceiverPO receiver=null;
		String sql="select * from receiver where name="+name;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			receiver=new ReceiverPO(rs.getString("name"), rs.getString("receive_time"));
		} catch (SQLException e) {
			return null;
		}
		return receiver;
	}

	public ReceiverPO findOnTime(String time) {
		ReceiverPO receiver=null;
		String sql="select * from receiver where receive_time="+time;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			receiver=new ReceiverPO(rs.getString("name"), rs.getString("receive_time"));
		} catch (SQLException e) {
			return null;
		}
		return receiver;
	}

}
