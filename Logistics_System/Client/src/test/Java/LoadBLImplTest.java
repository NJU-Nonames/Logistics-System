package Java;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.logisticsbl.LoadBLImpl;
import businesslogicservice.logisticsblservice.LoadBLService;
//completed
public class LoadBLImplTest {
	LoadBLService load=new LoadBLImpl(new CurrentUser("李四","南京市鼓楼营业厅","025001","lisi"));
    //测试获得本次装车单号
	@Test
	public void testCreateLoadlistId() {
		assertTrue("0250012015122000003".equals(load.createLoadlistId()));
	}

}
