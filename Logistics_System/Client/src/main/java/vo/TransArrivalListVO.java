/**
 *2015年10月21日
 *author:tdy
 *discirption:中转中心的到达单 的vo实体类
 */
package vo;

import java.util.ArrayList;

import utility.CheckType;

public class TransArrivalListVO extends ListVO{
	private String id;
	/**
	 * 中转单编号/装运单编号
	 */
	private String transferNumber;
	
	/**
	 * 中转中心编号
	 */
	private String centerNumber;

	/**
	 * 货物到达日期
	 */
	private String date;
	
	/**
	 * 货物状态信息
	 */
	private ArrayList<GoodsInfoVO> GoodsInfoVOs;

	public TransArrivalListVO(String id,String transferNumber, String centerNumber, String date,
			ArrayList<GoodsInfoVO> goodsInfoVOs,CheckType type) {
		super();
		this.setId(id);
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		GoodsInfoVOs = goodsInfoVOs;
		this.setCheckType(type);
	}

	public String getTransferNumber() {
		return transferNumber;
	}

	public String getCenterNumber() {
		return centerNumber;
	}

	public String getDate() {
		return date;
	}

	public ArrayList<GoodsInfoVO> getGoodsInfoVOs() {
		return GoodsInfoVOs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
