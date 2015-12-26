package businesslogic.rmi;
import java.rmi.Naming;
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
    
	public static final String IP = XMLReader.loadipconfig().getIP(); //Can be read from config file
    public static final int PORT=XMLReader.loadipconfig().getPORT();//端口号
    
    public static Object find(String serviceName){
    	if(IP==null){
    		System.out.println("error.Ip is not found!");
    	    System.exit(0);
    	}
    	 try {
             Object service = (Object) Naming.lookup("rmi://"+IP+":"+PORT+"/"+serviceName);
             return service;
         } catch (Exception e) {
        	//new Thread(new ReconnectedFrame()).start();
        	 try {
				Thread.sleep(5000);
			} catch (InterruptedException e1) {
				// TODO 自动生成的 catch 块
				e1.printStackTrace();
			}
        	 return RMIHelper.find(serviceName);
         }
    }
    
    public static void init(){
    	System.setProperty("sun.rmi.transport.tcp.responseTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.tcp.readTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.connectionTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.proxy.connectTimeout", "2000"); 
    	System.setProperty("sun.rmi.transport.tcp.handshakeTimeout", "2000");
    }


	
    
  
}

