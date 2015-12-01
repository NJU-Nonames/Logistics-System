package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import po.list.OrderListPO;
import presentation.mainui.CurrentUser;
import dataservice.list.OrderListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.OrderListVO;
import vo.ReceiverVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;

public class ReceivePkgBLImpl implements ReceivePkgBLService {
	OrderListDataService service1=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public ReceivePkgBLImpl(CurrentUser currentuser){
		service1=(OrderListDataService)RMIHelper.find("OrderListDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}
	public OrderListVO findOrderlist(String orderlistId) {
		OrderListPO orderlistpo=null;
		try{
			orderlistpo=service1.find(orderlistId);
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		if(orderlistpo==null)
			return null;
		return new OrderListVO(orderlistpo);
	}
	public ResultMessage confirmRecieve(ReceiverVO receiver,String barcode) {
		OrderListPO orderListPO=null;
		try {
			orderListPO=service1.find(barcode);
			if(orderListPO==null)
				return new ResultMessage(false, "无此单号!");
			if(orderListPO!=null){
				orderListPO.setArriveTime(receiver.getTime());
				orderListPO.setReceiverName(receiver.getName());
				orderListPO.getPkgState().add(receiver.getTime()+" 订单已经签收");
				service1.update(orderListPO);
			}
			} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true,"已成功收件!");
	}

}
