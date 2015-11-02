package dataservice.logisticsdataservice;

import java.util.ArrayList;

import po.agency.DriverPO;


public interface DriverManagementDataService {
	
	public ArrayList<DriverPO> show(String Hall_Num);
	/**营业厅业务员更改司机信息
	 * 前置条件：开始更改司机信息任务
	 * 后置条件:更新司机的详细信息，系统存储
	 * @param 司机实体类
	 */
	public boolean update(DriverPO driver);
	/**营业厅业务员删除司机
	 * 前置条件：开始删除司机
	 * 后置条件:显示删除某司机
	 * @param 司机实体类
	 */
	public boolean delete(DriverPO driver);
	/**营业厅业务员增加司机
	 * 前置条件：开始添加司机
	 * 后置条件:显示添加司机的详细信息，系统存储
	 * @param 司机实体类
	 */
	public boolean add(DriverPO driver);
	
	/**
	 * 通过编号查找
	 * @param num
	 * @return
	 */
	public DriverPO find(String num);
}
