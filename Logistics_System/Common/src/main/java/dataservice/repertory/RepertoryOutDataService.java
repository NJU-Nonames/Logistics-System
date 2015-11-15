package dataservice.repertory;

import java.io.Serializable;
import java.util.ArrayList;

import po.repertory.RepertoryOutPO;

public interface RepertoryOutDataService extends Serializable{
	
	public boolean add(RepertoryOutPO repertoryOut);
	
	public boolean delete(RepertoryOutPO repertoryOut);
	
	public boolean update(RepertoryOutPO repertoryOut);
	
	public RepertoryOutPO findOnID(String id);
	
	public ArrayList<RepertoryOutPO> findOnTime(String time);
	
	/**
	 * 返回出库单PO集合
	 * @param start_day
	 * @param end_day
	 * @return MonryInlistPO
	 */
	public ArrayList<RepertoryOutPO> showAll(String start_day, String end_day);
	
}


