/**
 * 2015年10月22日
 *author:
 *description:结算管理
 */
package dataservice.financedataservice;

import java.util.ArrayList;

import po.moneyInfomation.MoneyOutListPO;


/**
 * @author 谭期友
 *
 */
public interface SettlementManageDataService {
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:系统返回付款单的集合
	 * @param start_day
	 * @param end_day
	 * @return 收款单的集合
	 */
	public ArrayList<MoneyOutListPO> search(String start_day, String end_day,String Hallid);

}
