package Java;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.TransferCenterReceiveBLImpl;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;
//completed
public class TransferCenterReceiveBLImplTest {
	TransferCenterReceiveBLService trans=new TransferCenterReceiveBLImpl(new CurrentUser("小芳", "南京市中转中心", "025000", "xiaofang"));

    //测试根据装车单号来获得本批货物信息
	@Test
	public void testGetLoadList() {
		assertTrue(trans.getLoadList("0250012015120700002").barcodes.size()==2);
	}
    //测试根据上一个中转中心中转单号来获得本批货物信息
	@Test
	public void testGetTransShipmentList() {
		assertTrue(trans.getTransShipmentList("025000201512070000001").barcodes.size()==2);
	}
    //测试获得本次中转中心到达单单号
	@Test
	public void testCreateTransArrivalListId() {
		assertTrue("02500000002".equals(trans.createTransArrivalListId()));
	}

}
