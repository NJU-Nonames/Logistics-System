/**
 *2015年10月22日
 *author:tdy
 *description:营业厅管理的司机的数据层表现 
 */
package po.agency;

import java.io.Serializable;

import po.system.UserPO;

public class DriverPO implements Serializable{
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
     public DriverPO(String driverNum,String name,String sex,String birthday,
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
