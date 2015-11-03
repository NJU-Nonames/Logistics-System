package dataservice.moneyInformation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.moneyInfomation.MoneyInformationListPO;

public interface MoneyInformationListService extends Remote{
	
	public static final String NAME="moneyInformationListService";

	public boolean add(MoneyInformationListPO moneyInformationList) throws RemoteException;
	
	public ArrayList<MoneyInformationListPO> findOnTime(String time1,String time2)throws RemoteException;

}
