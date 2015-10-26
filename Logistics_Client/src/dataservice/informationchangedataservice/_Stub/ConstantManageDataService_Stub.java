package dataservice.informationchangedataservice._Stub;

import po.DistanceChartPO;
import po.PriceChartPO;
import dataservice.informationchangedataservice.ConstantManageDataService;

public class ConstantManageDataService_Stub implements ConstantManageDataService{

	public boolean setDistance(String newDistance, String cityA, String cityB) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean setPrice(String newPrice, String otherInformation) {
		// TODO 自动生成的方法存根
		return false;
	}

	public boolean addCity(String name) {
		// TODO 自动生成的方法存根
		return false;
	}

	public DistanceChartPO showDistanceChart() {
		// TODO 自动生成的方法存根
		return new DistanceChartPO(null);
	}

	public PriceChartPO showPriceChart() {
		// TODO 自动生成的方法存根
		return new PriceChartPO(0, 0, 0, 0, 0, 0);
	}

}
