package businesslogic.test.chartbl;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import vo.MoneyInformationListVO;

public class FormBLImplTest {

	@Test
	public void testGetCostandBenefitChart() {
		MockMoneyInformation m1=new MockMoneyInformation("收款单","2015-11-16","000000",100);
		ArrayList<MockMoneyInformation> list1=new ArrayList<MockMoneyInformation>();
		list1.add(new MockMoneyInformation("收款单","2015-11-16","000000",100));
		list1.add(new MockMoneyInformation("付款单","2015-11-16","000001",50));
		list1.add(new MockMoneyInformation("收款单","2015-11-15","000002",100));
		ArrayList<MoneyInformationListVO> list2=new ArrayList<MoneyInformationListVO>();
		list2.add(new MoneyInformationListVO("2015-11-16",100,50,50));
		ArrayList<MoneyInformationListVO> list3=new ArrayList<MoneyInformationListVO>();
		list3.add(m1.calculate("2015-11-16", list1));
		assertEquals(list2,list3);
	}

}
