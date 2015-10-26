/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._stub;

import po.RepertoryInPO;
import po.RepertoryInfoPO;
import po.RepertoryOutPO;
import dataservice.logisticsdataservice.RepertoryDataService;

/**
 * @author 谭期友
 *
 */
public class RepertoryDataService_Stub implements RepertoryDataService{

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.RepertoryDataService#inputRepertory(po.RepertoryInPO)
	 */
	public boolean inputRepertory(RepertoryInPO repertoryIn) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.RepertoryDataService#outputRepertory(po.RepertoryOutPO)
	 */
	public boolean outputRepertory(RepertoryOutPO repertoryOut) {
		System.out.println("创建成功！");
		return true;
	}

	/* （非 Javadoc）
	 * @see dataservice.logisticsdataservice.RepertoryDataService#showRepertory(java.lang.String, java.lang.String)
	 */
	public RepertoryInfoPO showRepertory(String start_time, String end_time) {
		System.out.println("创建成功！");
		return new RepertoryInfoPO(0, 0, 0, null);
	}

}
