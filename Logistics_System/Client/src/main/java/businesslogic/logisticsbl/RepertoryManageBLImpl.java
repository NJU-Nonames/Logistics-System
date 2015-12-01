package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.repertory.RepertoryInPO;
import po.repertory.RepertoryInfoPO;
import po.repertory.RepertoryOutPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.list.OrderListDataService;
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
	OrderListDataService orderlist=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public RepertoryManageBLImpl(CurrentUser currentuser){
		orderlist=(OrderListDataService) RMIHelper.find("OrderListDataService");
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
				repertoryinfo.add(repertoryinpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"添加一条入库单"+repertoryIn.getId(),user.getAdmin()));
				
		}catch(RemoteException e){
			e.printStackTrace();
		}
		ResultMessage rs=this.repertoryAlarm(Integer.parseInt(repertoryinpo.getAreacode()));
		if(rs.isPass())
		   return new ResultMessage(true,"创建入库单成功!");
		else 
			return new ResultMessage(true,"创建入库单成功!仓位到达报警线，请进行库存调整修改位置。");
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
				repertoryinfo.delete(repertoryoutpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"添加一条出库单"+repertoryOut.getId(),user.getAdmin()));
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return new ResultMessage(true,"创建出库单成功!");
	}

	
	/* (non-Javadoc)
	 * 库存盘点
	 * @see businesslogicservice.logisticsblservice.RepertoryManageBLService#showRepertory()
	 */
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

	
	/* (non-Javadoc)
	 * 库存查看
	 * @see businesslogicservice.logisticsblservice.RepertoryManageBLService#searchRepertory(java.lang.String, java.lang.String)
	 */
	public RepertorySearch searchRepertory(String start_time, String end_time) {
		RepertorySearch repertorySearch=new RepertorySearch();
		try {
			ArrayList<RepertoryInPO> arrayin=repertoryin.showAllByAgency(start_time, end_time, user.getAgencyNum());
			ArrayList<RepertoryOutPO> arrayout=repertoryout.showByAgency(start_time, end_time, user.getAgencyNum());
		    repertorySearch.numberIn=arrayin.size()+"";
		    repertorySearch.numberOut=arrayout.size()+"";
		    ArrayList<RepertoryInVO> repertoryin=new ArrayList<RepertoryInVO>();
		    ArrayList<RepertoryOutVO> repertoryout=new ArrayList<RepertoryOutVO>();
		    double moneyin=0;
		    double moneyout=0;
		    for(int i=0;i<arrayin.size();i++)
		    {
		    	repertoryin.add(new RepertoryInVO(arrayin.get(i).getId(), arrayin.get(i).getNum(), arrayin.get(i).getTime(), arrayin.get(i).getDestination(), arrayin.get(i).getAreacode(), arrayin.get(i).getRownumber(), arrayin.get(i).getFramenumber(), arrayin.get(i).getPlacenumber(), arrayin.get(i).getCheckType()));
		        moneyin+=orderlist.find(arrayin.get(i).getNum()).getPackPrice();
		    }
		    
		    for(int i=0;i<arrayout.size();i++)
		    {
		    	repertoryout.add(new RepertoryOutVO(arrayout.get(i).getId(), arrayout.get(i).getCode(), arrayout.get(i).getTime(), arrayout.get(i).getDestination(), arrayout.get(i).getTransportation(), arrayout.get(i).getTransCode(), arrayout.get(i).getVehicleCode(), arrayout.get(i).getCheckType()));
		        moneyout+=orderlist.find(arrayout.get(i).getCode()).getPackPrice();
		    }
		    
		    repertorySearch.repertoryin=repertoryin;
		    repertorySearch.repertoryout=repertoryout;
		    repertorySearch.moneyIn=moneyin+"";
		    repertorySearch.moneyOut=moneyout+"";
		    
		    
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		
		return repertorySearch;
	}
	
	/* (non-Javadoc)
	 * 库存报警
	 * @see businesslogicservice.logisticsblservice.RepertoryManageBLService#repertoryAlarm()
	 */
	public ResultMessage repertoryAlarm(int num) {
		double percent=0;
		switch(num)
		{
		case 1: percent=Double.parseDouble(this.showRepertory().percentA);break;
		case 2: percent=Double.parseDouble(this.showRepertory().percentB);break;
		case 3: percent=Double.parseDouble(this.showRepertory().percentC);break;
		case 4: percent=Double.parseDouble(this.showRepertory().percentD);break;
		
		}
		boolean isdanger=CaculateRepertory.isdangerous(percent);
		if(isdanger)
			return new ResultMessage(isdanger,"仓位已经到达警告线，请调整仓位");
		else
		    return new ResultMessage(isdanger,"仓位预存正常，未到达警戒线");
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
