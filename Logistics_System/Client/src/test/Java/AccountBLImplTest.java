package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.financebl.AccountBLImpl;
import businesslogicservice.financeblservice.AccountBLService;
import presentation.mainui.CurrentUser;
//completed
public class AccountBLImplTest {
	AccountBLService account=new AccountBLImpl(new CurrentUser("欧阳", "快递中心", "000000", "ouyang"));
    //测试根据账户名和账号模糊查找账户信息
	@Test
	public void testSearchCount() {
		//账户名全名查找
		assertTrue("张三".equals(account.searchCount("张三").getName()));
		//账户名模糊查找
		assertTrue("张三".equals(account.searchCount("张").getName()));
		//账号全号查找
		assertTrue("张三".equals(account.searchCount("0000000000000000001").getName()));
		//账号模糊查找
		assertTrue(account.searchCount("0000000000000000")==null);
	}
    //测试显示所有账户信息
	@Test
	public void testShow() {
		assertTrue(account.show().size()==4);
	}

}
