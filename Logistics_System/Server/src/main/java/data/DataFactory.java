/**
 * 2015年11月12日
 *author:
 *description:数据工厂，用于实现RMI通信
 */
package data;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import rmiImpl.agency.AgencyDataImpl;
import rmiImpl.agency.BankAccountDataImpl;
import rmiImpl.agency.DriverDataImpl;
import rmiImpl.agency.StaffDataImpl;
import rmiImpl.agency.TruckDataImpl;
import rmiImpl.constantinfo.ConstantDataImpl;
import rmiImpl.list.DeliveringListDataImpl;
import rmiImpl.list.HallArrivalListDataImpl;
import rmiImpl.list.LoadListDataImpl;
import rmiImpl.list.OrderListDataImpl;
import rmiImpl.list.TransArrivalListDataImpl;
import rmiImpl.list.TransShipmentListDataImpl;
import rmiImpl.moneyInformation.BaseDataSettingDataImpl;
import rmiImpl.moneyInformation.MoneyInListDataImpl;
import rmiImpl.moneyInformation.MoneyOutListDataImpl;
import rmiImpl.receiver.ReceiverDataImpl;
import rmiImpl.repertory.RepertoryInDataImpl;
import rmiImpl.repertory.RepertoryInfoDataImpl;
import rmiImpl.repertory.RepertoryOutDataImpl;
import rmiImpl.system.SystemLogDataImpl;
import rmiImpl.system.UserDataImpl;
import dataservice.DataFactoryService;
import dataservice.agency.AgencyDataService;
import dataservice.agency.BankAccountDataService;
import dataservice.agency.DriverDataService;
import dataservice.agency.StaffDataService;
import dataservice.agency.TruckDataService;
import dataservice.constantinfo.ConstantDataService;
import dataservice.list.DeliveringListDataService;
import dataservice.list.HallArrivalListDataService;
import dataservice.list.LoadListDataService;
import dataservice.list.OrderListDataService;
import dataservice.list.TransArrivalListDataService;
import dataservice.list.TransShipmentListDataService;
import dataservice.moneyInformation.BaseDataSettingDataService;
import dataservice.moneyInformation.MoneyInListDataService;
import dataservice.moneyInformation.MoneyOutListDataService;
import dataservice.receiver.ReceiverDataService;
import dataservice.repertory.RepertoryInDataService;
import dataservice.repertory.RepertoryInfoDataService;
import dataservice.repertory.RepertoryOutDataService;
import dataservice.system.SystemLogDataService;
import dataservice.system.UserDataService;

/**
 * @author 谭期友
 *
 */
public class DataFactory extends UnicastRemoteObject implements DataFactoryService, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 3287244603999423897L;

	//必须定义构造方法，因为它必须抛出RemoteException异常
	public DataFactory() throws RemoteException {
		super();
	}

	public SystemLogDataService getSystemLogDataService()throws RemoteException {
		return new SystemLogDataImpl();
	}

	public UserDataService getUserDataService() throws RemoteException {
		return new UserDataImpl();
	}

	public AgencyDataService getAgencyDataService() throws RemoteException {
		
		return new AgencyDataImpl();
	}

	public BankAccountDataService getBankAccountDataService()
			throws RemoteException {
	
		return new BankAccountDataImpl();
	}

	public DriverDataService getDriverDataService() throws RemoteException {

		return new DriverDataImpl();
	}

	public StaffDataService getStaffDataService() throws RemoteException {

		return new StaffDataImpl();
	}

	public TruckDataService getTruckDataService() throws RemoteException {

		return new TruckDataImpl();
	}

	public ConstantDataService getConstantDataService() throws RemoteException {

		return new ConstantDataImpl();
	}

	public DeliveringListDataService getDeliveringDataService()
			throws RemoteException {
	
		return new DeliveringListDataImpl();
	}

	public HallArrivalListDataService getHallArrivalDataService()
			throws RemoteException {

		return new HallArrivalListDataImpl();
	}

	public LoadListDataService getLoadListDataService() throws RemoteException {

		return new LoadListDataImpl();
	}

	public OrderListDataService getOrderListDataService()
			throws RemoteException {
	
		return new OrderListDataImpl();
	}

	public TransArrivalListDataService getTransArrivalListDataService()
			throws RemoteException {

		return new TransArrivalListDataImpl();
	}

	public TransShipmentListDataService getTransShipmentDataService()
			throws RemoteException {

		return new TransShipmentListDataImpl();
	}

	public BaseDataSettingDataService getBaseDataSettingDataService()
			throws RemoteException {

		return new BaseDataSettingDataImpl();
	}

	public MoneyInListDataService getMoneyInListDataService()
			throws RemoteException {

		return new MoneyInListDataImpl();
	}

	public MoneyOutListDataService getMoneyOutListDataService()
			throws RemoteException {

		return new MoneyOutListDataImpl();
	}

	public ReceiverDataService getReceiverDataService() throws RemoteException {

		return new ReceiverDataImpl();
	}

	public RepertoryInDataService getRepertoryInDataService()
			throws RemoteException {
	
		return new RepertoryInDataImpl();
	}

	public RepertoryOutDataService getRepertoryDataService()
			throws RemoteException {

		return new RepertoryOutDataImpl();
	}

	public RepertoryInfoDataService getRepertoryInfoDataService()
			throws RemoteException {

		return new RepertoryInfoDataImpl();
	}
	
}
