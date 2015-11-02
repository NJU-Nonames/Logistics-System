package dataservice.logisticsdataservice;

import po.list.TransShipmentListPO;


public interface TransShipmentDataService {
	/**
	 * 生成中转单
	 * @param transShipment
	 * @return
	 */
	public boolean addShiplist(TransShipmentListPO transShipment);
}
