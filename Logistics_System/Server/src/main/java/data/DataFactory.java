/**
 * 2015年11月12日
 *author:
 *description:
 */
package data;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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
		// TODO Auto-generated method stub
		return null;
	}

	public BankAccountDataService getBankAccountDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DriverDataService getDriverDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public StaffDataService getStaffDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public TruckDataService getTruckDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ConstantDataService getConstantDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public DeliveringListDataService getDeliveringDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public HallArrivalListDataService getHallArrivalDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public LoadListDataService getLoadListDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public OrderListDataService getOrderListDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public TransArrivalListDataService getTransArrivalListDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public TransShipmentListDataService getTransShipmentDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public BaseDataSettingDataService getBaseDataSettingDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MoneyInListDataService getMoneyInListDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public MoneyOutListDataService getMoneyOutListDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ReceiverDataService getReceiverDataService() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public RepertoryInDataService getRepertoryInDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public RepertoryOutDataService getRepertoryDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public RepertoryInfoDataService getRepertoryInfoDataService()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
