package dataservice.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.DeliveringListPO;

public interface DeliveringListDataService extends Serializable{
	
	public boolean add (DeliveringListPO deliveringList);
	
	public boolean delete (DeliveringListPO deliveringList);
	
	public boolean update (DeliveringListPO deliveringList);
	
	public DeliveringListPO find(String id);
	
	public ArrayList<DeliveringListPO> showAll(String time1,String time2);
}
