/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.informationchangeblservice._driver;

import businesslogicservice.informationchangeblservice.ConstantManageBLService;
import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;
import businesslogicservice.informationchangeblservice._stub.ConstantManageBLService_Stub;
import businesslogicservice.informationchangeblservice._stub.PeopleAgencyBLService_Stub;

/**
 * @author Administrator
 *
 */
public class InformationChangeBLService_Driver {
	public static void main(String[] args){
		InformationChangeBLService_Driver driver=new InformationChangeBLService_Driver();
		driver.run();
	}
	private void run(){
		ConstantManageBLService_Driver d1=new ConstantManageBLService_Driver();
		ConstantManageBLService s1=new ConstantManageBLService_Stub();
		d1.drive(s1);
		
		PeopleAgencyBLService_Driver d2=new PeopleAgencyBLService_Driver();
		PeopleAgencyBLService s2=new PeopleAgencyBLService_Stub();
		d2.drive(s2);
	}
}
