/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import vo.MoneyInListVO;
import businesslogicservice.financeblservice.SettlementManageBLService;

public class SettlementManageBLService_Stub implements SettlementManageBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.SettlementManageBLService#search(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<MoneyInListVO> search(String start_day, String end_day,
			String hall_id) {
		// TODO 自动生成的方法存根
		System.out.println("搜寻成功"); 
		ArrayList<MoneyInListVO> list =new ArrayList<MoneyInListVO>();
		list.add(new MoneyInListVO(null, 0, null, null));
		return list;
	}

}
