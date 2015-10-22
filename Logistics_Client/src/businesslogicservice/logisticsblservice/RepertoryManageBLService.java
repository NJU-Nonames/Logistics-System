/**
 *2015年10月21日
 *author:tdy
 *discirption: 仓库管理的相关接口，可能需要后期的进一步修订，尤其是返回值类型方面
 */
package businesslogicservice.logisticsblservice;

import businesslogic.utilitybl.ResultMessage;
import vo.OrderlistVO;
import vo.TransferCentreRecievelistVO;

public interface RepertoryManageBLService {
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	中转中心到达单
	 * @return	入库是否成功
	 */
	public boolean inputRepertory(TransferCentreRecievelistVO transCentreRecievelist);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	订单的vo实体类
	 * @return	出库是否成功
	 */
	public boolean outputRepertory(OrderlistVO orderlist);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param	时间段
	 * @return	查看操作是否成功
	 */
	public boolean  seeRepertory(String timePeriods);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	盘点操作是否成功
	 */
	public boolean 	checkRepertory();
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	库存中的某一个区是否报警（存储量超出容量的90%）
	 */
	public ResultMessage repertoryAlarm();
	/**
	 * 前置条件：
	 * 后置条件：
	 */
	public void repertoryAdjust();
	/**
	 * 前置条件：
	 * 后置条件：
	 */
	public void repertoryUpdate();
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	取消操作是否成功
	 */
	public boolean cancelManage();
}
