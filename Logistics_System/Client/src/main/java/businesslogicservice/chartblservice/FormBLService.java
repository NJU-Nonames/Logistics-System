/**
 * 2015年10月23日
 *description:FormBL接口，用户获取统计报表的逻辑接口
 */
package businesslogicservice.chartblservice;

import java.util.ArrayList;

import utility.ChartType;
import vo.ListVO;
import vo.MoneyInformationListVO;
import vo.MoneyItemVO;



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
	public ArrayList<MoneyItemVO> getBusinessCircumstanceChart(String start_day, String end_day);
	
	/**
	 * 导出成本收益表
	 * @param 起始日期
	 * @param 终止日期
	 * @param 路径
	 */
	public void exportCostandBenefitChart(String start_day,String end_day,String path);
	/**
	 * 导出经营情况表
	 * @param 起始日期
	 * @param 终止日期
	 * @param 路径
	 */
	public void exportBusinessCircumstanceChart(String start_day,String end_day,String path);
	
}
