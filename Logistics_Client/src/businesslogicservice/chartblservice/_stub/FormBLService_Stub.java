/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.chartblservice._stub;

import java.util.ArrayList;

import vo.ListVO;
import vo.MoneyInformationListVO;
import vo.OrderListVO;
import businesslogic.utilitybl.ChartType;
import businesslogicservice.chartblservice.FormBLService;

public class FormBLService_Stub implements FormBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.FormBLService#isFormatRight(java.lang.String, java.lang.String, businesslogic.utilitybl.ChartType)
	 */
	@Override
	public boolean isFormatRight(String start_day, String end_day,
			ChartType chartType) {
		// TODO 自动生成的方法存根
		System.out.println("验证成功");
		return true;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.FormBLService#getCostandBenefitChart(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<MoneyInformationListVO> getCostandBenefitChart(
			String start_day, String end_day) {
		// TODO 自动生成的方法存根
		System.out.println("获得成功");
		ArrayList<MoneyInformationListVO> list = new ArrayList<MoneyInformationListVO>();
		list.add(new MoneyInformationListVO(null, 0, 0, 0));
		return list;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.FormBLService#getBusinessCircumstanceChart(java.lang.String, java.lang.String)
	 */
	@Override
	public ArrayList<ListVO> getBusinessCircumstanceChart(String start_day,
			String end_day) {
		// TODO 自动生成的方法存根
		System.out.println("获得成功");
		ArrayList<ListVO> list = new ArrayList<ListVO>();
		list.add(new OrderListVO(null, null, null, null, null, 0, 0, null, null, null, 0, null));
		return list;
	}

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.FormBLService#exportChart(java.lang.String, java.lang.String, businesslogic.utilitybl.ChartType, java.lang.String)
	 */
	@Override
	public void exportChart(String strat_day, String end_day,
			ChartType chartType, String path) {
		// TODO 自动生成的方法存根
		System.out.println("输出成功");
		
	}

}
