/**
 *2015年10月26日
 *author:
 *description: 
 */
package businesslogicservice.chartblservice._stub;

import java.util.ArrayList;

import vo.SystemLogVO;
import businesslogicservice.chartblservice.LogInquiryBLService;

/**
 * @author Administrator
 *
 */
public class LogInquiryBLService_Stub implements  LogInquiryBLService{

	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.LogInquiryBLService#getLogInfo(java.lang.String)
	 */
	@Override
	public ArrayList<SystemLogVO> getLogInfo(String time) {
		// TODO 自动生成的方法存根
		System.out.println("获得成功");
		ArrayList<SystemLogVO> list = new ArrayList<SystemLogVO>();
		list.add(new SystemLogVO(null, null, null));
		return list;
	}

}
