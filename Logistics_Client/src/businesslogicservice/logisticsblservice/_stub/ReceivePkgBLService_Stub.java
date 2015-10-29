package businesslogicservice.logisticsblservice._stub;

import vo.OrderListVO;
import vo.ReceiverVO;
import businesslogic.utilitybl.ExpressType;
import businesslogic.utilitybl.PkgState;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;

public class ReceivePkgBLService_Stub implements ReceivePkgBLService{
	

	public OrderListVO findOrderlist(String orderlistId) {
          System.out.println("查找成功");
		return new OrderListVO("wjw", "大街2-13号",
			"asd_2-21","13974829111", "2",
				65.3, 1.2, "okok", ExpressType.EXPRESS,
				PkgState.RECEIVER_CENTER_ARRIVAL, 15.5, orderlistId);
	}

	public ResultMessage confirmRecieve(ReceiverVO receiver) {
		System.out.println("确认接收");
		return new ResultMessage(true,"确认接收") ;
	}

}
