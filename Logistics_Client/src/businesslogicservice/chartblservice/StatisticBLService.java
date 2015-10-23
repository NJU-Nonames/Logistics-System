/**
 * 2015年10月23日
 *author:
 *description:统计报表
 */
package businesslogicservice.chartblservice;

import java.util.ArrayList;

import vo.ListVO;


/**
 * @author 谭期友
 *
 */
public interface StatisticBLService {
	/**
	 * 前置条件：财务人员或总经理已经登陆
	 * 后置条件:返回单据
	 * @param start_day
	 * @param end_day
	 * @return 只能是InlistVO和GetlistVO的集合
	 */
	public ArrayList<ListVO> look(String start_day, String end_day);
}
