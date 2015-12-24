package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.DriverManageBLImpl;
import businesslogicservice.logisticsblservice.DriverManageBLService;
//completed
public class DriverManageBLImplTest {
	DriverManageBLService drivermanage=new DriverManageBLImpl(new CurrentUser("李四", "南京市鼓楼营业厅", "025001", "lisi"));
    //测试显示本营业厅所有司机信息
	@Test
	public void testShow() {
		assertTrue(drivermanage.show("025001").size()==1);
	}
    //测试根据司机工号来获得司机信息
	@Test
	public void testFind() {
		assertTrue("难道".equals(drivermanage.find("025001001").getName()));
	}

}
