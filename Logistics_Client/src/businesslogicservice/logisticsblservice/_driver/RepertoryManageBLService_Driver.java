package businesslogicservice.logisticsblservice._driver;

import vo.RepertoryInVO;
import vo.RepertoryOutVO;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;



public class RepertoryManageBLService_Driver {

	public void drive(RepertoryManageBLService repertoryManageBLService){
		repertoryManageBLService.inputRepertory(new RepertoryInVO(null, null, null, null, null, null, null));
		repertoryManageBLService.outputRepertory(new RepertoryOutVO(null, null, null, null, null, null));
		repertoryManageBLService.showRepertory("2015-2-19", "2015-2-20");
		repertoryManageBLService.repertoryAdjust();
		repertoryManageBLService.repertoryAlarm();
		repertoryManageBLService.repertoryUpdate();
	}
}
