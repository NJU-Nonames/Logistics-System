/**
 *2015年10月22日
 *author:tdy
 *description:营业厅业务员进行的司机管理 
 */
package businesslogicservice.logisticsblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.DriverVO;

public interface DriverManageBLService {
	
	public ArrayList<DriverVO> show(String Hall_Num);
	
	/**营业厅业务员更改司机信息
	 */
	public ResultMessage update(DriverVO driver);
	
	/**营业厅业务员删除司机
	 * @param 司机实体类
	 */
	public ResultMessage delete(DriverVO driver);
	
	/**营业厅业务员增加司机
	 * @param 司机实体类
	 */
	public ResultMessage add(DriverVO driver);
	
	/**
	 * 通过编号查找
	 * @param num
	 * @return
	 */
	public DriverVO find(String num);
}
