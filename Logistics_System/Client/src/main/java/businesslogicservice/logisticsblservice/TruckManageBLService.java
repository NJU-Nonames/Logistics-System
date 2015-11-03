/**
 *2015年10月22日
 *author:tdy
 *discirption:货车信息管理 
 */
package businesslogicservice.logisticsblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.TruckVO;

public interface TruckManageBLService {
	
	/**
	 * 显示营业厅车辆
	 * @param Hall_Num
	 * @return
	 */
	public ArrayList<TruckVO> show(String Hall_Num);
	
	/**营业厅业务员更改货车信息
	 * @param 货车实体类
	 */
	public ResultMessage update(TruckVO truck);

	/**营业厅业务员删除货车
	 * 前置条件：开始删除货车
	 * 后置条件:显示删除某货车
	 * @param 货车实体类
	 */
	public ResultMessage delete(TruckVO truck);
	
	/**营业厅业务员增加货车
	 * 前置条件：开始添加货车
	 * 后置条件:显示添加货车的详细信息，系统存储
	 * @param 货车实体类
	 */
	public ResultMessage add(TruckVO truck);
	
	/**
	 * 通过编号查找
	 * @param num
	 * @return
	 */
	public TruckVO find(String num);
	
}
