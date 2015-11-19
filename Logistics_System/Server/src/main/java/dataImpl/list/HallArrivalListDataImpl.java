package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.list.HallArrivalListPO;
import dataservice.list.HallArrivalListDataService;

public class HallArrivalListDataImpl extends UnicastRemoteObject implements HallArrivalListDataService,Serializable {

	public HallArrivalListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(HallArrivalListPO hallArrivalListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(HallArrivalListPO hallArrivalListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(HallArrivalListPO hallArrivalListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public HallArrivalListPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<HallArrivalListPO> showAll(String time1, String time2) {
		// TODO Auto-generated method stub
		return null;
	}

}
