package dataImpl.moneyInformation;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

import po.agency.AgencyPO;
import po.agency.BankAccountPO;
import po.agency.TruckPO;
import po.moneyInfomation.BaseDataSettingPO;
import po.repertory.RepertoryInfoPO;
import dataservice.moneyInformation.BaseDataSettingDataService;

public class BaseDataSettingDataImpl extends UnicastRemoteObject implements BaseDataSettingDataService,Serializable {

	public BaseDataSettingDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void init() throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public ArrayList<BankAccountPO> findBaseAccount() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<AgencyPO> findBaseAgency() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<TruckPO> findBaseTruck() throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<RepertoryInfoPO> findBaseRepertory()
			throws RemoteException {
		// TODO Auto-generated method stub
		return null;
	}



}
