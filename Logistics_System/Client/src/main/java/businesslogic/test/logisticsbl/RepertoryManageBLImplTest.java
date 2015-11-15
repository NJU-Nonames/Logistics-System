package businesslogic.test.logisticsbl;

import static org.junit.Assert.*;

import org.junit.Test;

import utility.GoodsState;
import vo.GoodsInfoVO;

public class RepertoryManageBLImplTest {

	@Test
	public void testFind(){
		MockRepertoryInfo m1=new MockRepertoryInfo(new GoodsInfoVO("", GoodsState.COMPLETE, "南京"));
	    assertEquals (new GoodsInfoVO("", GoodsState.COMPLETE, "南京"),m1.getGoodsInfobyID("2500010"));
	 }

}
