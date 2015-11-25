package po.list;

import java.util.ArrayList;

import utility.CheckType;

/**
 * @author 这菜咸了
 * 装车单
 */
public class LoadListPO extends ListPO{
	private String id;
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
	private String transportationNumber;

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

	public LoadListPO(String id,String date, String hallNumber, String transportationNumber, String destination,
			String carNumber, String guardMan, String supercargoMan, ArrayList<String> barcodes,CheckType type) {
		super();
		this.setId(id);
		this.date = date;
		this.hallNumber = hallNumber;
		this.transportationNumber = transportationNumber;
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

	public String getTransportationNumber() {
		return transportationNumber;
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

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
