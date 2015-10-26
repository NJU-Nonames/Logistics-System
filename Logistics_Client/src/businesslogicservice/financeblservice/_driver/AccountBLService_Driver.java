/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.financeblservice._driver;

import businesslogicservice.financeblservice.AccountBLService;

/**
 * @author Administrator
 *
 */
public class AccountBLService_Driver {
	public void drive(AccountBLService accountBLService){
		accountBLService.createCount(null);
		accountBLService.login(null, null);
		accountBLService.removeCount(null);
		accountBLService.searchCount(null);
		accountBLService.show();
		accountBLService.updadaCount(null);
	}
}
