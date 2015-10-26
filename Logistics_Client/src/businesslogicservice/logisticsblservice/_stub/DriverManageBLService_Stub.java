package businesslogicservice.logisticsblservice._stub;

import java.util.ArrayList;

import vo.DriverVO;
import businesslogic.utilitybl.ResultMessage;
import businesslogicservice.logisticsblservice.DriverManageBLService;

public class DriverManageBLService_Stub implements DriverManageBLService{
	
	

	@Override
	public ArrayList<DriverVO> show(String Hall_Num) {
		ArrayList<DriverVO> driverlist=new ArrayList<DriverVO>();
		driverlist.add(new DriverVO("13213412", "wjw", "2015-2-13", "610101222345531243","13975232134", "男", "10years"));
		return driverlist;
	}

	@Override
	public ResultMessage update(DriverVO driver) {
		System.out.println("更新成功");
		return new ResultMessage(true, "更新成功");
	}

	@Override
	public ResultMessage delete(DriverVO driver) {
		System.out.println("删除成功");
		return new ResultMessage(true, "删除成功");
	}

	@Override
	public ResultMessage add(DriverVO driver) {
		System.out.println("添加成功");
		return new ResultMessage(true, "添加成功");
	}

	@Override
	public DriverVO find(String num) {
		System.out.println("查找成功");
		return new DriverVO(num, num, num, num, num, num, num);
	}

}
