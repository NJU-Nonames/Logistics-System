package test.java.JunitTest;

import static org.junit.Assert.*;

import org.junit.Test;

import businesslogic.logisticsbl.SearchPkgInformationBLImpl;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

public class SearchPkgInformationBLImplTest {
	SearchPkgInformationBLService search=new SearchPkgInformationBLImpl(null);
    //测试获得订单轨迹
	@Test
	public void testSearchPkgInformation() {
		assertTrue(search.searchPkgInformation("").getPkgState().size()==5);
	}
}
