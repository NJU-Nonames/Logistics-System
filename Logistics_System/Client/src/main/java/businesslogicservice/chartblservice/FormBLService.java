/**
 * 2015年10月23日
 *description:FormBL接口，用户获取统计报表的逻辑接口
 */
package businesslogicservice.chartblservice;

import java.util.ArrayList;

import utility.ChartType;
import vo.ListVO;
import vo.MoneyInformationListVO;



/**
 * @author 谭期友
 * 2015-10-23修改 王家玮
 *
 */
public interface FormBLService {
	
	
	/**
	 * 该方法需要实现对每天的成本监控，包括当天的总支出与总收入与净利润
	 * 前置条件：财务人员或总经理已经登陆，申请查看成本收益表
	 * 后置条件: 返回成本收益信息
	 * @param start_day
	 * @param end_day
	 * @return 返回成本收益MoneyInfomationListVO
	 */
	public ArrayList<MoneyInformationListVO> getCostandBenefitChart(String start_day, String end_day);
	
	/**
	 * 该方法需要返回查看日期内的所有付款信息与收款信息
	 * 前置条件：财务人员或总经理已经登陆，申请查看经营情况表
	 * 后置条件：返回经营情况表
	 * @param start_day
	 * @param end_day
	 * @return 内容为MoneyInlistVO和MoneyOutlistVO的集合
	 */
	public ArrayList<? super ListVO> getBusinessCircumstanceChart(String start_day, String end_day);
	
	/**
	 * 前置条件：用户已登录，申请打印导出报表
	 * 后置条件：导出报表至指定路径
	 * @param strat_day
	 * @param end_day
	 * @param path 导出路径
	 * @param chartType
	 */
	public void exportChart(String strat_day,String end_day,ChartType chartType,String path);
}
