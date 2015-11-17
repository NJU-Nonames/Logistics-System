/**
 *2015年11月10日
 *author:
 *description: 
 */
package dataservice.agency;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.StaffPO;

/**
 * @author Administrator
 *
 */
public interface StaffDataService extends Serializable{
	public void add(StaffPO staff);
	public void delete(StaffPO staff);
	public void update(StaffPO staff);
	public StaffPO find(String id);
	public ArrayList<StaffPO> showAll();
}
