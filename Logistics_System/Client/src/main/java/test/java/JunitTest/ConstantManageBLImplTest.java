package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.informationchangebl.ConstantManageBLImpl;
import businesslogicservice.informationchangeblservice.ConstantManageBLService;

public class ConstantManageBLImplTest {
	ConstantManageBLService constant=new ConstantManageBLImpl(new CurrentUser("", "", "", ""));
    //测试获得距离常量表
	@Test
	public void testShowDistanceChart() {
		String[][]chart=constant.showDistanceChart().getDistanceChart();
		assertTrue(Integer.parseInt(chart[1][1])==0);
		assertTrue(Integer.parseInt(chart[1][2])==999);
		assertTrue(chart[0][1].equals(""));
	}
    //测试获得价格常量信息
	@Test
	public void testShowPriceChart() {
		assertTrue(constant.showPriceChart().getEconomic()==0);
		assertTrue(constant.showPriceChart().getStandard()==0);
		assertTrue(constant.showPriceChart().getExpress()==0);
		assertTrue(constant.showPriceChart().getAirplane_kilo_t()==0);
		assertTrue(constant.showPriceChart().getTruck_kilo_t()==0);
		assertTrue(constant.showPriceChart().getTrain_kilo_t()==0);
	}
}
