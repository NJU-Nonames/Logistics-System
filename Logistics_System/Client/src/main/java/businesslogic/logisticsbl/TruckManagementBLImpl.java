package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import po.agency.TruckPO;
import presentation.mainui.CurrentUser;
import dataservice.agency.TruckDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.TruckVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.TruckManageBLService;

public class TruckManagementBLImpl implements TruckManageBLService{
	TruckDataService truckdataservice=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public TruckManagementBLImpl(CurrentUser currentuser){
		truckdataservice=(TruckDataService)RMIHelper.find("TruckDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}

	public ArrayList<TruckVO> show(String Hall_Num) {
		// TODO Auto-generated method stub
		ArrayList<TruckVO> truckvo=new ArrayList<TruckVO>();
		ArrayList<TruckPO> truckpo=new ArrayList<TruckPO>();
		try{
			truckpo=truckdataservice.showAll(Hall_Num);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(TruckPO po:truckpo){
			truckvo.add(new TruckVO(po.getVehiclecode(),po.getPlatenumber(),po.getServiceTimeLimit()));
		}
		return truckvo;
	}

	public ResultMessage update(TruckVO truck) {
		// TODO Auto-generated method stub
		TruckPO truckpo=null;
		try{
			truckpo=truckdataservice.find(truck.getVehiclecode());
			if(truckpo==null)
				return new ResultMessage(false,"此车辆未找到!");
			else{
				truckpo=new TruckPO(truck.getVehiclecode(),truck.getPlatenumber(),truck.getServiceTimeLimit());
				truckdataservice.update(truckpo);
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}		
		return new ResultMessage(true,"车辆信息更新成功!");
	}

	public ResultMessage delete(TruckVO truck) {
		// TODO Auto-generated method stub
		TruckPO truckpo=null;
		try{
			truckpo=truckdataservice.find(truck.getVehiclecode());
			if(truckpo==null)
				return new ResultMessage(false,"此车辆未找到!");
			else{
				truckdataservice.delete(truck.getVehiclecode());
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}		
		return new ResultMessage(true,"车辆信息删除成功!");
	}

	public ResultMessage add(TruckVO truck) {
		// TODO Auto-generated method stub
		TruckPO truckpo=null;
		try{
			truckpo=truckdataservice.find(truck.getVehiclecode());
			if(truckpo!=null)
				return new ResultMessage(false,"车辆代号已存在!");
			else{
				truckpo=new TruckPO(truck.getVehiclecode(),truck.getPlatenumber(),truck.getServiceTimeLimit());
				truckdataservice.add(truckpo);
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}		
		return new ResultMessage(true,"车辆信息添加成功!");
	}

	public TruckVO find(String num) {
		// TODO Auto-generated method stub
		TruckPO po=null;
		try{
			po=truckdataservice.find(num);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		TruckVO vo=new TruckVO(po.getVehiclecode(),po.getPlatenumber(),po.getServiceTimeLimit());
		return vo;
	}

}
