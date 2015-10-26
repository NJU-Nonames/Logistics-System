package dataservice.financedataservice._Stub;

import java.util.ArrayList;

import po.BankAccountPO;
import dataservice.financedataservice.AccountDataService;

public class AccountDataService_Stub implements AccountDataService{

	public boolean createCount(BankAccountPO countpo) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean removeCount(String name) {
		// TODO 自动生成的方法存根
		return true;
	}

	public boolean updataCount(BankAccountPO countpo) {
		// TODO 自动生成的方法存根
		return true;
	}

	public BankAccountPO searchCount(String keyword) {
		// TODO 自动生成的方法存根
		System.out.println("查找成功!");
		return new BankAccountPO(keyword, keyword, 0);
	}

	public ArrayList<BankAccountPO> show() {
		// TODO 自动生成的方法存根
		ArrayList<BankAccountPO> list=new ArrayList<BankAccountPO>();
		list.add(new BankAccountPO(null, null, 0));
		System.out.println("成功!");
		return list;
	}

}
