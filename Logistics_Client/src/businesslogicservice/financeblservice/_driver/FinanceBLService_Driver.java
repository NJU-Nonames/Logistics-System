/**
 *2015年10月26日
 *author:tdy
 *description: 
 */
package businesslogicservice.financeblservice._driver;

import businesslogicservice.financeblservice.AccountBLService;
import businesslogicservice.financeblservice.BaseDataSettingBLService;
import businesslogicservice.financeblservice.CostManagementBLService;
import businesslogicservice.financeblservice.SettlementManageBLService;
import businesslogicservice.financeblservice._stub.AccountBLService_Stub;
import businesslogicservice.financeblservice._stub.BaseDataSettingBLService_Stub;
import businesslogicservice.financeblservice._stub.CostManagementBLService_Stub;
import businesslogicservice.financeblservice._stub.SettlementManageBLService_Stub;

public class FinanceBLService_Driver{
	public static void main(String[] args){
		FinanceBLService_Driver driver = new FinanceBLService_Driver();
		driver.run();
	}
	private void run(){
		AccountBLService_Driver d1=new AccountBLService_Driver();
		AccountBLService s1=new AccountBLService_Stub();
		d1.drive(s1);
		
		BaseDataSettingBLService_Driver d2=new BaseDataSettingBLService_Driver();
		BaseDataSettingBLService s2=new BaseDataSettingBLService_Stub();
		d2.drive(s2);
		
		CostManagementBLService_Driver d3=new CostManagementBLService_Driver();
		CostManagementBLService s3=new CostManagementBLService_Stub();
		d3.drive(s3);
		
		SettlementManageBLService_Driver d4=new SettlementManageBLService_Driver();
		SettlementManageBLService s4=new SettlementManageBLService_Stub();
		d4.drive(s4);
	}
}
