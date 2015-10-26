/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.DriverPO;
import po.LoadListPO;
import po.OrderListPO;
import dataservice.logisticsdataservice.LoadDataService;

/**
 * @author 谭期友
 *
 */
public class LoadDataService_Stub implements LoadDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.LoadDataService#addLoad(java.lang.String)
	 */
	public OrderListPO addLoad(String num) {
		System.out.println("创建成功！");
		return new OrderListPO(num, num, num, num, num, 0, 0, num, null, null, 0, num);
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.LoadDataService#createLoadlist(po.LoadListPO)
	 */
	public boolean createLoadlist(LoadListPO loadListPO) {
		System.out.println("创建成功！");
		return true;
	}

}
