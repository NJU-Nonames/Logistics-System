/**
 * 2015年10月26日
 *author:
 *description:
 */
package dataservice.logisticsdataservice._driver;

import dataservice.logisticsdataservice.*;
import dataservice.logisticsdataservice._stub.*;

/**
 * @author 谭期友
 *
 */
public class LogisticsDataService_Driver {
	public static void main(String[] args){
		LogisticsDataService_Driver driver=new LogisticsDataService_Driver();
		driver.run();
	}
	private void run(){
		DeliverAndReceiveDataService_Driver d1 = new DeliverAndReceiveDataService_Driver();
		DeliverAndReceiveDataService s1 = new DeliverAndReceiveDataService_Stub();
		d1.drive(s1);
		
		DriverManagementDataService_Driver d2 = new DriverManagementDataService_Driver();
		DriverManagementDataService s2 = new DriverManagementDataService_Stub();
		d2.drive(s2);
		
		LoadDataService_Driver d3 = new LoadDataService_Driver();
		LoadDataService s3 = new LoadDataService_Stub();
		d3.drive(s3);
		
		ReceiverPkgDataService_Driver d4 = new ReceiverPkgDataService_Driver();
		ReceiverPkgDataService s4 = new ReceiverPkgDataService_Stub();
		d4.drive(s4);
		
		RepertoryDataService_Driver d5 = new RepertoryDataService_Driver();
		RepertoryDataService s5 = new RepertoryDataService_Stub();
		d5.drive(s5);
		
		SendingPkgDataService_Driver d6 = new SendingPkgDataService_Driver();
		SendingPkgDataService s6 = new SendingPkgDataService_Stub();
		d6.drive(s6);
		
		SerchPkgInformationDataService_Driver d7 = new SerchPkgInformationDataService_Driver();
		SerchPkgInformationDataService s7 = new SerchPkgInformationDataService_Stub();
		d7.drive(s7);
		
		TransferCentreRecieveDataService_Driver d8 = new TransferCentreRecieveDataService_Driver();
		TransferCentreRecieveDataService s8 = new TransferCentreRecieveDataService_Stub();
		d8.drive(s8);
		
		TransShipmentDataService_Driver d9 = new TransShipmentDataService_Driver();
		TransShipmentDataService s9 = new TransShipmentDataService_Stub();
		d9.drive(s9);
		
		TruckManagementDataService_Driver d10 = new TruckManagementDataService_Driver();
		TruckManagementDataService s10 = new TruckManagementDataService_Stub();
		d10.drive(s10);
	}
}
