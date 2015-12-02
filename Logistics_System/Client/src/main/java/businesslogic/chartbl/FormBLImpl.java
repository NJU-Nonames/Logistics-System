package businesslogic.chartbl;

import java.io.FileOutputStream;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import presentation.mainui.CurrentUser;
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
	CurrentUser user=null;
	public FormBLImpl(){	
	}
	public FormBLImpl(CurrentUser currentuser){
		service1=(CostManagementBLService)RMIHelper.find("CostManagementBLService");
		service2=(SettlementManageBLService)RMIHelper.find("SettlementManageBLService");
		user=currentuser;
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

	public void exportCostandBenefitChart(String start_day,String end_day,ArrayList<MoneyInformationListVO> list,String path) {
		// TODO 自动生成的方法存根
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("成本收益表");
		HSSFRow row=sheet.createRow(0);
		HSSFCellStyle style=wb.createCellStyle();
		sheet.setDefaultColumnWidth(12);
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("成本收益日期");
		cell.setCellStyle(style);
		cell=row.createCell(1);
		cell.setCellValue("当日收入");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("当日支出");
		cell.setCellStyle(style);
		cell=row.createCell(3);
		cell.setCellValue("当日利润");
		cell.setCellStyle(style);
		double moneyin=0;
		double moneyout=0;
		double profit=0;
		for(int i=0;i<list.size();i++){
			row=sheet.createRow(i+1);
			MoneyInformationListVO money=list.get(i);
			cell=row.createCell(0);
			cell.setCellValue(money.getTime());
			cell.setCellStyle(style);
			moneyin+=money.getMoneyIn();
			moneyout+=money.getMoneyOut();
			profit+=money.getProfit();
			row.createCell(1).setCellValue((double)money.getMoneyIn());
			row.createCell(2).setCellValue((double)money.getMoneyOut());
			row.createCell(3).setCellValue((double)money.getProfit());
		}
		row=sheet.createRow(list.size()+1);
		cell=row.createCell(0);
		cell.setCellValue("总计");
		cell.setCellStyle(style);
		row.createCell(1).setCellValue((double)moneyin);
		row.createCell(2).setCellValue((double)moneyout);
		row.createCell(3).setCellValue((double)profit);
		try{
			FileOutputStream fout=new FileOutputStream("D:/"+start_day+"至"+end_day+"日成本收益表.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}

	public void exportBusinessCircumstanceChart(String start_day,String end_day,ArrayList<MoneyItemVO> list,String path) {
		// TODO 自动生成的方法存根
		HSSFWorkbook wb=new HSSFWorkbook();
		HSSFSheet sheet=wb.createSheet("经营情况表");
		HSSFRow row=sheet.createRow(0);
		HSSFCellStyle style=wb.createCellStyle();
		sheet.setDefaultColumnWidth(12);
		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
		HSSFCell cell=row.createCell(0);
		cell.setCellValue("日期");
		cell.setCellStyle(style);
		cell=row.createCell(1);
		cell.setCellValue("编号");
		cell.setCellStyle(style);
		cell=row.createCell(2);
		cell.setCellValue("金额");
		cell.setCellStyle(style);
		cell=row.createCell(3);
		cell.setCellValue("条目");
		cell.setCellStyle(style);
		for(int i=0;i<list.size();i++){
			row=sheet.createRow(i+1);
			MoneyItemVO money=list.get(i);
			cell=row.createCell(0);
			cell.setCellValue(money.getDate());
			cell.setCellStyle(style);
			cell=row.createCell(1);
			cell.setCellValue(money.getId());
			cell.setCellStyle(style);
			row.createCell(2).setCellValue((double)money.getMoney());
			cell=row.createCell(3);
			cell.setCellValue(money.getClause());
			cell.setCellStyle(style);
		}
		try{
			FileOutputStream fout=new FileOutputStream("D:/"+start_day+"至"+end_day+"日经营情况表.xls");
			wb.write(fout);
			fout.close();
			wb.close();
		}catch(Exception e){
			e.printStackTrace();
		}	
	}
}
