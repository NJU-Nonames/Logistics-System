package dataservice.constantinfo;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.constantinfo.DistanceChartPO;
import po.constantinfo.PriceChartPO;


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
	public boolean setDistance(String newDistance,String cityA,String cityB)throws RemoteException;
	
	/**
	 * 修改价格常量数据
	 * @param newPrice
	 * @param otherInformation
	 * @return
	 */
	public boolean setPrice(String newPrice,String otherInformation)throws RemoteException;
	
	/**
	 * 添加城市
	 * @param name
	 * @return
	 */
	public boolean addCity(String name)throws RemoteException;
	
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
