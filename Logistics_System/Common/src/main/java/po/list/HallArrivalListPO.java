package po.list;

import java.util.ArrayList;

import po.repertory.GoodsInfoPO;
import utility.CheckType;
import utility.GoodsState;

public class HallArrivalListPO extends ListPO{
	
	private String id;
	/**
	 * 到达日期
	 */
	private String date;

	/**
	 * 装车单编号
	 */
	private String TransferNumber;
	
	
	/**
	 * 货物到达信息状态
	 */
	private ArrayList<GoodsInfoPO> goodsInfoPO;

	public HallArrivalListPO(String id,String date, String transferNumber,
			ArrayList<GoodsInfoPO> goodsInfoPO,CheckType type) {
		
		super();
		this.id=id;
		this.date = date;
		TransferNumber = transferNumber;
		this.goodsInfoPO=goodsInfoPO;
		this.setCheckType(type);
	}

	public String getDate() {
		return date;
	}

	public String getTransferNumber() {
		return TransferNumber;
	}

	

	public String getId() {
		return id;
	}

	

	public ArrayList<GoodsInfoPO> getGoodsInfoPO() {
		return goodsInfoPO;
	}

	

}
