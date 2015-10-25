/**
 * 2015年10月23日
 *author:tqy
 *description:管理仓库
 */
package dataservice.logisticsdataservice;

import po.RepertoryInPO;
import po.RepertoryInfoPO;
import po.RepertoryOutPO;
;


/**
 * @author 谭期友
 *
 */
public interface RepertoryDataService {
	/**仓库管理人员根据中转中心到达单进行入库管理
	 * @param 	入库单
	 * @return	入库是否成功
	 */
	public boolean inputRepertory(RepertoryInPO repertoryIn);
	
	/**仓库管理人员执行出库管理，生成出库单 同时从库存里删除信息
	 * @param 	出库单
	 * @return	出库是否成功
	 */
	public boolean outputRepertory(RepertoryOutPO repertoryOut);
	
	/**仓库管理人员进行查看库存操作
	 * @param	时间段
	 * @return	库存查看\库存盘点
	 */
	public RepertoryInfoPO  showRepertory(String start_time,String end_time);
	

	//暂无 待修改

}
