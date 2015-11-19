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

	public boolean add(DriverPO driver) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(DriverPO driver) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(DriverPO driver) {
		// TODO Auto-generated method stub
		return false;
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
