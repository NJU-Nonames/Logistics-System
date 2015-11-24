/**
 *2015年10月22日
 *author:tdy
 *discirption:派件单 
 */
package po.list;

import java.io.Serializable;
import java.util.ArrayList;

import utility.CheckType;

public class DeliveringListPO extends ListPO implements Serializable{
	private String id;
	/**
	 * 货物到达日期
	 */
	private String date;

	/**
	 * 货物托运条形号码
	 */
	private ArrayList<String> BarCode;

	/**
	 * 派件员
	 */
	private String DeliveryMan;

	public DeliveringListPO(String id,String date, ArrayList<String> barCode, String deliveryMan,CheckType type) {
		super();
		this.id=id;
		this.date = date;
		BarCode = barCode;
		DeliveryMan = deliveryMan;
		this.setCheckType(type);
	}

	public String getId(){
		return id;
	}
	
    public String getDate() {
        return date;
    }

    public ArrayList<String> getBarCode() {
        return BarCode;
    }

    public String getDeliveryMan() {
        return DeliveryMan;
    }
}
