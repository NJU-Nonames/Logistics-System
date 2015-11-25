package presentation.mainui;

import vo.StaffVO;

/**
 * @author 这菜咸了
 * 当前使用者类
 */
public class CurrentUser {
	private String name;
	private String agencyName;
	private String agencyNum;
	public String getname(){
		return this.name;
	}
	public String getAgencyName(){
		return agencyName;
	}
	public String getAgencyNum(){
		return agencyNum;
	}
	public CurrentUser(String name,String agencyName,String agencyNum){
		this.name = name;
		this.agencyName=agencyName;
		this.agencyNum=agencyNum;
	}
}
