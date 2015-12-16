package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.DeliverAndReceiveBLImpl;
import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;

public class DeliverAndReceiveBLImplTest {
    //测试获得本次营业厅到达单单号
	DeliverAndReceiveBLService deliverAndReceive=new DeliverAndReceiveBLImpl(new CurrentUser("","","",""));
	@Test
	public void testCreateHallArrivalListId() {
		assertTrue(deliverAndReceive.createHallArrivalListId().equals(""));
	}
    //测试获得本次派件单单号
	@Test
	public void testCreateDeliveringListId() {
		assertTrue(deliverAndReceive.createDeliveringListId().equals(""));
	}
    //测试根据中转单来获得本批货物信息
	@Test
	public void testGetLoadList() {
		assertTrue(deliverAndReceive.getLoadList("").barcodes.size()==5);
	}

}
