package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.ReceivePkgBLImpl;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;
//completed
public class ReceivePkgBLImplTest {
	ReceivePkgBLService receive=new ReceivePkgBLImpl(new CurrentUser("翠花", "北京市朝阳营业厅", "010001", "cuihua"));
    //测试获得订单信息
	@Test
	public void testFindOrderlist() {
		assertTrue("025001201512071848".equals(receive.findOrderlist("025001201512071848").getBarCode()));
		assertTrue(receive.findOrderlist("025001201512071850")==null);
	}

}
