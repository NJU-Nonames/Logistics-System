package dataservice.logisticsdataservice;

import po.TransArrivalListPO;


public interface TransferCentreRecieveDataService {
	
	/**
	 * 生成中转中心到达单
	 * @param transArrivalList
	 * @return
	 */
	public boolean addTransArrivalList(TransArrivalListPO transArrivalList);
}
