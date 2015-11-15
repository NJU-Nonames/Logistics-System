package dataservice.impl;


import java.util.ArrayList;

import po.system.SystemLogPO;
import dataservice.system.SystemLogDataService;

/**
 * @author 这菜咸了
 * 
 */
public class SystemLogDataImpl implements SystemLogDataService{
	
	/**
	 * 因为SystemLogDataService接口继承了Serializable接口才有这个
	 */
	private static final long serialVersionUID = 2799513190675805279L;

	public ArrayList<SystemLogPO> showAll(String time1,String time2){
		ArrayList<SystemLogPO> systemLogs=new ArrayList<SystemLogPO>();
		systemLogs.add(new SystemLogPO(time1, "捡了一分钱", "王大锤"));
		return systemLogs;
	}

	public void add(SystemLogPO systemLog){
		
	}

}
