/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.OrderListPO;
import dataservice.logisticsdataservice.SendingPkgDataService;

/**
 * @author 谭期友
 *
 */
public class SendingPkgDataService_Stub implements SendingPkgDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.SendingPkgDataService#InputOrderList(po.OrderListPO)
	 */
	public boolean addOrderList(OrderListPO orderList) {
		System.out.println("创建成功！");
		return true;
	}

}
