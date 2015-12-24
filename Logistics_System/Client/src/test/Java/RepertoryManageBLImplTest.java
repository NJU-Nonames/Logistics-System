package Java;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.RepertoryManageBLImpl;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;
//completed
public class RepertoryManageBLImplTest {
	RepertoryManageBLService repertoryManage=new RepertoryManageBLImpl(new CurrentUser("小亮", "南京市中转中心", "025000", "xiaoliang"));
    //测试获得本次的入库单号
	@Test
	public void testCreateRepertoryInId() {
		assertTrue("02500000002".equals(repertoryManage.createRepertoryInId()));
	}
    //测试获得本次的入库单号
	@Test
	public void testCreateRepertoryOutId() {
		assertTrue("02500000001".equals(repertoryManage.createRepertoryOutId()));
	}

}
