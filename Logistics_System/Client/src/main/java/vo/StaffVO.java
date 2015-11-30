package vo;

import utility.Position;



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
	private Position postion;
	
	/**
	 * 身份证
	 */
	private String IDNum;
	
	/**
	 * 工作起始时间
	 */
	private String workingstarttime;
	
	/**
	 * 手机
	 */
	private String phoneNum;
	
	/**
	 * 工资
	 */
	private String wage;
	private String agencyName;
	private String id;
	private String agencyId;
	
	/**
	 * @param name
	 * @param sex
	 * @param postion
	 * @param IDNum
	 * @param workingtime
	 * @param phoneNum
	 * @param wage
	 */
	public StaffVO(String name,String sex,Position postion,String IDNum,String workingstarttime,String phoneNum,String wage,String agencyName,String id,String agencyId){
		this.name = name;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.IDNum = IDNum;
		this.phoneNum = phoneNum;
		this.postion = postion;
		this.wage = wage;
		this.workingstarttime = workingstarttime;
		this.agencyName=agencyName;
		this.id=id;
		this.agencyId=agencyId;
	}
	public String getAgencyId(){
		return agencyId;
	}
	public String getName() {
		return name;
	}

	public String getSex() {
		return sex;
	}

	public Position getPostion() {
		return postion;
	}

	public String getIDNum() {
		return IDNum;
	}

	public String getWorkingstarttime() {
		return workingstarttime;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getWage() {
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

}
