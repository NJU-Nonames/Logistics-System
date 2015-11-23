/**
 *2015年11月10日
 *author:
 *description: 
 */
package businesslogic.logisticsbl;


import java.rmi.RemoteException;

import po.list.OrderListPO;
import dataservice.list.OrderListDataService;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

/**
 * @author Administrator
 *
 */
public class SearchPkgInformationBLImpl implements SearchPkgInformationBLService{
	OrderListDataService service=null; 
	//构造函数
	public SearchPkgInformationBLImpl(){
		this.service=(OrderListDataService) RMIHelper.find("OrderListDataService");
	}

	public OrderListVO searchPkgInformation(String orderlistId) {
		// TODO 自动生成的方法存根
		OrderListPO orderListPO=null;
		OrderListVO orderListVO=null;
		try {
			orderListPO=service.find(orderlistId);
			if(orderListPO==null){
				
			}
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
