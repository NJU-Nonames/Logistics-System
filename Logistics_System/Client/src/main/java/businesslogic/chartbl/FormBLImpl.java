package businesslogic.chartbl;

import java.util.ArrayList;

import utility.ChartType;
import vo.ListVO;
import vo.MoneyInformationListVO;
import businesslogicservice.chartblservice.FormBLService;

public class FormBLImpl implements FormBLService{

	MoneyInformation moneyList;
	
	public FormBLImpl(){
		moneyList=new MoneyInformation();
	}
	
	public ArrayList<MoneyInformationListVO> getCostandBenefitChart(
			String start_day, String end_day) {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<? super ListVO> getBusinessCircumstanceChart(
			String start_day, String end_day) {
		// TODO Auto-generated method stub
		return null;
	}

	public void exportChart(String strat_day, String end_day,
			ChartType chartType, String path) {
		// TODO Auto-generated method stub
		
	}

}
