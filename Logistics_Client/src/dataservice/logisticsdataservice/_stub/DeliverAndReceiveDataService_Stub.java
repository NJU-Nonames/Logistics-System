/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.DeliveringListPO;
import po.HallArrivalListPO;
import dataservice.logisticsdataservice.DeliverAndReceiveDataService;

/**
 * @author 谭期友
 *
 */
public class DeliverAndReceiveDataService_Stub implements DeliverAndReceiveDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.DeliverAndReceiveDataService#createHallArrivalList(po.HallArrivalListPO)
	 */
	public boolean createHallArrivalList(HallArrivalListPO hallArrivalList) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.DeliverAndReceiveDataService#createDeliveringList(po.DeliveringListPO)
	 */
	public boolean createDeliveringList(DeliveringListPO deliveringList) {
		System.out.println("创建成功！");
		return true;
	}

}
