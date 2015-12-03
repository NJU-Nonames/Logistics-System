package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;
import com.mysql.jdbc.ResultSet;
import po.repertory.RepertoryInPO;
import po.repertory.RepertoryInfoPO;
import po.repertory.RepertoryOutPO;
import data.DataJDBCConnection;
import dataservice.repertory.RepertoryInfoDataService;

public class RepertoryInfoDataImpl extends UnicastRemoteObject implements RepertoryInfoDataService,Serializable {

	public RepertoryInfoDataImpl() throws RemoteException {
		super();
	}

	public void add(RepertoryInPO repertoryPO)
			throws RemoteException {
		String sql="insert into repertoryinfo values('"+repertoryPO.getId().substring(0, 6)+"','"+repertoryPO.getAreacode()+"','"+repertoryPO.getRownumber()
				+"','"+repertoryPO.getFramenumber()+"','"+repertoryPO.getPlacenumber()+"','"+repertoryPO.getNum()+"')";
		DataJDBCConnection.update(sql);
		
	}

	public void delete(RepertoryOutPO repertoryPO)
			throws RemoteException {
		String sql="delete from repertoryinfo where goodid='"+repertoryPO.getCode()+"'";
		DataJDBCConnection.update(sql);
	}
	
	public void update(RepertoryInfoPO repertoryInfoPO) throws RemoteException {
		String sql="delete from repertoryinfo where goodid='"+repertoryInfoPO.getOrderId()+"'";
		DataJDBCConnection.update(sql);
		String sql2="insert into repertoryinfo values('"+repertoryInfoPO.getId()+"','"+repertoryInfoPO.getAreaNumber()+"','"+repertoryInfoPO.getRowNumber()
				+"','"+repertoryInfoPO.getFrameNumber()+"','"+repertoryInfoPO.getPlaceNumber()+"','"+repertoryInfoPO.getOrderId()+"')";
		DataJDBCConnection.update(sql2);
		
	}
	
	public RepertoryInfoPO findbyPlace(RepertoryInfoPO repertoryInfoPO){
		RepertoryInfoPO repertoryinfo=null;
		String sql="select * from repertoryinfo where id='"+repertoryInfoPO.getId()+"' and areanumber='"+repertoryInfoPO.getAreaNumber()+"' and rownumber='"+repertoryInfoPO.getRowNumber()+"' and framenumber='"+repertoryInfoPO.getFrameNumber()+"' and placenumber='"+repertoryInfoPO.getPlaceNumber()+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			repertoryinfo=new RepertoryInfoPO(repertoryInfoPO.getId(), rs.getString("areanumber"), rs.getString("rownumber"), rs.getString("framenumber"), rs.getString("placenumber"), rs.getString("orderid"));
		} catch (SQLException e) {
		    return null;
		}
		return repertoryinfo;
		
	}
	
	public RepertoryInfoPO findbyID(String id){
		RepertoryInfoPO repertoryinfo=null;
		String sql="select * from repertoryinfo where orderid='"+id+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			repertoryinfo=new RepertoryInfoPO(id, rs.getString("areanumber"), rs.getString("rownumber"), rs.getString("framenumber"), rs.getString("placenumber"), rs.getString("orderid"));
		} catch (SQLException e) {
		    return null;
		}
		return repertoryinfo;
	}

	public ArrayList<RepertoryInfoPO> show(String id) {
		ArrayList<RepertoryInfoPO> repertoryinfo=new ArrayList<RepertoryInfoPO>();
		String sql="select * from repertoryinfo where id='"+id+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			repertoryinfo.add(new RepertoryInfoPO(id, rs.getString("areanumber"), rs.getString("rownumber"), rs.getString("framenumber"), rs.getString("placenumber"), rs.getString("goodid")));
		} catch (SQLException e) {
			System.out.println("查询失败");
			return repertoryinfo;
		}
		
		return repertoryinfo;
	}



}
