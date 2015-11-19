package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.list.TransArrivalListPO;
import dataservice.list.TransArrivalListDataService;

public class TransArrivalListDataImpl extends UnicastRemoteObject implements TransArrivalListDataService,Serializable {

	public TransArrivalListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(TransArrivalListPO transArrivalListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String ID) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(TransArrivalListPO transArrivalListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public TransArrivalListPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransArrivalListPO> showAll(String time1, String time2) {
		// TODO Auto-generated method stub
		return null;
	}

}
