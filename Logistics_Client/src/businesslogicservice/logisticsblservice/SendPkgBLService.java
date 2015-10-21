/**
 *2015年10月21日
 *author:tdy
 *discirption:输入订单信息，系统保存保存订单 
 */
package businesslogicservice.logisticsblservice;

import vo.OrderlistVO;


public interface SendPkgBLService {
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param	订单的基本信息，如货物质量，尺寸大小，出发地目的地，寄件人收件人信息等等
	 * @return	完整的某个订单实体
	 */
	public OrderlistVO createOrderlist(String[] orderBaseInformation);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	取消操作是否成功
	 */
	public boolean cancelSend();
}
