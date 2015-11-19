package dataImpl.moneyInformation;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

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

	public boolean addInstitutionInfo(AgencyPO agencyPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addCommodityInfo(RepertoryInfoPO repertoryPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addTruckInfo(TruckPO truck) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addFinanceInfo(BankAccountPO bankAccountPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public BaseDataSettingPO show() {
		// TODO Auto-generated method stub
		return null;
	}

}
