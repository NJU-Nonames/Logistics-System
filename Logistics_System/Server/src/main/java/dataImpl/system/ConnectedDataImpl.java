package dataImpl.system;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.system.ConnectedDataService;

public class ConnectedDataImpl extends UnicastRemoteObject implements ConnectedDataService,Serializable {

	public ConnectedDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean isConnected() throws RemoteException {
		return true;
	}

}
