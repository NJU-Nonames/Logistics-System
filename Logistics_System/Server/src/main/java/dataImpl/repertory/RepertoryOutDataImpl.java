package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.repertory.RepertoryOutPO;
import dataservice.repertory.RepertoryOutDataService;

public class RepertoryOutDataImpl extends UnicastRemoteObject implements RepertoryOutDataService,Serializable {

	public RepertoryOutDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(RepertoryOutPO repertoryOut) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(RepertoryOutPO repertoryOut) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean update(RepertoryOutPO repertoryOut) {
		// TODO Auto-generated method stub
		return false;
	}

	public RepertoryOutPO findOnID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RepertoryOutPO> findOnTime(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RepertoryOutPO> showAll(String start_day, String end_day) {
		// TODO Auto-generated method stub
		return null;
	}

}
