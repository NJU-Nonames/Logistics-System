package dataservice.chartdataservice._Driver;

import dataservice.chartdataservice.CheckDataService;
import dataservice.chartdataservice.FormDataService;
import dataservice.chartdataservice.LogInquiryDataService;
import dataservice.chartdataservice._Stub.CheckDataService_Stub;
import dataservice.chartdataservice._Stub.FormDataService_Stub;
import dataservice.chartdataservice._Stub.LogInquiryDataService_Stub;

public class chartdataservice_Driver {
public static void main(String []args){
	CheckDataService a=new CheckDataService_Stub();
	CheckDataService_Driver b=new CheckDataService_Driver();
	b.drive(a);
	FormDataService c=new FormDataService_Stub();
	FormDataService_Driver d=new FormDataService_Driver();
	d.drive(c);
	LogInquiryDataService e=new LogInquiryDataService_Stub();
	LogInquiryDataService_Driver f=new LogInquiryDataService_Driver();
	f.drive(e);
}
}
