package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.OrderListPO;

public interface OrderListDataService extends Remote{
	
	public boolean add (OrderListPO orderList)throws RemoteException;
	
	public boolean delete (OrderListPO orderList)throws RemoteException;
	
	public boolean update (OrderListPO orderList)throws RemoteException;
	
	public OrderListPO find(String id)throws RemoteException;
	
	public ArrayList<OrderListPO> showAll(String time1,String time2)throws RemoteException;

}
