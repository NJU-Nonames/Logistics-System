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
	 * 快递员工号
	 */
	private String staffId;
	
	/**
	 *条形码
	 */
	private ArrayList<String> barcode;
	


	public MoneyInListPO(String date, double moneySum, String staffId,
			ArrayList<String> barcode) {
		super();
		this.date = date;
		this.moneySum = moneySum;
		this.staffId=staffId;
		this.barcode = barcode;
	}

	public String getDate() {
		return date;
	}

	public double getMoneySum() {
		return moneySum;
	}

	public String getStaffId() {
		return staffId;
	}

	public ArrayList<String> getBarcode() {
		return barcode;
	}
	

}
