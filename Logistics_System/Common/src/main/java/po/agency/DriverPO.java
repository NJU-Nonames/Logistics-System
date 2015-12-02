/**
 *2015年10月22日
 *author:tdy
 *description:营业厅管理的司机的数据层表现 
 */
package po.agency;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

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
	private String drivingLicencePeriodstarttime;
	
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
     public DriverPO(String driverNum,String name,String sex,
    		 String IDNum,String phoneNum,String drivingLicencePeriodstarttime){
    	 this.driverNum = driverNum;
    	 this.name = name;
    	 this.IDNum = IDNum;
    	 this.phoneNum = phoneNum;
    	 this.sex = sex;
    	 this.drivingLicencePeriodstarttime = drivingLicencePeriodstarttime;
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
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = null,date1 = null;
		try {
			now = df.parse(df.format(Calendar.getInstance().getTime()));
			date1 = df.parse(drivingLicencePeriodstarttime);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		long day = (now.getTime() - date1.getTime())
			     / (24 * 60 * 60 * 1000);
		int year=(int) (day/365);
		int month=(int) ((day%365)/30);
		int day1=(int) ((day%365)%30);
		return year+"年"+month+"月"+day1+"日";
	}
}
