/**
 *2015年10月21日
 *author:tdy
 *discirption:物流模块中提供给收件的相关操作的接口
 */
package businesslogicservice.logisticsblservice;

import vo.OrderlistVO;
import vo.RecieverVO;

public interface RecievePkgBLService {
	/**快递员进行的确定正在签收的订单的方法的接口
	 * 前置条件：	开始一个签收任务
	 * 后置条件：	系统寻找到要签收的订单的vo实体类，并显示
	 * @param 	准备签收的订单编号
	 * @return	正在准备签收的订单实体
	 */
	public OrderlistVO findOrderlist(String orderlistId);
	/**快递员输入签收人相关信息，系统确认收件
	 * 前置条件：	快递员输入签收人的相关信息，系统在生成签收人vo类之后由快递员确认是否签收
	 * 后置条件：	签收成功则修改订单相关数据，不成功则不加以修改
	 * @param 	实际签收人
	 * @return	签收是否成功
	 */
	public boolean confirmRecieve(RecieverVO reciever);
	/**快递员取消签收的方法接口
	 * 前置条件：	快递员点击取消按钮
	 * 后置条件：	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelRecieve();
}
