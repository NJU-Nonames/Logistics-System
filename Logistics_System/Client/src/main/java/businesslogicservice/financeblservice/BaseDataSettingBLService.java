package businesslogicservice.financeblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.AgencyVO;
import vo.BankAccountVO;
import vo.BaseAgencyVO;
import vo.RepertoryInfoVO;
import vo.RepertoryOrderVO;
import vo.StaffVO;
import vo.TruckVO;


public interface BaseDataSettingBLService {
	
	
	/**
	 * 期初建账，点击以后进行建账
	 * @return
	 */
	public ResultMessage init();
	
	/**
	 * 查看期初银行账户信息
	 * @return
	 */
	public ArrayList<BankAccountVO> findBaseAccount();
	
	/**查看期初人员机构信息
	 * @return
	 */
	public ArrayList<BaseAgencyVO> findBaseAgency();
	
	/**查看期初人员信息
	 * @return
	 */
	public ArrayList<StaffVO> findBaseStaff();
	
	/**查看期初车辆信息
	 * @return
	 */
	public ArrayList<TruckVO> findBaseTruck();
	
	/**查看期初库存信息
	 * @return
	 */
	public ArrayList<RepertoryInfoVO> findBaseRepertory();
	
	
}
