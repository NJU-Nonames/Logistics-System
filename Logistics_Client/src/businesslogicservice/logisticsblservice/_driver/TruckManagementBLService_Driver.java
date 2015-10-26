package businesslogicservice.logisticsblservice._driver;

import vo.TruckVO;
import businesslogicservice.logisticsblservice.TruckManageBLService;

public class TruckManagementBLService_Driver {
	
	public void drive(TruckManageBLService truckManageBLService){
		truckManageBLService.add(new TruckVO("100000", "陕A2131", "10years"));
		truckManageBLService.delete(new TruckVO("100000", "陕A2131", "10years"));
		truckManageBLService.find("100000");
		truckManageBLService.show("10000");
		truckManageBLService.update(new TruckVO("100000", "陕A2131", "10years"));
		
	}

}
