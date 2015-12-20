package businesslogic.rmi;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.management.remote.rmi.RMIConnection;
import javax.management.remote.rmi.RMIConnectionImpl;

import presentation.mainui.ReconnectedFrame;
import config.XMLReader;


/**
 * @author 这菜咸了
 * 该类用于RMI方法调用
 * 调用方法：
 * 1.调用RMIHelper.find函数 参数名为使用的接口service的名称
 * 2.得到一个service引用，调用该service中的方法即可
 * 
 */
public class RMIHelper{
    
	public static final String IP = XMLReader.loadconfig().getIP(); //Can be read from config file
    public static final int PORT=XMLReader.loadconfig().getPORT();//端口号
    
    public static Object find(String serviceName){
    	if(IP==null){
    		System.out.println("error.Ip is not found!");
    	    System.exit(0);
    	}
    	 try {
             Object service = (Object) Naming.lookup("rmi://"+IP+":"+PORT+"/"+serviceName);
             return service;
         } catch (Exception e) {
        	// new ReconnectedFrame().run();
        	 try {
				e.wait(5000);
			} catch (InterruptedException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
        	 return RMIHelper.find(serviceName);
         }
    }


	
    
  
}

