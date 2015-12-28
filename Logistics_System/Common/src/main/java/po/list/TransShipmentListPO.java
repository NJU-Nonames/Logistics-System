package po.list;

import java.util.ArrayList;

import utility.CheckType;

/**
 * 中转单
 * @author 这菜咸了
 *
 */
public class TransShipmentListPO extends ListPO{
	/**
	 * 装车日期
	 */
	private String date;

	/**
	 * 中转单编号	
	 */
	private String transitDocNumber;

	/**
	 * 航班号	
	 */
	private String flightNumber;

	/**
	 * 出发地
	 */
	private String departurePlace;

	/**
	 * 到达地
	 */
	private String destination;

	/**
	 * 货柜号
	 */
	private String containerNumber;

	/**
	 * 监装员
	 */
	private String supercargoMan;

	/**
	 * 装箱所有托运单号
	 */
	private ArrayList<String> barcodes;
	
	/**
	 * 运费
	 */
	private double price;

	public TransShipmentListPO(String date, String transitDocNumber, String flightNumber, String departurePlace,
			String destination, String containerNumber, String supercargoMan, ArrayList<String> barcodes,double price,CheckType type) {
		super();
		this.date = date;
		this.transitDocNumber = transitDocNumber;
		this.flightNumber = flightNumber;
		this.departurePlace = departurePlace;
		this.destination = destination;
		this.containerNumber = containerNumber;
		this.supercargoMan = supercargoMan;
		this.barcodes = barcodes;
		this.price=price;
		this.setCheckType(type);
	}

	public String getDate() {
		return date;
	}

	public String getTransitDocNumber() {
		return transitDocNumber;
	}

	public String getFlightNumber() {
		return flightNumber;
	}

	public String getDeparturePlace() {
		return departurePlace;
	}

	public String getDestination() {
		return destination;
	}

	public String getContainerNumber() {
		return containerNumber;
	}

	public String getSupercargoMan() {
		return supercargoMan;
	}

	public ArrayList<String> getBarcodes() {
		return barcodes;
	}

	public double getPrice() {
		return price;
	}
}
