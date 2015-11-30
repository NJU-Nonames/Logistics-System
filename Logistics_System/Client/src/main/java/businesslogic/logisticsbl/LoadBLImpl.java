package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;

import po.list.LoadListPO;
import po.list.OrderListPO;
import presentation.mainui.CurrentUser;
import dataservice.list.LoadListDataService;
import dataservice.list.OrderListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.LoadListVO;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.LoadBLService;

public class LoadBLImpl implements LoadBLService {
	OrderListDataService service1=null; 
	LoadListDataService service2=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public LoadBLImpl(CurrentUser currentuser){
		this.service1= (OrderListDataService) RMIHelper.find("OrderListDataService");
		this.service2= (LoadListDataService)RMIHelper.find("LoadListDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");

	}
	public ResultMessage createLoadlist(LoadListVO loadListVO) {
		for(String id:loadListVO.getBarcodes()){
			try{
				OrderListPO orderListPO=service1.find(id);
				//待修改！！！！！！！！！！！！！
				//orderListPO.getPkgState().add(keywords);
				service1.update(orderListPO);
			}catch(RemoteException e){
				e.printStackTrace();
			}
		}
		LoadListPO loadListPO=new LoadListPO(loadListVO.getId(),loadListVO.getDate(),loadListVO.getHallNumber(),loadListVO.getTranspotationNumber(), 
				loadListVO.getDestination(),loadListVO.getCarNumber(),loadListVO.getGuardMan(),loadListVO.getSupercargoMan(),loadListVO.getBarcodes(),loadListVO.getCheckType());
		try{
			service2.add(loadListPO);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true, "装车成功！");
	}

}
