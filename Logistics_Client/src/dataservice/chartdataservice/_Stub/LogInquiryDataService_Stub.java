package dataservice.chartdataservice._Stub;

import java.util.ArrayList;

import po.SystemLogPO;
import dataservice.chartdataservice.LogInquiryDataService;

public class LogInquiryDataService_Stub implements LogInquiryDataService{

	public ArrayList<SystemLogPO> getLogInfo(String time) {
		// TODO 自动生成的方法存根
		ArrayList<SystemLogPO> list=new ArrayList<SystemLogPO>();
		list.add(new SystemLogPO(time, time, time));
		System.out.println("成功!");
		return list;
	}

}
