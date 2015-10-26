package dataservice.financedataservice._Driver;

import java.io.File;
import java.util.ArrayList;

import po.AgencyPO;
import po.BankAccountPO;
import po.RepertoryInfoPO;
import po.StaffPO;
import po.TruckPO;
import dataservice.financedataservice.BaseDataSettingDataService;

public class BaseDataSettingDataService_Driver {
public void drive(BaseDataSettingDataService baseDataSettingDataService){
	String[][][][][][] s=new String[2][][][][][];
	ArrayList<StaffPO> list=new ArrayList<StaffPO>();
	list.add(1,new StaffPO("张三","男","快递员","111000",100,"13200000000",1000));
	baseDataSettingDataService.addInstitutionInfo(new AgencyPO("111000",list));
	baseDataSettingDataService.addCommodityInfo(new RepertoryInfoPO(100,10,200,s));
	baseDataSettingDataService.addTruckInfo(new TruckPO("2","2","1",new File("picture")));
	baseDataSettingDataService.addFinanceInfo(new BankAccountPO("张三","111000",100));
}
}
