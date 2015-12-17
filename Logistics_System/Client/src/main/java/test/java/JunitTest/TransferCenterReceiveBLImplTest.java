package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.TransferCenterReceiveBLImpl;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;

public class TransferCenterReceiveBLImplTest {
	TransferCenterReceiveBLService trans=new TransferCenterReceiveBLImpl(new CurrentUser("", "", "", ""));

    //测试根据装车单号来获得本批货物信息
	@Test
	public void testGetLoadList() {
		assertTrue(trans.getLoadList("").barcodes.size()==5);
	}
    //测试根据上一个中转中心中转单号来获得本批货物信息
	@Test
	public void testGetTransShipmentList() {
		assertTrue(trans.getTransShipmentList("").barcodes.size()==5);
	}
    //测试获得本次中转中心到达单单号
	@Test
	public void testCreateTransArrivalListId() {
		assertTrue("".equals(trans.createTransArrivalListId()));
	}

}
