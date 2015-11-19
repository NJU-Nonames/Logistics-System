/**
 *2015年11月10日
 *author:
 *description: 
 */
package dataservice.agency;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.StaffPO;

/**
 * @author Administrator
 *
 */
public interface StaffDataService extends Remote{
	public void add(StaffPO staff)throws RemoteException;
	public void delete(String id)throws RemoteException;
	public void update(StaffPO staff)throws RemoteException;
	public StaffPO find(String id)throws RemoteException;

}
