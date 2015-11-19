package dataImpl.list;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.list.OrderListPO;
import dataservice.list.OrderListDataService;

public class OrderListDataImpl extends UnicastRemoteObject implements OrderListDataService,Serializable {

	public OrderListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(OrderListPO orderList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(OrderListPO orderList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(OrderListPO orderList) {
		// TODO Auto-generated method stub
		return false;
	}

	public OrderListPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<OrderListPO> showAll(String time1, String time2) {
		// TODO Auto-generated method stub
		return null;
	}

}
