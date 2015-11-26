package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.list.TransShipmentListPO;
import dataservice.list.TransShipmentListDataService;

public class TransShipmentListDataImpl extends UnicastRemoteObject implements TransShipmentListDataService,Serializable {

	public TransShipmentListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(TransShipmentListPO transShipmentListPO)
			throws RemoteException {
		String sql="insert into";
		
	}

	public void delete(String transShipmentListID) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void update(TransShipmentListPO transShipmentListPO)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public TransShipmentListPO find(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransShipmentListPO> showAll(String time1, String time2)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

}
