/**
 *2015年10月21日
 *author:tdy
 *discirption: 营业厅的装车单vo实体类
 */
package vo;

import java.util.ArrayList;

import utility.CheckType;

public class LoadListVO extends ListVO{
	/**
	 * 汽运编号即Id！
	 */
	private String transpotationNumber;

	/**
	 * 装车日期
	 */
	private String date;

	/**
	 * 本营业厅编号
	 */
	private String hallNumber;

	

	/**
	 * 目的地
	 */
	private String Destination;

	/**
	 * 车辆代号
	 */
	private String carNumber;

	/**
	 * 监装员信息
	 */
	private String guardMan;

	/**
	 * 押运员信息
	 */
	private String supercargoMan;

	/**
	 * 货物条形码
	 */
	private ArrayList<String> barcodes;

	public LoadListVO(String date, String hallNumber, String transpotationNumber, String destination,
			String carNumber, String guardMan, String supercargoMan, ArrayList<String> barcodes,CheckType type) {
		super();
		this.date = date;
		this.hallNumber = hallNumber;
		this.transpotationNumber = transpotationNumber;
		Destination = destination;
		this.carNumber = carNumber;
		this.guardMan = guardMan;
		this.supercargoMan = supercargoMan;
		this.barcodes = barcodes;
		this.setCheckType(type);
	}

	public String getDate() {
		return date;
	}

	public String getHallNumber() {
		return hallNumber;
	}

	public String getTranspotationNumber() {
		return transpotationNumber;
	}

	public String getDestination() {
		return Destination;
	}

	public String getCarNumber() {
		return carNumber;
	}

	public String getGuardMan() {
		return guardMan;
	}

	public String getSupercargoMan() {
		return supercargoMan;
	}

	public ArrayList<String> getBarcodes() {
		return barcodes;
	}


}
