package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import presentation.mainui.CurrentUser;
import businesslogic.financebl.BaseDataSettingBLImpl;
import businesslogicservice.financeblservice.BaseDataSettingBLService;

public class BaseDataSettingBLImplTest {
	BaseDataSettingBLService basedatasetting=new BaseDataSettingBLImpl();
    //查找获得期初银行账户信息
	@Test
	public void testFindBaseAccount() {
		assertTrue(basedatasetting.findBaseAccount().size()==4);
	}
    //测试期初机构信息
	@Test
	public void testFindBaseAgency() {
		assertTrue(basedatasetting.findBaseAgency().size()==7);
	}
    //测试获得期初员工信息
	@Test
	public void testFindBaseStaff() {
		assertTrue(basedatasetting.findBaseStaff().size()==13);
	}
    //测试获得期初货车信息
	@Test
	public void testFindBaseTruck() {
		assertTrue(basedatasetting.findBaseTruck().size()==3);
	}
    //测试获得期初库存信息
	@Test
	public void testFindBaseRepertory() {
		assertTrue(basedatasetting.findBaseRepertory().size()==1);
	}

}
