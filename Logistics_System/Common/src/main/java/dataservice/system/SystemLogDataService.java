package dataservice.system;

import java.io.Serializable;
import java.util.ArrayList;

import po.system.SystemLogPO;

//远程接口DataFactoryService使用到的参数类型和返回值类型都必须可序列化。
public interface SystemLogDataService extends Serializable {
	
	/**
	 * 返回系统日志列表 
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogPO> showAll(String time1,String time2);
	
	/**
	 * 添加一条系统日志
	 * @param systemLog
	 */
	public void add(SystemLogPO systemLog);
}
