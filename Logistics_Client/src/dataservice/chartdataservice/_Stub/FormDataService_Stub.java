package dataservice.chartdataservice._Stub;

import java.util.ArrayList;

import po.ListPO;
import po.MoneyInListPO;
import po.MoneyInformationListPO;
import po.MoneyOutListPO;
import dataservice.chartdataservice.FormDataService;

public class FormDataService_Stub implements FormDataService{
	public ArrayList<ListPO> getBusinessCircumstanceChart(String start_day, String end_day){
		ArrayList<ListPO> list=new ArrayList<ListPO>();
		list.add(new MoneyInListPO(end_day, 0, end_day, null));
		list.add(new MoneyOutListPO(end_day, 0, end_day, end_day, end_day));
		System.out.println("成功!");
		return list;
	}
	public ArrayList<MoneyInformationListPO> getCostandBenefitChart(String start_day, String end_day){
		ArrayList<MoneyInformationListPO> list=new ArrayList<MoneyInformationListPO>();
		list.add(new MoneyInformationListPO(end_day, 0, 0, 0));
		System.out.println("成功!");
		return list;
	}
}
