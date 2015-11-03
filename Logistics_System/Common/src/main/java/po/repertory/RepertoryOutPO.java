package po.repertory;

import utility.TransportationType;

/**
 * 出库单PO
 * @author 这菜咸了
 *
 */
public class RepertoryOutPO {
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

	public RepertoryOutPO(String code, String time, String destnation,
			TransportationType transportation, String transCode,
			String vehicleCode) {
		super();
		this.code = code;
		this.time = time;
		this.destnation = destnation;
		this.transportation = transportation;
		this.transCode = transCode;
		this.vehicleCode = vehicleCode;
	}
}
