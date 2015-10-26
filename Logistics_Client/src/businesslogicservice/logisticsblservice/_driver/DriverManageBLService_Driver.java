package businesslogicservice.logisticsblservice._driver;

import vo.DriverVO;
import businesslogicservice.logisticsblservice.DriverManageBLService;

public class DriverManageBLService_Driver {

	public void drive(DriverManageBLService driverManagement){
		driverManagement.add(new DriverVO("南京", "TOM", "1996-3-8", "100000", "13991829392", "male", "10y"));
		driverManagement.delete(new DriverVO("南京", "TOM", "1996-3-8", "100000", "13991829392", "male", "10y"));
		driverManagement.update(new DriverVO("南京", "TOM", "1996-3-8", "100000", "13991829392", "male", "10y"));
		driverManagement.find("10000202");
		driverManagement.show("南京仙林营业厅");
	}
}
