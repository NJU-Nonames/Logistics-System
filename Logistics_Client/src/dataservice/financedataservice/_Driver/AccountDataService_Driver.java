package dataservice.financedataservice._Driver;

import po.BankAccountPO;
import dataservice.financedataservice.AccountDataService;

public class AccountDataService_Driver {
public void drive(AccountDataService accountDataService){
	accountDataService.createCount(new BankAccountPO("张三","10000020",100));
	accountDataService.removeCount("张三");
	accountDataService.updataCount(new BankAccountPO("张三","10000021",100));
	accountDataService.searchCount("张三");
	accountDataService.show();
}
}
