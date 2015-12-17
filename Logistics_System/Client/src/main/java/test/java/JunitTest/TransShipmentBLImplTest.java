package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.TransShipmentBLImpl;
import businesslogicservice.logisticsblservice.TransShipmentBLService;

public class TransShipmentBLImplTest {
	TransShipmentBLService trans=new TransShipmentBLImpl(new CurrentUser("", "", "", ""));

	//测试获得本次中转单单号
	@Test
	public void testCreateTransShipmentListId() {
		assertTrue("".equals(trans.createTransShipmentListId()));
	}

}
