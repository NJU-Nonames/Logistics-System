/**
 *2015年11月10日
 *author:
 *description: 
 */
package businesslogic.logisticsbl;


import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import po.list.OrderListPO;
import presentation.mainui.CurrentUser;
import dataservice.list.OrderListDataService;
import dataservice.system.SystemLogDataService;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

/**
 * @author Administrator
 *
 */
public class SearchPkgInformationBLImpl implements SearchPkgInformationBLService{
	OrderListDataService service=null; 
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	//构造函数
	public SearchPkgInformationBLImpl(CurrentUser currentuser){
		this.service=(OrderListDataService) RMIHelper.find("OrderListDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}
	public OrderListVO searchPkgInformation(String orderlistId) {
		// TODO 自动生成的方法存根
		OrderListPO orderListPO=null;
		OrderListVO orderListVO=null;
		try {
			orderListPO=service.find(orderlistId);
			if(orderListPO==null)
				return null;
			else{
				orderListVO=new OrderListVO(orderListPO);
			}
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}	
		return orderListVO;
	}
}
