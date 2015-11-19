package dataImpl.moneyInformation;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.moneyInfomation.MoneyInListPO;
import dataservice.moneyInformation.MoneyInListDataService;

public class MoneyInListDataImpl extends UnicastRemoteObject implements MoneyInListDataService,Serializable {

	public MoneyInListDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(MoneyInListPO moneyInList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(MoneyInListPO moneyInList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(MoneyInListPO moneyInList) {
		// TODO Auto-generated method stub
		return false;
	}

	public MoneyInListPO findOnID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public MoneyInListPO findOnTime(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MoneyInListPO> showAll(String start_day, String end_day) {
		// TODO Auto-generated method stub
		return null;
	}

}
