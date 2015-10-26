package businesslogicservice.logisticsblservice._driver;

import vo.OrderListVO;
import businesslogic.utilitybl.ExpressType;
import businesslogic.utilitybl.PkgState;
import businesslogicservice.logisticsblservice.SendPkgBLService;

public class SendPkgBLService_Driver {

	public void drive(SendPkgBLService sendPkgBLService){
		
		String[] s=new String[5];
		sendPkgBLService.createOrderList(s);
		sendPkgBLService.submitOrderList(new OrderListVO("wjw", "大街2-13号",
			"asd_2-21","13974829111", "2",
				65.3, 1.2, "okok", ExpressType.EXPRESS,
				PkgState.RECEIVER_CENTER_ARRIVAL, 15.5, "100000"));
	}
}
