package businesslogic.test.chartbl;

import java.util.ArrayList;

import vo.MoneyInformationListVO;
import businesslogic.chartbl.MoneyInformation;

public class MockMoneyInformation extends MoneyInformation{
	String ordertype;
	String date;
	String number;
	double money;
	double inmoney;
	double outmoney;
	/**
	 * 
	 * @param ordertype 订单类型
	 * @param date 日期
	 * @param number 单号
	 * @param money 数额
	 */
public MockMoneyInformation(String ordertype,String date,String number,double money){
	this.ordertype=ordertype;
	this.date=date;
	this.number=number;
	this.money=money;
}
/**
 * 
 * @param date 日期
 * @param inmoney 总收入
 * @param outmoney 总支出
 * @param profit 利润
 */
public MockMoneyInformation(String date,double inmoney,double outmoney,double profit){
	this.date=date;
	this.inmoney=inmoney;
	this.outmoney=outmoney;
	profit=inmoney-outmoney;
}

public String getOrdertype() {
	return ordertype;
}

public String getDate() {
	return date;
}

public String getNumber() {
	return number;
}

public double getMoney() {
	return money;
}

public double getInmoney() {
	return inmoney;
}

public double getOutmoney() {
	return outmoney;
}

public MoneyInformationListVO calculate(String date,ArrayList <MockMoneyInformation> a){
	double intotal=0;
	double outtotal=0;
	for(MockMoneyInformation m:a)
		if(m.getDate().equals(date)){
			if(m.getOrdertype().equals("收款单"))
				intotal+=m.getInmoney();
			else
				outtotal+=m.getOutmoney();
		}
	return new MoneyInformationListVO(date,intotal,outtotal,intotal-outtotal);

}

}
