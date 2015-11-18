package mainServer;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import data.DataFactory;
import data.DataJDBCConnection;
import dataImpl.system.UserDataImpl;
import dataservice.DataFactoryService;
import dataservice.system.UserDataService;

public class MainServer {
	
	/**
	 * 端口号
	 */
	private static final int PORT=50000;
	
	/**
	 * 服务器ip地址
	 */
	private static final String IP="127.0.0.1";
	
	
	
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String args[]){
		
		try {
			//注册通讯端口
			LocateRegistry.createRegistry(PORT);

			//注册通讯路径;将datafactory共享掉；datafactory被赋予新名字dataFactory
			//DataFactoryService datafactory =new DataFactory();
			UserDataService userDataService=new UserDataImpl();
			Naming.rebind("rmi://"+IP+":"+PORT+"/UserDataService", userDataService);
			
			DataJDBCConnection.init();
			
			System.out.println("Server start!");
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}finally{
			
		}
	}
}
