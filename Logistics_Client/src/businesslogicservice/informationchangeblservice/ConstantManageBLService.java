/**
 *2015年10月23日
 *author:tdy
 *description:距离价格常量变更 
 *王家玮 2015-10-24 修改
 */
package businesslogicservice.informationchangeblservice;

import vo.PriceChartVO;
import vo.DistanceChartVO;
import businesslogic.utilitybl.ResultMessage;

public interface ConstantManageBLService {
	
	/**
	 * 添加城市
	 * @param name
	 * @return
	 */
	public ResultMessage addCity(String name);
	
	/**显示城市价格距离情况表
	 * @return
	 */
	public DistanceChartVO showDistanceChart();
	
	/**
	 * 返回价格常量情况表
	 * @return
	 */
	public PriceChartVO showPriceChart();
	
	/**
	 * 若输入符合标准 则调入submit函数
	 * @param newDistance
	 * @param cityA
	 * @param cityB
	 * @return
	 */
	public ResultMessage submitDistance(String newDistance,String cityA,String cityB);
	
	/**
	 *  若输入符合标准 则调入submit函数
	 * @param newPrice
	 * @param otherInformation
	 * @return
	 */
	public ResultMessage submitPrice(String newPrice,String otherInformation);
	

}
