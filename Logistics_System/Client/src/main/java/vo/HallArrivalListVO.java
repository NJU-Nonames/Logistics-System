package vo;

import java.util.ArrayList;

import utility.CheckType;




/**
 * @author 这菜咸了
 *营业厅到达单
 */
public class HallArrivalListVO extends ListVO{
	public String id;
	/**
	 * 到达日期
	 */
	public String date;

	/**
	 * 装车单编号
	 */
	public String TransferNumber;
	/**
	 * 货物出发地
	 */
	private String departureplace;
	
	
	/**
	 * 货物到达信息状态
	 */
	public ArrayList<GoodsInfoVO> goodsInfoVO;

	public HallArrivalListVO(String id,String date, String transferNumber,String departureplace,
			ArrayList<GoodsInfoVO> goodsInfoVO,CheckType type) {
		
		super();
		this.id=id;
		this.date = date;
		TransferNumber = transferNumber;
		this.goodsInfoVO=goodsInfoVO;
		this.departureplace=departureplace;
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

	

	public ArrayList<GoodsInfoVO> getGoodsInfoVO() {
		return goodsInfoVO;
	}
	public String getDepartureplace() {
		return departureplace;
	}
}

