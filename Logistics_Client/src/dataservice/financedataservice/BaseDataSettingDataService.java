package dataservice.financedataservice;

import po.AgencyPO;
import po.BankAccountPO;
import po.RepertoryPO;
import po.TruckPO;




public interface BaseDataSettingDataService {
	
	
	/**
	 * 财务人员开始期初建账操作，输入机构信息
	 * 
	 * @param institutionPO
	 * @return
	 */
	public boolean addInstitutionInfo(AgencyPO agencyPO);
	
	/**
	 * 期初建账操作，输入库存信息
	 * 
	 * @param commodityInfoPO
	 * @return
	 */
	public boolean addCommodityInfo(RepertoryPO repertoryPO);
	
	/**
	 * 期初建账，输入车辆信息
	 * @param truck
	 * @return
	 */
	public boolean addTruckInfo(TruckPO truck);
	
	/**
	 * 无基础期初建账操作，输入财务信息
	 * 
	 * @param financeInfoPO
	 * @return
	 */
	public boolean addFinanceInfo(BankAccountPO bankAccountPO);
}