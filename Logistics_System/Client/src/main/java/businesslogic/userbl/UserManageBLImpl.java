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
	StaffDataService staffDataService=null;
	
	//构造函数
	public UserManageBLImpl(){
		this.userDataService=(UserDataService)RMIHelper.find("UserDataService");	
	}

	
	public StaffVO login(String admin, String password) {
		this.staffDataService=(StaffDataService)RMIHelper.find("StaffDataService");
		UserPO userpo=null;
		StaffPO staffpo=null;
		try{
			userpo=userDataService.findonAdmin(admin);
			if(userpo!=null && userpo.getPassword().compareTo(password)==0){
				staffpo=staffDataService.find(userpo.getId());
				StaffVO staffvo = new StaffVO(staffpo.getName(), staffpo.getSex(), staffpo.getPostion(), staffpo.getIDNum(), staffpo.getWorkingstarttime(), staffpo.getPhoneNum(),staffpo.getWage(),staffpo.getAgencyId(),staffpo.getId());
				return staffvo;
			}
		}catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
        return null;
	}
    /**
     * 方法中已经判断输入的账号或者工号是否存在
     * 传入数据层中的po可以直接添加
     */
	public ResultMessage addUser(UserVO user) {
		// TODO 自动生成的方法存根
		UserPO userpo=null;
		try{
			userpo=userDataService.findonAdmin(user.getAdmin());
			if(userpo!=null)
				return new ResultMessage(false,"存在一致的账号!");
			userpo=userDataService.findonId(user.getId());
			if(userpo!=null)
				return new ResultMessage(false,"存在一致的工号!");
			 userpo=new UserPO(user.getAdmin(),user.getPassword(),user.getPosition(),user.getId());
			 userDataService.add(userpo);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,"添加账户成功!");
	}

	
	public ResultMessage removeUser(String admin) {
		// TODO 自动生成的方法存根
		UserPO userpo=null;
		try{
			userpo=userDataService.findonAdmin(admin);
			if(userpo!=null){
			userDataService.delete(admin);
			return new ResultMessage(true,"删除账号成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"需要删除的账户未找到!");
	}


	public ResultMessage updateUser(UserVO user) {
		// TODO 自动生成的方法存根
		UserPO userpo=null;
		try{
			userpo=userDataService.findonAdmin(user.getAdmin());
			if(userpo!=null){
				userpo.setId(user.getId());
				userpo.setPassword(user.getPassword());
				userpo.setPosition(user.getPosition());
				userDataService.update(userpo);
				return new ResultMessage(true,"更新账户信息成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"需要修改的账户未找到!");
	}

	
	public ArrayList<UserVO> showAll() {
		// TODO 自动生成的方法存根
		  ArrayList<UserVO> uservo=new ArrayList<UserVO>();
		  ArrayList<UserPO> userpo=new ArrayList<UserPO>();
		  try{
			  userpo=userDataService.showAll();
		  }catch(RemoteException e){
				e.printStackTrace();
			}
		  for(UserPO po:userpo){
		    	uservo.add(new UserVO(po.getAdmin(),po.getPassword(),po.getPosition(),po.getId()));
		    }
			return uservo;
	}

	
	public UserVO findonAdmin(String admin) {
		// TODO 自动生成的方法存根
		UserPO userpo=null;
		try{
		  userpo=userDataService.findonAdmin(admin);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		UserVO uservo=new UserVO(userpo.getAdmin(),userpo.getPassword(),userpo.getPosition(),userpo.getId());
		return uservo;
	}

	
	public UserVO findonId(String id) {
		// TODO 自动生成的方法存根
		UserPO userpo=null;
		try{
		  userpo=userDataService.findonId(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		UserVO uservo=new UserVO(userpo.getAdmin(),userpo.getPassword(),userpo.getPosition(),userpo.getId());
		return uservo;
	}
	
}