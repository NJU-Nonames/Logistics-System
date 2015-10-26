/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.chartblservice._driver;

import businesslogicservice.chartblservice.CheckBLService;

public class CheckBLService_Driver {
	public void drive(CheckBLService checkBLService){
		checkBLService.ChangeDoc(null, null);
		checkBLService.failSelectedDoc(null, null);
		checkBLService.passAllDoc(null,null);
		checkBLService.passSelectedDoc(null, null);
	}
}
