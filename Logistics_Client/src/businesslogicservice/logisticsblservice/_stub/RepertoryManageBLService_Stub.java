package businesslogicservice.logisticsblservice._stub;

import vo.RepertoryInVO;
import vo.RepertoryInfoVO;
import vo.RepertoryOutVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;

public class RepertoryManageBLService_Stub implements RepertoryManageBLService{

	public ResultMessage createInputRepertory(RepertoryInVO repertoryIn) {
		System.out.println("创建成功");
		
		return new ResultMessage(true,"input succeed");
	}

	public ResultMessage createOutputRepertory(RepertoryOutVO repertoryOut) {
		System.out.println("创建成功");
		
		return new ResultMessage(true,"output succeed");
	}

	public RepertoryInfoVO showRepertory(String start_time, String end_time) {
		System.out.println("显示成功");
		return new RepertoryInfoVO(2, 2, 2,new String[3][3][3][3][3]);
	}

	public ResultMessage repertoryAlarm() {
		System.out.println("报警成功");
		return new ResultMessage(true,"警告超出");
	}

	public ResultMessage repertoryAdjust() {
		System.out.println("改变成功");
		return new ResultMessage(true,"input succeed");
	}

	public ResultMessage repertoryUpdate() {
		System.out.println("更新成功");
		return new ResultMessage(true,"update succeed");
	}

}
