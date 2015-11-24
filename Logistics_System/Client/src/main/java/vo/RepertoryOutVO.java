package vo;

import utility.CheckType;
import utility.TransportationType;

/**
 * 出库单
 * @author 这菜咸了
 *
 */
public class RepertoryOutVO extends ListVO{
	private String id;
	/**
	 * 快递编号
	 */
	private String code;
	
	/**
	 * 出库时间
	 */
	private String time;
	
	/**
	 * 目的地
	 */
	private String destnation;
	
	/**
	 * 装运方式
	 */
	private TransportationType transportation;
	
	/**
	 * 中转单编号
	 */
	private String transCode;
	
	/**
	 * 汽运编号
	 */
	private String vehicleCode;

	public String getCode() {
		return code;
	}

	public String getTime() {
		return time;
	}

	public String getDestnation() {
		return destnation;
	}

	public TransportationType getTransportation() {
		return transportation;
	}

	public String getTransCode() {
		return transCode;
	}

	public String getVehicleCode() {
		return vehicleCode;
	}

	public RepertoryOutVO(String id,String code, String time, String destnation,
			TransportationType transportation, String transCode,
			String vehicleCode,CheckType type) {
		super();
		this.id=id;
		this.code = code;
		this.time = time;
		this.destnation = destnation;
		this.transportation = transportation;
		this.transCode = transCode;
		this.vehicleCode = vehicleCode;
		this.setCheckType(type);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
