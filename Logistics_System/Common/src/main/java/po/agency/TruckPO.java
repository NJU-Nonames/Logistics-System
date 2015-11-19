/**
 *2015年10月22日
 *author:tdy
 *description:营业厅管理的货车的数据层表现 
 */
package po.agency;

import java.io.File;
import java.io.Serializable;

import po.system.UserPO;

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
	 * 服役期限
	 */
	private String serviceTimeLimit;
	
	
	/**
	 * 
	 * @param vehiclecode
	 * @param platenumber
	 * @param serviceTimeLimit
	 */
	public TruckPO(String vehiclecode,String platenumber,String serviceTimeLimit){
		this.vehiclecode = vehiclecode;
		this.platenumber = platenumber;
		this.serviceTimeLimit =serviceTimeLimit;

	}

	public String getVehiclecode() {
		return vehiclecode;
	}

	public String getPlatenumber() {
		return platenumber;
	}

	public String getServiceTimeLimit() {
		return serviceTimeLimit;
	}
	

}
