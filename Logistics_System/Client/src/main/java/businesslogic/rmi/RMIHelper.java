package businesslogic.rmi;
import java.rmi.Naming;


/**
 * @author 这菜咸了
 * 该类用于RMI方法调用
 * 调用方法：
 * 1.调用RMIHelper.find函数 参数名为使用的接口service的名称
 * 2.得到一个service引用，调用该service中的方法即可
 * 
 */
public class RMIHelper {

    private static final String IP = "114.212.43.215"; //Can be read from config file
    private static final String PORT="40000";//端口号

    public static Object find(String serviceName){
    	 try {
             Object service = (Object) Naming.lookup("rmi://"+IP+":"+PORT+"/"+serviceName);
             return service;
         } catch (Exception e) {
             e.printStackTrace();
         }
		return null;
    }
  
}

