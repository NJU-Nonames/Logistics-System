package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.list.DeliveringListPO;
import dataservice.list.DeliveringListDataService;

public class DeliveringListDataImpl extends UnicastRemoteObject implements DeliveringListDataService,Serializable {

	public DeliveringListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(DeliveringListPO deliveringList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String deliveringListID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(DeliveringListPO deliveringList) {
		// TODO Auto-generated method stub
		return false;
	}

	public DeliveringListPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<DeliveringListPO> showAll(String time1, String time2) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
