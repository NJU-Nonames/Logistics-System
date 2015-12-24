package Java;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import utility.CheckType;
import utility.ExpressType;
import utility.PkgType;
import vo.OrderListVO;
import businesslogic.logisticsbl.SendPkgBLImpl;
import businesslogicservice.logisticsblservice.SendPkgBLService;
//completed
public class SendPkgBLImplTest {
	SendPkgBLService send=new SendPkgBLImpl(new CurrentUser("张三", "南京市鼓楼营业厅", "025001", "zhangsan"));
    //测试获得订单价格和到达时间
	@Test
	public void testCreateMoneyAndDate() {
		ArrayList<String>list=new ArrayList<String>();
		OrderListVO vo=new OrderListVO("小二","南京市南京大学","11111111111","小六","北京市北京大学","11111111112","2",1,1,"手套",ExpressType.STANDARD,list,0,"025001201512171915",PkgType.WOODEN,"2015-12-17 19:15:30","",CheckType.UNDERCHECK,"","");
		//价格
		assertTrue(send.createMoneyAndDate(vo).getPackPrice()==31.78);
		//时间
		assertTrue(send.createMoneyAndDate(vo).getArriveTime().equals("0"));
	}
		
	}

