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
	/**仓库管理人员根据中转中心到达单进行入库管理
	 * 前置条件：	开启入库任务
	 * 后置条件：	相关订单被放入合适位置并修改相关属性
	 * @param 	中转中心到达单
	 * @return	入库是否成功
	 */
	public boolean inputRepertory(TransferCentreRecievelistVO transCentreRecievelist);
	/**仓库管理人员执行出库管理
	 * 前置条件：	开启出库任务
	 * 后置条件：	订单的相关属性被修改
	 * @param 	订单的vo实体类
	 * @return	出库是否成功
	 */
	public boolean outputRepertory(OrderlistVO orderlist);
	/**仓库管理人员进行查看库存操作
	 * 前置条件：	开启查看库存操作
	 * 后置条件：	无
	 * @param	时间段
	 * @return	查看操作是否成功
	 */
	public boolean  seeRepertory(String timePeriods);
	/**仓库管理人员进行盘点库存操作
	 * 前置条件：	开启盘点库存操作
	 * 后置条件：	
	 * @return	盘点操作是否成功
	 */
	public boolean 	checkRepertory();
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
	public void repertoryAdjust();
	/**更新库存
	 * 前置条件：库存监控根据存储内容实时更新
	 * 后置条件：
	 */
	public void repertoryUpdate();
	/**仓库管理人员取消某操作
	 * 前置条件：	点击取消按钮
	 * 后置条件:	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelManage();
}
