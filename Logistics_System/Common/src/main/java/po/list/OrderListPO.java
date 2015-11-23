package po.list;

import java.io.Serializable;
import java.util.ArrayList;

import utility.ExpressType;
import utility.PkgType;

/**
 * @author 这菜咸了
 * 订单类
 */
public class OrderListPO extends ListPO implements Serializable{
	private String senderName;
	
	/**
	 * 客户地址
	 */
	private String senderAddress;

	
	/**
	 * 客户电话（手机）号码
	 */
	private String senderTeleNumber;
	
	private String receiverName;
	private String receiverAddress;
	private String receiverTeleNumber;
	
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
	private ArrayList<String> pkgState;
	
	/**
	 *运费（包括包装费用）
	 */
	private double packPrice;
	//包装种类（纸箱，木箱，纸袋）
	private PkgType type;
	/**
	 * 货物条形码
	 */
	private String barCode;

	private String departTime;

	private String arriveTime;
	
	
	public OrderListPO(String senderName, String senderAddress,
			String senderTeleNumber, String receiverName,String receiverAddress,String receiverTeleNumber,String number,
			double weight, double volume, String name, ExpressType category,
			ArrayList<String> pkgState, double packPrice, String barCode,PkgType type,String time1,String time2) {
		super();
		this.senderName = senderName;
		this.senderAddress = senderAddress;
		this.senderTeleNumber = senderTeleNumber;
		this.receiverName=receiverName;
		this.receiverAddress=receiverAddress;
		this.receiverTeleNumber=receiverTeleNumber;
		this.number = number;
		this.weight = weight;
		this.volume = volume;
		this.name = name;
		this.category = category;
		this.pkgState = pkgState;
		this.packPrice = packPrice;
		this.barCode = barCode;
		this.type=type;
		this.departTime=time1;
		this.arriveTime=time2;
	}
	public PkgType getPkgType(){
		return type;
	}
	public ExpressType getCategory() {
		return category;
	}

	public ArrayList<String> getPkgState() {
		return pkgState;
	}

	public String getSenderName() {
		return senderName;
	}

	public String getSenderAddress() {
		return senderAddress;
	}

	public String getReceiverName(){
		return receiverName;
	}
	public String getReceiverAddress(){
		return receiverAddress;
	}
	public String getReceiverTeleNumber(){
		return receiverTeleNumber;
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
	public String getDepartTime() {
		// TODO 自动生成的方法存根
		return departTime;
	}
	public String getArriveTime() {
		// TODO 自动生成的方法存根
		return arriveTime;
	}
	public void setArriveTime(String time){
		this.arriveTime=time;
	}
	public void setReceiverName(String receiverName){
		this.receiverName=receiverName;
	}
}
