package businesslogicservice.logisticsblservice._stub;

import vo.OrderListVO;
import businesslogic.utilitybl.ExpressType;
import businesslogic.utilitybl.PkgState;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.SendPkgBLService;

public class SendPkgBLService_Stub implements SendPkgBLService{

	public OrderListVO createMoneyInformation(OrderListVO orderList) {
		System.out.println("创建成功");
		return new OrderListVO("wjw", "大街2-13号",
			"asd_2-21","13974829111", "2",
				65.3, 1.2, "okok", ExpressType.EXPRESS,
				PkgState.RECEIVER_CENTER_ARRIVAL, 15.5, "100000");
	}

	public ResultMessage createOrderList(OrderListVO orderListVO) {
		System.out.println("提交成功");
		return new ResultMessage(true,"创建成功");
	}

}
