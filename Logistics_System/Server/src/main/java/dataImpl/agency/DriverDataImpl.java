package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.agency.DriverPO;
import dataservice.agency.DriverDataService;

public class DriverDataImpl extends UnicastRemoteObject implements DriverDataService,Serializable{

	public DriverDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public void add(DriverPO driver) throws RemoteException {
		// TODO Auto-generated method stub
		
	}



	public void delete(String driverID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}



	public void update(DriverPO driver) throws RemoteException {
		// TODO Auto-generated method stub
		
	}
	

	public DriverPO find(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DriverPO> showAll(String Hall_Num) {
		// TODO Auto-generated method stub
		return null;
	}

}
