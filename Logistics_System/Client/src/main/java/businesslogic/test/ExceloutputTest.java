package businesslogic.test;

import java.util.ArrayList;

import presentation.mainui.CurrentUser;
import businesslogic.chartbl.FormBLImpl;
import businesslogic.logisticsbl.RepertoryManageBLImpl;
import vo.MoneyInformationListVO;
import vo.MoneyItemVO;
import vo.RepertoryInformationVO;

public class ExceloutputTest {
	FormBLImpl formbl=new FormBLImpl();
	RepertoryManageBLImpl repertorybl=new RepertoryManageBLImpl();
	public static void main(String []args){
		ExceloutputTest t=new ExceloutputTest();
		t.testCostandBenefitChart();
		t.testBusinessCircumstanceChart();	
		t.testRepertoryInformation();
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
	public void testRepertoryInformation(){
		ArrayList<RepertoryInformationVO> list=new ArrayList<RepertoryInformationVO>();
		list.add(new RepertoryInformationVO("025000", "1", "1", "1", "1", "2015-12-03 10:00:00", "北京市", "025001201512030925"));
		list.add(new RepertoryInformationVO("025000", "2", "1", "1", "1", "2015-12-03 10:00:00", "北京市", "025001201512030926"));
		list.add(new RepertoryInformationVO("025000", "1", "2", "1", "1", "2015-12-03 10:00:00", "北京市", "025001201512030927"));
		list.add(new RepertoryInformationVO("025000", "1", "1", "2", "1", "2015-12-03 10:00:00", "北京市", "025001201512030928"));
		list.add(new RepertoryInformationVO("025000", "1", "1", "1", "2", "2015-12-03 10:00:00", "北京市", "025001201512030929"));
		list.add(new RepertoryInformationVO("025000", "2", "2", "1", "1", "2015-12-03 10:00:00", "北京市", "025001201512030930"));
		list.add(new RepertoryInformationVO("025000", "1", "2", "2", "1", "2015-12-03 10:00:00", "北京市", "025001201512030931"));
		list.add(new RepertoryInformationVO("025000", "1", "1", "2", "2", "2015-12-03 10:00:00", "北京市", "025001201512030932"));
		repertorybl.exportRepertoryInformation("南京市中转中心仓库", "2015-12-03 10:00:30", list, null);
	}

}
