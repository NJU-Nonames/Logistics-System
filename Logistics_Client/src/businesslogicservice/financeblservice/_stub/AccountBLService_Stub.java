/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.financeblservice._stub;

import java.util.ArrayList;

import vo.BankAccountVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.financeblservice.AccountBLService;

public class AccountBLService_Stub implements AccountBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.AccountBLService#login(java.lang.String, java.lang.String)
	 */
	public boolean login(String admin, String password) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return true;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.AccountBLService#createCount(vo.BankAccountVO)
	 */
	public ResultMessage createCount(BankAccountVO countVo) {
		// TODO 自动生成的方法存根
		System.out.println("创建成功");
		return new ResultMessage(true, "创建成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.AccountBLService#removeCount(java.lang.String)
	 */
	public ResultMessage removeCount(String name) {
		// TODO 自动生成的方法存根
		System.out.println("删除成功");
		return new ResultMessage(true, "删除成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.AccountBLService#updadaCount(vo.BankAccountVO)
	 */
	public ResultMessage updadaCount(BankAccountVO countVo) {
		// TODO 自动生成的方法存根
		System.out.println("更新成功");
		return new ResultMessage(true, "更新成功");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.AccountBLService#searchCount(java.lang.String)
	 */
	public BankAccountVO searchCount(String keyword) {
		// TODO 自动生成的方法存根
		System.out.println("查找成功");
		return new BankAccountVO(null, null, 0);
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.financeblservice.AccountBLService#show()
	 */
	public ArrayList<BankAccountVO> show() {
		// TODO 自动生成的方法存根
		System.out.println("显示成功");
		ArrayList<BankAccountVO> list=new ArrayList<BankAccountVO>();
		list.add(new BankAccountVO(null, null, 0));
		return list;
	}
	
}
