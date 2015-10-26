/**
7 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.chartblservice._driver;

import businesslogicservice.chartblservice.CheckBLService;
import businesslogicservice.chartblservice.FormBLService;
import businesslogicservice.chartblservice.LogInquiryBLService;
import businesslogicservice.chartblservice._stub.CheckBLService_Stub;
import businesslogicservice.chartblservice._stub.FormBLService_Stub;
import businesslogicservice.chartblservice._stub.LogInquiryBLService_Stub;


public class ChartBLService_Drive {
	public static void main(String[] args){
		ChartBLService_Drive driver=new ChartBLService_Drive();
		driver.run();
	}
	private void run(){
		CheckBLService_Driver d1=new CheckBLService_Driver();
		CheckBLService s1=new CheckBLService_Stub();
		d1.drive(s1);
		
		FormBLService_Driver d2=new FormBLService_Driver();
		FormBLService s2=new FormBLService_Stub();
		d2.drive(s2);
		
		LogInquiryBLService_Driver d3=new LogInquiryBLService_Driver();
		LogInquiryBLService s3=new LogInquiryBLService_Stub();
		d3.drive(s3);
	}
}
