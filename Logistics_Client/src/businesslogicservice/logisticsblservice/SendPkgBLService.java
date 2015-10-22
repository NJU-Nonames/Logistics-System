/**
 *2015年10月21日
 *author:tdy
 *discirption:输入订单信息，系统保存保存订单 
 */
package businesslogicservice.logisticsblservice;

import vo.OrderlistVO;


public interface SendPkgBLService {
	/**快递员进行的输入订单基本信息，生成订单的方法接口
	 * 前置条件：	开始一个寄件任务
	 * 后置条件：	系统在补足缺省选项的基础上，生成一个订单，返回订单的vo实体用于显示，在系统中保存订单
	 * @param	订单的基本信息，如货物质量，尺寸大小，出发地目的地，寄件人收件人信息等等
	 * @return	完整的某个订单实体
	 */
	public OrderlistVO createOrderlist(String[] orderBaseInformation);
	/**快递员取消寄件任务
	 * 前置条件：	快递员点击取消按钮
	 * 后置条件：	返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelSend();
}
