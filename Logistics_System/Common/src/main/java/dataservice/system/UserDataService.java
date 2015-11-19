/**
 *2015年10月22日
 *author:tdy
 *discirption:用户的数据层接口，规定了用户的增删改查初始化和结束操作 
 */
package dataservice.system;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.system.UserPO;

//远程接口DataFactoryService使用到的参数类型和返回值类型都必须可序列化。
public interface UserDataService extends Remote{
	
	/**
	 * 前置条件：不存在同样的UserPO
	 * 后置条件：在数据库中增加UserPO结果
	 * @param 	UserPO
	 */
	public void add(UserPO user) throws RemoteException;
	
	/**
	 * 前置条件：存在同样id的UserPO
	 * 后置条件：在数据库中删除对应的UserPO
	 * @param 	UserPO
	 */
	public void delete(String id)throws RemoteException;
	/**
	 * 前置条件：存在同样id的UserPO
	 * 后置条件：在数据库中更新对应的UserPO
	 * @param 	UserPO
	 */
	public void update(UserPO user)throws RemoteException;
	
	/**
	 * 前置条件：无
	 * 后置条件：按ID进行查找返回相应的UserPO结果
	 * @param 	id
	 * @return 	相应的UserPO结果
	 */
	public UserPO findonId(String id)throws RemoteException;
	
	/**
	 * 按照用户名查找用户信息
	 * @param admin
	 * @return
	 * @throws RemoteException
	 */
	public UserPO findonAdmin(String admin)throws RemoteException;
	
	/**
	 * 返回所用用户信息
	 */
	public ArrayList<UserPO> showAll()throws RemoteException;
	
}
