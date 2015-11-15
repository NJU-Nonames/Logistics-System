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

<<<<<<< HEAD
	//构造函数
	public SystemLogBLImpl(){
		this.dataFactory=(DataFactoryService)RMIHelper.find("dataFactory");
	}
//	public static void main(String args[]){
//		SystemLogBLImpl ss=new SystemLogBLImpl();
//		ss.showAll("2014-2-23","2014-2-24");
//	}
	
	public ArrayList<SystemLogVO> showAll(String time1,String time2){
		SystemLogDataService service = null;
        try {
			service=dataFactory.getSystemLogDataService();//远程方法调用
=======
	public static void main(String args[]){
		SystemLogBLImpl ss=new SystemLogBLImpl();
		ss.showAll("2014-2-23","2014-3-23");
	}
	
	public ArrayList<SystemLogVO> showAll(String time1,String time2) {
		//检查time
		//if(CheckFormat.check(time1,time2)){
		
		//SystemLogDataService service1 =new SystemLogDataServiceImpl();
        SystemLogDataService service=(SystemLogDataService) RMIHelper.find(SystemLogDataService.NAME);
        ArrayList<SystemLogPO> logs = null;
		try {
			logs = service.showAll(time1,time2);
>>>>>>> origin/master
		} catch (RemoteException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
<<<<<<< HEAD
		ArrayList<SystemLogPO> logs = service.showAll(time1,time2);
=======
		//PO---VO
>>>>>>> origin/master
        System.out.println(logs.get(0).getContent());
        //添加进入系统日志
		return null;
		//}
		//else{
			//return null;
		//}
	}

	public ResultMessage addLogInfo(SystemLogVO systemLogVO) {
		// TODO Auto-generated method stub
		return null;
	}

}
