package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.userbl.UserManageBLImpl;
import businesslogicservice.userblservice.UserManageBLService;
//completed
public class UserManageBLImplTest {
	UserManageBLService usermanage=new UserManageBLImpl(new CurrentUser("亮亮", "快递中心", "000000", "admin"));
	
	//测试根据账号查找用户信息
	@Test
	public void testFindonAdmin() {
		//找到
		assertTrue("025001101".equals(usermanage.findonAdmin("lisi").getId()));
		//未找到
		assertTrue(usermanage.findonAdmin("xiaoliu")==null);
	}
    //测试根据工号查找用户信息
	@Test
	public void testFindonId() {
		//找到
		assertTrue("lisi".equals(usermanage.findonId("025001101").getAdmin()));
		//未找到
		assertTrue(usermanage.findonId("025001001")==null);
	}

}
