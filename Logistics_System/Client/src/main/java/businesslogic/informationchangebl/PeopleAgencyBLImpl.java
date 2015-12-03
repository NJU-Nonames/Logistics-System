package businesslogic.informationchangebl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.agency.AgencyPO;
import po.agency.StaffPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.agency.AgencyDataService;
import dataservice.system.SystemLogDataService;
import utility.Position;
import utility.ResultMessage;
import vo.AgencyVO;
import vo.StaffVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;

public class PeopleAgencyBLImpl implements PeopleAgencyBLService {
    AgencyDataService agencydataservice=null;
    CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public PeopleAgencyBLImpl(CurrentUser currentuser){
    	this.agencydataservice=(AgencyDataService)RMIHelper.find("AgencyDataService");
    	user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
    }
	public ResultMessage salaryManage(Position position, String salary) {
		// TODO Auto-generated method stub
		try{
			agencydataservice.salaryManage(position, salary);
			system.add(new SystemLogPO((String)df.format(new Date()),"修改"+position+"工资信息为"+salary,user.getAdmin()));
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
				if(agency.getStaffList()!=null)
				for(StaffVO staffvo:agency.getStaffList()){
					list.add(new StaffPO(staffvo.getName(),staffvo.getSex(),staffvo.getPostion(),staffvo.getIDNum(),staffvo.getWorkingtime(),staffvo.getPhoneNum(),staffvo.getWage(),staffvo.getAgencyName(),staffvo.getId(),staffvo.getAgencyId()));
				}
				agencypo=new AgencyPO(agency.getAgencyName(),agency.getAgencyNum(),list);
				agencydataservice.add(agencypo);
				system.add(new SystemLogPO((String)df.format(new Date()),"增加机构信息,编号为"+agency.getAgencyNum(),user.getAdmin()));
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
			system.add(new SystemLogPO((String)df.format(new Date()),"删除机构信息,编号为"+agencyId,user.getAdmin()));
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
				list.add(new StaffPO(staffvo.getName(),staffvo.getSex(),staffvo.getPostion(),staffvo.getIDNum(),staffvo.getWorkingtime(),staffvo.getPhoneNum(),staffvo.getWage(),staffvo.getAgencyName(),staffvo.getId(),staffvo.getAgencyId()));
			}
			agencypo=new AgencyPO(agency.getAgencyName(),agency.getAgencyNum(),list);
			agencydataservice.update(agencypo);
			system.add(new SystemLogPO((String)df.format(new Date()),"更新机构信息,编号为"+agency.getAgencyNum(),user.getAdmin()));
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
			if(agencypolist==null)
				return null;
			for(AgencyPO agencypo:agencypolist){
				AgencyVO agencyvo;
				ArrayList<StaffVO> list=new ArrayList<StaffVO>();
				for(StaffPO staffpo:agencypo.getStaffList()){
					list.add(new StaffVO(staffpo.getName(),staffpo.getSex(),staffpo.getPostion(),staffpo.getIDNum(),staffpo.getWorkingtime(),staffpo.getPhoneNum(),staffpo.getWage(),staffpo.getAgencyName(),staffpo.getId(),staffpo.getAgencyId()));
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
		if(agencypo==null)
			return null;
		AgencyVO agencyvo=null;
		ArrayList<StaffVO> list=new ArrayList<StaffVO>();
		for(StaffPO staffpo:agencypo.getStaffList()){
			list.add(new StaffVO(staffpo.getName(),staffpo.getSex(),staffpo.getPostion(),staffpo.getIDNum(),staffpo.getWorkingtime(),staffpo.getPhoneNum(),staffpo.getWage(),staffpo.getAgencyName(),staffpo.getId(),staffpo.getAgencyId()));
		}
		agencyvo=new AgencyVO(agencypo.getAgencyName(),agencypo.getAgencyNum(),list);
		return agencyvo;
	}

}
