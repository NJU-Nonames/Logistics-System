/**
 *2015年10月21日
 *author:tdy
 *discirption:在库存达到一定条件时，一个已经经过验证中转中心业务员根据库存情况，决定需要转运到其他中转中心或者营业厅的物品，并在系统中做出记录。 
 */
package businesslogicservice.logisticsblservice;

import vo.DeparturelistVO;
import vo.OrderlistVO;
import vo.ShiplistVO;

public interface ShipBLService {
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	交通工具编号
	 * @return	交通工具编号是否合法
	 */
	public boolean inputVehicleId(String inputVehicleId);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	目的地中转中心或者营业厅的编号
	 * @return	中转中心编号和营业厅编号是否合法
	 */
	public boolean inputDestinationId(String destinationId);
	/**
	 * 前置条件：
	 * 后置条件:
	 * @param 	运费
	 * @return	运费是否合理
	 */
	public boolean inputPrice(int shipPrice);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	所有订单
	 * @param 	交通工具种类
	 * @param 	交通工具编号
	 * @param 	目的地中转中心或营业厅编号
	 * @param 	运费
	 * @return	完整装运单vo实体类，包含了缺省选项
	 */
	public ShiplistVO createShiplist(
			OrderlistVO[] allOrderlists,String vehicleType,String vehicleId,String destinationId,int shipPrice);
	/**
	 * 前置条件：
	 * 后置条件:
	 * @return	取消操作是否成功
	 */
	public boolean cancelShip();
}
