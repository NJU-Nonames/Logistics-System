/**
 *2015年10月21日
 *author:tdy
 *discirption:中转中心的到达单 的vo实体类
 */
package po.list;

import java.io.Serializable;
import java.util.ArrayList;

import po.repertory.GoodsInfoPO;
import utility.CheckType;


public class TransArrivalListPO extends ListPO implements Serializable{
	private String id;
	/**
	 * 中转单编号
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
	private ArrayList<GoodsInfoPO> GoodsInfoPOs;

	public TransArrivalListPO(String id,String transferNumber, String centerNumber, String date,
			ArrayList<GoodsInfoPO> goodsInfoPOs,CheckType type) {
		super();
		this.setId(id);
		this.transferNumber = transferNumber;
		this.centerNumber = centerNumber;
		this.date = date;
		GoodsInfoPOs = goodsInfoPOs;
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

	public ArrayList<GoodsInfoPO> getGoodsInfoPOs() {
		return GoodsInfoPOs;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
}
