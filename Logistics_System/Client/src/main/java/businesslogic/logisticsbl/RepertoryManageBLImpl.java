package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import po.repertory.RepertoryInPO;
import po.repertory.RepertoryInfoPO;
import po.repertory.RepertoryOutPO;
import presentation.mainui.CurrentUser;
import dataservice.repertory.RepertoryInDataService;
import dataservice.repertory.RepertoryInfoDataService;
import dataservice.repertory.RepertoryOutDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.RepertoryInVO;
import vo.RepertoryInfoVO;
import vo.RepertoryInformationVO;
import vo.RepertoryOutVO;
import vo.RepertorySearch;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.CaculateRepertory;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;

public class RepertoryManageBLImpl implements RepertoryManageBLService{
	RepertoryInDataService repertoryin=null;
	RepertoryOutDataService repertoryout=null;
	RepertoryInfoDataService repertoryinfo=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public RepertoryManageBLImpl(CurrentUser currentuser){
		repertoryin=(RepertoryInDataService)RMIHelper.find("RepertoryInDataService");
		repertoryout=(RepertoryOutDataService)RMIHelper.find("RepertoryOutDataService");
		repertoryinfo=(RepertoryInfoDataService)RMIHelper.find("RepertoryInfoDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
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

	public RepertoryInfoVO showRepertory() {
		RepertoryInfoVO repertoryInfo=new RepertoryInfoVO();
		try {
			ArrayList<RepertoryInfoPO> repertoryInfoPO=repertoryinfo.show(user.getAgencyNum());
			ArrayList<RepertoryInformationVO> repertoryInfoVO=new ArrayList<RepertoryInformationVO>();
	        int a=0,b=0,c=0,d=0;
	        for(int i=0;i<repertoryInfoPO.size();i++)
	        {
	        	repertoryInfoVO.add(new RepertoryInformationVO(repertoryInfoPO.get(i).getId(), repertoryInfoPO.get(i).getAreaNumber(), repertoryInfoPO.get(i).getRowNumber(),repertoryInfoPO.get(i).getFrameNumber(), repertoryInfoPO.get(i).getPlaceNumber(), repertoryInfoPO.get(i).getOrderId()));
	        	switch(Integer.parseInt((repertoryInfoPO.get(i).getAreaNumber()))){
	        		case 1:a++;break;
	        		case 2:b++;break;
	        		case 3:c++;break;
	        		case 4:d++;break;
	        	}
	        }
	        repertoryInfo.percentA=""+CaculateRepertory.caculatePercent(a);
	        repertoryInfo.percentB=""+CaculateRepertory.caculatePercent(b);
	        repertoryInfo.percentC=""+CaculateRepertory.caculatePercent(c);
	        repertoryInfo.percentD=""+CaculateRepertory.caculatePercent(d);
	        repertoryInfo.repertoryinformation=repertoryInfoVO;
	        		
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return repertoryInfo;
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

	public RepertorySearch searchRepertory(String start_time, String end_time) {
		// TODO Auto-generated method stub
		return null;
	}

}
