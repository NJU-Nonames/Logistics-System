/**
 *2015年10月21日
 *author:tdy
 *discirption:物流模块中提供给收件的相关操作的接口
 */
package businesslogicservice.logisticsblservice;

import vo.OrderlistVO;
import vo.RecieverVO;

public interface RecievePkgBLService {
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	准备签收的订单编号
	 * @return	正在准备签收的订单实体
	 */
	public OrderlistVO findOrderlist(String orderlistId);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	实际签收人
	 * @return	是否和系统存储的收件人一致
	 */
	public boolean isagreed(RecieverVO reciever);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	是否确认成功
	 */
	public boolean confirmRecieve();
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	取消操作是否成功
	 */
	public boolean cancelRecieve();
}
