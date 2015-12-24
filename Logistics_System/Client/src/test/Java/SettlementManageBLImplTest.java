package test.java.JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import vo.MoneyInListVO;
import businesslogic.financebl.SettlementManageBLImpl;
import businesslogicservice.financeblservice.SettlementManageBLService;
//completed
public class SettlementManageBLImplTest {
	SettlementManageBLService settle=new SettlementManageBLImpl(new CurrentUser("李四", "南京市鼓楼营业厅", "025001", "lisi"));
    //测试查找两个日期之间的某营业厅的收款单
	@Test
	public void testSearchbyhall() {
		ArrayList<MoneyInListVO> moneyin=settle.searchbyhall("2015-11-1", "2015-12-27", "025001");
		//收款单数目
		assertTrue(moneyin.size()==1);
		//总金额
		double total=0;
		for(MoneyInListVO vo:moneyin)
			total+=vo.getMoneySum();
		assertTrue(total==300);
	}
    //测试获得本次收款单单号
	@Test
	public void testCreateMoneyInListId() {
		assertTrue("02500100002".equals(settle.createMoneyInListId()));
	}

}
