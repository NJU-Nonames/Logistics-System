package presentation.mainui;

import vo.StaffVO;

/**
 * @author 这菜咸了
 * 当前使用者类
 */
public class CurrentUser {
	private String name;
	public String getname(){
		return this.name;
	}
	
	public CurrentUser(String name){
		this.name = name;
	}
}
