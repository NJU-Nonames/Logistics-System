/**
 *2015年10月23日
 *author:tdy
 *description:距离价格常量变更 
 */
package businesslogicservice.informationchangeblservice;

public interface ConstantManageBLService {
	/**总经理对城市距离常量的管理
	 * 前置条件：开启了距离常量管理任务
	 * 后置条件：两个城市之间有了新的距离
	 * @param newDistance
	 * @param cityA
	 * @param cityB
	 */
	public void distanceManage(String newDistance,String cityA,String cityB);
	/**总经理对价格常量的管理
	 * 前置条件：开启了距离常量管理任务
	 * 后置条件：新的距离常量
	 * @param newDistance
	 * @param otherInformation
	 */
	public void priceManage(String newPrice,String otherInformation);
	/**总经理取消管理
	 * 前置条件：	点击取消按钮
	 * 后置条件:	系统返回上一层界面
	 * @return	取消操作是否成功
	 */
	public boolean cancelManage();
}
