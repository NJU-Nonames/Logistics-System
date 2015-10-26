/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._driver;

import po.LoadListPO;
import dataservice.logisticsdataservice.LoadDataService;

/**
 * @author 谭期友
 *
 */
public class LoadDataService_Driver{
	public void drive(LoadDataService loadDataService){
		loadDataService.addLoad(null);
		loadDataService.createLoadlist(null);
	}
}
