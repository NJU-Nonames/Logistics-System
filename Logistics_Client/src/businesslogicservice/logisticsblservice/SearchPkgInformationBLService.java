/**
 *2015年10月21日
 *author:tdy
 *discirption:物流模块中查询订单详情提供的接口 
 */
package businesslogicservice.logisticsblservice;

import vo.OrderlistVO;

public interface SearchPkgInformationBLService {
	/**
	 * 前置条件：	
	 * 后置条件：
	 * @param 	订单编号
	 * @return 	返回给展示层的一个订单的实体类
	 */
	public OrderlistVO searchPkgInformation(String orderlistId);
	/**
	 * 前置条件：
	 * 后置条件：
	 * @return	取消操作是否成功
	 */
	public boolean cancelSearch();
}
