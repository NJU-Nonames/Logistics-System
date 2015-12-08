package dataservice.moneyInformation;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;
import po.agency.AgencyPO;
import po.agency.BankAccountPO;
import po.agency.TruckPO;
import po.repertory.RepertoryInfoPO;
import utility.ResultMessage;




public interface BaseDataSettingDataService extends Remote{
	/**
	 * 期初建账，点击以后进行建账
	 * @return
	 */
	public void init()throws RemoteException;
	
	/**
	 * 查看期初银行账户信息
	 * @return
	 */
	public ArrayList<BankAccountPO> findBaseAccount()throws RemoteException;
	
	/**查看期初人员机构信息
	 * @return
	 */
	public ArrayList<AgencyPO> findBaseAgency()throws RemoteException;

	
	/**查看期初车辆信息
	 * @return
	 */
	public ArrayList<TruckPO> findBaseTruck()throws RemoteException;
	
	/**查看期初库存信息
	 * @return
	 */
	public ArrayList<RepertoryInfoPO> findBaseRepertory()throws RemoteException;
	
}