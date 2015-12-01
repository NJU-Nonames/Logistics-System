/**
 *2015年10月21日
 *author:tdy
 *discirption:订单的vo实体类
 */
package vo;
import java.util.ArrayList;

import po.list.OrderListPO;
import utility.CheckType;
import utility.ExpressType;
import utility.PkgType;

public class OrderListVO extends ListVO{
	/**
	 * 客户姓名
	 */
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
	
    public String realreceiver;
	
	public String realreceivertelenumber;
	
	
	public OrderListVO(String senderName, String senderAddress,
			String senderTeleNumber, String receiverName,String receiverAddress,String receiverTeleNumber,String number,
			double weight, double volume, String name, ExpressType category,
			ArrayList<String> pkgState, double packPrice, String barCode,PkgType type,String time1,String time2,CheckType checktype,String realreceiver,String realreceivertelenumber) {
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
		this.setCheckType(checktype);
		this.realreceiver=realreceiver;
		this.realreceivertelenumber=realreceivertelenumber;
	}
	public OrderListVO(OrderListPO orderListPO) {
		// TODO 自动生成的构造函数存根
		this.senderName=orderListPO.getSenderName();
		this.senderAddress=orderListPO.getSenderAddress();
		this.senderTeleNumber=orderListPO.getSenderTeleNumber();
		this.receiverName=orderListPO.getReceiverName();
		this.receiverAddress=orderListPO.getReceiverAddress();
		this.receiverTeleNumber=orderListPO.getReceiverTeleNumber();
		this.number = orderListPO.getNumber();
		this.weight = orderListPO.getWeight();
		this.volume = orderListPO.getVolume();
		this.name = orderListPO.getName();
		this.category = orderListPO.getCategory();
		this.pkgState = orderListPO.getPkgState();
		this.packPrice = orderListPO.getPackPrice();
		this.barCode = orderListPO.getBarCode();
		this.type=orderListPO.getPkgType();
		this.departTime=orderListPO.getDepartTime();
		this.arriveTime=orderListPO.getArriveTime();
	}
	public void setArriveTime(String time){
		this.arriveTime=time;
	}
	public void setPackPrice(double price){
		this.packPrice=price;
	}
	public String getDepartTime(){
		return departTime;
	}
	public String getArriveTime(){
		return arriveTime;
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
}	
