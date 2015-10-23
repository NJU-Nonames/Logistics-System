/**
 * 2015年10月23日
 *author:tqy
 *description:管理仓库
 */
package dataservice.logisticsdataservice;

import java.rmi.RemoteException;
import po.WarehousePO;

/**
 * @author 谭期友
 *
 */
public interface WarehouseDataService {
	/**
	 * 前置条件：无
	 * 后置条件：按ID进行查找返回相应的WarehousePO结果
	 * @param 	id
	 * @return 	相应的WarehousePO结果
	 */
	public WarehousePO find(String id) throws RemoteException;
	/**
	 * 前置条件：不存在同样的WarehousePO
	 * 后置条件：在数据库中增加WarehousePO结果
	 * @param 	WarehousePO
	 */
	public void insert(WarehousePO warehousePO) throws RemoteException;
	/**
	 * 前置条件：存在同样id的WarehousePO
	 * 后置条件：在数据库中删除对应的WarehousePO
	 * @param 	WarehousePO
	 */
	public void delete(WarehousePO warehousePO) throws RemoteException;
	/**
	 * 前置条件：存在同样id的WarehousePO
	 * 后置条件：在数据库中更新对应的WarehousePO
	 * @param 	WarehousePO
	 */
	public void update(WarehousePO warehousePO) throws RemoteException;
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
