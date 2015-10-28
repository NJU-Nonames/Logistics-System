package vo;

import businesslogic.utilitybl.GoodsState;

public class GoodsInfoVO {
	/**
	 * 货物快递编号
	 */
	private String barcode;

	/**
	 * 货物到达状态
	 */
	private GoodsState state;

	/**
	 * 货物出发地
	 */
//	private String departurePlace;

	public GoodsInfoVO(String barcode, GoodsState state, String departurePlace) {
		super();
		this.barcode = barcode;
		this.state = state;
//		this.departurePlace = departurePlace;
	}

	public String getBarcode() {
		return barcode;
	}

	public GoodsState getState() {
		return state;
	}

//	public String getDeparturePlace() {
//		return departurePlace;
//	}
}
