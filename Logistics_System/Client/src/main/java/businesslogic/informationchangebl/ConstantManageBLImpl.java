package businesslogic.informationchangebl;

import java.rmi.RemoteException;

import po.constantinfo.DistanceChartPO;
import po.constantinfo.PriceChartPO;
import dataservice.constantinfo.ConstantDataService;
import utility.ResultMessage;
import vo.DistanceChartVO;
import vo.PriceChartVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.informationchangeblservice.ConstantManageBLService;

public class ConstantManageBLImpl implements ConstantManageBLService {
ConstantDataService constantdataservice=null;
public ConstantManageBLImpl(){
	constantdataservice=(ConstantDataService)RMIHelper.find("ConstantDataService");
}
	public ResultMessage addCity(String name) {
		// TODO Auto-generated method stub
		try{
			constantdataservice.addCity(name);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,"添加城市成功!");
	}

	public DistanceChartVO showDistanceChart() {
		// TODO Auto-generated method stub
		DistanceChartVO distancechartvo=null;
		try{
			DistanceChartPO distancechartpo=constantdataservice.showDistanceChart();
			distancechartvo=new DistanceChartVO(distancechartpo.getDistanceChart());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return distancechartvo;
	}

	public PriceChartVO showPriceChart() {
		// TODO Auto-generated method stub
		PriceChartVO pricechartvo=null;
		try{
			PriceChartPO pricechartpo=constantdataservice.showPriceChart();
			pricechartvo=new PriceChartVO(pricechartpo.getTrain_kilo_t(),pricechartpo.getTruck_kilo_t(),pricechartpo.getAirplane_kilo_t(),pricechartpo.getStandard(),pricechartpo.getEconomic(),pricechartpo.getExpress());
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return pricechartvo;
	}

	public ResultMessage submitDistance(String newDistance, String cityA,
			String cityB) {
		// TODO Auto-generated method stub
		return null;
	}

	public ResultMessage submitPrice(String newPrice, String otherInformation) {
		// TODO Auto-generated method stub
		return null;
	}

}
