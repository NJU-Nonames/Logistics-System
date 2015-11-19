package dataservice.moneyInformation;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;

import po.agency.AgencyPO;
import po.agency.BankAccountPO;
import po.agency.TruckPO;
import po.moneyInfomation.BaseDataSettingPO;
import po.repertory.RepertoryInfoPO;




public interface BaseDataSettingDataService extends Remote{
	
	
	/**
	 * 财务人员开始期初建账操作，输入机构信息
	 * 
	 * @param institutionPO
	 * @return
	 */
	public boolean addInstitutionInfo(AgencyPO agencyPO)throws RemoteException;
	
	/**
	 * 期初建账操作，输入库存信息
	 * 
	 * @param commodityInfoPO
	 * @return
	 */
	public boolean addCommodityInfo(RepertoryInfoPO repertoryPO)throws RemoteException;
	
	/**
	 * 期初建账，输入车辆信息
	 * @param truck
	 * @return
	 */
	public boolean addTruckInfo(TruckPO truck)throws RemoteException;
	
	/**
	 * 无基础期初建账操作，输入财务信息
	 * 
	 * @param financeInfoPO
	 * @return
	 */
	public boolean addFinanceInfo(BankAccountPO bankAccountPO)throws RemoteException;
	
	/**
	 * 显示最近一次期初建账信息
	 * @return
	 */
	public BaseDataSettingPO show()throws RemoteException;
}