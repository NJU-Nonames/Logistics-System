package dataservice.informationchangedataservice._Driver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.AgencyPO;
import po.StaffPO;
import dataservice.informationchangedataservice.PeopleAgencyDataService;

public class PeopleAgencyDataService_Driver {
public void drive(PeopleAgencyDataService peopleAgencyDataService){
	peopleAgencyDataService.salaryManage("admin", "3000");
	try{
	peopleAgencyDataService.showAll();
	ArrayList<StaffPO> list=new ArrayList<StaffPO>();
	list.add(new StaffPO("张三","男","快递员","000",1,"13100000000",3000));
	peopleAgencyDataService.add(new AgencyPO("000", null, list));
	peopleAgencyDataService.delete(new AgencyPO("000", null, list));
	peopleAgencyDataService.update(new AgencyPO("000", null, list));
	peopleAgencyDataService.find("000");
	}
	catch(RemoteException e){	
	}
}
}
