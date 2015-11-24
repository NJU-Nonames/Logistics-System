package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.DriverPO;
import dataservice.agency.DriverDataService;
import utility.ResultMessage;
import vo.DriverVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.DriverManageBLService;

public class DriverManageBLImpl implements DriverManageBLService {
	DriverDataService service=null;
	public DriverManageBLImpl(){
		service=(DriverDataService)RMIHelper.find("DriverDataService");
	}
	public ArrayList<DriverVO> show(String Hall_Num) {
		// TODO Auto-generated method stub
		ArrayList<DriverPO> poList=null;
		try {
			poList = service.showAll(Hall_Num);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		ArrayList<DriverVO> voList=new ArrayList<DriverVO>();
		for(DriverPO po:poList){
			voList.add(new DriverVO(po));
		}
		return voList;
	}

	public ResultMessage update(DriverVO driver) {
		// TODO Auto-generated method stub
		DriverPO temp=null;
		try {
			temp = service.find(driver.getDriverNum());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(temp==null){
			return new ResultMessage(false, "该司机不存在！");
		}
		else{
			try {
				service.update(new DriverPO(driver.getDriverNum(),driver.getName(),driver.getIDNum(),driver.getPhoneNum(),driver.getSex(),driver.getDrivingLicencePeriod()));
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return new ResultMessage(true, "更新司机信息成功！");
		}
	}

	public ResultMessage delete(DriverVO driver) {
		// TODO Auto-generated method stub
		DriverPO temp=null;
		try {
			temp = service.find(driver.getDriverNum());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(temp==null){
			return new ResultMessage(false, "该司机不存在！");
		}
		else{
			try {
				service.delete(driver.getDriverNum());
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			return new ResultMessage(true, "删除司机成功！");
		}
	}

	public ResultMessage add(DriverVO driver) {
		// TODO Auto-generated method stub
		DriverPO temp=null;
		try {
			temp = service.find(driver.getDriverNum());
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		if(temp!=null){
			return new ResultMessage(false, "该司机编号已经存在！");
		}
		try {
			service.add(new DriverPO(driver.getDriverNum(),driver.getName(),driver.getIDNum(),driver.getPhoneNum(),driver.getSex(),driver.getDrivingLicencePeriod()));
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true, "添加司机成功！");
	}

	public DriverVO find(String num) {
		// TODO Auto-generated method stub
		DriverPO temp=null;
		try {
			temp = service.find(num);
		} catch (RemoteException e1) {
			e1.printStackTrace();
		}
		return new DriverVO(temp);
	}

}
