/**
 *2015年10月22日
 *author:tdy
 *discirption:营业厅管理的货车的vo实体类
 */
package vo;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TruckVO {
	/**
	 * 车辆代号
	 */
	private String vehiclecode;
	
	/**
	 * 车牌号
	 */
	private String platenumber;
	
	/**
	 * 服役期限
	 */
	private String servicestarttime;
	
	
	/**
	 * 
	 * @param vehiclecode
	 * @param platenumber
	 * @param serviceTimeLimit
	 */
	public TruckVO(String vehiclecode,String platenumber,String servicestarttime){
		this.vehiclecode = vehiclecode;
		this.platenumber = platenumber;
		this.servicestarttime =servicestarttime;

	}

	public String getVehiclecode() {
		return vehiclecode;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	
	public String getServicestarttime(){
 		return servicestarttime;
	}
	
	public String getServiceTimeLimit() {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date now = null,date1 = null;
		try {
			now = df.parse(df.format(Calendar.getInstance().getTime()));
			date1 = df.parse(servicestarttime);
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
