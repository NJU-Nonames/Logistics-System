package businesslogicservice.logisticsblservice;

import businesslogic.utilitybl.ResultMessage;
import vo.OrderVO;

public interface SearchPkgInformationBLService {
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param orderVo
	 * @return
	 */
	public ResultMessage searchPkgInformation(String orderId);
}
