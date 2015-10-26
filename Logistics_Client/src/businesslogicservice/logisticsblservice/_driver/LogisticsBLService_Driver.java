package businesslogicservice.logisticsblservice._driver;

import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;
import businesslogicservice.logisticsblservice.DriverManageBLService;
import businesslogicservice.logisticsblservice.LoadBLService;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;
import businesslogicservice.logisticsblservice.SendPkgBLService;
import businesslogicservice.logisticsblservice.TransShipmentBLService;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;
import businesslogicservice.logisticsblservice.TruckManageBLService;
import businesslogicservice.logisticsblservice._stub.DeliverAndReceiveBLService_Stub;
import businesslogicservice.logisticsblservice._stub.DriverManageBLService_Stub;
import businesslogicservice.logisticsblservice._stub.LoadBLService_Stub;
import businesslogicservice.logisticsblservice._stub.ReceivePkgBLService_Stub;
import businesslogicservice.logisticsblservice._stub.RepertoryManageBLService_Stub;
import businesslogicservice.logisticsblservice._stub.SearchPkgInformationBLService_Stub;
import businesslogicservice.logisticsblservice._stub.SendPkgBLService_Stub;
import businesslogicservice.logisticsblservice._stub.TransShipmentBLService_Stub;
import businesslogicservice.logisticsblservice._stub.TransferCenterReceiveBLService_Stub;
import businesslogicservice.logisticsblservice._stub.TruckManagementBLService_Stub;

public class LogisticsBLService_Driver {
	
	public static void main(String args[]){
		LogisticsBLService_Driver l=new LogisticsBLService_Driver();
		System.out.println("测试开始");
		l.run();
	}

	private void run() {
	    DeliverAndReceiveBLService darbl=new DeliverAndReceiveBLService_Stub();
	    DeliverAndReceiveBLService_Driver d1=new DeliverAndReceiveBLService_Driver();
	    d1.drive(darbl);
	    
	    DriverManageBLService dmbl=new DriverManageBLService_Stub();
	    DriverManageBLService_Driver d2=new DriverManageBLService_Driver();
	    d2.drive(dmbl);
	    
	    LoadBLService lbl=new LoadBLService_Stub();
	    LoadBLService_Driver d3=new LoadBLService_Driver();
	    d3.drive(lbl);

	    RepertoryManageBLService rmbl=new RepertoryManageBLService_Stub();
	    RepertoryManageBLService_Driver d4=new RepertoryManageBLService_Driver();
	    d4.drive(rmbl);
	    
	    SearchPkgInformationBLService spibl=new SearchPkgInformationBLService_Stub();
	    SearchPkgInformationBLService_Driver d5=new SearchPkgInformationBLService_Driver();
	    d5.drive(spibl);
	    
	    ReceivePkgBLService rpkg=new ReceivePkgBLService_Stub();
	    ReceivePkgBLService_Driver d6=new ReceivePkgBLService_Driver();
	    d6.drive(rpkg);
	    
	    SendPkgBLService spbl=new SendPkgBLService_Stub();
	    SendPkgBLService_Driver d7=new SendPkgBLService_Driver();
	    d7.drive(spbl);
	    
	    TransferCenterReceiveBLService tcrbl=new TransferCenterReceiveBLService_Stub();
	    TransferCenterReceiveBLService_Driver d8=new TransferCenterReceiveBLService_Driver();
	    d8.drive(tcrbl);
	    
	    TransShipmentBLService tsbl=new TransShipmentBLService_Stub();
	    TransShipmentBLService_Driver d9=new TransShipmentBLService_Driver();
	    d9.drive(tsbl);
	    
	    TruckManageBLService tmbl=new TruckManagementBLService_Stub();
	    TruckManagementBLService_Driver d10=new TruckManagementBLService_Driver();
	    d10.drive(tmbl);
	    
	}

}
