package dataservice.userdataservice._Stub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.UserPO;
import dataservice.userdataservice.UserDataService;

public class UserDataService_Stub implements UserDataService{

	public UserPO login(String admin, String password) {
		// TODO 自动生成的方法存根
		return new UserPO(password, password, password, password);
	}

	public UserPO findonId(String id) throws RemoteException {
		// TODO 自动生成的方法存根
		return new UserPO(id, id, id, id);
	}

	public UserPO findonAdmin(String admin) throws RemoteException {
		// TODO 自动生成的方法存根
		return new UserPO(admin, admin, admin, admin);
	}

	public void insert(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

	public void delete(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}


	public ArrayList<UserPO> show() throws RemoteException {
		// TODO 自动生成的方法存根
		ArrayList<UserPO> list=new ArrayList<UserPO>();
		list.add(new UserPO(null, null, null, null));
		return null;
	}

	public void update(UserPO user) throws RemoteException {
		// TODO 自动生成的方法存根
		
	}

}
