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
	/**中转中心业务员在选择需要装运的订单，输入了航班号（火车车次，货车车次），目的地编号和运费之后，系统补足缺省选项并完成中转中心中转单的创建
	 * 前置条件：
	 * 后置条件：
	 * @param 	所有订单
	 * @param 	交通工具编号
	 * @param 	目的地中转中心或营业厅编号
	 * @param 	运费
	 * @return	完整装运单vo实体类，包含了缺省选项
	 */
	public ShiplistVO createShiplist(
			OrderlistVO[] allOrderlists,String vehicleId,String destinationId,int shipPrice);
	/**
	 * 前置条件：
	 * 后置条件:
	 * @return	取消操作是否成功
	 */
	public boolean cancelShip();
}
