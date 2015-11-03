/**
 *2015年10月21日
 *author:tdy
 *discirption:输入订单信息，系统保存保存订单 
 */
package businesslogicservice.logisticsblservice;

import utility.ResultMessage;
import vo.OrderListVO;


public interface SendPkgBLService {
	
	/**
	 * 输入订单信息 返回价格、预计到达时间信息
	 * @param	订单的基本信息，如货物质量，尺寸大小，出发地目的地，寄件人收件人信息等等
	 * @return	完整的某个订单实体
	 */
	public OrderListVO createMoneyInformation(OrderListVO orderListVO);
	
	/**
	 * 提交订单 确认生成VO
	 * @param orderListVO
	 * @return
	 */
	public ResultMessage createOrderList(OrderListVO orderListVO);
	
	
}
