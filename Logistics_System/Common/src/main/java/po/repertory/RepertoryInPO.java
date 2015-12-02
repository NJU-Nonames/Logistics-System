package po.repertory;

import po.list.ListPO;
import utility.CheckType;

/**
 * 入库单
 * @author 这菜咸了
 *
 */
public class RepertoryInPO extends ListPO{
	private String id;
	/**
	 * 快递编号
	 */
	private String num;
	
	/**
	 * 入库时间
	 */
	private String time;
	
	/**
	 * 目的地
	 */
	private String destination;
	
	/**
	 * 区号
	 */
	private String areacode;
	
	/**
	 * 排号
	 */
	private String rownumber;
	
	/**
	 * 架号
	 */
	private String framenumber;
	
	/**
	 * 位号
	 */
	private String placenumber;

	public String getNum() {
		return num;
	}

	public String getTime() {
		return time;
	}

	public String getDestination() {
		return destination;
	}

	public String getAreacode() {
		return areacode;
	}

	public String getRownumber() {
		return rownumber;
	}

	public String getFramenumber() {
		return framenumber;
	}

	public String getPlacenumber() {
		return placenumber;
	}

	public void setAreacode(String areacode) {
		this.areacode = areacode;
	}

	public void setRownumber(String rownumber) {
		this.rownumber = rownumber;
	}

	public void setFramenumber(String framenumber) {
		this.framenumber = framenumber;
	}

	public void setPlacenumber(String placenumber) {
		this.placenumber = placenumber;
	}

	public RepertoryInPO(String id,String num, String time, String destination,
			String areacode, String rownumber, String framenumber,
			String placenumber,CheckType type) {
		super();
		this.id=id;
		this.num = num;
		this.time = time;
		this.destination = destination;
		this.areacode = areacode;
		this.rownumber = rownumber;
		this.framenumber = framenumber;
		this.placenumber = placenumber;
		this.setCheckType(type);
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
}
