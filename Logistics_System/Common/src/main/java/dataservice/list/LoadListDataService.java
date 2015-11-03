package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.HallArrivalListPO;
import po.list.LoadListPO;
import po.list.OrderListPO;


public interface LoadListDataService extends Remote{
	
	public static final String NAME="loadListDataService";
	
	public boolean add(LoadListPO loadListPO);
	
     public boolean delete (LoadListPO loadListPO)throws RemoteException;
	
	public boolean update (LoadListPO loadListPO)throws RemoteException;
	
	public LoadListPO find(String id)throws RemoteException;
	
	public ArrayList<LoadListPO> showAll(String time1,String time2)throws RemoteException;
}
