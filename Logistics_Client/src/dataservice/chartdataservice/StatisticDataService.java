/**
 * 2015年10月23日
 *author:
 *description:统计报表
 */
package dataservice.chartdataservice;

import java.util.ArrayList;

import po.ListPO;


/**
 * @author 谭期友
 *
 */
public interface StatisticDataService {
	/**
	 * 前置条件：财务人员或总经理已经登陆
	 * 后置条件:返回单据
	 * @param start_day
	 * @param end_day
	 * @return 只能是InlistPO和GetlistPO的集合
	 */
	public ArrayList<ListPO> look(String start_day, String end_day);
}
