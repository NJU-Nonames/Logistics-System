/**
 * 2015年11月12日
 *author:
 *description:
 */
package data;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import dataservice.DataFactoryService;
import dataservice.impl.SystemLogDataImpl;
import dataservice.impl.UserDataImpl;
import dataservice.system.SystemLogDataService;
import dataservice.system.UserDataService;

/**
 * @author 谭期友
 *
 */
public class DataFactory extends UnicastRemoteObject implements DataFactoryService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3287244603999423897L;

	//必须定义构造方法，因为它必须抛出RemoteException异常
	public DataFactory() throws RemoteException {
		super();
	}

	public SystemLogDataService getSystemLogDataService()throws RemoteException {
		SystemLogDataService data = new SystemLogDataImpl();
		return data;
	}

	public UserDataService getUserDataService() throws RemoteException {
		UserDataService data = new UserDataImpl();
		return data;
	}
	
}
