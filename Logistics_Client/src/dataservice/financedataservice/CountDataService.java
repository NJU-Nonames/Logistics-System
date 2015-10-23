/**
 * 2015年10月23日
 *author:
 *description:
 */
package dataservice.financedataservice;

import po.CountPO;

/**
 * @author 谭期友
 *
 */
public interface CountDataService {
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:增加账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 账户
	 */
	public CountPO createCount(String name, String password, double money);
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:删除账户
	 * @param name
	 * @return 操作是否成功
	 */
	public boolean removeCount(String name);
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:更改账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 操作是否成功
	 */
	public boolean changeCount(String name, String password, double money);
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:查询账户
	 * @param name
	 * @return 账户
	 */
	public CountPO searchCount(String name);
	/**
	 * 前置条件：财务人员已经登陆
	 * 后置条件:返回上一级
	 * @return 取消操作是否成功
	 */
	public boolean cancelCount();
}
