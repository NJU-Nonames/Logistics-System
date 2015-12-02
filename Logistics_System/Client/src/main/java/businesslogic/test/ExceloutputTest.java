package businesslogic.test;

import java.util.ArrayList;

import presentation.mainui.CurrentUser;
import businesslogic.chartbl.FormBLImpl;
import vo.MoneyInformationListVO;
import vo.MoneyItemVO;

public class ExceloutputTest {
	FormBLImpl formbl=new FormBLImpl();
	public static void main(String []args){
		ExceloutputTest t=new ExceloutputTest();
		//t.testCostandBenefitChart();
		t.testBusinessCircumstanceChart();	
	}
	public void testCostandBenefitChart(){
		ArrayList<MoneyInformationListVO> list=new ArrayList<MoneyInformationListVO>();
		list.add(new MoneyInformationListVO("2015-11-30", 20, 10, 10));
		list.add(new MoneyInformationListVO("2015-12-01", 30, 5, 25));
		formbl.exportCostandBenefitChart("2015-11-30", "2015-12-01", list, null);	
	}
	public void testBusinessCircumstanceChart(){
		ArrayList<MoneyItemVO>list=new ArrayList<MoneyItemVO>();
		list.add(new MoneyItemVO("付款单","2015-11-30","02500100001",10));
		list.add(new MoneyItemVO("收款单","2015-12-01","02500100002",13));
		formbl.exportBusinessCircumstanceChart("2015-11-30", "2015-12-01", list, null);
	}

}
