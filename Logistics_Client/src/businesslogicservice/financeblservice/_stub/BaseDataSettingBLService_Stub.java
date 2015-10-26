/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.financeblservice._stub;

import vo.AgencyVO;
import vo.BankAccountVO;
import vo.RepertoryInfoVO;
import vo.TruckVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.financeblservice.BaseDataSettingBLService;


public class BaseDataSettingBLService_Stub implements BaseDataSettingBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.BaseDataSettingBLService#restart()
	 */
	@Override
	public ResultMessage restart() {
		// TODO 自动生成的方法存根
		System.out.println("重启成功");
		return new ResultMessage(true, "重启成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.BaseDataSettingBLService#addInstitutionInfo(vo.AgencyVO)
	 */
	@Override
	public ResultMessage addInstitutionInfo(AgencyVO agencyVO) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.BaseDataSettingBLService#addCommodityInfo(vo.RepertoryInfoVO)
	 */
	@Override
	public ResultMessage addCommodityInfo(RepertoryInfoVO repertoryVO) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.BaseDataSettingBLService#addTruckInfo(vo.TruckVO)
	 */
	@Override
	public ResultMessage addTruckInfo(TruckVO truck) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.BaseDataSettingBLService#addFinanceInfo(vo.BankAccountVO)
	 */
	@Override
	public ResultMessage addFinanceInfo(BankAccountVO bankAccountVO) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功");
	}

}
