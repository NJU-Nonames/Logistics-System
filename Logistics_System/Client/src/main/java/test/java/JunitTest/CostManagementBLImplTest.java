package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import vo.MoneyItemVO;
import businesslogic.financebl.CostManagementBLImpl;
import businesslogicservice.financeblservice.CostManagementBLService;

public class CostManagementBLImplTest {
	CostManagementBLService costmanage=new CostManagementBLImpl(new CurrentUser("欧阳", "快递中心", "000000", "ouyang"));
    //测试获得两个日期之间的付款单
	@Test
	public void testSearch() {
		//两个日期之间的付款单数目
        assertTrue(costmanage.search("", "").size()==5);
        assertTrue(costmanage.search("", "").size()==5);
		
	}
    //测试获得本次付款单单号
	@Test
	public void testCreateMoneyOutListId() {
		assertTrue(costmanage.createMoneyOutListId().equals(""));
	}

}
