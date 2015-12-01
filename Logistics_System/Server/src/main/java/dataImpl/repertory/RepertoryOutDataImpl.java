package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.repertory.RepertoryOutPO;
import utility.CheckType;
import utility.TransportationType;
import data.DataJDBCConnection;
import dataservice.repertory.RepertoryOutDataService;

public class RepertoryOutDataImpl extends UnicastRemoteObject implements RepertoryOutDataService,Serializable {

	public RepertoryOutDataImpl() throws RemoteException {
		super();
	}

	public void add(RepertoryOutPO repertoryOut) {
		String sql="insert into repertoryout values ('"+repertoryOut.getId()+"','"+repertoryOut.getCode()+"','"+repertoryOut.getTime()+"','"+repertoryOut.getDestination()+"','"+repertoryOut.getTransportation()
				+"','"+repertoryOut.getTransCode()+"','"+repertoryOut.getVehicleCode()+"','"+repertoryOut.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		
	}

	public void delete(String repertoryOutID) {
		String sql="delete from repertoryout where id='"+repertoryOutID+"'";
		DataJDBCConnection.update(sql);
		
	}

	public void update(RepertoryOutPO repertoryOut) {
		this.delete(repertoryOut.getId());
		this.add(repertoryOut);
		
	}

	public RepertoryOutPO findOnID(String id) {
		RepertoryOutPO repertoryout=null;
		String sql="select * from repertoryout where id='"+id+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			repertoryout=new RepertoryOutPO(id, rs.getString("orderid"), rs.getString("timee"), rs.getString("destination"),TransportationType.valueOf(rs.getString("transportation")), rs.getString("transcode"), rs.getString("vehiclecode"), CheckType.valueOf(rs.getString("checkstate")));
		} catch (SQLException e) {
			System.out.println("查找失败");
			return null;
		}
		
		return repertoryout;
	}


	public ArrayList<RepertoryOutPO> showAll(String start_day, String end_day) {
		ArrayList<RepertoryOutPO> repertoryout=new ArrayList<RepertoryOutPO>();
		String sql="select * from repertoryout where timee<='"+end_day+"' and timee>='"+start_day+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				repertoryout.add(this.findOnID(rs.getString("id")));
			}
		} catch (SQLException e) {
			System.out.println("操作失败");
		}
		
		return repertoryout;
	}

	public ArrayList<RepertoryOutPO> showByAgency(String start_day,
			String end_day, String id) throws RemoteException {
		ArrayList<RepertoryOutPO> repertoryout=new ArrayList<RepertoryOutPO>();
		String sql="select * from repertoryout where timee<='"+end_day+"' and timee>='"+start_day+"' and id like '%"+id+"%'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				repertoryout.add(this.findOnID(rs.getString("id")));
			}
		} catch (SQLException e) {
			System.out.println("操作失败");
		}
		
		return repertoryout;
	}

}
