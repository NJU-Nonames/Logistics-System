package dataservice.chartdataservice._Driver;

import dataservice.chartdataservice.FormDataService;

public class FormDataService_Driver {
public void drive(FormDataService formDataService){
	formDataService.getBusinessCircumstanceChart("2015-10-25", "2015-10-26");
	formDataService.getCostandBenefitChart("2015-10-25", "2015-10-26");
}
}
