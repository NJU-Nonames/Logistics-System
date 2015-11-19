/**
 * 2015年10月23日
 *author:
 *description:统计报表
 */
package dataservice.moneyInformation;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.moneyInfomation.MoneyInListPO;



/**
 * @author 谭期友
 * 2015-10-23 王家玮修改
 *
 */
public interface MoneyInListDataService extends Remote{
	
	public boolean add(MoneyInListPO moneyInList)throws RemoteException;
	
	public boolean delete(String moneyInListID)throws RemoteException;
	
	public boolean update(MoneyInListPO moneyInList)throws RemoteException;
	
	public MoneyInListPO findOnID(String id)throws RemoteException;
	
	public MoneyInListPO findOnTime(String time)throws RemoteException;
	
	/**
	 * 返回收款单PO集合
	 * @param start_day
	 * @param end_day
	 * @return MonryInlistPO
	 */
	public ArrayList<MoneyInListPO> showAll(String start_day, String end_day)throws RemoteException;
	
}
