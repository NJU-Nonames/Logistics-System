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
		double distance=Double.parseDouble(newDistance);
		if(cityA.equals(cityB)){
			if(distance!=0)
				return new ResultMessage(false,"相同城市之间的距离为0!");
		}
		else if(distance<0)
			return new ResultMessage(false,"城市之间的距离不能为负数!");
		try{
			constantdataservice.setDistance(newDistance, cityA, cityB);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,"新的城市距离设定成功!");
	}
/**
 * 展示层传入参数为修改的价格类型
 */
	public ResultMessage submitPrice(String newPrice, String otherInformation) {
		// TODO Auto-generated method stub
		try{
			constantdataservice.setPrice(newPrice, otherInformation);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,otherInformation+"价格常量修改成功!");
	}

}
