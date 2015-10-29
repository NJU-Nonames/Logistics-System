package businesslogicservice.logisticsblservice._driver;

import java.util.ArrayList;

import vo.TransShipmentListVO;
import businesslogicservice.logisticsblservice.TransShipmentBLService;

public class TransShipmentBLService_Driver {

	public void drive(TransShipmentBLService  transShipmentBLService){
		ArrayList<String> barcodes=new ArrayList<String>();
		
		transShipmentBLService.createShiplist(new TransShipmentListVO("2013-2-4", "1000202", "HA2321", "西安", "南京", "12321", "wjw", barcodes));
	}
}
