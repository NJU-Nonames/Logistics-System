/**
 * 2015年10月23日
 *author:tqy
 *description:管理仓库
 */
package dataservice.repertory;

import java.rmi.Remote;
import java.rmi.RemoteException;

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
	public boolean add(GoodsInfoPO goods,RepertoryInPO repertoryPO)throws RemoteException;
	
	/**
	 * 出库修改库存信息
	 * @param goods
	 * @param repertoryPO
	 * @return
	 */
	public boolean delete(String barCode,RepertoryOutPO repertoryPO)throws RemoteException;
	
	/**
	 * 获得库存信息情况
	 * @return
	 */
	public RepertoryInfoPO show();

}
