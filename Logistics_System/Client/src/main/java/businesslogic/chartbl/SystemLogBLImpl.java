package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.system.SystemLogDataService;
import po.system.SystemLogPO;
import utility.ResultMessage;
import vo.SystemLogVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.chartblservice.SystemLogBLService;

public class SystemLogBLImpl implements SystemLogBLService{

	public static void main(String args[]){
		SystemLogBLImpl ss=new SystemLogBLImpl();
		ss.showAll("2014-2-23","2014-3-23");
	}
	
	public ArrayList<SystemLogVO> showAll(String time1,String time2) {
		//检查time
		//SystemLogDataService service1 =new SystemLogDataServiceImpl();
        SystemLogDataService service=(SystemLogDataService) RMIHelper.find(SystemLogDataService.NAME);
        ArrayList<SystemLogPO> logs = null;
		try {
			logs = service.showAll(time1,time2);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		//PO---VO
        System.out.println(logs.get(0).getContent());
        //添加进入系统日志
		return null;
	}

	public ResultMessage addLogInfo(SystemLogVO systemLogVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
