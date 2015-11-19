/**
 *2015年10月22日
 *author:tqy
 *description:包括中转中心和营业厅的机构类
 */
package vo;

import java.util.ArrayList;


public class AgencyVO {
	/**
	 * 机构名称
	 */
	private String agencyName;
	/**
	 * 机构编号
	 */
	private String agencyNum;
	
	/**
	 * 机构中人员信息
	 */
	private ArrayList<StaffVO> staffList;

	public AgencyVO(String agencyName,String agencyNum, ArrayList<StaffVO> staffList) {
		super();
		this.agencyName=agencyName;
		this.agencyNum = agencyNum;
		this.staffList = staffList;
	}

	public void setAgencyName(String agencyName) {
		this.agencyName = agencyName;
	}

	public void setAgencyNum(String agencyNum) {
		this.agencyNum = agencyNum;
	}

	public void setStaffList(ArrayList<StaffVO> staffList) {
		this.staffList = staffList;
	}

	public String getAgencyNum() {
		return agencyNum;
	}

	public ArrayList<StaffVO> getStaffList() {
		return staffList;
	}
	public String getAgencyName(){
		return agencyName;
	}

}