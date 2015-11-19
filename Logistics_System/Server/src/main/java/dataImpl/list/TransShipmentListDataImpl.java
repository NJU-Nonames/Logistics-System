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

	public boolean add(TransShipmentListPO transShipmentListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(TransShipmentListPO transShipmentListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(TransShipmentListPO transShipmentListPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public TransShipmentListPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TransShipmentListPO> showAll(String time1, String time2) {
		// TODO Auto-generated method stub
		return null;
	}

}
