package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.logisticsbl.SearchPkgInformationBLImpl;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;
//completed
public class SearchPkgInformationBLImplTest {
	SearchPkgInformationBLService search=new SearchPkgInformationBLImpl(null);
    //测试获得订单轨迹
	@Test
	public void testSearchPkgInformation() {
		assertTrue(search.searchPkgInformation("025001201512071848").getPkgState().size()==18);
	}
}
