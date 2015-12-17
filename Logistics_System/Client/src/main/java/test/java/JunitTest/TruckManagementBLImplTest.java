package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.TruckManagementBLImpl;
import businesslogicservice.logisticsblservice.TruckManageBLService;

public class TruckManagementBLImplTest {
	TruckManageBLService truckmanage=new TruckManagementBLImpl(new CurrentUser("","","",""));
    //测试根据车辆代号查找货车
	public void testFind() {
		//找到
		assertTrue("".equals(truckmanage.find("").getPlatenumber()));
		//未找到
		assertTrue(truckmanage.find("")==null);
	}

}
