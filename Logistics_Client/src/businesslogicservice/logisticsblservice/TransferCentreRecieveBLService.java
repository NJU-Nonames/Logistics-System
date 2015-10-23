/**
 *2015年10月21日
 *author:tdy
 *discirption:当营业厅送达货物到中转中心或快递到达目的地中转中心时，中转中心的业务员将从其他中转中心接收的货物进行中转接收
 */
package businesslogicservice.logisticsblservice;

import vo.DeparturelistVO;
import vo.TransferCentreRecievelistVO;

public interface TransferCentreRecieveBLService {
	/**中转中心收到其他营业厅或者中转中心的快递之后，在系统中寻找相关单据
	 * 前置条件：	开启了接收任务
	 * 后置条件：	系统根据输入的营业厅装车单或中转中心中转单的编号显示单据详情
	 * @param 	营业厅装车单或中转中心中转单的编号
	 * @return	营业厅装车单或中转中心中转单的vo实体
	 */
	public DeparturelistVO findDeparturelist(String departurelistId);
	/**中转中心业务员根据上面得到的单据确认生成营业厅到达单
	 * 前置条件：	已经寻找到了营业厅装车单或中转中心中转单
	 * 后置条件：	系统生成并保存营业厅到达单（补足了缺省选项）
	 * @param 	营业厅装车单或中转中心中转单的vo实体
	 * @return	中转中心到达单的vo实体
	 */
	public TransferCentreRecievelistVO createTransferCentreRecievelist(DeparturelistVO departurelist);
	/**中转中心业务员取消接收
	 * 前置条件：	点击取消按钮
	 * 后置条件:	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelRecieve();
}
