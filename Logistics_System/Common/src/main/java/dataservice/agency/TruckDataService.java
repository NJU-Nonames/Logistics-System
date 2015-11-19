package dataservice.agency;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.TruckPO;


public interface TruckDataService extends Remote{
	
	/**营业厅业务员增加货车
	 * 前置条件：开始添加货车
	 * 后置条件:显示添加货车的详细信息，系统存储
	 * @param 货车实体类
	 */
	public boolean add(TruckPO truck)throws RemoteException;
	
	/**营业厅业务员删除货车
	 * 前置条件：开始删除货车
	 * 后置条件:显示删除某货车
	 * @param 货车实体类
	 */
	public boolean delete(TruckPO truck)throws RemoteException;
	
	/**营业厅业务员更改货车信息
	 * @param 货车实体类
	 */
	public boolean update(TruckPO truck)throws RemoteException;
	
	/**
	 * 通过编号查找
	 * @param num
	 * @return
	 */
	public TruckPO find(String num)throws RemoteException;
	
	/**
	 * 显示营业厅车辆
	 * @param Hall_Num
	 * @return
	 */
	public ArrayList<TruckPO> showAll(String Hall_Num)throws RemoteException;
}
