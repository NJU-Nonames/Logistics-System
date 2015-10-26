package businesslogicservice.logisticsblservice._stub;

import vo.OrderListVO;
import businesslogic.utilitybl.ExpressType;
import businesslogic.utilitybl.PkgState;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

public class SearchPkgInformationBLService_Stub implements SearchPkgInformationBLService{

	@Override
	public OrderListVO searchPkgInformation(String orderlistId) {
		System.out.println("查找成功");
		return new OrderListVO("wjw", "大街2-13号",
			"asd_2-21","13974829111", "2",
				65.3, 1.2, "okok", ExpressType.EXPRESS,
				PkgState.RECEIVER_CENTER_ARRIVAL, 15.5, "100000");
	}

}
