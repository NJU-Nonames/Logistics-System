/**
 *2015年10月21日
 *author:tdy
 *discirption:营业厅的接收和派件接口 
 */
package businesslogicservice.logisticsblservice;

import vo.DeliverlistVO;
import vo.DeparturelistVO;
import vo.OrderlistVO;
import vo.SellingAreaRecievelistVO;

public interface SellingAreaRecieveBLService {
	/**营业厅收到其他营业厅或者中转中心的快递之后，在系统中寻找相关单据
	 * 前置条件：	开启了接收任务
	 * 后置条件：	系统根据输入的营业厅装车单或中转中心中转单的编号显示单据详情
	 * @param 	营业厅装车单或中转中心中转单的编号
	 * @return	营业厅装车单或中转中心中转单的vo实体
	 */
	public DeparturelistVO findDeparturelist(String departurelistId);
	/**营业厅业务员根据上面得到的单据确认生成营业厅到达单
	 * 前置条件：	已经寻找到了营业厅装车单或中转中心中转单
	 * 后置条件：	系统生成并保存营业厅到达单（补足了缺省选项）
	 * @param 	营业厅装车单或中转中心中转单的vo实体
	 * @return	营业厅到达单的vo实体
	 */
	public SellingAreaRecievelistVO createSellingAreaRecievelist(DeparturelistVO departurelist);
	/**营业厅业务员完善到达订单的信息
	 * 前置条件：	开启派件任务
	 * 后置条件：	订单完善完成
	 * @param 	完善需要派件的订单其他信息（例如派件人员）
	 * @return	操作是否成功
	 */
	public boolean inputDeliverlistInfo(String[] otherInfo);
	/**营业厅业务员准备派件
	 * 前置条件：	需要派件的订单已经被完善，及可以被派件
	 * 后置条件：	系统生成并保存了派件单
	 * @param 	订单的实体vo类
	 * @return	派件单的实体vo类
	 */
	public DeliverlistVO createDeliverlist(OrderlistVO orderlist);
	/**营业厅业务员取消接收
	 * 前置条件：	点击取消按钮
	 * 后置条件:	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelRecieve();
	/**营业厅业务员派件
	 * 前置条件：	点击取消按钮
	 * 后置条件:	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelDeliver();
}