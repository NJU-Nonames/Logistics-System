package dataservice.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.LoadListPO;


public interface LoadListDataService extends Serializable{
	
	public boolean add(LoadListPO loadListPO);
	
     public boolean delete (LoadListPO loadListPO);
	
	public boolean update (LoadListPO loadListPO);
	
	public LoadListPO find(String id);
	
	public ArrayList<LoadListPO> showAll(String time1,String time2);
}
