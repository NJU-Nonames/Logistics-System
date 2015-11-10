package rmiImpl.system.accepter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import rmiImpl.system.SystemLogDataImpl;
import dataservice.system.SystemLogDataService;


public class SystemLogDataImpl_accepter {

	public static void main(String args[]){
		try {
			SystemLogDataService systemLogDataService=new SystemLogDataImpl();
			//注册通讯端口
			LocateRegistry.createRegistry(50000);
			//注册通讯路径
			Naming.rebind("rmi://127.0.0.1:50000/systemLogDataService", systemLogDataService);
			
			System.out.println("Server start!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
}
