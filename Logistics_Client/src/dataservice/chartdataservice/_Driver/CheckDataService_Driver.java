package dataservice.chartdataservice._Driver;

import java.util.ArrayList;

import po.ListPO;
import businesslogic.utilitybl.DocType;
import dataservice.chartdataservice.CheckDataService;

public class CheckDataService_Driver {
public void drive(CheckDataService checkDataService){
	checkDataService.getDoc(DocType.BUSINESSHALL_ARRIVAL_NOTE,"2015-10-26");
	checkDataService.changeDoc(new ArrayList<ListPO>());
}
}
