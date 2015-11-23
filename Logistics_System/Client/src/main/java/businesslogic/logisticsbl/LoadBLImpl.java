package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.list.LoadListPO;
import po.list.OrderListPO;
import dataservice.list.LoadListDataService;
import dataservice.list.OrderListDataService;
import utility.ResultMessage;
import vo.LoadListVO;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.LoadBLService;

public class LoadBLImpl implements LoadBLService {
	OrderListDataService service1=null; 
	LoadListDataService service2=null;
	public LoadBLImpl(){
		this.service1= (OrderListDataService) RMIHelper.find("OrderListDataService");
		this.service2= (LoadListDataService)RMIHelper.find("LoadListDataService");
	}
	public OrderListVO addLoad(String num) {
		OrderListPO orderListPO=null;
		OrderListVO orderListVO=null;
		try {
			orderListPO=service1.find(num);
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
	//疑惑：到底啥时候修改订单的货运轨迹？
	public ResultMessage createLoadlist(LoadListVO loadListVO) {
		LoadListPO loadListPO=new LoadListPO(loadListVO.getDate(),loadListVO.getHallNumber(),loadListVO.getTranspotationNumber(), 
				loadListVO.getDestination(),loadListVO.getCarNumber(),loadListVO.getGuardMan(),loadListVO.getSupercargoMan(),loadListVO.getBarcodes());
		try{
			service2.add(loadListPO);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true, "装车成功！");
	}

}
