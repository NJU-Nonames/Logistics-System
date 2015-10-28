/**
 *2015年10月22日
 *author:tdy
 *discirption:营业厅管理的货车的vo实体类
 */
package vo;

import java.io.File;

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
	public TruckVO(String vehiclecode,String platenumber,String serviceTime,File picture,String checkTime){
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