package businesslogic.informationchangebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.AgencyPO;
import po.agency.StaffPO;
import dataservice.agency.AgencyDataService;
import utility.ResultMessage;
import vo.AgencyVO;
import vo.StaffVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;

public class PeopleAgencyBLImpl implements PeopleAgencyBLService {
    AgencyDataService agencydataservice=null;
    public PeopleAgencyBLImpl(){
    	this.agencydataservice=(AgencyDataService)RMIHelper.find("AgencyDataService");
    }
	public ResultMessage salaryManage(String position, String salary) {
		// TODO Auto-generated method stub
		try{
			agencydataservice.salaryManage(position, salary);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,position+"的工资方案修改成功!");
	}

	public ResultMessage addAgency(AgencyVO agency) {
		// TODO Auto-generated method stub
		AgencyPO agencypo=null;
		try{
			agencypo=agencydataservice.find(agency.getAgencyNum());
			if(agencypo==null){
				ArrayList<StaffPO> list=new ArrayList<StaffPO>();
				for(StaffVO staffvo:agency.getStaffList()){
					list.add(new StaffPO(staffvo.getName(),staffvo.getSex(),staffvo.getPostion(),staffvo.getIDNum(),staffvo.getWorkingstarttime(),staffvo.getPhoneNum(),staffvo.getWage(),staffvo.getAgencyName(),staffvo.getId()));
				}
				agencypo=new AgencyPO(agency.getAgencyName(),agency.getAgencyNum(),list);
				agencydataservice.add(agencypo);
				return new ResultMessage(true,"增加机构信息成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"机构已存在!");
	}

	public ResultMessage deleteAgency(String agencyId) {
		// TODO Auto-generated method stub
		AgencyPO agencypo=null;
		try{
		agencypo=agencydataservice.find(agencyId);
		if(agencypo!=null){
			agencydataservice.delete(agencyId);
			return new ResultMessage(true,"删除机构成功!");
		}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"机构不存在!");
	}

	public ResultMessage updateAgency(AgencyVO agency) {
		// TODO Auto-generated method stub
		AgencyPO agencypo=null;
		try{
		agencypo=agencydataservice.find(agency.getAgencyNum());
		if(agencypo!=null){
			ArrayList<StaffPO> list=new ArrayList<StaffPO>();
			for(StaffVO staffvo:agency.getStaffList()){
				list.add(new StaffPO(staffvo.getName(),staffvo.getSex(),staffvo.getPostion(),staffvo.getIDNum(),staffvo.getWorkingstarttime(),staffvo.getPhoneNum(),staffvo.getWage(),staffvo.getAgencyName(),staffvo.getId()));
			}
			agencypo=new AgencyPO(agency.getAgencyName(),agency.getAgencyNum(),list);
			agencydataservice.update(agencypo);
			return new ResultMessage(true,"更新机构成功!");
		}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"机构不存在!");
	}

	public ArrayList<AgencyVO> showAgency() {
		// TODO Auto-generated method stub
		ArrayList<AgencyVO> agencyvolist=new ArrayList<AgencyVO>();
		ArrayList<AgencyPO> agencypolist=new ArrayList<AgencyPO>();
		try{
			agencypolist=agencydataservice.showAll();
			for(AgencyPO agencypo:agencypolist){
				AgencyVO agencyvo;
				ArrayList<StaffVO> list=new ArrayList<StaffVO>();
				for(StaffPO staffpo:agencypo.getStaffList()){
					list.add(new StaffVO(staffpo.getName(),staffpo.getSex(),staffpo.getPostion(),staffpo.getIDNum(),staffpo.getWorkingstarttime(),staffpo.getPhoneNum(),staffpo.getWage(),staffpo.getAgencyName(),staffpo.getId()));
				}
				agencyvo=new AgencyVO(agencypo.getAgencyName(),agencypo.getAgencyNum(),list);
				agencyvolist.add(agencyvo);
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return agencyvolist;
	}

	public AgencyVO findAgency(String id) {
		// TODO Auto-generated method stub
		AgencyPO agencypo=null;
		try{
			agencypo=agencydataservice.find(id);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		AgencyVO agencyvo;
		ArrayList<StaffVO> list=new ArrayList<StaffVO>();
		for(StaffPO staffpo:agencypo.getStaffList()){
			list.add(new StaffVO(staffpo.getName(),staffpo.getSex(),staffpo.getPostion(),staffpo.getIDNum(),staffpo.getWorkingstarttime(),staffpo.getPhoneNum(),staffpo.getWage(),staffpo.getAgencyName(),staffpo.getId()));
		}
		agencyvo=new AgencyVO(agencypo.getAgencyName(),agencypo.getAgencyNum(),list);
		return agencyvo;
	}

}
