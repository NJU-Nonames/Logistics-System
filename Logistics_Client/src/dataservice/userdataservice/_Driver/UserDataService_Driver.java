package dataservice.userdataservice._Driver;

import java.rmi.RemoteException;

import po.UserPO;
import dataservice.userdataservice.UserDataService;
import dataservice.userdataservice._Stub.UserDataService_Stub;

public class UserDataService_Driver {
	public static void main(String []args){
		UserDataService userDataService=new UserDataService_Stub();
		UserDataService_Driver userDataService_Driver=new UserDataService_Driver();
		userDataService_Driver.drive(userDataService);
	}
public void drive(UserDataService userDataService){
	
	userDataService.login("admin"," admin");
	try{
	userDataService.findonId("admin");
	userDataService.findonAdmin("张三");
	userDataService.insert(new UserPO("admin","admin","高", null));
	userDataService.delete(new UserPO("admin","admin","高", null));
	userDataService.update(new UserPO("admin","admin","高", null));
	userDataService.show();
	}
	catch(RemoteException e){
		
	}
	
}
}
