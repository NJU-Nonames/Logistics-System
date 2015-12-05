package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.repertory.RepertoryInPO;
import utility.CheckType;
import data.DataJDBCConnection;
import dataservice.repertory.RepertoryInDataService;

public class RepertoryInDataImpl extends UnicastRemoteObject implements RepertoryInDataService,Serializable {

	public RepertoryInDataImpl() throws RemoteException {
		super();
	}

	public void add(RepertoryInPO repertoryIn) {
		String sql="insert into repertoryin values ('"+repertoryIn.getId()+"','"+repertoryIn.getNum()+"','"+repertoryIn.getTime()+"','"+repertoryIn.getDestination()+"','"+repertoryIn.getAreacode()+"','"+repertoryIn.getRownumber()+
				"','"+repertoryIn.getFramenumber()+"','"+repertoryIn.getPlacenumber()+"','"+repertoryIn.getCheckType()+"')";
		DataJDBCConnection.update(sql);
		
	}

	public void delete(String repertoryInID) {
		String sql="delete from repertoryin where id='"+repertoryInID+"'";
		DataJDBCConnection.update(sql);
	
	}

	public void update(RepertoryInPO repertoryIn) {
		this.delete(repertoryIn.getId());
		this.add(repertoryIn);
	
	}

	public RepertoryInPO findOnOrderID(String orderID,String id){
		RepertoryInPO repertoryin=null;
		String sql="select * from repertoryin where orderid='"+orderID+"' and id like '"+id+"%'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			repertoryin=new RepertoryInPO(id,rs.getString("orderid") , rs.getString("timee"), rs.getString("destination"), rs.getString("arenumber"), rs.getString("rownumber"), rs.getString("framenumber"), rs.getString("placenumber"), CheckType.valueOf(rs.getString("checkstate")));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("出现问题,查找出错");
			return null;
		}
		return repertoryin;
	}
	
	public RepertoryInPO findOnID(String id) {
		RepertoryInPO repertoryin=null;
		String sql="select * from repertoryin where id='"+id+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			repertoryin=new RepertoryInPO(id,rs.getString("orderid") , rs.getString("timee"), rs.getString("destination"), rs.getString("arenumber"), rs.getString("rownumber"), rs.getString("framenumber"), rs.getString("placenumber"), CheckType.valueOf(rs.getString("checkstate")));
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("出现问题,查找出错");
			return null;
		}
		return repertoryin;
	}

	public ArrayList<RepertoryInPO> showAllByAgency(String start_day, String end_day,String agencyID) {
		ArrayList<RepertoryInPO> repertoryin=new ArrayList<RepertoryInPO>();
		String sql="select * from repertoryin where timee<='"+end_day+"' and timee>='"+start_day+"' and id like '"+agencyID+"%'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				System.out.println(rs.getString("id"));
				repertoryin.add(this.findOnID(rs.getString("id")));
			}
		} catch (SQLException e) {
			System.out.println("操作未成功");
			return repertoryin;
		}
		
		return repertoryin;
	}
	
	
	public ArrayList<RepertoryInPO> showAll(String start_day, String end_day) {
		ArrayList<RepertoryInPO> repertoryin=new ArrayList<RepertoryInPO>();
		String sql="select * from repertoryin where timee<='"+end_day+"' and timee>='"+start_day+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				repertoryin.add(this.findOnID(rs.getString("id")));
			}
		} catch (SQLException e) {
			System.out.println("操作未成功");
			return repertoryin;
		}
		
		return repertoryin;
	}

	public ArrayList<RepertoryInPO> showAllByAgency(String agencyID)
			throws RemoteException {
		ArrayList<RepertoryInPO> repertoryin=new ArrayList<RepertoryInPO>();
		String sql="select * from repertoryin where id like '"+agencyID+"%'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				repertoryin.add(this.findOnID(rs.getString("id")));
			}
		} catch (SQLException e) {
			System.out.println("操作未成功");
			return repertoryin;
		}
		
		return repertoryin;
	}
	

}
