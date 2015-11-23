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
	public ResultMessage createLoadlist(LoadListVO loadListVO,String keywords) {
		for(String id:loadListVO.getBarcodes()){
			try{
				OrderListPO orderListPO=service1.find(id);
				orderListPO.getPkgState().add(keywords);
				service1.update(orderListPO);
			}catch(RemoteException e){
				e.printStackTrace();
			}
		}
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
