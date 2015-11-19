package dataImpl.moneyInformation;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.moneyInfomation.MoneyOutListPO;
import dataservice.moneyInformation.MoneyOutListDataService;

public class MoneyOutListDataImpl extends UnicastRemoteObject implements MoneyOutListDataService,Serializable {

	public MoneyOutListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(MoneyOutListPO moneyOutList) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(String moneyOutListID) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(MoneyOutListPO moneyOutList) throws RemoteException {
		// TODO Auto-generated method stub
		return false;
	}

	public MoneyOutListPO findOnID(String id) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MoneyOutListPO findOnTime(String time) throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MoneyOutListPO> showAll(String start_day, String end_day)
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	
}
