package dataservice.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.TransShipmentListPO;


public interface TransShipmentListDataService extends Serializable{
	
	public boolean add(TransShipmentListPO transShipmentListPO);
	
     public boolean delete (TransShipmentListPO transShipmentListPO);
	
	public boolean update (TransShipmentListPO transShipmentListPO);
	
	public TransShipmentListPO find(String id);
	
	public ArrayList<TransShipmentListPO> showAll(String time1,String time2);


}