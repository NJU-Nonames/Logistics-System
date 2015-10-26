package dataservice.informationchangedataservice._Driver;

import dataservice.informationchangedataservice.ConstantManageDataService;

public class ConstantManageDataService_Driver {
public void drive(ConstantManageDataService constantManageDataService){
	constantManageDataService.setDistance("1000", "北京","南京");
	constantManageDataService.setPrice("25", "次晨快递");
	constantManageDataService.addCity("上海");
	constantManageDataService.showDistanceChart();
	constantManageDataService.showPriceChart();
}
}
