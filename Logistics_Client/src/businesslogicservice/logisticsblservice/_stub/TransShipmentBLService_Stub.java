package businesslogicservice.logisticsblservice._stub;

import vo.TransShipmentListVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.TransShipmentBLService;

public class TransShipmentBLService_Stub implements TransShipmentBLService{

	public ResultMessage createShiplist(TransShipmentListVO transShipment) {
		System.out.println("创建成功");
		return new ResultMessage(true,"创建成功");
	}

}
