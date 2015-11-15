package dataservice.repertory;

import java.io.Serializable;
import java.util.ArrayList;

import po.repertory.RepertoryInPO;

public interface RepertoryInDataService extends Serializable{
		
		public boolean add(RepertoryInPO repertoryIn);
		
		public boolean delete(RepertoryInPO repertoryIn);
		
		public boolean update(RepertoryInPO repertoryIn);
		
		public RepertoryInPO findOnID(String id);
		
		public ArrayList<RepertoryInPO> findOnTime(String time);
		
		/**
		 * 返回入库单PO集合
		 * @param start_day
		 * @param end_day
		 * @return MonryInlistPO
		 */
		public ArrayList<RepertoryInPO> showAll(String start_day, String end_day);
		
	}

