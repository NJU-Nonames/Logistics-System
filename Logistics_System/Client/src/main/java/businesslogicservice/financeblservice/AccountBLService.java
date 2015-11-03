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
	 * 账户登录 仅拥有最高权限的财务人员才能进行账户管理操作
	 * @param admin
	 * @param password
	 * @return
	 */
	public boolean login(String admin,String password);
	
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
	public ResultMessage updadaCount(BankAccountVO countVo);
	
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
