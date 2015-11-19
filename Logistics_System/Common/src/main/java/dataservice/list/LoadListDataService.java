package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.LoadListPO;


public interface LoadListDataService extends Remote{
	
	public boolean add(LoadListPO loadListPO)throws RemoteException;
	
     public boolean delete (String ID)throws RemoteException;
	
	public boolean update (LoadListPO loadListPO)throws RemoteException;
	
	public LoadListPO find(String id)throws RemoteException;
	
	public ArrayList<LoadListPO> showAll(String time1,String time2)throws RemoteException;
}
