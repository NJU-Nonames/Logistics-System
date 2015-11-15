package dataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

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

public interface DataFactoryService extends Remote{
	//所有远程接口使用到的参数类型和返回值类型都必须可序列化。这个类里所有函数的返回类型都必须可序列化
	public SystemLogDataService getSystemLogDataService()throws RemoteException;
	public UserDataService getUserDataService()throws RemoteException;
	public AgencyDataService getAgencyDataService()throws RemoteException;
	public BankAccountDataService getBankAccountDataService()throws RemoteException;
	public DriverDataService getDriverDataService()throws RemoteException;
	public StaffDataService getStaffDataService()throws RemoteException;
	public TruckDataService getTruckDataService()throws RemoteException;
	public ConstantDataService getConstantDataService() throws RemoteException;
	public DeliveringListDataService getDeliveringDataService() throws RemoteException;
	public HallArrivalListDataService getHallArrivalDataService() throws RemoteException;
	public LoadListDataService getLoadListDataService() throws RemoteException;
	public OrderListDataService getOrderListDataService() throws RemoteException;
	public TransArrivalListDataService getTransArrivalListDataService() throws RemoteException;
	public TransShipmentListDataService getTransShipmentDataService() throws RemoteException;
	public BaseDataSettingDataService getBaseDataSettingDataService() throws RemoteException;
	public MoneyInListDataService getMoneyInListDataService()throws RemoteException;
	public MoneyOutListDataService getMoneyOutListDataService()throws RemoteException;
	public ReceiverDataService getReceiverDataService()throws RemoteException;
	public RepertoryInDataService getRepertoryInDataService()throws RemoteException;
	public RepertoryOutDataService getRepertoryDataService()throws RemoteException;
	public RepertoryInfoDataService getRepertoryInfoDataService()throws RemoteException;
	
	
	
}