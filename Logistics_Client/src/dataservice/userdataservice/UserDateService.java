/**
 *2015年10月22日
 *author:tdy
 *discirption:用户的数据层接口，规定了用户的增删改查初始化和结束操作 
 */
package dataservice.userdataservice;

import java.rmi.RemoteException;

import po.UserPO;

public interface UserDateService {
	/**
	 * 前置条件：无
	 * 后置条件：按ID进行查找返回相应的UserPO结果
	 * @param 	id
	 * @return 	相应的UserPO结果
	 */
	public UserPO find(String id) throws RemoteException;
	/**
	 * 前置条件：不存在同样的UserPO
	 * 后置条件：在数据库中增加UserPO结果
	 * @param 	UserPO
	 */
	public void insert(UserPO user) throws RemoteException;
	/**
	 * 前置条件：存在同样id的UserPO
	 * 后置条件：在数据库中删除对应的UserPO
	 * @param 	UserPO
	 */
	public void delete(UserPO user) throws RemoteException;
	/**
	 * 前置条件：存在同样id的UserPO
	 * 后置条件：在数据库中更新对应的UserPO
	 * @param 	UserPO
	 */
	public void update(UserPO user) throws RemoteException;
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
