/**
 * 2015年10月23日
 *author:
 *description:
 */
package dataservice.financedataservice;

import java.util.ArrayList;

import po.agency.BankAccountPO;

/**
 * @author 谭期友
 *
 */
public interface AccountDataService {
	/**
	 * 添加账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 账户
	 */
	public boolean createCount(BankAccountPO countpo);
	/**
	 * 删除账户
	 * @param name
	 * @return 操作是否成功
	 */
	public boolean removeCount(String name);
	/**
	 * 更新账户
	 * @param name
	 * @param password
	 * @param money
	 * @return 操作是否成功
	 */
	public boolean updataCount(BankAccountPO countpo);
	/**
	 * 查询账户
	 * @param name
	 * @return 账户
	 */
	public BankAccountPO searchCount(String keyword);
	
	/**
	 * 显示所有账户信息
	 * @return
	 */
	public ArrayList<BankAccountPO> show();
}
