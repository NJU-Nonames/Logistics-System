package businesslogicservice.logisticsblservice._driver;

import java.util.ArrayList;

import vo.LoadListVO;
import businesslogicservice.logisticsblservice.LoadBLService;

public class LoadBLService_Driver {

	public void drive(LoadBLService loadBLService){
	   ArrayList<String> list=new ArrayList<String>();
   	   list.add("123123141");
   	  
		loadBLService.addLoad("123123141");
		loadBLService.createLoadlist(new LoadListVO("2015-10-11", "1000232", "123142122", "西安", "陕A213123", "wjw", "tdy", list));
	}
}
