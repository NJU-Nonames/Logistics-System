/**
 *2015年10月22日
 *author:tdy
 *description:人员机构功能调整的逻辑层接口 
 */
package businesslogicservice.informationchangeblservice;

public interface PeopleAgencyBLService {
	/**总经理进行的人员工资调整
	 * 前置条件：开始了人员工资调整任务
	 * 后置条件：相关人员有了新的工资方案
	 * @param 要调整的用户编号
	 * @param 新的工资方案
	 * @return	调整是否成功
	 */             
	public boolean salaryManage(String userID,String salary);
	/**总经理进行的机构调整
	 * 前置条件：	开始了机构管理任务
	 * 后置条件：	有了新的机构方案
	 * @param 	新的机构方案
	 * @return	调整是否成功	
	 */
	public boolean AgencyManage(String newPlan);
	/**总经理取消管理任务
	 * 前置条件：	总经理点击取消按钮
	 * 后置条件：	返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelManage();
}
