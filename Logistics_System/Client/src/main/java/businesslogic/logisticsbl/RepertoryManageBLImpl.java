package businesslogic.logisticsbl;

import java.rmi.RemoteException;

import po.repertory.RepertoryInPO;
import po.repertory.RepertoryOutPO;
import dataservice.repertory.RepertoryInDataService;
import dataservice.repertory.RepertoryOutDataService;
import utility.ResultMessage;
import vo.RepertoryInVO;
import vo.RepertoryInfoVO;
import vo.RepertoryOutVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;

public class RepertoryManageBLImpl implements RepertoryManageBLService{
	RepertoryInDataService repertoryin=null;
	RepertoryOutDataService repertoryout=null;
	public RepertoryManageBLImpl(){
		repertoryin=(RepertoryInDataService)RMIHelper.find("RepertoryInDataService");
		repertoryout=(RepertoryOutDataService)RMIHelper.find("RepertoryOutDataService");
	}
 
	public ResultMessage createInputRepertory(RepertoryInVO repertoryIn) {
		// TODO 自动生成的方法存根
		RepertoryInPO repertoryinpo=null;
		try{
			repertoryinpo=repertoryin.findOnID(repertoryIn.getId());
			if(repertoryinpo!=null)
				return new ResultMessage(false,"入库单已经存在!");
				repertoryinpo=new RepertoryInPO(repertoryIn.getId(),repertoryIn.getNum(),repertoryIn.getTime(),repertoryIn.getDestination(),repertoryIn.getAreacode(),repertoryIn.getRownumber(),repertoryIn.getFramenumber(),repertoryIn.getPlacenumber(),repertoryIn.getCheckType());
				repertoryin.add(repertoryinpo);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return new ResultMessage(true,"创建入库单成功!");
	}

	public ResultMessage createOutputRepertory(RepertoryOutVO repertoryOut) {
		// TODO 自动生成的方法存根
		RepertoryOutPO repertoryoutpo=null;
		try{
			repertoryoutpo=repertoryout.findOnID(repertoryOut.getId());
			if(repertoryoutpo!=null)
				return new ResultMessage(false,"出库单已经存在!");
				repertoryoutpo=new RepertoryOutPO(repertoryOut.getId(),repertoryOut.getCode(),repertoryOut.getTime(),repertoryOut.getDestination(),repertoryOut.getTransportation(),repertoryOut.getTransCode(),repertoryOut.getVehicleCode(),repertoryOut.getCheckType());
				repertoryout.add(repertoryoutpo);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return new ResultMessage(true,"创建出库单成功!");
	}

	public RepertoryInfoVO showRepertory(String start_time, String end_time) {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage repertoryAlarm() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage repertoryAdjust() {
		// TODO 自动生成的方法存根
		return null;
	}

	public ResultMessage repertoryUpdate() {
		// TODO 自动生成的方法存根
		return null;
	}

}
