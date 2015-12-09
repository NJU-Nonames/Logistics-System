package vo;

public class RepertoryOrderVO{
	//包含仓库中所有的订单信息
	/**
	 * 仓库号
	 */
	public String id;
	/**
	 * 区
	 */
	public String areaNumber;
	/**
	 * 排
	 */
	public String rowNumber;
	/**
	 * 架
	 */
	public String frameNumber;
	/**
	 * 位
	 */
	public String placeNumber;
	/**
	 * 入库日期
	 */
	public String time;
	/**
	 * 目的地
	 */
	public String destination;
	/**
	 * 订单号
	 */
	public String orderId;
	public RepertoryOrderVO(String id, String areaNumber,
			String rowNumber, String frameNumber, String placeNumber,
			String time, String destination, String orderId) {
		super();
		this.id = id;
		this.areaNumber = areaNumber;
		this.rowNumber = rowNumber;
		this.frameNumber = frameNumber;
		this.placeNumber = placeNumber;
		this.time = time;
		this.destination = destination;
		this.orderId = orderId;
	}
	
	
}