package vo;

import java.awt.List;

/**
 * 成本收益信息
 * @author 这菜咸了
 *
 */
public class MoneyInfomationListVO extends List{
	
	private String time;//成本收益日期
	private double moneyIn;//当日收入
	private double moneyOut;//当日支出
	private double profit;//当日利润
	
	public MoneyInfomationListVO(String time, double moneyIn, double moneyOut,double profit)
	 {
		super();
		this.time = time;
		this.moneyIn = moneyIn;
		this.moneyOut = moneyOut;
		this.profit=profit;
	}
	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	public double getMoneyIn() {
		return moneyIn;
	}

	public void setMoneyIn(double moneyIn) {
		this.moneyIn = moneyIn;
	}

	public double getMoneyOut() {
		return moneyOut;
	}

	public void setMoneyOut(double moneyOut) {
		this.moneyOut = moneyOut;
	}

	public double getProfit() {
		return profit;
	}

	public void setProfit(double profit) {
		this.profit = profit;
	}
	

}
