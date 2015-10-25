package dataservice.logisticsdataservice;

import po.TransShipmentListPO;


public interface TransShipmentDataService {
	/**
	 * 生成中转单
	 * @param transShipment
	 * @return
	 */
	public boolean createShiplist(TransShipmentListPO transShipment);
}
