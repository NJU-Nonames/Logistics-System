package vo;

import java.util.ArrayList;

/**
 * 派件单
 * @author 这菜咸了
 *
 */
public class DeliveringListVO {
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

	public DeliveringListVO(String date, ArrayList<String> barCode, String deliveryMan) {
		super();
		this.date = date;
		BarCode = barCode;
		DeliveryMan = deliveryMan;
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
