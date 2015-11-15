package dataservice.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.OrderListPO;

public interface OrderListDataService extends Serializable{
	
	public boolean add (OrderListPO orderList);
	
	public boolean delete (OrderListPO orderList);
	
	public boolean update (OrderListPO orderList);
	
	public OrderListPO find(String id);
	
	public ArrayList<OrderListPO> showAll(String time1,String time2);

}
