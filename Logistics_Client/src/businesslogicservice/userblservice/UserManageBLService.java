/**
 * 2015年10月23日
 *author:tqy
 *description:用户 管理
 */
package businesslogicservice.userblservice;

import vo.UserVO;

public interface UserManageBLService {
	/**雇佣新员工
	 * 前置条件：管理员已经登陆
	 * 后置条件:系统增加员工
	 * @param 用户名，姓名，密码，职位
	 * @return	新员工信息
	 */
	public UserVO addUser(String admin, String name, String password, String position);
	/**员工离职
	 * 前置条件：管理员已经登陆
	 * 后置条件:系统删除员工
	 * @param 用户名
	 */
	public void removeUser(String admin);
	/**更改员工职位
	 * 前置条件：管理员已经登陆
	 * 后置条件:系统更改员工职位
	 * @param 用户名，职位
	 */
	public void changePosition(String admin, String position);
	/**更改员工密码
	 * 前置条件：管理员已经登陆
	 * 后置条件:系统更改员工密码
	 * @param 用户名，密码
	 */
	public void changePassword(String admin, String password);
	/**取消管理任务
	 * 前置条件：	管理员已经登陆
	 * 后置条件：	返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelManage();
}
