package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.DataFactoryService;
import dataservice.system.SystemLogDataService;
import po.system.SystemLogPO;
import utility.ResultMessage;
import vo.SystemLogVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.chartblservice.SystemLogBLService;

public class SystemLogBLImpl implements SystemLogBLService{
	SystemLogDataService systemLogDataService=null;
	//构造函数
	public SystemLogBLImpl(){
		this.systemLogDataService=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}
	
//	public static void main(String args[]){
//		SystemLogBLImpl s=new SystemLogBLImpl();
//		s.showAll("", "");
//	}

	
	//TODO 方法测试 有待修改
	public ArrayList<SystemLogVO> showAll(String time1, String time2) {
		// TODO 方法实例！！！
		
		ArrayList<SystemLogPO> systemLog = null;
		try {
			systemLog=systemLogDataService.showAll("2010-8", "2010-10");
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(systemLog.get(0).getContent());
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
