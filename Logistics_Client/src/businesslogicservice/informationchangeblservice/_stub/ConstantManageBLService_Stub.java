/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.informationchangeblservice._stub;

import vo.DistanceChartVO;
import vo.PriceChartVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.informationchangeblservice.ConstantManageBLService;

public class ConstantManageBLService_Stub implements ConstantManageBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.ConstantManageBLService#addCity(java.lang.String)
	 */
	@Override
	public ResultMessage addCity(String name) {
		// TODO 自动生成的方法存根
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功") ;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.ConstantManageBLService#showDistanceChart()
	 */
	@Override
	public DistanceChartVO showDistanceChart() {
		// TODO 自动生成的方法存根
		System.out.println("显示成功");
		return new DistanceChartVO(null);
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.ConstantManageBLService#showPriceChart()
	 */
	@Override
	public PriceChartVO showPriceChart() {
		// TODO 自动生成的方法存根
		System.out.println("显示成功");
		return new PriceChartVO(0, 0, 0, 0, 0, 0);
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.ConstantManageBLService#submitDistance(java.lang.String, java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage submitDistance(String newDistance, String cityA,
			String cityB) {
		// TODO 自动生成的方法存根
		System.out.println("提交成功");
		return new ResultMessage(true, "提交成功 ");
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.informationchangeblservice.ConstantManageBLService#submitPrice(java.lang.String, java.lang.String)
	 */
	@Override
	public ResultMessage submitPrice(String newPrice, String otherInformation) {
		// TODO 自动生成的方法存根
		System.out.println("提交成功");
		return new ResultMessage(true, "提交成功 ");
	}

}
