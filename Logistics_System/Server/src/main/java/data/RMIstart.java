package data;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;

import dataImpl.agency.AgencyDataImpl;
import dataImpl.agency.BankAccountDataImpl;
import dataImpl.agency.DriverDataImpl;
import dataImpl.agency.StaffDataImpl;
import dataImpl.agency.TruckDataImpl;
import dataImpl.constantinfo.ConstantDataImpl;
import dataImpl.list.DeliveringListDataImpl;
import dataImpl.list.HallArrivalListDataImpl;
import dataImpl.list.LoadListDataImpl;
import dataImpl.list.OrderListDataImpl;
import dataImpl.list.TransArrivalListDataImpl;
import dataImpl.list.TransShipmentListDataImpl;
import dataImpl.moneyInformation.BaseDataSettingDataImpl;
import dataImpl.moneyInformation.MoneyInListDataImpl;
import dataImpl.moneyInformation.MoneyOutListDataImpl;
import dataImpl.repertory.RepertoryInDataImpl;
import dataImpl.repertory.RepertoryInfoDataImpl;
import dataImpl.repertory.RepertoryOutDataImpl;
import dataImpl.system.SystemLogDataImpl;
import dataImpl.system.UserDataImpl;
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
import dataservice.repertory.RepertoryInDataService;
import dataservice.repertory.RepertoryInfoDataService;
import dataservice.repertory.RepertoryOutDataService;
import dataservice.system.SystemLogDataService;
import dataservice.system.UserDataService;

public class RMIstart {
	
	/**
	 * 端口号
	 */
	private static final int PORT=40000;
	
	/**
	 * 服务器ip地址
	 */
	private static final String IP="172.26.204.9";
	
	
	
	public static void init(){

		
		try {
			//注册RMI通信服务器端
			System.setProperty("java.rmi.server.hostname",IP);
			//注册通讯端口
			LocateRegistry.createRegistry(PORT);
			//创建实现类
			AgencyDataService AgencyDataImpl=new AgencyDataImpl();
			BankAccountDataService BankAccountDataImpl=new BankAccountDataImpl();
			DriverDataService DriverDataImpl=new DriverDataImpl();
			StaffDataService StaffDataImpl=new StaffDataImpl();
			TruckDataService TruckDataImpl=new TruckDataImpl();
			ConstantDataService ConstantDataImpl=new ConstantDataImpl();
			DeliveringListDataService DeliveringListDataImpl=new DeliveringListDataImpl();
			HallArrivalListDataService HallArrivalListDataImpl=new HallArrivalListDataImpl();
			LoadListDataService LoadListDataImpl=new LoadListDataImpl();
			OrderListDataService OrderListDataImpl=new OrderListDataImpl();
			TransArrivalListDataService TransArrivalListDataImpl=new TransArrivalListDataImpl();
			TransShipmentListDataService TransShipmentListDataImpl=new TransShipmentListDataImpl();
			BaseDataSettingDataService BaseDataSettingDataImpl=new BaseDataSettingDataImpl();
			MoneyInListDataService MoneyInListDataImpl=new MoneyInListDataImpl();
			MoneyOutListDataService MoneyOutListDataImpl=new MoneyOutListDataImpl();
			RepertoryInDataService RepertoryInDataImpl=new RepertoryInDataImpl();
			RepertoryOutDataService RepertoryOutDataImpl=new RepertoryOutDataImpl();
			RepertoryInfoDataService RepertoryInfoDataImpl=new RepertoryInfoDataImpl();
			UserDataService UserDataImpl=new UserDataImpl();
			SystemLogDataService SystemLogDataImpl=new SystemLogDataImpl();
			//注册通讯路径，把所有的Impl实现类注册到RMI服务器上
			Naming.rebind("rmi://"+IP+":"+PORT+"/UserDataService", UserDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/AgencyDataService", AgencyDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/SystemLogDataService", SystemLogDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/BankAccountDataService", BankAccountDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/DriverDataService", DriverDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/StaffDataService", StaffDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/TruckDataService", TruckDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/ConstantDataService", ConstantDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/DeliveringListDataService", DeliveringListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/HallArrivalListDataService", HallArrivalListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/LoadListDataService", LoadListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/OrderListDataService", OrderListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/TransArrivalListDataService", TransArrivalListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/TransShipmentListDataService", TransShipmentListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/BaseDataSettingDataService", BaseDataSettingDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/MoneyInListDataService", MoneyInListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/MoneyOutListDataService", MoneyOutListDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/RepertoryInDataService", RepertoryInDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/RepertoryOutDataService", RepertoryOutDataImpl);
			Naming.rebind("rmi://"+IP+":"+PORT+"/RepertoryInfoDataService", RepertoryInfoDataImpl);
			
			
			
		} catch (RemoteException e) {
			
			e.printStackTrace();
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}

		
	}

}
