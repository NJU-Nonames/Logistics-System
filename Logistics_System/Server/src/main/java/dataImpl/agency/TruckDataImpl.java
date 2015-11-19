package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.agency.TruckPO;
import data.DataJDBCConnection;
import dataservice.agency.TruckDataService;

public class TruckDataImpl extends UnicastRemoteObject implements TruckDataService,Serializable {

	public TruckDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(TruckPO truck) {
		String sql="insert into truck values ("+truck.getVehiclecode()+",'"+truck.getPlatenumber()+"','"+truck.getServiceTimeLimit()+"')";
        DataJDBCConnection.update(sql);
	}

	public void delete(String vehicleCode) {
		String sql="delete from truck where vehiclecode="+vehicleCode;
		DataJDBCConnection.update(sql);
	}

	public void update(TruckPO truck) {
		this.delete(truck.getVehiclecode());
		this.add(truck);
	}

	public TruckPO find(String num) {
		TruckPO truck=null;
		String sql="select * from truck where vehiclecode="+num;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			truck=new TruckPO(rs.getString("vehiclecode"), rs.getString("platenumber"), rs.getString("serviceTimeLimit"));
		} catch (SQLException e) {
			return null;
		}
		return truck;
	}

	public ArrayList<TruckPO> showAll(String Hall_Num) {
		String sql="select * from truck";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		ArrayList<TruckPO> truckList=new ArrayList<TruckPO>();
		TruckPO truck;
		try {
			while(rs.next()){
				truck=new TruckPO(rs.getString("vehiclecode"), rs.getString("platenumber"), rs.getString("serviceTimeLimit"));
			    truckList.add(truck);
			}
		} catch (SQLException e) {
			return null;
		}
		return truckList;
	}

}
