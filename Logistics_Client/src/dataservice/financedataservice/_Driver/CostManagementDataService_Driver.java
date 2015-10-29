package dataservice.financedataservice._Driver;

import po.MoneyOutListPO;
import dataservice.financedataservice.CostManagementDataService;

public class CostManagementDataService_Driver {
public void drive(CostManagementDataService costManagementDataService){
	costManagementDataService.createMoneyOutlist(new MoneyOutListPO("2015-10-26", 100, "张三", "111000", "现金", null));
}
}
