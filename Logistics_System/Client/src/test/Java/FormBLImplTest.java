package test.java.JunitTest;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import vo.MoneyInformationListVO;
import businesslogic.chartbl.FormBLImpl;
import businesslogicservice.chartblservice.FormBLService;
//completed
public class FormBLImplTest {
	FormBLService form=new FormBLImpl(new CurrentUser("欧阳", "快递中心", "000000", "ouyang"));
    //测试获得两个日期之间的成本收益表
	@Test
	public void testGetCostandBenefitChart() {
		ArrayList<MoneyInformationListVO> moneylist1=form.getCostandBenefitChart("2015-11-29", "2015-12-1");
		ArrayList<MoneyInformationListVO> moneylist2=form.getCostandBenefitChart("2015-11-29", "2015-12-6");
		//成本收益表数目
		assertTrue(moneylist1.size()-1==2);
		//成本收益表数目
		assertTrue(moneylist2.size()-1==3);
		//计算结果
		double in=0,out=0,profit=0;
		for(int i=0;i<moneylist1.size()-1;i++){
			in+=moneylist1.get(i).getMoneyIn();
			out+=moneylist1.get(i).getMoneyOut();
			profit+=moneylist1.get(i).getProfit();
		}
		assertTrue(in== moneylist1.get(moneylist1.size()-1).getMoneyIn());
		assertTrue(out== moneylist1.get(moneylist1.size()-1).getMoneyOut());
		assertTrue(profit== moneylist1.get(moneylist1.size()-1).getProfit());
	}
    //测试获得两个日期之间的经营情况表
	@Test
	public void testGetBusinessCircumstanceChart() {
		assertTrue(form.getBusinessCircumstanceChart("2015-11-29", "2015-12-6").size()==5);
	}
}
