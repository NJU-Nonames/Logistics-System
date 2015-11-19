package vo;



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
	private String postion;
	
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
	private String agencyId;
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
	public StaffVO(String name,String sex,String postion,String IDNum,String workingstarttime,String phoneNum,String wage,String agencyId,String id){
		this.name = name;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.IDNum = IDNum;
		this.phoneNum = phoneNum;
		this.postion = postion;
		this.wage = wage;
		this.workingstarttime = workingstarttime;
		this.agencyId=agencyId;
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
	public String getAgencyId() {
		return agencyId;
	}

	/**
	 * @param agency the agency to set
	 */
	public void setAgency(String agencyId) {
		this.agencyId = agencyId;
	}

	/**
	 * @return the id
	 */

}
