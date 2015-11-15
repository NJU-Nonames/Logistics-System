/**
 * 2015年10月23日
 *author:tqy
 *description:管理仓库
 */
package dataservice.repertory;

import java.io.Serializable;

import po.repertory.GoodsInfoPO;
import po.repertory.RepertoryInPO;
import po.repertory.RepertoryOutPO;



/**
 * @author 王家玮
 *
 */
public interface RepertoryInfoDataService extends Serializable{
	
	/**
	 * 入库修改库存信息
	 * @param goods
	 * @param repertoryPO
	 * @return
	 */
	public boolean add(GoodsInfoPO goods,RepertoryInPO repertoryPO);
	
	/**
	 * 出库修改库存信息
	 * @param goods
	 * @param repertoryPO
	 * @return
	 */
	public boolean delete(GoodsInfoPO goods,RepertoryOutPO repertoryPO);

}