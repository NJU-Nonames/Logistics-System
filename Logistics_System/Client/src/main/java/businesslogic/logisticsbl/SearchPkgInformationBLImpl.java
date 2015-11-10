/**
 *2015年11月10日
 *author:
 *description: 
 */
package businesslogic.logisticsbl;


import dataservice.list.OrderListDataService;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

/**
 * @author Administrator
 *
 */
public class SearchPkgInformationBLImpl implements SearchPkgInformationBLService{

	/* (non-Javadoc)
	 * @see businesslogicservice.logisticsblservice.SearchPkgInformationBLService#searchPkgInformation(java.lang.String)
	 */
	public OrderListVO searchPkgInformation(String orderlistId) {
		// TODO Auto-generated method stub
		OrderListDataService service=(OrderListDataService)RMIHelper.find(OrderListDataService.NAME);
		
		return null;
	}

}
