/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.financeblservice._stub;

import vo.MoneyOutListVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.financeblservice.CostManagementBLService;

/**
 * @author Administrator
 *
 */
public class CostManagementBLService_Stub implements CostManagementBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.CostManagementBLService#createMoneyOutlist(vo.MoneyOutListVO)
	 */
	@Override
	public ResultMessage createMoneyOutlist(MoneyOutListVO moneyOut) {
		// TODO 自动生成的方法存根
		System.out.println("创建成功");
		return new ResultMessage(true, null);
	}

}
