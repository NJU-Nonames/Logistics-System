package businesslogicservice.chartblservice;

import java.util.ArrayList;

import vo.SystemLogVO;

/**
 * @author 这菜咸了
 * 查看系统日志
 */
public interface LogInquiryblService {

	
	/**
	 * 前置条件：用户输入正确格式的日期
	 * 后置条件：系统显示匹配日的系统日志查询结果
	 * 
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogVO> getLogInfo(String time);
}
