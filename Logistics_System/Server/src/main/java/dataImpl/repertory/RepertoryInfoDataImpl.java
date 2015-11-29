package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.repertory.GoodsInfoPO;
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

	public ArrayList<RepertoryInfoPO> show(String id) {
		ArrayList<RepertoryInfoPO> repertoryinfo=new ArrayList<RepertoryInfoPO>();
		String sql="select * from repertoryinfo where id='"+id+"'";
		ResultSet rs=DataJDBCConnection.find(sql);
		try {
			rs.next();
			repertoryinfo.add(new RepertoryInfoPO(id, rs.getString("areanumber"), rs.getString("rownumber"), rs.getString("framenumber"), rs.getString("placenumber"), rs.getString("orderid")));
		} catch (SQLException e) {
			System.out.println("查询失败");
			return null;
		}
		
		return repertoryinfo;
	}


}
