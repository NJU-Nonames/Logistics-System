package dataservice.financedataservice._Stub;

import java.util.ArrayList;

import po.MoneyOutListPO;
import dataservice.financedataservice.SettlementManageDataService;

public class SettlementManageDataService_Stub implements SettlementManageDataService{

	public ArrayList<MoneyOutListPO> search(String start_day, String end_day,
			String Hallid) {
		// TODO 自动生成的方法存根
		ArrayList<MoneyOutListPO> list=new ArrayList<MoneyOutListPO>();
		list.add(new MoneyOutListPO(Hallid, 0, Hallid, Hallid, Hallid, Hallid));
		return list;
	}

}
