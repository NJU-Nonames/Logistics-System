package dataservice.financedataservice._Driver;

import dataservice.financedataservice.AccountDataService;
import dataservice.financedataservice.BaseDataSettingDataService;
import dataservice.financedataservice.CostManagementDataService;
import dataservice.financedataservice.SettlementManageDataService;
import dataservice.financedataservice._Stub.AccountDataService_Stub;
import dataservice.financedataservice._Stub.BaseDataSettingDataService_Stub;
import dataservice.financedataservice._Stub.CostManagementDataService_Stub;
import dataservice.financedataservice._Stub.SettlementManageDataService_Stub;

public class financedataservice_Driver {
	public static void main(String [] args){
        AccountDataService accountDataService=new AccountDataService_Stub();
        AccountDataService_Driver accountDataService_Driver=new AccountDataService_Driver();
        accountDataService_Driver.drive(accountDataService);
        BaseDataSettingDataService baseDataSettingDataService=new BaseDataSettingDataService_Stub();
        BaseDataSettingDataService_Driver baseDataSettingDataService_Driver=new BaseDataSettingDataService_Driver();
        baseDataSettingDataService_Driver.drive(baseDataSettingDataService);
        CostManagementDataService costManagementDataService=new CostManagementDataService_Stub();
        CostManagementDataService_Driver CostManagementDataService_Driver=new CostManagementDataService_Driver();
        CostManagementDataService_Driver.drive(costManagementDataService);
        SettlementManageDataService settlementManageDataService=new SettlementManageDataService_Stub();
        SettlementManageDataService_Driver settlementManageDataService_Driver=new SettlementManageDataService_Driver();
        settlementManageDataService_Driver.drive(settlementManageDataService);
	}  
}
