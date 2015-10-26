/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.OrderListPO;
import po.ReceiverPO;
import dataservice.logisticsdataservice.ReceiverPkgDataService;

/**
 * @author 谭期友
 *
 */
public class ReceiverPkgDataService_Stub implements ReceiverPkgDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.ReceiverPkgDataService#findOrderlist(java.lang.String)
	 */
	public OrderListPO findOrderlist(String orderlistId) {
		System.out.println("创建成功！");
		return new OrderListPO(orderlistId, orderlistId, orderlistId, orderlistId, orderlistId, 0, 0, orderlistId, null, null, 0, orderlistId);
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.ReceiverPkgDataService#confirmReceive(po.ReceiverPO)
	 */
	public boolean confirmReceive(ReceiverPO receiver) {
		System.out.println("创建成功！");
		return true;
	}

}
