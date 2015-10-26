package businesslogicservice.logisticsblservice._stub;

import vo.LoadListVO;
import vo.OrderListVO;
import businesslogic.utilitybl.ExpressType;
import businesslogic.utilitybl.PkgState;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.LoadBLService;

public class LoadBLService_Stub implements LoadBLService{

	@Override
	public OrderListVO addLoad(String num) {
		System.out.println("添加成功");
		return new OrderListVO("wjw", "大街2-13号",
			"asd_2-21","13974829111", "2",
				65.3, 1.2, "okok", ExpressType.EXPRESS,
				PkgState.RECEIVER_CENTER_ARRIVAL, 15.5, "100000");
	}

	@Override
	public ResultMessage createLoadlist(LoadListVO loadListVO) {
		System.out.println("创建成功");
		return new ResultMessage(true,"创建成功");
	}

}
