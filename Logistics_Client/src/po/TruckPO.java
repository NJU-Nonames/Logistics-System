/**
 *2015年10月22日
 *author:tdy
 *description:营业厅管理的货车的数据层表现 
 */
package po;

import java.io.File;
import java.io.Serializable;

import po.UserPO;

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
	 * 服役时间
	 */
	private String serviceTime;
	
	/**
	 * 下次检修时间
	 */
	private String checkTime;
	
	
	/**
	 * 
	 * @param vehiclecode
	 * @param platenumber
	 * @param serviceTime
	 */
	public TruckPO(String vehiclecode,String platenumber,String serviceTime,File picture,String checkTime){
		this.vehiclecode = vehiclecode;
		this.platenumber = platenumber;
		this.serviceTime =serviceTime;
		this.checkTime=checkTime;

	}

	public String getVehiclecode() {
		return vehiclecode;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public String getServiceTime() {
		return serviceTime;
	}
	public String getCheckTime(){
		return checkTime;
	}
	public void setCheckTime(String checkTime){
		this.checkTime=checkTime;
	}
	

}
