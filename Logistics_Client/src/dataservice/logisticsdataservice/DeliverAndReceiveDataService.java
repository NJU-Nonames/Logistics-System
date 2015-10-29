package dataservice.logisticsdataservice;

import po.DeliveringListPO;
import po.HallArrivalListPO;

public interface DeliverAndReceiveDataService {
	/**
	 * 营业厅生成营业厅到达单
	 * @param hallArrivalList
	 * @return
	 */
	public boolean addHallArrivalList(HallArrivalListPO hallArrivalList);
	
	/**
	 * 营业厅生成派件单
	 * @param deliveringList
	 * @return
	 */
	public boolean addDeliveringList (DeliveringListPO deliveringList);
}
