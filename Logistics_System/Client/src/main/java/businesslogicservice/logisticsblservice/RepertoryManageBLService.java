/**
 *2015年10月21日
 *author:tdy
 *discirption: 仓库管理的相关接口，可能需要后期的进一步修订，尤其是返回值类型方面
 */
package businesslogicservice.logisticsblservice;


import utility.ResultMessage;
import vo.RepertoryInVO;
import vo.RepertoryInfoVO;
import vo.RepertoryOutVO;


public interface RepertoryManageBLService {
	
	/**仓库管理人员根据中转中心到达单进行入库管理
	 * @param 	入库单
	 * @return	入库是否成功
	 */
	public ResultMessage createInputRepertory(RepertoryInVO repertoryIn);
	
	/**仓库管理人员执行出库管理
	 * @param 	出库单
	 * @return	出库是否成功
	 */
	public ResultMessage createOutputRepertory(RepertoryOutVO repertoryOut);
	
	/**仓库管理人员进行查看库存操作
	 * @param	时间段
	 * @return	库存查看、库存盘点
	 */
	public RepertoryInfoVO  showRepertory(String start_time,String end_time);
	
	
	
	//以下需要修改 内容暂定
	/**实时监控
	 * 前置条件：无
	 * 后置条件：若报警则返回报警信息，否则返回安全信息
	 * @return	库存中的某一个区是否报警（存储量超出容量的90%）
	 */
	public ResultMessage repertoryAlarm();
	
	/**仓库管理人员进行库存管理操作
	 * 前置条件：库存中某一个区已经报警
	 * 后置条件：库存中的某区不再报警
	 */
	public ResultMessage repertoryAdjust();
	
	/**更新库存
	 * 前置条件：库存监控根据存储内容实时更新
	 * 后置条件：
	 */
	public ResultMessage repertoryUpdate();
	
}
