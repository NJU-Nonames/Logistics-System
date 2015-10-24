/**
 * 2015年10月22日
 *author:谭期友
 *description:账户类
 */
package vo;

public class BankAccountVO {
	
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
