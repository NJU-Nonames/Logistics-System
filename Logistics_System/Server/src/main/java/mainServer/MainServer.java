package mainServer;

import config.IPconfig;
import config.XMLReader;
import data.DataJDBCConnection;
import data.RMIstart;

public class MainServer {
	

	
	/**
	 * 程序入口
	 * @param args
	 */
	public static void main(String args[]){
			
		//启动RMI服务
		RMIstart.init();
		
		DataJDBCConnection.init();
			
     	System.out.println("Server start! IP:"+XMLReader.loadconfig().getIP());
			
   
	}
}
