package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.agency.StaffPO;
import po.list.DeliveringListPO;
import po.list.HallArrivalListPO;
import po.list.OrderListPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.agency.StaffDataService;
import dataservice.list.DeliveringListDataService;
import dataservice.list.HallArrivalListDataService;
import dataservice.list.OrderListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.DeliveringListVO;
import vo.HallArrivalListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;

public class DeliverAndReceiveBLImpl implements DeliverAndReceiveBLService {
	HallArrivalListDataService service1=null;
	DeliveringListDataService service2=null;
	OrderListDataService service3=null;
	StaffDataService staff=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public DeliverAndReceiveBLImpl(CurrentUser currentuser){
		staff=(StaffDataService) RMIHelper.find("StaffDataService");
		service1=(HallArrivalListDataService)RMIHelper.find("HallArrivalListDataService");
		service2=(DeliveringListDataService)RMIHelper.find("DeliveringListDataService");
		service3=(OrderListDataService)RMIHelper.find("OrderListDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}
	public ResultMessage createHallArrivalList(HallArrivalListVO hallArrivalList) {
		// TODO Auto-generated method stub
		HallArrivalListPO hallarrivallist=null;
		try{
			hallarrivallist=service1.find(hallArrivalList.getId());
		}catch (RemoteException e) {
			e.printStackTrace();
		}	
		if(hallarrivallist!=null)
			return new ResultMessage(false,"营业厅到达单已经存在!");
		for(String id:hallArrivalList.getBarCodes()){
			try {
				OrderListPO orderListPO=service3.find(id);
				ArrayList<String> orderpath=orderListPO.getPkgState();
				orderpath.add((String)df.format(new Date())+" 快递到达"+user.getAgencyName());
				orderListPO.setPkgState(orderpath);
				service3.update(orderListPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}		
		}
		hallarrivallist=new HallArrivalListPO(hallArrivalList.getId(),hallArrivalList.getDate(),hallArrivalList.getTransferNumber(),hallArrivalList.getFrom(),hallArrivalList.getState(),hallArrivalList.getBarCodes(),hallArrivalList.getCheckType());
		try {
			service1.add(hallarrivallist);
			system.add(new SystemLogPO((String)df.format(new Date()),"添加营业厅到达单,单号为"+hallarrivallist.getId(),user.getAdmin()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		return new ResultMessage(true, "添加营业厅到达单成功!");
	}
	public ResultMessage createDeliveringList(DeliveringListVO deliveringList) {
		DeliveringListPO deliverlistpo=null;
		try{
			deliverlistpo=service2.find(deliveringList.getId());
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		if(deliverlistpo!=null)
			return new ResultMessage(false,"派件单已经存在!");
		for(String id:deliveringList.getBarCode()){
			try {
				OrderListPO orderListPO=service3.find(id);
				ArrayList<String> orderpath=orderListPO.getPkgState();
				ArrayList<StaffPO> stafflist=staff.findbyname(deliveringList.getDeliveryMan());
				StaffPO st=null;
				for(int i=0;i<stafflist.size();i++){
					if(stafflist.get(i).getAgencyId().equals(deliveringList.getId().substring(0, 6)))
						st=stafflist.get(i);
					
				}
				if(st==null)
					return  new ResultMessage(false, "不存在该快递员信息!");
				orderpath.add((String)df.format(new Date())+" 快递正在由快递员"+deliveringList.getDeliveryMan()+"派送,电话 "+st.getPhoneNum());
				orderListPO.setPkgState(orderpath);
				service3.update(orderListPO);
			} catch (RemoteException e) {
				e.printStackTrace();
			}	
		}
		deliverlistpo=new DeliveringListPO(deliveringList.getId(),deliveringList.getDate(),deliveringList.getBarCode(),deliveringList.getDeliveryMan(),deliveringList.getCheckType());
		try {
			service2.add(deliverlistpo);
			system.add(new SystemLogPO((String)df.format(new Date()),"添加派件单,单号为"+deliverlistpo.getId(),user.getAdmin()));
		} catch (RemoteException e) {
			e.printStackTrace();		
		}
		return new ResultMessage(true, "添加派件单成功!");
	}
	public String createHallArrivalListId() {
		// TODO 自动生成的方法存根
		String s="";
		try{
		s=(service1.showAllByAgency(user.getAgencyNum()).size()+1)+"";
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(int i=0;i<5-s.length();i++)
			s="0"+s;
		return user.getAgencyNum()+s;
	}
	public String createDeliveringListId() {
		// TODO 自动生成的方法存根
		String s="";
		try{
		s=(service2.showAllbyAgency(user.getAgencyNum()).size()+1)+"";
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(int i=0;i<5-s.length();i++)
			s="0"+s;
		return user.getAgencyNum()+s;
	}
}
