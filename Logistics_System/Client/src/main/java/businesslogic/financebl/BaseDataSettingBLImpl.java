package businesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.AgencyPO;
import po.agency.BankAccountPO;
import po.agency.StaffPO;
import po.agency.TruckPO;
import po.repertory.RepertoryInfoPO;
import dataservice.moneyInformation.BaseDataSettingDataService;
import utility.ResultMessage;
import vo.AgencyVO;
import vo.BankAccountVO;
import vo.BaseAgencyVO;
import vo.RepertoryInfoVO;
import vo.RepertoryOrderVO;
import vo.StaffVO;
import vo.TruckVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.BaseDataSettingBLService;

public class BaseDataSettingBLImpl implements BaseDataSettingBLService {
	BaseDataSettingDataService basedatasetting=null;
	public BaseDataSettingBLImpl(){
		basedatasetting=(BaseDataSettingDataService)RMIHelper.find("BaseDataSettingDataService");
	}

	public ResultMessage init() {
		// TODO Auto-generated method stub
		try{
			basedatasetting.init();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true, "初始化成功!");
	}

	public ArrayList<BankAccountVO> findBaseAccount() {
		// TODO Auto-generated method stub
		ArrayList<BankAccountVO> bankaccountvo=new ArrayList<BankAccountVO>();
		ArrayList<BankAccountPO> bankaccountpo=null;
		try{
			bankaccountpo=basedatasetting.findBaseAccount();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(bankaccountpo==null)
			return null;
		for(BankAccountPO po:bankaccountpo)
			bankaccountvo.add(new BankAccountVO(po.getName(), po.getNumber(), po.getMoney()));
		return bankaccountvo;
	}

	public ArrayList<BaseAgencyVO> findBaseAgency() {
		// TODO Auto-generated method stub
		ArrayList<AgencyPO> agencypo=null;
		try{
			agencypo=basedatasetting.findBaseAgency();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<BaseAgencyVO> list=new ArrayList<BaseAgencyVO>();
		if(agencypo==null)
			return null;
		for(AgencyPO po:agencypo)
			list.add(new BaseAgencyVO(po.getAgencyName(), po.getAgencyNum()));
		return list;
	}

	public ArrayList<StaffVO> findBaseStaff() {
		// TODO Auto-generated method stub
		ArrayList<AgencyPO> agencypo=null;
		try{
			agencypo=basedatasetting.findBaseAgency();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		ArrayList<StaffVO>list=new ArrayList<StaffVO>();
		for(AgencyPO po:agencypo)
			for(StaffPO staffpo:po.getStaffList())
				list.add(new StaffVO(staffpo.getName(),staffpo.getSex(),staffpo.getPostion(),staffpo.getIDNum(),staffpo.getWorkingtime(),staffpo.getPhoneNum(),staffpo.getWage(),staffpo.getAgencyName(),staffpo.getId(),staffpo.getAgencyId()));
		return list;
	}

	public ArrayList<TruckVO> findBaseTruck() {
		// TODO Auto-generated method stub
		ArrayList<TruckPO> truckpo=null;
		try{
			truckpo=basedatasetting.findBaseTruck();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(truckpo==null)
			return null;
		ArrayList<TruckVO> list=new ArrayList<TruckVO>();
		for(TruckPO po:truckpo)
			list.add(new TruckVO(po.getVehiclecode(),po.getPlatenumber(),po.getServicestarttime()));
		return list;
	}

	public ArrayList<RepertoryInfoVO> findBaseRepertory() {
		// TODO Auto-generated method stub
		ArrayList<RepertoryInfoPO>repertoryinfopo=null;
		try{
			repertoryinfopo=basedatasetting.findBaseRepertory();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(repertoryinfopo==null)
			return null;
		ArrayList<RepertoryInfoVO>list=new ArrayList<RepertoryInfoVO>();
		for(RepertoryInfoPO po:repertoryinfopo)
			list.add(new RepertoryInfoVO(po.getId(),po.getAreaNumber(),po.getRowNumber(),po.getFrameNumber(),po.getPlaceNumber(),po.getOrderId()));
		return list;
	}

	

}
