package vo;

public class MoneyItemVO {
//这个vo是为了将收款单和付款单综合的vo
//根据此vo生成MoneyInformationVO
	
	/**
	 * 条目:收款单or付款单
	 */
	private String clause;
	/**
	 * 单据日期
	 */
	private String date;
	/**
	 * 单据编号
	 */
	private String id;
	/**
	 * 单据金额
	 */
	private double money;
	/**
	 * 
	 * @param clause
	 * @param date
	 * @param id
	 * @param money
	 */
	
	public MoneyItemVO(String clause,String date,String id,double money){
		this.clause =clause;
		this.date=date;
		this.id=id;
		this.money=money;
	}
	public String getClause() {
		return clause;
	}
	public String getDate() {
		return date;
	}
	public String getId() {
		return id;
	}
	public double getMoney() {
		return money;
	}
	
}
