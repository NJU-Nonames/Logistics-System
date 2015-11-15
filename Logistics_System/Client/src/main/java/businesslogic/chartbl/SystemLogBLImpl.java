package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataFactoryService;
import dataservice.system.SystemLogDataService;
import po.system.SystemLogPO;
import utility.ResultMessage;
import vo.SystemLogVO;
import businesslogic.rmi.RMIHelper;
import businesslogic.utilitybl.CheckFormat;
import businesslogicservice.chartblservice.SystemLogBLService;

public class SystemLogBLImpl implements SystemLogBLService{
	private DataFactoryService dataFactory;//数据工厂
	//构造函数
	public SystemLogBLImpl(){
		this.dataFactory=(DataFactoryService)RMIHelper.find("dataFactory");
	}

	public ArrayList<SystemLogVO> showAll(String time1, String time2) {
		// TODO 自动生成的方法存根
		return null;
	}
	/* （非 Javadoc）
	 * @see businesslogicservice.chartblservice.SystemLogBLService#addLogInfo(vo.SystemLogVO)
	 */
	public ResultMessage addLogInfo(SystemLogVO systemLogVO) {
		// TODO 自动生成的方法存根
		return null;
	}
}
