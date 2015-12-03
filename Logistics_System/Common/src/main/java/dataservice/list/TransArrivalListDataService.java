package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.list.TransArrivalListPO;


public interface TransArrivalListDataService extends Remote{
	
	public void add(TransArrivalListPO transArrivalListPO)throws RemoteException;
	
     public void delete (String transArrivalListID)throws RemoteException;
	
	public void update (TransArrivalListPO transArrivalListPO)throws RemoteException;
	
	public TransArrivalListPO find(String id)throws RemoteException;
	
	public ArrayList<TransArrivalListPO> showAllByAgency(String agencyID)throws RemoteException;
	
	public ArrayList<TransArrivalListPO> showAll(String time1,String time2)throws RemoteException;


}
