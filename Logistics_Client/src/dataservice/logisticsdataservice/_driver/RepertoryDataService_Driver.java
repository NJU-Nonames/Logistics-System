/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._driver;

import po.RepertoryInPO;
import po.RepertoryInfoPO;
import po.RepertoryOutPO;
import dataservice.logisticsdataservice.RepertoryDataService;

/**
 * @author 谭期友
 *
 */
public class RepertoryDataService_Driver {
	public void drive(RepertoryDataService repertoryDataService){
		repertoryDataService.addInputRepertory(null);
		repertoryDataService.addOutputRepertory(null);
		repertoryDataService.showRepertory(null, null);
	}
}
