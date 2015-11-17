package vo;

import po.agency.StaffPO;

public class StaffVO {
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 职位
	 */
	private String  postion;
	
	/**
	 * 身份证
	 */
	private String IDNum;
	
	/**
	 * 工作时长（按月）
	 */
	private int workingtime;
	
	/**
	 * 手机
	 */
	private String phoneNum;
	
	/**
	 * 工资
	 */
	private double wage;
	private String agencyName;
	private String id;
	
	/**
	 * @param name
	 * @param sex
	 * @param postion
	 * @param IDNum
	 * @param workingtime
	 * @param phoneNum
	 * @param wage
	 */
	public StaffVO(String name,String sex,String postion,String IDNum,int workingtime,String phoneNum,double wage,String agencyName,String id){
		this.name = name;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.IDNum = IDNum;
		this.phoneNum = phoneNum;
		this.postion = postion;
		this.wage = wage;
		this.workingtime = workingtime;
		this.agencyName=agencyName;
		this.id=id;
	}

	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public String getPostion() {
		return postion;
	}

	public String getIDNum() {
		return IDNum;
	}

	public int getWorkingtime() {
		return workingtime;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public double getWage() {
		return wage;
	}

	/**
	 * @return the iD
	 */
	public String getId() {
		return id;
	}

	/**
	 * @param iD the iD to set
	 */
	public void setID(String id) {
		this.id=id;
	}

	/**
	 * @return the agency
	 */
	public String getAgencyName() {
		return agencyName;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(String agencyName) {
		this.agencyName = agencyName;
	}

	/**
	 * @return the id
	 */

}
