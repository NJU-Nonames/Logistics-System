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
	BankAccountVO bankaccountvo=new BankAccountVO("银行账户测试1", "0000000000000000099", 100);

	@Test
	public void testCount() {
		assertTrue( "添加账户成功!".equals(accountbl.createCount(bankaccountvo).getMessage()));
		assertTrue( "账户已存在!".equals(accountbl.createCount(bankaccountvo).getMessage()));
		assertTrue("删除账户成功!".equals(accountbl.removeCount("银行账户测试1").getMessage()));
		assertTrue( "要删除的账户不存在!".equals(accountbl.removeCount("银行账户测试1").getMessage()));
		accountbl.createCount(bankaccountvo);
		assertTrue("更新账户信息成功!".equals(accountbl.updateCount(new BankAccountVO("银行账户测试", "0000000000000000099", 100)).getMessage()));
		assertTrue("要更新的账户不存在!".equals(accountbl.updateCount(new BankAccountVO("银行账户测试", "0000000000000000098", 100)).getMessage()));
		assertTrue("银行账户测试".equals(accountbl.searchCount("银行")));
		assertTrue("银行账户测试".equals(accountbl.searchCount("账户")));
		assertTrue("银行账户测试".equals(accountbl.searchCount("0000000000000000099")));
	}
}
