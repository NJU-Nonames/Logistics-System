/**
 * 2015年10月23日
 *author:tqy
 *description:管理仓库
 */
package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.RepertoryPO;


/**
 * @author 谭期友
 *
 */
public interface RepertoryDataService {
	/**
	 * 前置条件：无
	 * 后置条件：按ID进行查找返回相应的RepertoryPO结果
	 * @param 	id
	 * @return 	相应的RepertoryPO结果
	 */
	public RepertoryPO find(String id) throws RemoteException;
	/**
	 * 前置条件：不存在同样的RepertoryPO
	 * 后置条件：在数据库中增加RepertoryPO结果
	 * @param 	RepertoryPO
	 */
	public void insert(RepertoryPO repertory) throws RemoteException;
	/**
	 * 前置条件：存在同样id的RepertoryPO
	 * 后置条件：在数据库中删除对应的RepertoryPO
	 * @param 	RepertoryPO
	 */
	public void delete(RepertoryPO repertory) throws RemoteException;
	/**
	 * 前置条件：存在同样id的RepertoryPO
	 * 后置条件：在数据库中更新对应的RepertoryPO
	 * @param 	RepertoryPO
	 */
	public void update(RepertoryPO repertory) throws RemoteException;
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
