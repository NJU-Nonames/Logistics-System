/**
 * 2015年10月23日
 *author:
 *description:审判单据
 */
package dataservice.chartdataservice;

import java.util.ArrayList;

import po.ListPO;


/**
 * @author 谭期友
 *
 */
public interface CheckDataService {
	/**
	 * 前置条件：总经理已经登陆
	 * 后置条件:更新单据
	 * @param arr
	 * @return 操作是否成功
	 */
	public boolean Check(ArrayList<ListPO> arr);
}
