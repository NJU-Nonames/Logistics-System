package businesslogicservice.logisticsblservice._stub;

import vo.TransArrivalListVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;

public class TransferCenterReceiveBLService_Stub implements TransferCenterReceiveBLService{

	@Override
	public ResultMessage createTransArrivalList(
			TransArrivalListVO transArrivalList) {
        System.out.println("创建成功");
		return new ResultMessage(true,"创建成功");
	}

}
