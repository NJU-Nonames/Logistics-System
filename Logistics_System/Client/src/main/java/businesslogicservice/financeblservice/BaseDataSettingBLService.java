package businesslogicservice.financeblservice;

import utilitybl.ResultMessage;
import vo.AgencyVO;
import vo.BankAccountVO;
import vo.RepertoryInfoVO;
import vo.TruckVO;


public interface BaseDataSettingBLService {
	/**
	 * 期初建账，输入全新的机构，库存，财务信息
	 * 
	 * @return
	 */
	public ResultMessage restart();
	
	/**
	 * 财务人员开始期初建账操作，输入机构信息
	 * 
	 * @param institutionVO
	 * @return
	 */
	public ResultMessage addInstitutionInfo(AgencyVO agencyVO);
	
	/**
	 * 期初建账操作，输入库存信息
	 * 
	 * @param commodityInfoVO
	 * @return
	 */
	public ResultMessage addCommodityInfo(RepertoryInfoVO repertoryVO);
	
	/**
	 * 期初建账，输入车辆信息
	 * @param truck
	 * @return
	 */
	public ResultMessage addTruckInfo(TruckVO truck);
	
	/**
	 * 无基础期初建账操作，输入财务信息
	 * 
	 * @param financeInfoVO
	 * @return
	 */
	public ResultMessage addFinanceInfo(BankAccountVO bankAccountVO);
}
