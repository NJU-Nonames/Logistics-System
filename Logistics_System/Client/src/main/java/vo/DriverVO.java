/**
 *2015年10月22日
 *author:tdy
 *description: 营业厅管理的司机vo实体类
 */
package vo;

import po.agency.DriverPO;

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
	private String drivingLicencePeriod;
	
	/**
	 * 构造方法
	 * @param name
	 * @param birthday
	 * @param IDNum
	 * @param phoneNum
	 * @param sex
	 * @param drvingLicencePeriod
	 */
     public DriverVO(String driverNum,String name,String sex,
    		 String IDNum,String phoneNum,String drivingLicencePeriod){
    	 this.driverNum = driverNum;
    	 this.name = name;
    	 this.IDNum = IDNum;
    	 this.phoneNum = phoneNum;
    	 this.sex = sex;
    	 this.drivingLicencePeriod = drivingLicencePeriod;
     }

	public DriverVO(DriverPO po) {
		this.driverNum=po.getDriverNum();
		this.name=po.getName();
		this.IDNum=po.getIDNum();
		this.phoneNum=po.getPhoneNum();
		this.sex=po.getSex();
		this.drivingLicencePeriod=po.getDrivingLicencePeriodstarttime();
	}

	public String getDriverNum() {
		return driverNum;
	}

	public String getName() {
		return name;
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

	public String getDrivingLicencePeriod() {
		return drivingLicencePeriod;
	}
}
