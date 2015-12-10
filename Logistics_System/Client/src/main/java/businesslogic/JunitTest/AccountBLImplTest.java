package businesslogic.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.financebl.AccountBLImpl;
import po.agency.BankAccountPO;
import presentation.mainui.CurrentUser;
import utility.ResultMessage;
import vo.BankAccountVO;

public class AccountBLImplTest {
	AccountBLImpl accountbl=new AccountBLImpl(new CurrentUser("上官","快递中心","000000","shangguan"));

	
	@Test
	public void testCreateCount() {
		BankAccountVO bankaccountvo=new BankAccountVO("银行账户测试1", "0000000000000000099", 100);
		assertEquals(new ResultMessage(true, "添加账户成功!"), accountbl.createCount(bankaccountvo));
		assertEquals(new ResultMessage(false, "账户已存在!"), accountbl.createCount(bankaccountvo));
	}

	@Test
	public void testRemoveCount() {
		assertEquals(new ResultMessage(false, "删除账户成功!"), accountbl.removeCount("0000000000000000099"));
		assertEquals(new ResultMessage(false, "要删除的账户不存在!"), accountbl.removeCount("0000000000000000099"));
	}

	@Test
	public void testUpdateCount() {
		fail("尚未实现");
	}

	@Test
	public void testSearchCount() {
		fail("尚未实现");
	}

	@Test
	public void testShow() {
		fail("尚未实现");
	}

}
