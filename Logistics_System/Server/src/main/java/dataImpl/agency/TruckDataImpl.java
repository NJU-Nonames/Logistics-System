package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.agency.TruckPO;
import dataservice.agency.TruckDataService;

public class TruckDataImpl extends UnicastRemoteObject implements TruckDataService,Serializable {

	public TruckDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(TruckPO truck) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(TruckPO truck) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(TruckPO truck) {
		// TODO Auto-generated method stub
		return false;
	}

	public TruckPO find(String num) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TruckPO> showAll(String Hall_Num) {
		// TODO Auto-generated method stub
		return null;
	}

}
