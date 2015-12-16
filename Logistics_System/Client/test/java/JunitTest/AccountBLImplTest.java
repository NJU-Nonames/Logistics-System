package businesslogic.financebl;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;

public class AccountBLImplTest {
	AccountBLImpl account=new AccountBLImpl(new CurrentUser("欧阳", "快递中心", "000000", "ouyang"));
    //测试根据账户名和账号模糊查找账户信息
	@Test
	public void testSearchCount() {
		fail("Not yet implemented");
	}
    //测试显示所有账户信息
	@Test
	public void testShow() {
		fail("Not yet implemented");
	}

}
