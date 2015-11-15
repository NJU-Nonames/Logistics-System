package dataservice.moneyInformation;

import java.io.Serializable;
import java.util.ArrayList;

import po.moneyInfomation.MoneyOutListPO;

public interface MoneyOutListDataService extends Serializable{
	
	public boolean add(MoneyOutListPO moneyOutList);
	
	public boolean delete(MoneyOutListPO moneyOutList);
	
	public boolean update(MoneyOutListPO moneyOutList);
	
	public MoneyOutListPO findOnID(String id);
	
	public MoneyOutListPO findOnTime(String time);
	
	/**
	 * 返回付款单PO集合
	 * @param start_day
	 * @param end_day
	 * @return MonryInlistPO
	 */
	public ArrayList<MoneyOutListPO> showAll(String start_day, String end_day);

}
