package vo;

import java.util.ArrayList;

import utility.CheckType;

/**
 * 派件单
 * @author 这菜咸了
 *
 */
public class DeliveringListVO extends ListVO{
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

	public DeliveringListVO(String id,String date, ArrayList<String> barCode, String deliveryMan,CheckType type) {
		super();
		this.id=id;
		this.date = date;
		BarCode = barCode;
		DeliveryMan = deliveryMan;
		this.setCheckType(type);
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
