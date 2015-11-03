package businesslogicservice.chartblservice;

import java.util.ArrayList;

import utility.ResultMessage;
import vo.SystemLogVO;

/**
 * @author 这菜咸了
 * 查看系统日志
 */
public interface SystemLogBLService {

			
	/**
	 * 前置条件：用户输入正确格式的日期
	 * 后置条件：系统显示匹配日的系统日志查询结果
	 * 
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogVO> showAll(String time1,String time2);
	
	/**
	 * 创建新的系统日志
	 * @param systemLogVO
	 * @return
	 */
	public ResultMessage addLogInfo(SystemLogVO systemLogVO);
}
