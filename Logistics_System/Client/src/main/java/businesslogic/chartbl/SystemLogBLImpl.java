package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.chartdataservice.SystemLogDataService;
import po.system.SystemLogPO;
import vo.SystemLogVO;
import businesslogic.rmi.RMIHelper;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.chartblservice.SystemLogBLService;

public class SystemLogBLImpl implements SystemLogBLService{

//	public static void main(String args[]){
//		SystemLogBLImpl ss=new SystemLogBLImpl();
//		ss.getLogInfo("2014-2-23");
//	}
	
	public ArrayList<SystemLogVO> getLogInfo(String time) {
        SystemLogDataService service=(SystemLogDataService) RMIHelper.find(SystemLogDataService.NAME);
        ArrayList<SystemLogPO> logs = null;
		try {
			logs = service.getLogInfo(time);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
        System.out.println(logs.get(0).getContent());
		return null;
	}

	public ResultMessage addLogInfo(SystemLogVO systemLogVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
