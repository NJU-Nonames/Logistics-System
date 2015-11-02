package dataservice.logisticsdataservice;

import po.list.OrderListPO;
import po.receiver.ReceiverPO;

public interface ReceiverPkgDataService {
	
	
	/**
	 * 输入订单id返回订单
	 * @param orderlistId
	 * @return
	 */
	public OrderListPO findOrderlist(String orderlistId);
	
	/**快递员输入签收人相关信息，系统确认收件
	 * 前置条件：	快递员输入签收人的相关信息，系统在生成签收人po类之后由快递员确认是否签收
	 * 后置条件：	签收成功则修改订单相关数据，不成功则不加以修改
	 * @param 	实际签收人
	 * @return	签收是否成功
	 */
	public boolean confirmReceive(ReceiverPO receiver);
}
