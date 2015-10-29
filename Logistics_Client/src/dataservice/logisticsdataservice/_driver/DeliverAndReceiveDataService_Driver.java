/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._driver;

import dataservice.logisticsdataservice.DeliverAndReceiveDataService;

/**
 * @author 谭期友
 *
 */
public class DeliverAndReceiveDataService_Driver {
	public void drive(DeliverAndReceiveDataService deliverAndReceiveDataService){
		deliverAndReceiveDataService.addDeliveringList(null);
		deliverAndReceiveDataService.addHallArrivalList(null);
	}
}
