/**
 *2015年10月22日
 *author:tdy
 *discirption:营业厅管理的货车的vo实体类
 */
package vo;

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
	private String serviceTimeLimit;
	
	
	/**
	 * 
	 * @param vehiclecode
	 * @param platenumber
	 * @param serviceTimeLimit
	 */
	public TruckVO(String vehiclecode,String platenumber,String serviceTimeLimit){
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
