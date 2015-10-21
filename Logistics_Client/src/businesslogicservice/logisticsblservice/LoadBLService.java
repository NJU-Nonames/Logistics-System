/**
 *2015年10月21日
 *author:tdy
 *discirption:在快递员揽件，营业厅业务员完成分拣和装车之后，一个经过验证的营业厅业务员开始处理快递件装车，记录本次装车的所有信息。 
 */
package businesslogicservice.logisticsblservice;

import vo.LoadlistVO;

public interface LoadBLService {
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	所有订单的编号
	 * @return	订单编号是否合法，是否可以被装车
	 */
	public boolean inputOrdersId(String[] allOrdersId);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	货车的id和司机的id
	 * @return	货车id和司机id是否合法，是否空闲
	 */
	public boolean inputTruckAndDriver(String truckId,String driverId);
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
	public boolean inputPrice(int loadPrice);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	所有订单的编号
	 * @param 	货车编号
	 * @param 	司机编号
	 * @param 	目的地中转中心或营业厅编号
	 * @param 	运费
	 * @return	完整的装车单vo实体类，包含了缺省选项
	 */
	public LoadlistVO createLoadlist(
			String[] allOrdersId,String truckId,String driverId,String destinationId,int loadPrice);
	/**
	 * 前置条件：
	 * 后置条件:
	 * @return	取消操作是否成功
	 */
	public boolean cancelLoad();
}
