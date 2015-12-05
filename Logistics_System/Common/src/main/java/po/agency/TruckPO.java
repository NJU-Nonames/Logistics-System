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

	public String getServicestarttime(){
		return servicestarttime;
	}
	

}
