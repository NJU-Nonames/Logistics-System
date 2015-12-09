/**
 * 2015年10月23日
 *author:
 *description：收款单
 */
package po.moneyInfomation;

import java.io.Serializable;
import java.util.ArrayList;

import po.list.ListPO;
import utility.CheckType;

/**
 * @author 谭期友
 *
 */
public class MoneyInListPO extends ListPO implements Serializable{
	/**
	 * 单号
	 */
	private String id;
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
	/**
	 * 银行账号
	 */
	private String accountNum;




	public MoneyInListPO(String id,String date, double moneySum, String staffId,
			ArrayList<String> barcode,String accountNum,CheckType type) {
		super();
		this.id=id;
		this.date = date;
		this.moneySum = moneySum;
		this.staffId=staffId;
		this.barcode = barcode;
		this.setCheckType(type);
		this.accountNum=accountNum;
	}
    public String getId(){
	    return id;
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
	public String getAccountNum(){
		return accountNum;
	}
}
