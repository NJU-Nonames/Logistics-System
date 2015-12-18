package dataservice.system;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ConnectedDataService extends Remote{
	
	public boolean isConnected() throws RemoteException;

}
