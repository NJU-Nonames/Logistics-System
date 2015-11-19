package dataImpl.receiver;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.receiver.ReceiverPO;
import dataservice.receiver.ReceiverDataService;

public class ReceiverDataImpl extends UnicastRemoteObject implements ReceiverDataService,Serializable {

	public ReceiverDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(ReceiverPO receiver) {
		// TODO Auto-generated method stub
		return false;
	}

	public ReceiverPO findOnName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	public ReceiverPO findOnTime(String time) {
		// TODO Auto-generated method stub
		return null;
	}

}
