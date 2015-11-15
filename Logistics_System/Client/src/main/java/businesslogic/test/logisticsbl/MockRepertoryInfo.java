package businesslogic.test.logisticsbl;

import vo.GoodsInfoVO;
import businesslogic.logisticsbl.Repertory;


public class MockRepertoryInfo extends Repertory {

	GoodsInfoVO good;
	
	public MockRepertoryInfo(GoodsInfoVO goods){
			this.good=goods;
	}

	public GoodsInfoVO getGoodsInfobyID(String id){
		return good;
		
	}
}
