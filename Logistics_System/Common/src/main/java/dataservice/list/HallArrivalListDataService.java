package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.HallArrivalListPO;

public interface HallArrivalListDataService extends Remote{
	
	public boolean add (HallArrivalListPO hallArrivalListPO)throws RemoteException;
	
	public boolean delete (String hallArrivalListID)throws RemoteException;
	
	public boolean update (HallArrivalListPO hallArrivalListPO)throws RemoteException;
	
	public HallArrivalListPO find(String id)throws RemoteException;
	
	public ArrayList<HallArrivalListPO> showAll(String time1,String time2)throws RemoteException;
}
