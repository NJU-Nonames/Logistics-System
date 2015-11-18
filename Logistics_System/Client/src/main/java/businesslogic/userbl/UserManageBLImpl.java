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
	private DataFactoryService dataFactory;//数据工厂

	//构造函数
	public UserManageBLImpl(){
		this.dataFactory=(DataFactoryService)RMIHelper.find("dataFactory");
	}

	
	public UserVO login(String admin, String password) {
		UserDataService service1 = null;
		//StaffDataService service2 = null;
		try {
			service1=dataFactory.getUserDataService();//远程方法调用
			//service2=dataFactory.getStaffDataService();
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        UserPO userpo=service1.findonAdmin(admin);
        //StaffVO staffvo=null;
        UserVO vo=null;
        if(userpo!=null && userpo.getPassword().compareTo(password)==0){
        	vo=new UserVO(userpo.getAdmin(), userpo.getPassword(), userpo.getPosition(), userpo.getId());
//    		StaffPO staffpo=service2.find(admin);
//        	staffvo = new StaffVO(staffpo.getName(), staffpo.getSex(), staffpo.getPostion(), staffpo.getIDNum(), staffpo.getWorkingtime(), staffpo.getPhoneNum(),staffpo.getWage(),staffpo.getAgencyName(),staffpo.getId());
        }
        return vo;
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