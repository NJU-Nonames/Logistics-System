package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.DeliverAndReceiveBLImpl;
import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;
//completed
public class DeliverAndReceiveBLImplTest {
    //测试获得本次营业厅到达单单号
	DeliverAndReceiveBLService deliverAndReceive=new DeliverAndReceiveBLImpl(new CurrentUser("亮剑","北京市朝阳营业厅","010001","liangjian"));
	@Test
	public void testCreateHallArrivalListId() {
		assertTrue(deliverAndReceive.createHallArrivalListId().equals("01000100002"));
	}
    //测试获得本次派件单单号
	@Test
	public void testCreateDeliveringListId() {
		assertTrue(deliverAndReceive.createDeliveringListId().equals("01000100003"));
	}
    //测试根据中转单来获得本批货物信息
	@Test
	public void testGetLoadList() {
		assertTrue(deliverAndReceive.getLoadList("0100002015120700002").barcodes.size()==2);
	}

}
