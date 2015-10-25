/**
 * 2015年10月23日
 *author:
 *description：收款单即业务员记录快递员收款信息
 * 包含（收款日期、收款金额、收款快递员、对应的所有快递订单条形码号。）
 *
 */
package vo;

import java.util.ArrayList;

/**
 * @author 谭期友
 * 王家玮 2015-10-24
 */
public class MoneyInListVO extends ListVO{
	/**
	 * 收款日期
	 */
	private String date;
	
	/**
	 * 收款金额
	 */
	private double moneySum;
	
	/**
	 * 快递员姓名
	 */
	private String CourierName;
	
	/**
	 *条形码
	 */
	private ArrayList<String> barcode;
	


	public MoneyInListVO(String date, double moneySum, String courierName,
			ArrayList<String> barcode) {
		super();
		this.date = date;
		this.moneySum = moneySum;
		CourierName = courierName;
		this.barcode = barcode;
	}

	public String getDate() {
		return date;
	}

	public double getMoneySum() {
		return moneySum;
	}

	public String getCourierName() {
		return CourierName;
	}

	public ArrayList<String> getBarcode() {
		return barcode;
	}
}
