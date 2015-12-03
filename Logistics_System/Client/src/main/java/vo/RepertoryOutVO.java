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
	private String destination;
	
	/**
	 * 装运方式
	 */
	private TransportationType transportation;
	
	/**
	 * 中转单编号或汽运编号
	 */
	private String transCode;


	public String getCode() {
		return code;
	}

	public String getTime() {
		return time;
	}

	public String getDestination() {
		return destination;
	}

	public TransportationType getTransportation() {
		return transportation;
	}

	public String getTransCode() {
		return transCode;
	}


	public RepertoryOutVO(String id,String code, String time, String destination,
			TransportationType transportation, String transCode,
			CheckType type) {
		super();
		this.id=id;
		this.code = code;
		this.time = time;
		this.destination = destination;
		this.transportation = transportation;
		this.transCode = transCode;
		this.setCheckType(type);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
