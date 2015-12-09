/**
 * 2015年10月23日
 *author:
 *description：收款单即业务员记录快递员收款信息
 * 包含（收款日期、收款金额、收款快递员、对应的所有快递订单条形码号。）
 *
 */
package vo;

import java.util.ArrayList;

import utility.CheckType;

/**
 * @author 谭期友
 * 王家玮 2015-10-24
 */
public class MoneyInListVO extends ListVO{
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
	


	public MoneyInListVO(String id,String date, double moneySum, String staffId,
			ArrayList<String> barcode,String accountNum,CheckType type) {
		super();
		this.id=id;
		this.date = date;
		this.moneySum = moneySum;
		this.staffId = staffId;
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
