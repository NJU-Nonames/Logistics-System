package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.list.OrderListPO;
import dataservice.list.OrderListDataService;
import utility.ResultMessage;
import vo.OrderListVO;
import vo.ReceiverVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;

public class ReceivePkgBLImpl implements ReceivePkgBLService {
	OrderListDataService service1=null;
	public ReceivePkgBLImpl(){
		service1=(OrderListDataService)RMIHelper.find("OrderListDataService");
	}
	public OrderListVO findOrderlist(String orderlistId) {
		OrderListVO orderListVO=null;
		try{
			orderListVO=new OrderListVO(service1.find(orderlistId));
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return orderListVO;
	}

	public ResultMessage confirmRecieve(ReceiverVO receiver,OrderListVO orderListVO) {
		OrderListPO orderListPO=null;
		try {
			orderListPO=service1.find(orderListVO.getBarCode());
			if(orderListPO!=null){
				orderListPO.setArriveTime(receiver.getTime());
				orderListPO.setReceiverName(receiver.getName());
				orderListPO.getPkgState().add(orderListVO.getPkgState().get(orderListVO.getPkgState().size()-1));
				service1.update(orderListPO);
			}
			} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true,"已成功收件！");
	}

}
