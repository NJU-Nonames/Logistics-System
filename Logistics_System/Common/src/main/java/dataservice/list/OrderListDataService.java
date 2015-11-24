package dataservice.list;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.OrderListPO;

public interface OrderListDataService extends Remote{
	
	public void add (OrderListPO orderList)throws RemoteException;
	
	public void delete (String orderListID)throws RemoteException;
	
	public void update (OrderListPO orderList)throws RemoteException;
	
	public OrderListPO find(String id)throws RemoteException;
	
	public ArrayList<OrderListPO> showAll(String time1,String time2)throws RemoteException;

}
