package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.agency.DriverPO;
import data.DataJDBCConnection;
import dataservice.agency.DriverDataService;

public class DriverDataImpl extends UnicastRemoteObject implements DriverDataService,Serializable{

	public DriverDataImpl() throws RemoteException {
		super();
	}

	
	public void add(DriverPO driver) throws RemoteException {
		String sql="insert into driver values ('"+driver.getDriverNum()+"','"+driver.getName()+"','"+driver.getIDNum()
				+"','"+driver.getPhoneNum()+"','"+driver.getSex()+"','"+driver.getDrivingLicencePeriodstarttime()+"')";
		DataJDBCConnection.update(sql);
		
	}



	public void delete(String driverID) throws RemoteException {
		String sql="delete from driver where driverNum='"+driverID+"'";
		DataJDBCConnection.update(sql);
		
	}



	public void update(DriverPO driver) throws RemoteException {
		this.delete(driver.getDriverNum());
		this.add(driver);
		
	}
	

	public DriverPO find(String num) {
		DriverPO driver=null;
		String sql="select * from driver where driverNum='"+num+"'";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			driver=new DriverPO(rs.getString("driverNum"), rs.getString("name"), rs.getString("sex"), rs.getString("idNum"), rs.getString("phoneNum"), rs.getString("drivingLicencePeriod"));
		} catch (SQLException e) {
			return null;
		}
		
		return driver;
	}

	public ArrayList<DriverPO> showAll(String Hall_Num) {
		String sql="select * from driver where driverNum like '"+Hall_Num+"%'";
		ArrayList<DriverPO> driverList=new ArrayList<DriverPO>();
		DriverPO driver;
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			while(rs.next()){
				driver=new DriverPO(rs.getString("driverNum"), rs.getString("name"), rs.getString("sex"), rs.getString("idNum"), rs.getString("phoneNum"), rs.getString("drivingLicencePeriod"));
			    driverList.add(driver);
			}
		} catch (SQLException e) {
			return driverList;
		}
		
		
		return driverList;
	}

}
