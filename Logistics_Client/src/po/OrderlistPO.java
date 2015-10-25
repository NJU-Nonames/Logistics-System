package po;

import java.io.Serializable;

import businesslogic.utilitybl.ExpressType;
import businesslogic.utilitybl.PkgState;

/**
 * @author 这菜咸了
 * 订单类
 */
public class OrderListPO extends ListPO implements Serializable{
	/**
	 * 客户姓名
	 */
	private String senderName;
	
	/**
	 * 客户地址
	 */
	private String senderAddress;
	
	/**
	 * 客户单位地址
	 */
	private String senderWorkPlace;
	
	/**
	 * 客户电话（手机）号码
	 */
	private String senderTeleNumber;
	
	/**
	 * 寄件件数
	 */
	private String number;
	
	/**
	 * 货物实际重量
	 */
	private double weight;
	
	/**
	 * 货物体积
	 */
	private double volume;
	
	/**
	 * 货物内件品名
	 */
	private String name;
	
	/**
	 * 快递种类
	 */
	private ExpressType category;
	
	/**
	 * 货物运送位置 运送状态
	 */
	private PkgState pkgState;
	
	/**
	 * 包装费用
	 */
	private double packPrice;
	
	/**
	 * 货物条形码
	 */
	private String barCode;
	
	
	public OrderListPO(String senderName, String senderAddress,
			String senderWorkPlace, String senderTeleNumber, String number,
			double weight, double volume, String name, ExpressType category,
			PkgState pkgState, double packPrice, String barCode) {
		super();
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderWorkPlace = senderWorkPlace;
		this.senderTeleNumber = senderTeleNumber;
		this.number = number;
		this.weight = weight;
		this.volume = volume;
		this.name = name;
		this.category = category;
		this.pkgState = pkgState;
		this.packPrice = packPrice;
		this.barCode = barCode;
	}

	public ExpressType getCategory() {
		return category;
	}

	public PkgState getPkgState() {
		return pkgState;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getSenderWorkPlace() {
		return senderWorkPlace;
	}

	public String getSenderTeleNumber() {
		return senderTeleNumber;
	}

	public String getNumber() {
		return number;
	}

	public double getWeight() {
		return weight;
	}

	public double getVolume() {
		return volume;
	}

	public String getName() {
		return name;
	}


	public double getPackPrice() {
		return packPrice;
	}

	public String getBarCode() {
		return barCode;
	}
}
