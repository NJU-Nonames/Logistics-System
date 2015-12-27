/**
 *2015年10月21日
 *author:tdy
 *装运管理
 *discirption:在库存达到一定条件时，一个已经经过验证中转中心业务员根据库存情况，决定需要转运到其他中转中心或者营业厅的物品，并在系统中做出记录。 
 */
package businesslogicservice.logisticsblservice;

import utility.ResultMessage;
import vo.OrderListVO;
import vo.TransShipmentListVO;


public interface TransShipmentBLService {
	
	/**中转中心业务员在选择需要装运的订单，输入了航班号（火车车次，货车车次），目的地编号和运费之后，系统补足缺省选项并完成中转中心中转单的创建
	 * 前置条件：	开启了装运任务
	 * 后置条件：	系统判定输入准确无误之后，保存装运单，修改订单的相关属性
	 */
	public ResultMessage createShiplist(TransShipmentListVO transShipment);
	/**
	 * 生成中转单编号
	 * @return
	 */
	public String createTransShipmentListId();
	/**
	 * 生成订单的运费
	 * @param barcode
	 * @return
	 */
	public double createOrderFare(String barcode);

}
