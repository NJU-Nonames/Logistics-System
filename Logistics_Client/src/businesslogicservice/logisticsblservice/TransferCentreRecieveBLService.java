/**
 *2015年10月21日
 *author:tdy
 *discirption:当营业厅送达货物到中转中心或快递到达目的地中转中心时，中转中心的业务员将从其他中转中心接收的货物进行中转接收
 */
package businesslogicservice.logisticsblservice;

import vo.DeparturelistVO;
import vo.TransferCentreRecievelistVO;

public interface TransferCentreRecieveBLService {
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
	 * @return	中转中心到达单的vo实体
	 */
	public TransferCentreRecievelistVO createTransferCentreRecievelist(DeparturelistVO departurelist);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	取消操作是否成功
	 */
	public boolean cancelRecieve();
}
