package mainServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.DataFactory;
import dataservice.DataFactoryService;

public class MainServer {
	
	/**
	 * 端口号
	 */
	private static final int PORT=50000;
	
	private static final String IP="127.0.0.1";
	
	
	
	public static void main(String args[]){
		try {
			//注册通讯端口
			LocateRegistry.createRegistry(PORT);

			//注册通讯路径;将datafactory共享掉；datafactory被赋予新名字dataFactory
			DataFactoryService datafactory =new DataFactory();
			Naming.rebind("rmi://"+IP+":"+PORT+"/dataFactory", datafactory);
			
			System.out.println("Server start!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
}
