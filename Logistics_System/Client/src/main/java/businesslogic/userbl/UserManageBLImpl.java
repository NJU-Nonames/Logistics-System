/**
 * 2015年11月13日
 *author:
 *description:
 */
package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.StaffPO;
import po.system.UserPO;
import dataservice.DataFactoryService;
import dataservice.agency.StaffDataService;
import dataservice.system.UserDataService;
import utility.ResultMessage;
import utility.UserType;
import vo.StaffVO;
import vo.UserVO;
import businesslogic.chartbl.SystemLogBLImpl;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.userblservice.UserManageBLService;

/**
 * @author 谭期友
 *
 */
public class UserManageBLImpl implements UserManageBLService{
	UserDataService userDataService=null;
	
	//构造函数
	public UserManageBLImpl(){
		this.userDataService=(UserDataService)RMIHelper.find("UserDataService");
	}

	
	public UserVO login(String admin, String password) {
		
        return null;
	}

	public ResultMessage addUser(UserVO user) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	public ResultMessage removeUser(String admin) {
		// TODO 自动生成的方法存根
		return null;
	}


	public ResultMessage updateUser(UserVO user) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	public ArrayList<UserVO> showAll() {
		// TODO 自动生成的方法存根
		return null;
	}

	
	public UserVO findonAdmin(String admin) {
		// TODO 自动生成的方法存根
		return null;
	}

	
	public UserVO findonId(String id) {
		// TODO 自动生成的方法存根
		return null;
	}
	
}