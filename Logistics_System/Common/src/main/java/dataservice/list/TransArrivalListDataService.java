package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.TransArrivalListPO;


public interface TransArrivalListDataService extends Remote{
	
	public boolean add(TransArrivalListPO transArrivalListPO)throws RemoteException;
	
     public boolean delete (TransArrivalListPO transArrivalListPO)throws RemoteException;
	
	public boolean update (TransArrivalListPO transArrivalListPO)throws RemoteException;
	
	public TransArrivalListPO find(String id)throws RemoteException;
	
	public ArrayList<TransArrivalListPO> showAll(String time1,String time2)throws RemoteException;


}
