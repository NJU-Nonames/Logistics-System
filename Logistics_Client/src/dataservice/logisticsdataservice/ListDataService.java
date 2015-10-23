/**
 *2015年10月22日
 *author:tdy
 *discirption:物流单据的数据层接口，规定了物流单据的增删改查初始化和结束操作 
 */
package dataservice.logisticsdataservice;

import java.rmi.RemoteException;

import po.ListPO;

public interface ListDataService {
	/**
	 * 前置条件：无
	 * 后置条件：按ID进行查找返回相应的ListPO结果
	 * @param 	id
	 * @return 	相应的ListPO结果
	 */
	public ListPO find(String id) throws RemoteException;
	/**
	 * 前置条件：不存在同样的ListPO
	 * 后置条件：在数据库中增加ListPO结果
	 * @param 	ListPO
	 */
	public void insert(ListPO list) throws RemoteException;
	/**
	 * 前置条件：存在同样id的ListPO
	 * 后置条件：在数据库中删除对应的ListPO
	 * @param 	ListPO
	 */
	public void delete(ListPO list) throws RemoteException;
	/**
	 * 前置条件：存在同样id的ListPO
	 * 后置条件：在数据库中更新对应的ListPO
	 * @param 	ListPO
	 */
	public void update(ListPO list) throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：更新数据库
	 */
	public void init() throws RemoteException;
	/**
	 * 前置条件：无
	 * 后置条件：结束使用
	 */
	public void finish() throws RemoteException;;
}
