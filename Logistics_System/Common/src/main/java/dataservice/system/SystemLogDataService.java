package dataservice.system;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.system.SystemLogPO;

public interface SystemLogDataService extends Remote{
	
	/**
	 * 返回系统日志列表 
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogPO> showAll(String time1,String time2) throws RemoteException;
	
	/**
	 * 添加一条系统日志
	 * @param systemLog
	 */
	public void add(SystemLogPO systemLog)throws RemoteException;
}
