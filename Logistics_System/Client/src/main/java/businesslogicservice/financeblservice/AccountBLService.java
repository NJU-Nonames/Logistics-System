/**
 * 2015年10月22日
 *author:谭期友
 *description:账户管理
 */
package businesslogicservice.financeblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.BankAccountVO;


/**
 * @author 
 *
 */
public interface AccountBLService {
	

	
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:增加账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 账户
	 */
	public ResultMessage createCount(BankAccountVO countVo);
	
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:删除账户
	 * @param name
	 * @return 操作是否成功
	 */
	public ResultMessage removeCount(String name);
	
	/**
	 * 账户内的金额不允许进行修改！！！！
	 * 前置条件：财务人员已经登陆
	 * 后置条件:更改账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 操作是否成功
	 */
	public ResultMessage updateCount(BankAccountVO countVo);
	
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:查询账户
	 * @param name
	 * @return 账户
	 */
	public BankAccountVO searchCount(String keyword);
	
	/**
	 * 显示所有账户信息
	 * @return
	 */
	public ArrayList<BankAccountVO> show();
	
}
