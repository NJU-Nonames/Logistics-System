package businesslogic.logisticsbl;

import dataservice.list.OrderListDataService;
import utility.ResultMessage;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogic.utilitybl.CurrentUser;
import businesslogicservice.logisticsblservice.SendPkgBLService;

public class SendPkgBLImpl implements SendPkgBLService {
	OrderListDataService service=null;
	public SendPkgBLImpl(){
		this.service=(OrderListDataService) RMIHelper.find("OrderListDataService");
	}
	public OrderListVO createMoneyAndDate(OrderListVO orderListVO) {
		// TODO Auto-generated method stub
		OrderListVO vo1=null;
		
		return null;
	}

	public ResultMessage createOrderList(OrderListVO orderListVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
