package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.list.LoadListPO;
import po.list.OrderListPO;
import po.list.TransArrivalListPO;
import po.list.TransShipmentListPO;
import po.repertory.GoodsInfoPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.agency.AgencyDataService;
import dataservice.list.LoadListDataService;
import dataservice.list.OrderListDataService;
import dataservice.list.TransArrivalListDataService;
import dataservice.list.TransShipmentListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.GoodsInfoVO;
import vo.TransArrivalListVO;
import vo.TransArrivalVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;

public class TransferCenterReceiveBLImpl implements TransferCenterReceiveBLService {
     OrderListDataService orderlist=null;
     TransArrivalListDataService transarrival=null;
     CurrentUser user=null;
     LoadListDataService loadlist=null;
 	SystemLogDataService system=null;
 	AgencyDataService agency=null;
 	TransShipmentListDataService trans=null;
 	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 	
 	
     public TransferCenterReceiveBLImpl(CurrentUser currentuser){
        orderlist=(OrderListDataService)RMIHelper.find("OrderListDataService");
        transarrival=(TransArrivalListDataService)RMIHelper.find("TransArrivalListDataService");
        user=currentuser;
        system=(SystemLogDataService)RMIHelper.find("SystemLogDataService"); 
        loadlist=(LoadListDataService)RMIHelper.find("LoadListDataService");
        agency=(AgencyDataService)RMIHelper.find("AgencyDataService");
        trans=(TransShipmentListDataService)RMIHelper.find("TransShipmentListDataService");
        }
	public ResultMessage createTransArrivalList(TransArrivalListVO transArrivalList) {
		// TODO Auto-generated method stub
		ArrayList<GoodsInfoPO> goodpo=new ArrayList<GoodsInfoPO>();
		try{
			for(GoodsInfoVO goodvo:transArrivalList.getGoodsInfoVOs()){
				OrderListPO orderpo=orderlist.find(goodvo.getBarcode());
				ArrayList<String> orderpath=orderpo.getPkgState();
				orderpath.add((String)df.format(new Date())+" 快递到达"+user.getAgencyName());
				orderpo.setPkgState(orderpath);
				orderlist.update(orderpo);
				goodpo.add(new GoodsInfoPO(goodvo.getBarcode(),goodvo.getState(),goodvo.getDeparturePlace()));
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		TransArrivalListPO transpo=null;
		try{
			transpo=transarrival.find(transArrivalList.getTransferNumber());
			if(transpo!=null)
				return new ResultMessage(false,"中转单已经存在!");
			transpo=new TransArrivalListPO(transArrivalList.getId(),transArrivalList.getTransferNumber(),transArrivalList.getCenterNumber(),transArrivalList.getDate(),goodpo,transArrivalList.getCheckType());
			transarrival.update(transpo);
			system.add(new SystemLogPO((String)df.format(new Date()),"添加中转中心到达单,单号为"+transArrivalList.getId(),user.getAdmin()));
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,"添加中转到达单成功!");
	}
	public TransArrivalVO getLoadList(String loadlistid) {
		// TODO Auto-generated method stub
		LoadListPO loadlistpo=null;
		try{
			loadlistpo=loadlist.find(loadlistid);
			if(loadlistpo==null)
				return null;
			else{
				TransArrivalVO transvo=new TransArrivalVO();
				transvo.barcodes=loadlistpo.getBarcodes();
				transvo.depatureplace=agency.find(loadlistpo.getHallNumber()).getAgencyName();
				return transvo;
			}
			}catch(RemoteException e){
				e.printStackTrace();
			}
		return null;
	}
	public TransArrivalVO getTransShipmentList(String transshipmentlistid) {
		// TODO Auto-generated method stub
		TransShipmentListPO transshipmentpo=null;
		try{
			transshipmentpo=trans.find(transshipmentlistid);
			if(transshipmentpo==null)
				return null;
			else{
				TransArrivalVO transvo=new TransArrivalVO();
				transvo.barcodes=transshipmentpo.getBarcodes();
				transvo.depatureplace=agency.find(transshipmentpo.getTransitDocNumber().substring(0,6)).getAgencyName();
				return transvo;
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

}
