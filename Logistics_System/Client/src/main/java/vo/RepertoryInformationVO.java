package vo;

public class RepertoryInformationVO{
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
	 * 订单号
	 */
	public String orderId;
	
	public RepertoryInformationVO(String id,String areaNumber,String rowNumber,String frameNumber,String placeNumber,String orderId){
		this.id=id;
		this.areaNumber=areaNumber;
		this.rowNumber=rowNumber;
		this.frameNumber=frameNumber;
		this.placeNumber=placeNumber;
		this.orderId=orderId;
		
	}
}