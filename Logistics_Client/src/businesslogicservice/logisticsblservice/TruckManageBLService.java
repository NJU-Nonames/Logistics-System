/**
 *2015年10月22日
 *author:tdy
 *discirption:货车信息管理 
 */
package businesslogicservice.logisticsblservice;

import vo.TruckVO;

public interface TruckManageBLService {
	/**营业厅业务员查看自己营业厅的货车情况
	 * 前置条件：开始查看管理
	 * 后置条件:显示所有货车的情况
	 */
	public void check();
	/**营业厅业务员更改货车信息
	 * 前置条件：开始更改货车信息任务
	 * 后置条件:更新货车的详细信息，系统存储
	 * @param 货车实体类
	 */
	public void update(TruckVO truck);
	/**营业厅业务员删除货车
	 * 前置条件：开始删除货车
	 * 后置条件:显示删除某货车
	 * @param 货车实体类
	 */
	public void delete(TruckVO truck);
	/**营业厅业务员增加货车
	 * 前置条件：开始添加货车
	 * 后置条件:显示添加货车的详细信息，系统存储
	 * @param 货车实体类
	 */
	public void add(TruckVO truck);
	/**营业厅业务员取消管理任务
	 * 前置条件：	营业厅业务员点击取消按钮
	 * 后置条件：	返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelManage();
}
