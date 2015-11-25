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
	/**
	 * 员工所属机构名称
	 */
	private String agencyName;
	
	/**
	 * 员工编号
	 */
	private String id;
	/**
	 * 员工所属机构id
	 */
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
	public StaffPO(String name,String sex,String postion,String IDNum,String workingstarttime,String phoneNum,String wage,String agencyName,String id,String agencyId){
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

	public String getAgencyName() {
		return agencyName;
	}



	public String getId() {
		return id;
	}

	public String getAgencyId() {
		return agencyId;
	}


}
