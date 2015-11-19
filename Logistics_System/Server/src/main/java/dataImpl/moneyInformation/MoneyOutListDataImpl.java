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

	public boolean add(MoneyOutListPO moneyOutList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(MoneyOutListPO moneyOutList) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(MoneyOutListPO moneyOutList) {
		// TODO Auto-generated method stub
		return false;
	}

	public MoneyOutListPO findOnID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public MoneyOutListPO findOnTime(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<MoneyOutListPO> showAll(String start_day, String end_day) {
		// TODO Auto-generated method stub
		return null;
	}

}
