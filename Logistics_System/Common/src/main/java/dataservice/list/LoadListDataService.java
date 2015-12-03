package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.list.LoadListPO;


public interface LoadListDataService extends Remote{
	
	public void add(LoadListPO loadListPO)throws RemoteException;
	
     public void delete (String ID)throws RemoteException;
	
	public void update (LoadListPO loadListPO)throws RemoteException;
	
	public LoadListPO find(String id)throws RemoteException;
	
	public ArrayList<LoadListPO> showAllByAgency(String agencyID)throws RemoteException;
	
	public ArrayList<LoadListPO> showAll(String time1,String time2)throws RemoteException;
}
