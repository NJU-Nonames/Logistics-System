package dataservice.logisticsdataservice;

import po.OrderListPO;

public interface SerchPkgInformationDataService {
	
	/**用户查询订单信息的方法接口
	 * 前置条件：	orderlistId输入符合规则
	 * 后置条件：	查找是否存在相应的订单，返回这个订单的实体vo
	 * 若未查找到则返回null
	 * @param 	订单编号
	 * @return 	返回给展示层的一个订单的实体类
	 */
	public OrderListPO searchPkgInformation(String orderlistId);
}
