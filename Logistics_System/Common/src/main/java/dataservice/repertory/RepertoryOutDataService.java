package dataservice.repertory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.repertory.RepertoryOutPO;

public interface RepertoryOutDataService extends Remote{
	
	public void add(RepertoryOutPO repertoryOut)throws RemoteException;
	
	public void delete(String repertoryOutID)throws RemoteException;

	public void update(RepertoryOutPO repertoryOut)throws RemoteException;
	
	public RepertoryOutPO findOnID(String id)throws RemoteException;
	
	public ArrayList<RepertoryOutPO> showByAgency(String start_day, String end_day,String id)throws RemoteException;
	
	public ArrayList<RepertoryOutPO> showAllByAgency(String agencyID)throws RemoteException;
	/**
	 * 返回出库单PO集合
	 * @param start_day
	 * @param end_day
	 * @return MonryInlistPO
	 */
	public ArrayList<RepertoryOutPO> showAll(String start_day, String end_day)throws RemoteException;
	
}


