/**
 *2015年10月21日
 *author:tdy
 *discirption:在快递员揽件，营业厅业务员完成分拣和装车之后，一个经过验证的营业厅业务员开始处理快递件装车，记录本次装车的所有信息。 
 */
package businesslogicservice.logisticsblservice;

import vo.LoadlistVO;

public interface LoadBLService {
	/**营业厅业务员手动输入所有订单的编号
	 * 前置条件：	开始一个营业厅装车任务
	 * 后置条件：	如果无差错进行下一项输入，有差错提醒重新输入
	 * @param 	所有订单的编号
	 * @return	订单编号是否合法，是否可以被装车
	 */
	public boolean inputOrdersId(String[] allOrdersId);
	/**营业厅业务员手动输入（或选择）货车id和司机id
	 * 前置条件：	所有订单编号均无差错
	 * 后置条件：	如果无差错进行下一项输入，有差错提醒重新输入
	 * @param 	货车的id和司机的id
	 * @return	货车id和司机id是否合法，是否空闲
	 */
	public boolean inputTruckAndDriver(String truckId,String driverId);
	/**营业厅业务员手动输入（或选择）目的地id
	 * 前置条件：	货车id和司机id均无差错
	 * 后置条件：	如果无差错进行下一项输入，有差错提醒重新输入
	 * @param 	目的地中转中心或者营业厅的编号
	 * @return	中转中心编号和营业厅编号是否合法
	 */
	public boolean inputDestinationId(String destinationId);
	/**营业厅业务员手动输入运费
	 * 前置条件：	目的地编号无差错
	 * 后置条件:	如果运费输入合理，进行create任务，如果不合理提醒重新输入
	 * @param 	运费
	 * @return	运费是否合理
	 */
	public boolean inputPrice(int loadPrice);
	/**营业厅业务员确认生成装车单
	 * 前置条件：	前面所有输入无误，点击确认按钮
	 * 后置条件：	系统补足缺省选项之后保存装车单并显示装车单详情
	 * @param 	所有订单的编号
	 * @param 	货车编号
	 * @param 	司机编号
	 * @param 	目的地中转中心或营业厅编号
	 * @param 	运费
	 * @return	完整的装车单vo实体类，包含了缺省选项
	 */
	public LoadlistVO createLoadlist(
			String[] allOrdersId,String truckId,String driverId,String destinationId,int loadPrice);
	/**取消装车任务的方法接口
	 * 前置条件：	点击取消按钮
	 * 后置条件:	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelLoad();
}
