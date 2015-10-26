/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.userblservice._driver;

import businesslogicservice.userblservice.UserManageBLService;
import businesslogicservice.userblservice._stub.UserManageBLService_Stub;

public class UserBLService_Driver {
	public void main(String[] args){
		UserBLService_Driver driver=new UserBLService_Driver();
		driver.run();
	}
	private void run(){
		UserManageBLService_Driver d=new UserManageBLService_Driver();
		UserManageBLService s=new UserManageBLService_Stub();
		d.drive(s);
	}
}
