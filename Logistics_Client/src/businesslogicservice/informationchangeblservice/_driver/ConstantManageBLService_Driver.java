/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.informationchangeblservice._driver;

import businesslogicservice.informationchangeblservice.ConstantManageBLService;

/**
 * @author Administrator
 *
 */
public class ConstantManageBLService_Driver {
	public void drive(ConstantManageBLService constantManageBLService){
		constantManageBLService.addCity(null);
		constantManageBLService.showDistanceChart();
		constantManageBLService.showPriceChart();
		constantManageBLService.submitDistance(null, null, null);
		constantManageBLService.submitPrice(null, null);
	}
}
