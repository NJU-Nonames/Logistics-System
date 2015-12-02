/**
 * 2015年10月23日
 *author:tqy
 *description:管理仓库
 */
package dataservice.repertory;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.repertory.GoodsInfoPO;
import po.repertory.RepertoryInPO;
import po.repertory.RepertoryInfoPO;
import po.repertory.RepertoryOutPO;



/**
 * @author 王家玮
 *
 */
public interface RepertoryInfoDataService extends Remote{
	
	/**
	 * 入库修改库存信息
	 * @param goods
	 * @param repertoryPO
	 * @return
	 */
	public void add(RepertoryInPO repertoryPO)throws RemoteException;
	
	/**
	 * 出库修改库存信息
	 * @param goods
	 * @param repertoryPO
	 * @return
	 */
	public void delete(RepertoryOutPO repertoryPO)throws RemoteException;
	
	/**
	 * 对货物存放位置进行修改
	 * @param repertoryInfoPO
	 * @throws RemoteException
	 */
	public void update(RepertoryInfoPO repertoryInfoPO)throws RemoteException;
	
	/**
	 * 通过货物的存放位置找到货物
	 *
	 * @return
	 * @throws RemoteException
	 */
	public RepertoryInfoPO findbyPlace(RepertoryInfoPO repertoryInfoPO)throws RemoteException;
	/**
	 * 通过货物id查找货物所在位置
	 * @param id
	 * @return
	 * @throws RemoteException
	 */
	public RepertoryInfoPO findbyID(String id)throws RemoteException;
	/**
	 * 获得库存信息情况
	 * @return
	 */
	public ArrayList<RepertoryInfoPO> show(String id)throws RemoteException;

}
