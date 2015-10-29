/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.TransArrivalListPO;
import dataservice.logisticsdataservice.TransferCentreRecieveDataService;

/**
 * @author 谭期友
 *
 */
public class TransferCentreRecieveDataService_Stub implements TransferCentreRecieveDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.TransferCentreRecieveDataService#creatTransArrivalList(po.TransArrivalListPO)
	 */
	public boolean addTransArrivalList(TransArrivalListPO transArrivalList) {
		System.out.println("创建成功！");
		return true;
	}

}
