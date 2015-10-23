/**
 *2015年10月22日
 *author:tdy
 *description:营业厅业务员进行的司机管理 
 */
package businesslogicservice.logisticsblservice;

import vo.DriverVO;

public interface DriverManageBLService {
	/**营业厅业务员查看自己营业厅的司机情况
	 * 前置条件：开始查看任务
	 * 后置条件:显示所有司机的情况
	 */
	public void check();
	/**营业厅业务员更改司机信息
	 * 前置条件：开始更改司机信息任务
	 * 后置条件:更新司机的详细信息，系统存储
	 * @param 司机实体类
	 */
	public void update(DriverVO drive);
	/**营业厅业务员删除司机
	 * 前置条件：开始删除司机
	 * 后置条件:显示删除某司机
	 * @param 司机实体类
	 */
	public void delete(DriverVO drive);
	/**营业厅业务员增加司机
	 * 前置条件：开始添加司机
	 * 后置条件:显示添加司机的详细信息，系统存储
	 * @param 司机实体类
	 */
	public void add(DriverVO drive);
	/**营业厅业务员取消管理任务
	 * 前置条件：	营业厅业务员点击取消按钮
	 * 后置条件：	返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelManage();
}
