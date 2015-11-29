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
	 * 获得库存信息情况
	 * @return
	 */
	public ArrayList<RepertoryInfoPO> show(String id)throws RemoteException;

}
