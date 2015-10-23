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
	 * 前置条件：	开启了装运任务
	 * 后置条件：	系统判定输入准确无误之后，保存装运单，修改订单的相关属性
	 * @param 	所有订单
	 * @param 	交通工具编号
	 * @param 	目的地中转中心或营业厅编号
	 * @param 	运费
	 * @return	完整装运单vo实体类，包含了缺省选项
	 */
	public ShiplistVO createShiplist(
			OrderlistVO[] allOrderlists,String vehicleId,String destinationId,int shipPrice);
	/**营业厅业务员取消装运任务
	 * 前置条件：	点击取消按钮
	 * 后置条件:	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelShip();
}
