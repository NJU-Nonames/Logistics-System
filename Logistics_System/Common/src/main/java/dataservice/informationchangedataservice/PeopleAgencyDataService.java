/**
 *2015年10月22日
 *author:
 *description: 人员机构管理
 */
package dataservice.informationchangedataservice;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.AgencyPO;


public interface PeopleAgencyDataService {
	
	
	/**
	 * 薪水管理修改
	 * @param userID
	 * @param salary
	 */
	public void salaryManage(String userID,String salary);
	
	/**
	 * 前置条件：无
	 * 后置条件：按ID进行查找返回相应的ListPO结果
	 * @param 	id
	 * @return 	所有机构PO结果
	 */
	public ArrayList<AgencyPO> showAll() throws RemoteException;
	
	/**
	 * 前置条件：不存在同样的AgencyPO
	 * 后置条件：在数据库中增加AgencyPO结果
	 * @param 	AgencyPO
	 */
	public void add(AgencyPO agency) throws RemoteException;
	
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
	 * 对机构信息单独查找
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public AgencyPO find(String id) throws RemoteException;
	
}
