/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._driver;

import po.TransArrivalListPO;
import dataservice.logisticsdataservice.TransferCentreRecieveDataService;

/**
 * @author 谭期友
 *
 */
public class TransferCentreRecieveDataService_Driver {
	public void drive(TransferCentreRecieveDataService transferCentreRecieveDataService){
		transferCentreRecieveDataService.creatTransArrivalList(null);
	}
}
