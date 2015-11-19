package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.agency.AgencyPO;
import dataservice.agency.AgencyDataService;

public class AgencyDataImpl  extends UnicastRemoteObject implements AgencyDataService,Serializable {

	public AgencyDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void salaryManage(String userID, String salary) {
		// TODO Auto-generated method stub

	}

	public void add(AgencyPO agency) {
		// TODO Auto-generated method stub

	}

	public void delete(AgencyPO agency) {
		// TODO Auto-generated method stub

	}

	public void update(AgencyPO agency) {
		// TODO Auto-generated method stub

	}

	public AgencyPO find(String id) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<AgencyPO> showAll() {
		// TODO Auto-generated method stub
		return null;
	}

}
