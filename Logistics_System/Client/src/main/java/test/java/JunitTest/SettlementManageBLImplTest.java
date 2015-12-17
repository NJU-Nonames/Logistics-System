package test.java.JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import vo.MoneyInListVO;
import businesslogic.financebl.SettlementManageBLImpl;
import businesslogicservice.financeblservice.SettlementManageBLService;

public class SettlementManageBLImplTest {
	SettlementManageBLService settle=new SettlementManageBLImpl(new CurrentUser("", "", "", ""));
    //测试查找两个日期之间的某营业厅的收款单
	@Test
	public void testSearchbyhall() {
		ArrayList<MoneyInListVO> moneyin=settle.searchbyhall("", "", "");
		//收款单数目
		assertTrue(moneyin.size()==5);
		//总金额
		double total=0;
		for(MoneyInListVO vo:moneyin)
			total+=vo.getMoneySum();
		assertTrue(total==5);
	}
    //测试获得本次收款单单号
	@Test
	public void testCreateMoneyInListId() {
		assertTrue("".equals(settle.createMoneyInListId()));
	}

}
