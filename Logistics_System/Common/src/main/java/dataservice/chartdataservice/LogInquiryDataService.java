package dataservice.chartdataservice;

import java.util.ArrayList;

import po.SystemLogPO;


public interface LogInquiryDataService {
	/**
	 * 前置条件：用户输入正确格式的日期
	 * 后置条件：系统显示匹配日的系统日志查询结果
	 * 
	 * @param keywords
	 * @return
	 */
	public ArrayList<SystemLogPO> getLogInfo(String time);
}
