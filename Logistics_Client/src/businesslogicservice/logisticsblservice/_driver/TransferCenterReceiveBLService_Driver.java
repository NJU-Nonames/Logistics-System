package businesslogicservice.logisticsblservice._driver;

import java.util.ArrayList;

import vo.GoodsInfoVO;
import vo.TransArrivalListVO;
import businesslogic.utilitybl.GoodsState;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;

public class TransferCenterReceiveBLService_Driver {
	
	public void drive(TransferCenterReceiveBLService transferCenterReceiveBLService){
		
		ArrayList<GoodsInfoVO> goodsInfoVOs=new ArrayList<GoodsInfoVO>();
		goodsInfoVOs.add(new GoodsInfoVO("100000", GoodsState.COMPLETE, "南京"));
		transferCenterReceiveBLService.createTransArrivalList(new TransArrivalListVO("12321111231", "1231313", "2015-2-4",goodsInfoVOs ));
	}

}
