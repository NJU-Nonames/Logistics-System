/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.chartblservice._driver;

import businesslogicservice.chartblservice.FormBLService;

/**
 * @author Administrator
 *
 */
public class FormBLService_Driver {
	public void drive(FormBLService formBLService){
		formBLService.getBusinessCircumstanceChart(null, null);
		formBLService.exportChart(null, null, null, null);
		formBLService.getCostandBenefitChart(null, null);
		formBLService.isFormatRight(null, null, null);
	}
}
