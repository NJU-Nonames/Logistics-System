package dataservice.constantinfo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.constantinfo.DistanceChartPO;
import po.constantinfo.PriceChartPO;
import utility.PriceType;


/**
 * 数据层常量信息逻辑接口
 * @author 这菜咸了
 *
 */
public interface ConstantDataService extends Remote{
	
	
	/**
	 * 修改城市距离数据
	 * @param newDistance
	 * @param cityA
	 * @param cityB
	 * @return
	 */
	public void setDistance(String newDistance,String cityA,String cityB)throws RemoteException;
	
	/**
	 * 修改价格常量数据
	 * @param newPrice
	 * @param otherInformation
	 * @return
	 */
	public void setPrice(double newPrice,PriceType pricetype)throws RemoteException;
	
	/**
	 * 添加城市
	 * @param name
	 * @return
	 */
	public void addCity(String name)throws RemoteException;
	
	/**
	 * 返回城市距离情况表
	 * @return
	 */
	public DistanceChartPO showDistanceChart()throws RemoteException;
	
	
	/**
	 * 返回城市距离情况表
	 * @return
	 */
	public PriceChartPO showPriceChart()throws RemoteException;
	
}
