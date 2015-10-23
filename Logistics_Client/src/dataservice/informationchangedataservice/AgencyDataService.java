/**
 *2015年10月22日
 *author:
 *description: 
 */
package dataservice.informationchangedataservice;

import java.rmi.RemoteException;

import po.AgencyPO;


public interface AgencyDataService {
	/**
	 * 前置条件：无
	 * 后置条件：按ID进行查找返回相应的ListPO结果
	 * @param 	id
	 * @return 	相应的ListPO结果
	 */
	public AgencyPO find(String id) throws RemoteException;
	/**
	 * 前置条件：不存在同样的AgencyPO
	 * 后置条件：在数据库中增加AgencyPO结果
	 * @param 	AgencyPO
	 */
	public void insert(AgencyPO agency) throws RemoteException;
	/**
	 * 前置条件：存在同样id的AgencyPO
	 * 后置条件：在数据库中删除对应的AgencyPO
	 * @param 	AgencyPO
	 */
	public void delete(AgencyPO agency) throws RemoteException;
	/**
	 * 前置条件：存在同样id的AgencyPO
	 * 后置条件：在数据库中更新对应的AgencyPO
	 * @param 	AgencyPO
	 */
	public void update(AgencyPO agency) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：更新数据库
	 */
	public void init() throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：结束使用
	 */
	public void finish() throws RemoteException;
}
