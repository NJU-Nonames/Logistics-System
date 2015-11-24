package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.repertory.RepertoryInPO;
import dataservice.repertory.RepertoryInDataService;

public class RepertoryInDataImpl extends UnicastRemoteObject implements RepertoryInDataService,Serializable {

	public RepertoryInDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(RepertoryInPO repertoryIn) {
		// TODO Auto-generated method stub
		
	}

	public void delete(String repertoryInID) {
		// TODO Auto-generated method stub
	
	}

	public void update(RepertoryInPO repertoryIn) {
		// TODO Auto-generated method stub
	
	}

	public RepertoryInPO findOnID(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RepertoryInPO> findOnTime(String time) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RepertoryInPO> showAll(String start_day, String end_day) {
		// TODO Auto-generated method stub
		return null;
	}

}
