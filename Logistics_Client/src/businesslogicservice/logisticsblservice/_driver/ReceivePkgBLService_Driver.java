package businesslogicservice.logisticsblservice._driver;

import vo.ReceiverVO;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;

public class ReceivePkgBLService_Driver {

	public void drive(ReceivePkgBLService receiverPkgBLService){
		receiverPkgBLService.confirmRecieve(new ReceiverVO("wjw", "2015-2-21"));
		receiverPkgBLService.findOrderlist("10000101");
	}
}
