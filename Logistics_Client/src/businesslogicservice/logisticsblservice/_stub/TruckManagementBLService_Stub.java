package businesslogicservice.logisticsblservice._stub;

import java.util.ArrayList;

import vo.TruckVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.TruckManageBLService;

public class TruckManagementBLService_Stub implements TruckManageBLService{
	

	public ArrayList<TruckVO> show(String Hall_Num) {

		ArrayList<TruckVO> list=new ArrayList<TruckVO>();
		list.add(new TruckVO("123431321", "苏A12324", "10year"));
		return list;
	}

	public ResultMessage update(TruckVO truck) {
		System.out.println("更新成功");
		return new ResultMessage(true,"更新成功");
	}

	public ResultMessage delete(TruckVO truck) {
		System.out.println("删除成功");
		return new ResultMessage(true,"删除成功");
	}

	public ResultMessage add(TruckVO truck) {
		System.out.println("添加成功");
		return new ResultMessage(true,"添加成功");
	}

	public TruckVO find(String num) {
		System.out.println("查找成功");
		return new TruckVO("123431321", "苏A12324", "10year");
	}

}
