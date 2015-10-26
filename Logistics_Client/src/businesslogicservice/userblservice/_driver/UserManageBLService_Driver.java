/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.userblservice._driver;

import businesslogicservice.userblservice.UserManageBLService;

public class UserManageBLService_Driver {
	public void drive(UserManageBLService userManageBLService){
		userManageBLService.addUser(null);
		userManageBLService.findonAdmin(null);
		userManageBLService.findonId(null);
		userManageBLService.login(null, null);
		userManageBLService.removeUser(null);
		userManageBLService.updataUser(null);
		userManageBLService.showAll();
	}
}
