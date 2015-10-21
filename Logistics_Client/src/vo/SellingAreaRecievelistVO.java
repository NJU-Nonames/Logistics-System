/**
 *2015年10月21日
 *author:tdy
 *discirption:营业厅的到达单的vo实体类 
 */
package vo;
public interface SellingAreaRecievelistVO {
	/**
	 * 前置条件：
	 * 后置条件：
	 * @param 	营业厅装车单或中转中心中转单的编号
	 * @return	营业厅装车单或中转中心中转单的vo实体
	 */
	public DeparturelistVO findDeparturelist(String departurelistId);
}
