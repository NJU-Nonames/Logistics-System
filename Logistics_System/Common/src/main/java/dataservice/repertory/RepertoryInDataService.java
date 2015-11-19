package dataservice.repertory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.repertory.RepertoryInPO;

public interface RepertoryInDataService extends Remote{
		
		public boolean add(RepertoryInPO repertoryIn)throws RemoteException;
		
		public boolean delete(RepertoryInPO repertoryIn)throws RemoteException;
		
		public boolean update(RepertoryInPO repertoryIn)throws RemoteException;
		
		public RepertoryInPO findOnID(String id)throws RemoteException;
		
		public ArrayList<RepertoryInPO> findOnTime(String time)throws RemoteException;
		
		/**
		 * 返回入库单PO集合
		 * @param start_day
		 * @param end_day
		 * @return MonryInlistPO
		 */
		public ArrayList<RepertoryInPO> showAll(String start_day, String end_day)throws RemoteException;
		
	}

