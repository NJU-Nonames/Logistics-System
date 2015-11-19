package po.agency;

public class StaffPO {
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
	 * 进入公司工作时间
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
	public StaffPO(String name,String sex,String postion,String IDNum,String workingstarttime,String phoneNum,String wage,String agencyId,String id){
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

	public String getAgencyId() {
		return agencyId;
	}



	public String getId() {
		return id;
	}


}
