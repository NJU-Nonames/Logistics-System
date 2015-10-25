/**
 * 2015年10月22日
 *author:谭期友
 *description:账户类
 */
package vo;

public class BankAccountVO {
	
	/**
	 * 用户名
	 */
	private String name;
	/**
	 * 账户账号
	 */
	private String number;
	/**
	 * 用户余额
	 */
	private double money;
	
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
	public void setMoney(double money) {
		this.money = money;
	}
	public BankAccountVO(String name,String number, double money) {
		super();
		this.number=number;
		this.name = name;
		this.money = money;
	}

}
