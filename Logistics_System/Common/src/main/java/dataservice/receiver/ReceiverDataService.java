package dataservice.receiver;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.receiver.ReceiverPO;

public interface ReceiverDataService extends Remote{
	
	/**快递员输入签收人相关信息，系统确认收件
	 * 前置条件：	快递员输入签收人的相关信息，系统在生成签收人po类之后由快递员确认是否签收
	 * 后置条件：	签收成功则修改订单相关数据，不成功则不加以修改
	 * @param 	实际签收人
	 * @return	签收是否成功
	 */
	public void add(ReceiverPO receiver)throws RemoteException;
	
	public ReceiverPO findOnName(String name)throws RemoteException;
	
	public ReceiverPO findOnTime(String time)throws RemoteException;
}
