/**
 * 2015年10月23日
 *author:
 *description:成本管理
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.MoneyOutListVO;

/**
 * @author 谭期友
 *
 */
public interface CostManagementBLService {
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:新建付款单
	 * @param day付款日期
	 * @param name付款人
	 * @param c付款账号
	 * @param money付款金额
	 * @return 付款单
	 */
	public ResultMessage createMoneyOutlist(MoneyOutListVO moneyOut);
	/**
	 * 生成付款单单号
	 * @return
	 */
	public String createMoneyOutListId();
	
	public ArrayList<MoneyOutListVO> search(String start_day,String end_day);

}
