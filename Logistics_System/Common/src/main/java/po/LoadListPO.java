package po;

import java.util.ArrayList;

/**
 * @author 这菜咸了
 * 装车单
 */
public class LoadListPO {
	/**
	 * 装车日期
	 */
	private String date;

	/**
	 * 本营业厅编号
	 */
	private String hallNumber;

	/**
	 * 汽运编号
	 */
	private String transpotationNumber;

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

	public LoadListPO(String date, String hallNumber, String transpotationNumber, String destination,
			String carNumber, String guardMan, String supercargoMan, ArrayList<String> barcodes) {
		super();
		this.date = date;
		this.hallNumber = hallNumber;
		this.transpotationNumber = transpotationNumber;
		Destination = destination;
		this.carNumber = carNumber;
		this.guardMan = guardMan;
		this.supercargoMan = supercargoMan;
		this.barcodes = barcodes;
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
