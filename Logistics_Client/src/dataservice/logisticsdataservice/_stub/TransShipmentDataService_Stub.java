/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.TransShipmentListPO;
import dataservice.logisticsdataservice.TransShipmentDataService;

/**
 * @author 谭期友
 *
 */
public class TransShipmentDataService_Stub implements TransShipmentDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.TransShipmentDataService#createShiplist(po.TransShipmentListPO)
	 */
	public boolean addShiplist(TransShipmentListPO transShipment) {
		System.out.println("创建成功！");
		return true;
	}

}
