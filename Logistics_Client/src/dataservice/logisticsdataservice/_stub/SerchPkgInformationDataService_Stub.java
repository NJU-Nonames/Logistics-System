/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.OrderListPO;
import dataservice.logisticsdataservice.SerchPkgInformationDataService;

/**
 * @author 谭期友
 *
 */
public class SerchPkgInformationDataService_Stub implements SerchPkgInformationDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.SerchPkgInformationDataService#searchPkgInformation(java.lang.String)
	 */
	public OrderListPO searchPkgInformation(String orderlistId) {
		System.out.println("创建成功！");
		return new OrderListPO(orderlistId, orderlistId, orderlistId, orderlistId, orderlistId, 0, 0, orderlistId, null, null, 0, orderlistId);
	}

}
