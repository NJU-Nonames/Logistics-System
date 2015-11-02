/**
 * 2015年10月23日
 *author:
 *description:统计报表
 */
package dataservice.chartdataservice;

import java.util.ArrayList;

import po.list.ListPO;
import po.moneyInfomation.MoneyInformationListPO;


/**
 * @author 谭期友
 * 2015-10-23 王家玮修改
 *
 */
public interface FormDataService {
	/**
	 * 前置条件：财务人员或总经理已经登陆并申请查看经营情况表
	 * 后置条件: 返回收款付款PO
	 * @param start_day
	 * @param end_day
	 * @return 只能是MonryInlistPO和MoneyOutlistPO的集合
	 */
	public ArrayList<? super ListPO> getBusinessCircumstanceChart(String start_day, String end_day);
	
	/**
	 * 前置条件： 财务人员或总经理选择查看成本收益表
	 * 后置条件：返回成本收益PO
	 * @param start_day
	 * @param end_day
	 * @return
	 */
	public ArrayList<MoneyInformationListPO> getCostandBenefitChart(String start_day, String end_day);
}
