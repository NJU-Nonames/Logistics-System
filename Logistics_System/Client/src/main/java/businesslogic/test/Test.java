package businesslogic.test;

import java.util.ArrayList;

import utility.CheckType;
import utility.ExpressType;
import utility.PkgType;
import utility.UserType;
import vo.DeliveringListVO;
import vo.OrderListVO;
import vo.UserVO;
import businesslogic.logisticsbl.DeliverAndReceiveBLImpl;
import businesslogic.logisticsbl.SendPkgBLImpl;
import businesslogic.userbl.UserManageBLImpl;

public class Test {
	
	UserManageBLImpl usermanage=new UserManageBLImpl();
	DeliverAndReceiveBLImpl deliver=new DeliverAndReceiveBLImpl();
	SendPkgBLImpl send=new SendPkgBLImpl();
	public static void main(String []args){
		Test t=new Test();
		t.test();
	}
	public void test(){
//		usermanage.addUser(new UserVO("ysy", "ysy", UserType.BUSINESS_OFFICE_CLERK,"110111111"));
//        usermanage.addUser(new UserVO("ysy", "ysy", UserType.CENTER_CLERK, "100000000"));
//	    usermanage.addUser(new UserVO("wangjiawei","wjy",UserType.BUSINESS_OFFICE_CLERK,"110111111"));
//		usermanage.updateUser(new UserVO("ysy","wjy",UserType.COURIER,"1234111111"));
//		usermanage.removeUser("ysy");
//		deliver.createDeliveringList(new DeliveringListVO("111111000", "2015-9-11", barCode, "ysy", CheckType.UNDERCHECK), keywords)
		ArrayList<String> state=new ArrayList<String>();
		state.add("订单已经出发");
	OrderListVO order=	send.createMoneyAndDate(new OrderListVO("王家玮","南京市仙林","11100011100","杨三洋","南京市鼓楼","18260065267","2",10,100,"货物",ExpressType.ECONOMIC,state,0,"025001201509101025",PkgType.PAPER,"2015-9-10 10:25:00",0+"",CheckType.UNDERCHECK
				));
	 send.createOrderList(order);
	}

}
