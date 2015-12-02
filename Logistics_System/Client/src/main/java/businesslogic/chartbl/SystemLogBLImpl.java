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
	SystemLogDataService systemLogDataService=null;
	//构造函数
	public SystemLogBLImpl(){
		this.systemLogDataService=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}
	public ArrayList<SystemLogVO> showAll(String time1, String time2) {
		
		ArrayList<SystemLogPO> systempo = null;
		try {
			systempo=systemLogDataService.showAll(time1,time2);
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(systempo==null)
			return null;
		ArrayList <SystemLogVO> systemvo=new ArrayList<SystemLogVO>();
		for(SystemLogPO sys:systempo){
			systemvo.add(new SystemLogVO(sys.getTime(),sys.getContent(),sys.getUser()));
		}
		return systemvo;
	}

	public ResultMessage addLogInfo(SystemLogVO systemLogVO) {
		// TODO 自动生成的方法存根
		SystemLogPO sys=new SystemLogPO(systemLogVO.getTime(),systemLogVO.getContent(),systemLogVO.getUser());
		
		try{
			systemLogDataService.add(sys);
		}catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ResultMessage(true,"更新系统日志!");
	}
}
