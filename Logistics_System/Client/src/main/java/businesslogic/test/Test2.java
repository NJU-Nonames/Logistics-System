package businesslogic.test;

import java.util.ArrayList;

import utility.CheckType;
import utility.CostClause;
import vo.MoneyInListVO;
import vo.MoneyOutListVO;
import businesslogic.financebl.CostManagementBLImpl;
import businesslogic.financebl.SettlementManageBLImpl;

public class Test2 {
	ArrayList<String> barcodes=new ArrayList<String>();
	CostManagementBLImpl cost=new CostManagementBLImpl();
	SettlementManageBLImpl st=new SettlementManageBLImpl();
	public static void main(String args[]){
		Test2 test=new Test2();
		test.barcodes.add("025001201410210020");
		test.barcodes.add("025001201410210021");
		test.barcodes.add("025001201410210022");
		test.barcodes.add("025001201410210023");
		test.barcodes.add("025001201410210024");
		test.barcodes.add("025001201410210025");
		test.test();
	}
	
	public void test(){
		cost.createMoneyOutlist(new MoneyOutListVO("02500100001", "2015-11-29 19:46:00", 159.4, "杨三羊", "100002", CostClause.shipmentfare, "无", CheckType.UNDERCHECK));
		System.out.println(cost.search("2015-11-29", "2015-11-30").get(0).getMoney());
		
		st.createMoneyInList(new MoneyInListVO("02500100001", "2015-11-29 19:57:00", 300, "025001201", barcodes, CheckType.UNDERCHECK));
		st.searchbyhall("2015-11-29", "2015-11-30", "025001");
	}
}
