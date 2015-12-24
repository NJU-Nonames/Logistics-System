package Java;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.TransShipmentBLImpl;
import businesslogicservice.logisticsblservice.TransShipmentBLService;
//completed
public class TransShipmentBLImplTest {
	TransShipmentBLService trans=new TransShipmentBLImpl(new CurrentUser("小芳", "南京市中转中心", "025000", "xiaofang"));

	//测试获得本次中转单单号
	@Test
	public void testCreateTransShipmentListId() {
		assertTrue("025000201512200000002".equals(trans.createTransShipmentListId()));
	}

}
