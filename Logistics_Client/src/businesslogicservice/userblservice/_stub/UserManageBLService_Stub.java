/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.userblservice._stub;

import java.util.ArrayList;

import vo.UserVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.userblservice.UserManageBLService;

public class UserManageBLService_Stub implements UserManageBLService{
	@Override
	public ResultMessage login(String admin, String password) {
		// TODO 自动生成的方法存根
		System.out.println("登陆成功");
		return new ResultMessage(true, "登陆成功");
	}

	@Override
	public ResultMessage addUser(UserVO user) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功");
	}


	@Override
	public ResultMessage removeUser(String admin) {
		System.out.println("删除成功");
		return new ResultMessage(true, "删除成功");
	}


	@Override
	public ResultMessage updataUser(UserVO user) {
		System.out.println("更新成功");
		return new ResultMessage(true, "更新成功");
	}


	@Override
	public ArrayList<UserVO> showAll() {
		// TODO 自动生成的方法存根
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(new UserVO(null, null, null));
		System.out.println("显示成功");
		return list;
		
	}


	@Override
	public UserVO findonAdmin(String admin) {
		// TODO 自动生成的方法存根
		System.out.println("寻找成功");
		return new UserVO(null, null, null);
	}


	@Override
	public UserVO findonId(String id) {
		System.out.println("寻找成功");
		return new UserVO(null, null, null);
	}

}
