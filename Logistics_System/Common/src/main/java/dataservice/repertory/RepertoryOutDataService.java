package dataservice.repertory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.repertory.RepertoryInPO;
import po.repertory.RepertoryOutPO;

public interface RepertoryOutDataService extends Remote{
	
	public static final String NAME="repertoryOutDataService";
	
	public boolean add(RepertoryOutPO repertoryOut)throws RemoteException;
	
	public boolean delete(RepertoryOutPO repertoryOut)throws RemoteException;
	
	public boolean update(RepertoryOutPO repertoryOut)throws RemoteException;
	
	public RepertoryOutPO findOnID(String id)throws RemoteException;
	
	public ArrayList<RepertoryOutPO> findOnTime(String time)throws RemoteException;
	
	/**
	 * 返回出库单PO集合
	 * @param start_day
	 * @param end_day
	 * @return MonryInlistPO
	 */
	public ArrayList<RepertoryOutPO> showAll(String start_day, String end_day) throws RemoteException;
	
}


