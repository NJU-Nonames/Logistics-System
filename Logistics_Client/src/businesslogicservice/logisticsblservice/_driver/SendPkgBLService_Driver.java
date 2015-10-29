package businesslogicservice.logisticsblservice._driver;

import vo.OrderListVO;
import businesslogic.utilitybl.ExpressType;
import businesslogic.utilitybl.PkgState;
import businesslogicservice.logisticsblservice.SendPkgBLService;

public class SendPkgBLService_Driver {

	public void drive(SendPkgBLService sendPkgBLService){
		OrderListVO order=new OrderListVO("wjw", "大街2-13号",
				"asd_2-21","13974829111", "2",
					65.3, 1.2, "okok", ExpressType.EXPRESS,
					PkgState.RECEIVER_CENTER_ARRIVAL, 15.5, "100000");
		
		sendPkgBLService.createOrderList(order);
		sendPkgBLService.createMoneyInformation(order);
	}
}
