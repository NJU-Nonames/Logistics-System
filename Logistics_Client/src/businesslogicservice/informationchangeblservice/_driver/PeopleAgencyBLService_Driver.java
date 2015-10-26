/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.informationchangeblservice._driver;

import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;

/**
 * @author Administrator
 *
 */
public class PeopleAgencyBLService_Driver {
	public void drive(PeopleAgencyBLService peopleAgencyBLService){
		peopleAgencyBLService.addAgency(null);
		peopleAgencyBLService.deleteAgency(null);
		peopleAgencyBLService.findAgency(null);
		peopleAgencyBLService.salaryManage(null, null);
		peopleAgencyBLService.showAgency();
	}
}
