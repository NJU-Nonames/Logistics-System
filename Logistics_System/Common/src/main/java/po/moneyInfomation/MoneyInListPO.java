/**
 * 2015年10月23日
 *author:
 *description：收款单
 */
package po.moneyInfomation;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.ListPO;

/**
 * @author 谭期友
 *
 */
public class MoneyInListPO extends ListPO implements Serializable{
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
	


	public MoneyInListPO(String date, double moneySum, String courierName,
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
