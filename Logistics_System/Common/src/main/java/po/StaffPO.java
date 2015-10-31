package po;

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
	
	/**
	 * @param name
	 * @param sex
	 * @param postion
	 * @param IDNum
	 * @param workingtime
	 * @param phoneNum
	 * @param wage
	 */
	public StaffPO(String name,String sex,String postion,String IDNum,int workingtime,String phoneNum,double wage){
		this.name = name;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.IDNum = IDNum;
		this.phoneNum = phoneNum;
		this.postion = postion;
		this.wage = wage;
		this.workingtime = workingtime;
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
}
