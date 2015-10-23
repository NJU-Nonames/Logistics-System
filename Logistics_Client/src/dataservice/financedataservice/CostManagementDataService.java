/**
 * 2015年10月23日
 *author:
 *description:成本管理
 */
package dataservice.financedataservice;

import po.CountPO;
import po.PaylistPO;

/**
 * @author 谭期友
 *
 */
public interface CostManagementDataService {
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:新建付款单
	 * @param day付款日期
	 * @param name付款人
	 * @param c付款账号
	 * @param money付款金额
	 * @return 付款单
	 */
	public PaylistPO createPaylist(String day, String name, CountPO c, double money);

}
