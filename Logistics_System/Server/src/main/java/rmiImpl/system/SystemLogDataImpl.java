
package rmiImpl.system;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import po.system.SystemLogPO;
import dataservice.chartdataservice.SystemLogDataService;

/**
 * @author 这菜咸了
 * 该类为远程对象的实现类,需要继承unicastRemoteObject
 */
public class SystemLogDataImpl extends UnicastRemoteObject implements SystemLogDataService{

	public SystemLogDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public ArrayList<SystemLogPO> getLogInfo(String time)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<SystemLogPO> systemLogs=new ArrayList<SystemLogPO>();
		systemLogs.add(new SystemLogPO(time, "捡了一分钱", "王大锤"));
		return systemLogs;
	}

	public void add(SystemLogPO systemLog) throws RemoteException {
		// TODO Auto-generated method stub
		
	}

}
