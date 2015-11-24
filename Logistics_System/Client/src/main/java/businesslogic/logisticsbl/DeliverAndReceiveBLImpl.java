package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.list.DeliveringListPO;
import po.list.HallArrivalListPO;
import po.list.OrderListPO;
import dataservice.list.DeliveringListDataService;
import dataservice.list.HallArrivalListDataService;
import dataservice.list.OrderListDataService;
import utility.ResultMessage;
import vo.DeliveringListVO;
import vo.HallArrivalListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;

public class DeliverAndReceiveBLImpl implements DeliverAndReceiveBLService {
	HallArrivalListDataService service1=null;
	DeliveringListDataService service2=null;
	OrderListDataService service3=null;
	public DeliverAndReceiveBLImpl(){
		service1=(HallArrivalListDataService)RMIHelper.find("HallArrivalListDataService");
		service2=(DeliveringListDataService)RMIHelper.find("DeliveringListDataService");
		service3=(OrderListDataService)RMIHelper.find("OrderListDataService");
	}
	public ResultMessage createHallArrivalList(HallArrivalListVO hallArrivalList,String keywords) {
		// TODO Auto-generated method stub
		for(String id:hallArrivalList.getBarCodes()){
			try {
				OrderListPO orderListPO=service3.find(id);
				orderListPO.getPkgState().add(keywords);
				service3.update(orderListPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
		HallArrivalListPO result=new HallArrivalListPO(hallArrivalList.getDate(),hallArrivalList.getTransferNumber(),hallArrivalList.getFrom(),hallArrivalList.getState(),hallArrivalList.getBarCodes());
		try {
			service1.add(result);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true, "营业厅到达单已生成！");
	}

	public ResultMessage createDeliveringList(DeliveringListVO deliveringList,String keywords) {
		for(String id:deliveringList.getBarCode()){
			try {
				OrderListPO orderListPO=service3.find(id);
				orderListPO.getPkgState().add(keywords);
				service3.update(orderListPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
		}
		DeliveringListPO result=new DeliveringListPO(deliveringList.getDate(),deliveringList.getBarCode(),deliveringList.getDeliveryMan());
		try {
			service2.add(result);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true, "派件单已生成!");
	}

}
