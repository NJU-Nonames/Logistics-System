package rmiImpl.system.accepter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.DataFactory;
import dataservice.DataFactoryService;


public class SystemLogDataImpl_accepter {

	public static void main(String args[]){
		try {
			//注册通讯端口
			LocateRegistry.createRegistry(50000);

			//注册通讯路径;将datafactory共享掉；datafactory被赋予新名字dataFactory
			DataFactoryService datafactory =new DataFactory();
			Naming.rebind("rmi://127.0.0.1:50000/dataFactory", datafactory);
			
			System.out.println("Server start!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
}
