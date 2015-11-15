package dataservice.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.HallArrivalListPO;

public interface HallArrivalListDataService extends Serializable{
	
	public boolean add (HallArrivalListPO hallArrivalListPO);
	
	public boolean delete (HallArrivalListPO hallArrivalListPO);
	
	public boolean update (HallArrivalListPO hallArrivalListPO);
	
	public HallArrivalListPO find(String id);
	
	public ArrayList<HallArrivalListPO> showAll(String time1,String time2);
}
