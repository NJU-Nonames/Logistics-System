package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.list.LoadListPO;
import po.list.OrderListPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.list.LoadListDataService;
import dataservice.list.OrderListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.LoadListVO;
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
		LoadListPO loadlistpo=null;
		for(String id:loadListVO.getBarcodes()){
			try{
				OrderListPO orderListPO=service1.find(id);
				ArrayList<String> orderpath=orderListPO.getPkgState();
				orderpath.add((String)df.format(new Date())+" 快递已经装车,正在送往"+loadListVO.getDestination());
				orderListPO.setPkgState(orderpath);
				service1.update(orderListPO);
			}catch(RemoteException e){
				e.printStackTrace();
			}
		}
		loadlistpo=new LoadListPO(loadListVO.getDate(),loadListVO.getHallNumber(),loadListVO.getTranspotationNumber(), 
				loadListVO.getDestination(),loadListVO.getCarNumber(),loadListVO.getGuardMan(),loadListVO.getSupercargoMan(),loadListVO.getBarcodes(),loadListVO.getCheckType());
		try{
			service2.add(loadlistpo);
			system.add(new SystemLogPO((String)df.format(new Date()),"添加装车单,汽运编号为"+loadListVO.getTranspotationNumber(),user.getAdmin()));
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true, "添加装车单成功!");
	}
	public String createLoadlistId() {
		// TODO 自动生成的方法存根
		String s="";
		try{
		s=(service2.showAllByAgency(user.getAgencyNum()).size()+1)+"";
		}catch(RemoteException e){
			e.printStackTrace();
		}
		int num=s.length();
		for(int i=0;i<5-num;i++)
			s="0"+s;
        SimpleDateFormat df1=new SimpleDateFormat("yyyyMMdd");
		return user.getAgencyNum()+df1.format(new Date())+s;
	}
}
