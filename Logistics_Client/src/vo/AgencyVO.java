/**
 *2015年10月22日
 *author:tqy
 *description:包括中转中心和营业厅的机构类
 */
package vo;

import java.util.ArrayList;

public class AgencyVO {
	
	/**
	 * 机构编号
	 */
	private String AgencyNum;
	
	/**
	 * 机构中人员信息
	 */
	private ArrayList<StaffVO> staffList;

	public AgencyVO(String agencyNum, ArrayList<StaffVO> staffList) {
		super();
		AgencyNum = agencyNum;
		this.staffList = staffList;
	}

	public String getAgencyNum() {
		return AgencyNum;
	}

	public ArrayList<StaffVO> getStaffList() {
		return staffList;
	}

}
