/**
 *2015年11月10日
 *author:
 *description: 
 */
package businesslogic.logisticsbl;


import dataservice.DataFactoryService;
import dataservice.list.OrderListDataService;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

/**
 * @author Administrator
 *
 */
public class SearchPkgInformationBLImpl implements SearchPkgInformationBLService{
	private DataFactoryService dataFactory;//数据工厂

	//构造函数
	public SearchPkgInformationBLImpl(){
		this.dataFactory=(DataFactoryService)RMIHelper.find("dataFactory");
	}

	public OrderListVO searchPkgInformation(String orderlistId) {
		// TODO 自动生成的方法存根
		return null;
	}

}
