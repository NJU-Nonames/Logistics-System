package dataservice.moneyInformation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.moneyInfomation.MoneyOutListPO;

public interface MoneyOutListDataService extends Remote{
	
	public void add(MoneyOutListPO moneyOutList)throws RemoteException;
	
	public void delete(String moneyOutListID)throws RemoteException;
	
	public void update(MoneyOutListPO moneyOutList)throws RemoteException;
	
	public MoneyOutListPO findOnID(String id)throws RemoteException;
	
	public MoneyOutListPO findOnTime(String time)throws RemoteException;
	
	public ArrayList<MoneyOutListPO> showAllByAgency(String agencyID)throws RemoteException;
	
	/**
	 * 返回付款单PO集合
	 * @param start_day
	 * @param end_day
	 * @return MonryInlistPO
	 */
	public ArrayList<MoneyOutListPO> showAll(String start_day, String end_day)throws RemoteException;

}
