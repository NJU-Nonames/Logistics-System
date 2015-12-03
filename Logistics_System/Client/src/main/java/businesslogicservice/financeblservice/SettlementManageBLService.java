/**
 * 2015年10月22日
 *author:
 *description:结算管理
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.MoneyInListVO;


/**
 * @author 谭期友
 *
 */
public interface SettlementManageBLService {
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:系统返回付款单的集合
	 * @param start_day
	 * @param end_day
	 * @return 收款单的集合
	 */
	public ArrayList<MoneyInListVO> searchbyhall(String start_day, String end_day,String hall_id);
	public ArrayList<MoneyInListVO> search(String start_day,String end_day);
	public ResultMessage createMoneyInList(MoneyInListVO moneyin);
	/**
	 * 生成收款单单号
	 * @return
	 */
	public String createMoneyInListId();

}
