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
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	营业厅装车单或中转中心中转单的编号
	 * @return	营业厅装车单或中转中心中转单的vo实体
	 */
	public DeparturelistVO findDeparturelist(String departurelistId);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	营业厅装车单或中转中心中转单的vo实体
	 * @return	营业厅到达单的vo实体
	 */
	public SellingAreaRecievelistVO createSellingAreaRecievelist(DeparturelistVO departurelist);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	完善需要派件的订单其他信息（例如派件人员）
	 * @return	操作是否成功
	 */
	public boolean inputDeliverlistInfo(String[] otherInfo);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	订单的实体vo类
	 * @return	派件单的实体vo类
	 */
	public DeliverlistVO createDeliverlist(OrderlistVO orderlist);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	取消操作是否成功
	 */
	public boolean cancelRecieve();
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	取消操作是否成功
	 */
	public boolean cancelDeliver();
}