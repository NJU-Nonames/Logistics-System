/**
 *2015年10月22日
 *author:tdy
 *description:包括中转中心和营业厅的机构类 
 */
package po.agency;

import java.io.Serializable;
import java.util.ArrayList;



/**
 * @author Administrator
 *
 */
public class AgencyPO implements Serializable{
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
	private ArrayList<StaffPO> staffList;

	public AgencyPO(String agencyName,String agencyNum, ArrayList<StaffPO> staffList) {
		super();
		this.agencyName=agencyName;
		this.agencyNum = agencyNum;
		this.staffList = staffList;
	}

	public String getAgencyNum() {
		return agencyNum;
	}

	public ArrayList<StaffPO> getStaffList() {
		return staffList;
	}
	public String getAgencyName(){
		return agencyName;
	}

}
