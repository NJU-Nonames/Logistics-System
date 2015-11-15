package dataservice.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.TransArrivalListPO;


public interface TransArrivalListDataService extends Serializable{
	
	public boolean add(TransArrivalListPO transArrivalListPO);
	
     public boolean delete (TransArrivalListPO transArrivalListPO);
	
	public boolean update (TransArrivalListPO transArrivalListPO);
	
	public TransArrivalListPO find(String id);
	
	public ArrayList<TransArrivalListPO> showAll(String time1,String time2);


}
