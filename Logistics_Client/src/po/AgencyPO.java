/**
 *2015年10月22日
 *author:tdy
 *description:包括中转中心和营业厅的机构类 
 */
package po;

import java.io.Serializable;
import java.util.ArrayList;



/**
 * @author Administrator
 *
 */
public class AgencyPO implements Serializable{
	/**
	 * 机构编号
	 */
	private String AgencyNum;
	
	/**
	 * 机构中人员信息
	 */
	private ArrayList<StaffPO> staffList;

	public AgencyPO(String agencyNum, ArrayList<StaffPO> staffList) {
		super();
		AgencyNum = agencyNum;
		this.staffList = staffList;
	}

	public String getAgencyNum() {
		return AgencyNum;
	}

	public ArrayList<StaffPO> getStaffList() {
		return staffList;
	}

}
