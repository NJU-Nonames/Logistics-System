/**
 *2015年10月22日
 *author:tdy
 *description: 营业厅管理的司机vo实体类
 */
package vo;
public class DriverVO {
	/**
	 * 司机编号
	 */
	private String driverNum; 
    
	/**
	 * 姓名
	 */
	private String name;
	
	/**
	 * 出生日期
	 */
	private String birthday;
	
	/**
	 * 身份证号
	 */
	private String IDNum;
	
	/**
	 * 手机号
	 */
	private String phoneNum;
	
	/**
	 * 性别
	 */
	private String sex;
	
	/**
	 * 行驶证期限
	 */
	private String drvingLicencePeriod;
	
	/**
	 * 构造方法
	 * @param cityNum
	 * @param name
	 * @param birthday
	 * @param IDNum
	 * @param phoneNum
	 * @param sex
	 * @param drvingLicencePeriod
	 */
     public DriverVO(String driverNum,String name,String sex,String birthday,
    		 String IDNum,String phoneNum,String drvingLicencePeriod){
    	 this.driverNum = driverNum;
    	 this.name = name;
    	 this.IDNum = IDNum;
    	 this.birthday = birthday;
    	 this.phoneNum = phoneNum;
    	 this.sex = sex;
    	 this.drvingLicencePeriod = drvingLicencePeriod;
     }

	public String getDriverNum() {
		return driverNum;
	}

	public String getName() {
		return name;
	}

	public String getBirthday() {
		return birthday;
	}

	public String getIDNum() {
		return IDNum;
	}

	public String getPhoneNum() {
		return phoneNum;
	}

	public String getSex() {
		return sex;
	}

	public String getDrvingLicencePeriod() {
		return drvingLicencePeriod;
	}
}
