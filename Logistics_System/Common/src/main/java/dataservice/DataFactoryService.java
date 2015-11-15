package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import dataservice.system.SystemLogDataService;
import dataservice.system.UserDataService;

public interface DataFactoryService extends Remote{
	//所有远程接口使用到的参数类型和返回值类型都必须可序列化。这个类里所有函数的返回类型都必须可序列化
	public SystemLogDataService getSystemLogDataService()throws RemoteException;
	public UserDataService getUserDataService()throws RemoteException;
}