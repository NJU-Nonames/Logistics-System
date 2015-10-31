package dataservice.logisticsdataservice;

import po.OrderListPO;

public interface SendingPkgDataService {

	/**
	 * 输入寄件单信息
	 * @param orderList
	 * @return
	 */
	public boolean addOrderList(OrderListPO orderList);
}
