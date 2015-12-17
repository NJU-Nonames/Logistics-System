package test.java.JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import vo.MoneyInformationListVO;
import businesslogic.chartbl.FormBLImpl;
import businesslogicservice.chartblservice.FormBLService;

public class FormBLImplTest {
	FormBLService form=new FormBLImpl(new CurrentUser("欧阳", "快递中心", "000000", "ouyang"));
    //测试获得两个日期之间的成本收益表
	@Test
	public void testGetCostandBenefitChart() {
		ArrayList<MoneyInformationListVO> moneylist1=form.getCostandBenefitChart("", "");
		ArrayList<MoneyInformationListVO> moneylist2=form.getCostandBenefitChart("", "");
		//成本收益表数目
		assertTrue(moneylist1.size()-1==5);
		//成本收益表数目
		assertTrue(moneylist2.size()-1==5);
		//计算结果
		double in=0,out=0,profit=0;
		for(int i=0;i<moneylist1.size()-1;i++){
			in+=moneylist1.get(i).getMoneyIn();
			out+=moneylist1.get(i).getMoneyOut();
			profit+=moneylist1.get(i).getProfit();
		}
		assertEquals(in, moneylist1.get(moneylist1.size()-1));
		assertEquals(out, moneylist1.get(moneylist1.size()-1));
		assertEquals(profit, moneylist1.get(moneylist1.size()-1));
	}
    //测试获得两个日期之间的经营情况表
	@Test
	public void testGetBusinessCircumstanceChart() {
		assertTrue(form.getBusinessCircumstanceChart("", "").size()==5);
	}
}
