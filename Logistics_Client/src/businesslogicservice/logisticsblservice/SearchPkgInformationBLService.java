/**
 *2015年10月21日
 *author:tdy
 *discirption:物流模块中查询订单详情提供的接口 
 */
package businesslogicservice.logisticsblservice;

import vo.OrderlistVO;

public interface SearchPkgInformationBLService {
	/**用户查询订单信息的方法接口
	 * 前置条件：	orderlistId输入符合规则
	 * 后置条件：	查找是否存在相应的订单，返回这个订单的实体vo类
	 * @param 	订单编号
	 * @return 	返回给展示层的一个订单的实体类
	 */
	public OrderlistVO searchPkgInformation(String orderlistId);
	/**用户取消查询订单信息的方法接口
	 * 前置条件：	用户点击取消按钮
	 * 后置条件：	界面返回上一层
	 * @return	取消操作是否成功
	 */
	public boolean cancelSearch();
}
