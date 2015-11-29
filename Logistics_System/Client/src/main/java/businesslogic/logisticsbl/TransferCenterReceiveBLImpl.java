package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.OrderListPO;
import po.list.TransArrivalListPO;
import po.repertory.GoodsInfoPO;
import dataservice.list.OrderListDataService;
import dataservice.list.TransArrivalListDataService;
import utility.ResultMessage;
import vo.GoodsInfoVO;
import vo.TransArrivalListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;

public class TransferCenterReceiveBLImpl implements TransferCenterReceiveBLService {
           OrderListDataService orderlist=null;
           TransArrivalListDataService transarrival=null;
           public TransferCenterReceiveBLImpl(){
        	   orderlist=(OrderListDataService)RMIHelper.find("OrderListDataService");
        	   transarrival=(TransArrivalListDataService)RMIHelper.find("TransArrivalListDataService");
           }
	public ResultMessage createTransArrivalList(TransArrivalListVO transArrivalList,String keywords) {
		// TODO Auto-generated method stub
		ArrayList<GoodsInfoPO> goodpo=new ArrayList<GoodsInfoPO>();
		try{
			for(GoodsInfoVO goodvo:transArrivalList.getGoodsInfoVOs()){
				OrderListPO orderpo=orderlist.find(goodvo.getBarcode());
				orderpo.getPkgState().add(keywords);
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
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,"中转到达单添加成功!");
	}

}
