package dataservice.informationchangedataservice._Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AgencyPO;
import dataservice.informationchangedataservice.PeopleAgencyDataService;

public class PeopleAgencyDataService_Stub implements PeopleAgencyDataService{

	public void salaryManage(String userID, String salary) {
		// TODO 自动生成的方法存根
		
	}

	public ArrayList<AgencyPO> showAll() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<AgencyPO> list=new ArrayList<AgencyPO>();
		list.add(new AgencyPO(null, null));
		return list;
	}

	public void add(AgencyPO agency) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void delete(AgencyPO agency) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void update(AgencyPO agency) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public AgencyPO find(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return new AgencyPO(id, null);
	}

}
