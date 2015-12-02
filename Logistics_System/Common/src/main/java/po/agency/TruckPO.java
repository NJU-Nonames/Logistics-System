/**
 *2015年10月22日
 *author:tdy
 *description:营业厅管理的货车的数据层表现 
 */
package po.agency;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class TruckPO implements Serializable{
	/**
	 * 车辆代号
	 */
	private String vehiclecode;
	
	/**
	 * 车牌号
	 */
	private String platenumber;
	
	/**
	 * 服役起始日期格式（2015-2-21）
	 */
	private String servicestarttime;
	
	
	/**
	 * 
	 * @param vehiclecode
	 * @param platenumber
	 * @param serviceTimeLimit
	 */
	public TruckPO(String vehiclecode,String platenumber,String servicestarttime){
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
	
//	public static void main(String args[]){
//		TruckPO truck=new TruckPO("123", "123", "2013-2-23");
//		System.out.println(truck.getServiceTimeLimit());
//	}
	

}
