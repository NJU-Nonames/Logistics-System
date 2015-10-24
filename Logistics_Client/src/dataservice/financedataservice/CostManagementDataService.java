/**
 * 2015年10月23日
 *author:
 *description:成本管理
 */
package dataservice.financedataservice;

import po.MoneyOutListPO;


/**
 * @author 谭期友
 *
 */
public interface CostManagementDataService {
	/**
	 * 
	 * 新建付款单
	 */
	public boolean createMoneyOutlist(MoneyOutListPO moneyOut);

}
