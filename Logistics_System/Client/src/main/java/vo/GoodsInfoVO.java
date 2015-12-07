package vo;

import utility.GoodsState;

public class GoodsInfoVO {
	/**
	 * 货物快递编号
	 */
	private String barcode;

	/**
	 * 货物到达状态
	 */
	private GoodsState state;

	public GoodsInfoVO(String barcode, GoodsState state) {
		super();
		this.barcode = barcode;
		this.state = state;
	}

	public String getBarcode() {
		return barcode;
	}

	public GoodsState getState() {
		return state;
	}

}
