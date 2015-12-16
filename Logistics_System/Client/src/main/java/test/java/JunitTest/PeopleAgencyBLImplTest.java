package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.informationchangebl.PeopleAgencyBLImpl;
import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;

public class PeopleAgencyBLImplTest {
	PeopleAgencyBLService peopleAgency=new PeopleAgencyBLImpl(new CurrentUser("", "", "", ""));
    //测试根据机构编号查找机构
	@Test
	public void testFindAgency() {
		assertTrue("".equals(peopleAgency.findAgency("").getAgencyName()));
	}

}
