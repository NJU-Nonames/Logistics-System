package businesslogic.chartbl;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import utility.ChartType;
import vo.ListVO;
import vo.MoneyInListVO;
import vo.MoneyInformationListVO;
import vo.MoneyItemVO;
import vo.MoneyOutListVO;
import businesslogic.financebl.CostManagementBLImpl;
import businesslogic.financebl.SettlementManageBLImpl;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.chartblservice.FormBLService;
import businesslogicservice.financeblservice.CostManagementBLService;
import businesslogicservice.financeblservice.SettlementManageBLService;

public class FormBLImpl implements FormBLService{
	CostManagementBLService service1=null;
	SettlementManageBLService service2=null;
	
	
	public FormBLImpl(){
		service1=(CostManagementBLService)RMIHelper.find("CostManagementBLService");
		service2=(SettlementManageBLService)RMIHelper.find("SettlementManageBLService");
	}
	
	public ArrayList<MoneyInformationListVO> getCostandBenefitChart(
			String start_day, String end_day) {
		// TODO Auto-generated method stub
		ArrayList<MoneyItemVO> moneyitemvo=getBusinessCircumstanceChart(start_day, end_day);
		ArrayList<MoneyInformationListVO> list=new ArrayList<MoneyInformationListVO>();
		if(moneyitemvo==null)
			return null;
		String[] array11=start_day.split(" ");
		String[] array1=array11[0].split("-");
		String[] array21=end_day.split(" ");
		String[] array2=array21[0].split("-");
		int[] intarray1=new int[3];
		int[] intarray2=new int[3];
		for(int i=0;i<3;i++){
			intarray1[i]=Integer.parseInt(array1[i]);
			intarray2[i]=Integer.parseInt(array2[i]);	
		}
		Calendar start=Calendar.getInstance();
		start.set(intarray1[0], intarray1[1],intarray1[2]);
		long startTime=start.getTimeInMillis();
		Calendar end=Calendar.getInstance();
		end.set(intarray2[0], intarray2[1],intarray2[2]);
		long endTime=end.getTimeInMillis();
		long dayTime=24*60*60l;
		long time=startTime;
		while(time<=endTime){
			Date day=new Date(time);
			DateFormat format=new SimpleDateFormat("yyyy-M-d");
			String currentTime=(String)format.format(day);
			double inMoney=0;
			double outMoney=0;
			for(MoneyItemVO vo:moneyitemvo){
				if(vo.getDate().equals(currentTime)){
					if(vo.getClause().equals("付款单"))
						inMoney+=vo.getMoney();
					else
						outMoney+=vo.getMoney();
				}
				list.add(new MoneyInformationListVO(vo.getDate(),inMoney,outMoney,inMoney-outMoney));
			}
			time+=dayTime;
		}	
		return list;
	}

	public ArrayList<MoneyItemVO> getBusinessCircumstanceChart(
			String start_day, String end_day) {
		// TODO Auto-generated method stub
	   ArrayList<MoneyOutListVO> list1=service1.search(start_day, end_day);
	   ArrayList<MoneyInListVO> list2=service2.search(start_day, end_day);
	   ArrayList<MoneyItemVO> list=new ArrayList<MoneyItemVO>();
	   if(list1!=null)
	   for(MoneyOutListVO vo:list1){
		   list.add(new MoneyItemVO("付款单",vo.getDate(),vo.getId(),vo.getMoney()));
	   }
	   if(list2!=null)
	   for(MoneyInListVO vo:list2){
		   list.add(new MoneyItemVO("收款单",vo.getDate(),vo.getId(),vo.getMoneySum()));
	   }
			   return list;
	}

	public void exportChart(String strat_day, String end_day,
			ChartType chartType, String path) {
		// TODO Auto-generated method stub
		
	}

}
