package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.RepertoryManageBLImpl;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;

public class RepertoryManageBLImplTest {
	RepertoryManageBLService repertoryManage=new RepertoryManageBLImpl(new CurrentUser("", "", "", ""));
    //测试获得本次的入库单号
	@Test
	public void testCreateRepertoryInId() {
		assertTrue("".equals(repertoryManage.createRepertoryInId()));
	}
    //测试获得本次的入库单号
	@Test
	public void testCreateRepertoryOutId() {
		assertTrue("".equals(repertoryManage.createRepertoryOutId()));
	}

}
