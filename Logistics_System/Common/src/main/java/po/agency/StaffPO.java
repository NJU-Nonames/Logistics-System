package po.agency;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import utility.Position;

public class StaffPO implements Serializable{
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
	private Position  position;
	
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
	public StaffPO(String name,String sex,Position position,String IDNum,String workingstarttime,String phoneNum,String wage,String agencyName,String id,String agencyId){
		this.name = name;
		this.sex = sex;
		this.phoneNum = phoneNum;
		this.IDNum = IDNum;
		this.phoneNum = phoneNum;
		this.position = position;
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

	public Position getPostion() {
		return position;
	}

	public String getIDNum() {
		return IDNum;
	}

	public String getWorkingtime() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = null,date1 = null;
		try {
			now = df.parse(df.format(Calendar.getInstance().getTime()));
			date1 = df.parse(workingstarttime);
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
