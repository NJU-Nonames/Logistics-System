package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.userbl.UserManageBLImpl;
import businesslogicservice.userblservice.UserManageBLService;

public class UserManageBLImplTest {
	UserManageBLService usermanage=new UserManageBLImpl(new CurrentUser("", "快递中心", "000000", "admin"));
	
	//测试根据账号查找用户信息
	@Test
	public void testFindonAdmin() {
		//找到
		assertTrue("".equals(usermanage.findonAdmin("lisi").getId()));
		//未找到
		assertTrue(usermanage.findonAdmin("xiaoliu")==null);
	}
    //测试根据工号查找用户信息
	@Test
	public void testFindonId() {
		//找到
		assertTrue("".equals(usermanage.findonId("").getAdmin()));
		//未找到
		assertTrue(usermanage.findonId("")==null);
	}

}
