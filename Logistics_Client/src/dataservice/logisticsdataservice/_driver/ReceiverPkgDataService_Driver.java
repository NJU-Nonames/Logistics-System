/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._driver;

import po.ReceiverPO;
import dataservice.logisticsdataservice.ReceiverPkgDataService;

/**
 * @author 谭期友
 *
 */
public class ReceiverPkgDataService_Driver {
	public void drive(ReceiverPkgDataService receiverPkgDataService){
		receiverPkgDataService.findOrderlist(null);
		receiverPkgDataService.confirmReceive(null);
	}
}
