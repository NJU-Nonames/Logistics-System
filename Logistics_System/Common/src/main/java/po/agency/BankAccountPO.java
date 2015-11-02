/**
 * 2015年10月22日
 *author:
 *description:
 */
package po.agency;

import java.io.Serializable;

/**
 * @author 谭期友
 *
 */
public class BankAccountPO implements Serializable{
	
	private String name;//账户名称
	private String number;//账户账号
	private double money;//账户余额
	
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getMoney() {
		return money;
	}

	public BankAccountPO(String name,String number, double money) {
		super();
		this.number=number;
		this.name = name;
		this.money = money;
	}

}
