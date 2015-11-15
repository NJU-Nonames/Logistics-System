/**
 * 2015年11月13日
 *author:
 *description:
 */
package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.system.UserPO;
import dataservice.DataFactoryService;
import dataservice.system.UserDataService;
import utility.ResultMessage;
import utility.UserType;
import vo.UserVO;
import businesslogic.chartbl.SystemLogBLImpl;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.userblservice.UserManageBLService;

/**
 * @author 谭期友
 *
 */
public class UserManageBLImpl implements UserManageBLService{
	private DataFactoryService dataFactory;//数据工厂

	//构造函数
	public UserManageBLImpl(){
		this.dataFactory=(DataFactoryService)RMIHelper.find("dataFactory");
	}

	
	public UserVO login(String admin, String password) {
		UserDataService service = null;
        try {
			service=dataFactory.getUserDataService();//远程方法调用
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}

        UserVO uservo=null;
        UserPO userpo=service.findonAdmin(admin);
        if(userpo!=null && userpo.getPassword().compareTo(password)==0)
        	uservo = new UserVO(userpo.getAdmin(), userpo.getPassword(), userpo.getPosition(), userpo.getAuthority());
        return uservo;
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