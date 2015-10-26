/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import java.util.ArrayList;

import po.DriverPO;
import dataservice.logisticsdataservice.DriverManagementDataService;

/**
 * @author 谭期友
 *
 */
public class DriverManagementDataService_Stub implements DriverManagementDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.DriverManagementDataService#show(java.lang.String)
	 */
	public ArrayList<DriverPO> show(String Hall_Num) {
		System.out.println("创建成功！");
		ArrayList<DriverPO> a = new ArrayList<DriverPO>();
		a.add(new DriverPO(Hall_Num, Hall_Num, Hall_Num, Hall_Num, Hall_Num, Hall_Num, Hall_Num));
		return a;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.DriverManagementDataService#update(po.DriverPO)
	 */
	public boolean update(DriverPO driver) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.DriverManagementDataService#delete(po.DriverPO)
	 */
	public boolean delete(DriverPO driver) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.DriverManagementDataService#add(po.DriverPO)
	 */
	public boolean add(DriverPO driver) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.DriverManagementDataService#find(java.lang.String)
	 */
	public DriverPO find(String num) {
		System.out.println("创建成功！");
		return new DriverPO(num, num, num, num, num, num, num);
	}

}
