package businesslogic.test.logisticsbl;

import static org.junit.Assert.*;

import org.junit.Test;

import vo.OrderListVO;

public class SendPkgBLImplTest {

	@Test
	public void testCreateMoneyInformation() {
		MockOrder m1=new MockOrder(6.5);
		OrderListVO orderList=new OrderListVO
			("wjw", "仙林中心", "dss", "123", "123", 10, 10, "sd", null, null, 0.0, null);
		
		assertEquals (orderList,m1.getPrice());
	}

	@Test
	public void testCreateOrderList() {
		fail("Not yet implemented");
	}

}
