package dataservice.list;


import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.TransShipmentListPO;


public interface TransShipmentListDataService extends Remote{
	
	public boolean add(TransShipmentListPO transShipmentListPO)throws RemoteException;
	
     public boolean delete (String transShipmentListID)throws RemoteException;
	
	public boolean update (TransShipmentListPO transShipmentListPO)throws RemoteException;
	
	public TransShipmentListPO find(String id)throws RemoteException;
	
	public ArrayList<TransShipmentListPO> showAll(String time1,String time2)throws RemoteException;


}