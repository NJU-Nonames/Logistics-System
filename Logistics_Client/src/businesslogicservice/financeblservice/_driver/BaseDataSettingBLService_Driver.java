/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.financeblservice._driver;

import businesslogicservice.financeblservice.BaseDataSettingBLService;

/**
 * @author Administrator
 *
 */
public class BaseDataSettingBLService_Driver {
	public void drive(BaseDataSettingBLService baseDataSettingBLService){
		baseDataSettingBLService.addCommodityInfo(null);
		baseDataSettingBLService.addFinanceInfo(null);
		baseDataSettingBLService.addInstitutionInfo(null);
		baseDataSettingBLService.addTruckInfo(null);
		baseDataSettingBLService.restart();
	}
}
