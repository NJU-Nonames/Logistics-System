package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.ReceivePkgBLImpl;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;

public class ReceivePkgBLImplTest {
	ReceivePkgBLService receive=new ReceivePkgBLImpl(new CurrentUser("", "", "", ""));
    //测试获得订单信息
	@Test
	public void testFindOrderlist() {
		assertTrue("".equals(receive.findOrderlist("").getBarCode()));
	}

}
