package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.list.LoadListPO;
import dataservice.list.LoadListDataService;

public class LoadListDataImpl extends UnicastRemoteObject implements LoadListDataService,Serializable {

	public LoadListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(LoadListPO loadListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(LoadListPO loadListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(LoadListPO loadListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public LoadListPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<LoadListPO> showAll(String time1, String time2) {
		// TODO Auto-generated method stub
		return null;
	}

}
