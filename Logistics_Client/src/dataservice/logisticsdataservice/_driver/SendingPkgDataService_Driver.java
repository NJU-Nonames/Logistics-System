/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._driver;

import po.OrderListPO;
import dataservice.logisticsdataservice.SendingPkgDataService;

/**
 * @author 谭期友
 *
 */
public class SendingPkgDataService_Driver {
	public void drive(SendingPkgDataService sendingPkgDataService){
		sendingPkgDataService.addOrderList(null);
	}
}
