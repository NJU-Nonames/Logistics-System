package businesslogicservice.logisticsblservice._stub;

import vo.DeliveringListVO;
import vo.HallArrivalListVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;

public class DeliverAndReceiveBLService_Stub implements DeliverAndReceiveBLService{

	@Override
	public ResultMessage createHallArrivalList(HallArrivalListVO hallArrivalList) {
		System.out.println("创建成功");
		return new ResultMessage(true, "创建成功");
	}

	@Override
	public ResultMessage createDeliveringList(DeliveringListVO deliveringList) {
		System.out.println("创建成功");
		return new ResultMessage(true, "创建成功");
	}

}
