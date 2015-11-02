package dataservice.chartdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.system.SystemLogPO;


public interface SystemLogDataService extends Remote{
	
	public static final String NAME="systemLogDataService";
	/**
	 * 返回系统日志列表 
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogPO> getLogInfo(String time) throws RemoteException;
	
	/**
	 * 添加一条系统日志
	 * @param systemLog
	 */
	public void add(SystemLogPO systemLog) throws RemoteException;
}
