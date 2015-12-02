package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.list.OrderListPO;
import po.list.TransArrivalListPO;
import po.repertory.GoodsInfoPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.list.OrderListDataService;
import dataservice.list.TransArrivalListDataService;
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
 	SystemLogDataService system=null;
 	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
 	
     public TransferCenterReceiveBLImpl(CurrentUser currentuser){
        orderlist=(OrderListDataService)RMIHelper.find("OrderListDataService");
        transarrival=(TransArrivalListDataService)RMIHelper.find("TransArrivalListDataService");
        user=currentuser;
        system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");    	   
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
		return null;
	}
	public TransArrivalVO getTransShipmentList(String transshipmentlistid) {
		// TODO Auto-generated method stub
		return null;
	}

}
