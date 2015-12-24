package Java;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.informationchangebl.PeopleAgencyBLImpl;
import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;
//completed
public class PeopleAgencyBLImplTest {
	PeopleAgencyBLService peopleAgency=new PeopleAgencyBLImpl(new CurrentUser("王五", "快递中心", "000000", "wangwu"));
    //测试根据机构编号查找机构
	@Test
	public void testFindAgency() {
		assertTrue("南京市鼓楼营业厅".equals(peopleAgency.findAgency("025001").getAgencyName()));
	}

}
