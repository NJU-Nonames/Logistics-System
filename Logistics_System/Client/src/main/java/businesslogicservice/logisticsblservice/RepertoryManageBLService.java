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
import vo.RepertorySearch;


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
	
	/**仓库管理人员进行库存盘点
	 * @return	返回一个库存信息的VO里面包含库存的信息类
	 */
	public RepertoryInfoVO  showRepertory();
	
	/**
	 * 库存查看
	 * @param start_time
	 * @param end_time
	 * @return 返回一个库存查看的VO
	 */
	public RepertorySearch searchRepertory(String start_time,String end_time);
	
	//以下需要修改 内容暂定
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
