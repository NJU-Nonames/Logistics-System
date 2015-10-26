/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import java.util.ArrayList;

import po.DriverPO;
import po.TruckPO;
import dataservice.logisticsdataservice.TruckManagementDataService;

/**
 * @author 谭期友
 *
 */
public class TruckManagementDataService_Stub implements TruckManagementDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.TruckManagementDataService#show(java.lang.String)
	 */
	public ArrayList<TruckPO> show(String Hall_Num) {
		System.out.println("创建成功！");
		ArrayList<TruckPO> a = new ArrayList<TruckPO>();
		a.add(new TruckPO(Hall_Num, Hall_Num, Hall_Num, null));
		return a;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.TruckManagementDataService#update(po.TruckPO)
	 */
	public boolean update(TruckPO truck) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.TruckManagementDataService#delete(po.TruckPO)
	 */
	public boolean delete(TruckPO truck) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.TruckManagementDataService#add(po.TruckPO)
	 */
	public boolean add(TruckPO truck) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.TruckManagementDataService#find(java.lang.String)
	 */
	public TruckPO find(String num) {
		System.out.println("创建成功！");
		return new TruckPO(num, num, num, null);
	}

}
