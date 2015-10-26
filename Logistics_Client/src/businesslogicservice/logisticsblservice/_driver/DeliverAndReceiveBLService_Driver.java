package businesslogicservice.logisticsblservice._driver;

import java.util.ArrayList;

import vo.DeliveringListVO;
import vo.HallArrivalListVO;
import businesslogic.utilitybl.GoodsState;
import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;

public class DeliverAndReceiveBLService_Driver {
       public void drive(DeliverAndReceiveBLService deliverAndReceiveBLService){
    	   ArrayList<String> list=new ArrayList<String>();
    	   list.add("123123141");
    	  
    	   deliverAndReceiveBLService.createDeliveringList(new DeliveringListVO("2015-2-3", list, "wjw"));
    	   deliverAndReceiveBLService.createHallArrivalList(new HallArrivalListVO("2015-2-13", "1232145431", "西安", GoodsState.COMPLETE, list));
       }
}
