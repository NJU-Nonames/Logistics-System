package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.DriverManageBLImpl;
import businesslogicservice.logisticsblservice.DriverManageBLService;

public class DriverManageBLImplTest {
	DriverManageBLService drivermanage=new DriverManageBLImpl(new CurrentUser("", "", "", ""));
    //测试显示本营业厅所有司机信息
	@Test
	public void testShow() {
		assertTrue(drivermanage.show("").size()==5);
	}
    //测试根据司机工号来获得司机信息
	@Test
	public void testFind() {
		assertTrue("".equals(drivermanage.find("").getName()));
	}

}
