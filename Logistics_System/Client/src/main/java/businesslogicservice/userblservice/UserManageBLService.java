/**
 * 2015年10月23日
 *author:tqy
 *description:用户 管理
 *2015-10-24 王家玮修改
 */
package businesslogicservice.userblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.UserVO;

public interface UserManageBLService {
	
	/**用户登录功能 
	 * @param admin
	 * @param password
	 * @return 登录者VO
	 */
	public UserVO login(String admin,String password);
	
	/**雇佣新员工
	 * @param 用户名，姓名，密码，职位
	 * @return	新员工信息
	 */
	public ResultMessage addUser(UserVO user);
	
	/**员工离职系统删除员工
	 * @param 用户名
	 */
	public ResultMessage removeUser(String admin);
	
	/**
	 * 更新员工信息
	 * @param user
	 * @return
	 */
	public ResultMessage updateUser(UserVO user);
	
	/**
	 * 显示所有可登陆员工的信息
	 * @return
	 */
	public ArrayList<UserVO> showAll();
	
	/**
	 * 查找员工信息
	 * @param admin
	 * @return
	 */
	public UserVO findonAdmin(String admin);
	
	/**
	 * 查找员工信息
	 * @param admin
	 * @return
	 */
	public UserVO findonId(String id);
	
	
}
