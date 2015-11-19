package dataservice.agency;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.DriverPO;


public interface DriverDataService extends Remote{
	

	/**营业厅业务员增加司机
	 * 前置条件：开始添加司机
	 * 后置条件:显示添加司机的详细信息，系统存储
	 * @param 司机实体类
	 */
	public boolean add(DriverPO driver)throws RemoteException;
	
	/**营业厅业务员删除司机
	 * 前置条件：开始删除司机
	 * 后置条件:显示删除某司机
	 * @param 司机实体类
	 */
	public boolean delete(DriverPO driver)throws RemoteException;
	
	/**营业厅业务员更改司机信息
	 * 前置条件：开始更改司机信息任务
	 * 后置条件:更新司机的详细信息，系统存储
	 * @param 司机实体类
	 */
	public boolean update(DriverPO driver)throws RemoteException;
	
	
	/**
	 * 通过编号查找
	 * @param num
	 * @return
	 */
	public DriverPO find(String num)throws RemoteException;
	
	public ArrayList<DriverPO> showAll(String Hall_Num)throws RemoteException;
}
