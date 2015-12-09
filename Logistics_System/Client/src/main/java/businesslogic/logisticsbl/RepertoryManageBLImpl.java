package businesslogic.logisticsbl;

import java.io.File;
import java.io.FileOutputStream;
import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

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
import vo.RepertoryShowVO;
import vo.RepertoryOrderVO;
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
	
	public RepertoryManageBLImpl(){
		
	}
	
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
				repertoryoutpo=new RepertoryOutPO(repertoryOut.getId(),repertoryOut.getCode(),repertoryOut.getTime(),repertoryOut.getDestination(),repertoryOut.getTransportation(),repertoryOut.getTransCode(),repertoryOut.getCheckType());
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
	public RepertoryShowVO showRepertory() {
		RepertoryShowVO repertoryInfo=new RepertoryShowVO();
		try {
			ArrayList<RepertoryInfoPO> repertoryInfoPO=repertoryinfo.show(user.getAgencyNum());
			ArrayList<RepertoryOrderVO> repertoryInfoVO=new ArrayList<RepertoryOrderVO>();
	        int a=0,b=0,c=0,d=0;
	        System.out.println(repertoryInfoPO.size());
	        for(int i=0;i<repertoryInfoPO.size();i++)
	        {
	        	RepertoryInPO list=repertoryin.findOnOrderID(repertoryInfoPO.get(i).getOrderId(), repertoryInfoPO.get(i).getId());	
	        	repertoryInfoVO.add(new RepertoryOrderVO(repertoryInfoPO.get(i).getId(), repertoryInfoPO.get(i).getAreaNumber(), repertoryInfoPO.get(i).getRowNumber(),repertoryInfoPO.get(i).getFrameNumber(), repertoryInfoPO.get(i).getPlaceNumber(),list.getTime(),list.getDestination(), repertoryInfoPO.get(i).getOrderId()));
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
		    	repertoryout.add(new RepertoryOutVO(arrayout.get(i).getId(), arrayout.get(i).getCode(), arrayout.get(i).getTime(), arrayout.get(i).getDestination(), arrayout.get(i).getTransportation(), arrayout.get(i).getTransCode(), arrayout.get(i).getCheckType()));
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

	
	/* (non-Javadoc)
	 * 库存更新，库存调整
	 * @see businesslogicservice.logisticsblservice.RepertoryManageBLService#repertoryAdjust(vo.RepertoryInformationVO)
	 */
	public ResultMessage repertoryAdjust(
			RepertoryOrderVO repertoryinformation) {
		try {
			RepertoryInfoPO repertory=new RepertoryInfoPO(repertoryinformation.id, 
					repertoryinformation.areaNumber, repertoryinformation.rowNumber, repertoryinformation.frameNumber, repertoryinformation.placeNumber, repertoryinformation.orderId);
			System.out.println(repertoryinformation.orderId);
			if(repertoryinfo.findbyID(repertoryinformation.orderId)==null)
				return new ResultMessage(false,"未查询到该订单信息!");
			else if(repertoryinformation.id!=user.getAgencyNum())
				return new ResultMessage(false,"该订单不存在于该仓库中!");
			else if(repertoryinfo.findbyPlace(repertory).getOrderId().equals(repertoryinformation.id))
				return new ResultMessage(false,"位置没有发生变更!");
			else if(repertoryinfo.findbyPlace(repertory)!=null)
				return new ResultMessage(false,"该位置已经存在货物!");
			else{
				repertoryinfo.update(repertory);
				RepertoryInPO repertoryinlist=repertoryin.findOnID(repertoryinformation.orderId);
				repertoryinlist.setAreacode(repertory.getAreaNumber());
				repertoryinlist.setRownumber(repertory.getRowNumber());
				repertoryinlist.setFramenumber(repertory.getFrameNumber());
				repertoryinlist.setPlacenumber(repertory.getPlaceNumber());
				repertoryin.update(repertoryinlist);
				system.add(new SystemLogPO((String)df.format(new Date()),"更改"+repertoryinformation.orderId+"号订单在"+user.getAgencyName()+"中的库存位置",user.getAdmin()));
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
			
		if(this.repertoryAlarm(Integer.parseInt(repertoryinformation.areaNumber)).isPass())
		    return new ResultMessage(true,"位置变更成功!");
		else
			return new ResultMessage(true,"位置变更成功!转移仓位已到达报警线，请进行库存调整修改位置。");
	}
	public void exportRepertoryInformation(String repertoryname,String time,String path){
//		ArrayList<RepertoryOrderVO> list=showRepertory().repertoryinformation;
//		HSSFWorkbook wb=new HSSFWorkbook();
//		HSSFSheet sheet=wb.createSheet("库存信息表");
//		sheet.setColumnWidth(1, 5000);
//		HSSFRow row=sheet.createRow(0);
//		HSSFCellStyle style=wb.createCellStyle();
//		sheet.setDefaultColumnWidth(12);
//		style.setAlignment(HSSFCellStyle.ALIGN_RIGHT);
//		HSSFCell cell=row.createCell(0);
//		cell.setCellValue("快递编号");
//		cell.setCellStyle(style);
//		cell=row.createCell(1);
//		cell.setCellValue("入库日期");
//		cell.setCellStyle(style);
//		cell=row.createCell(2);
//		cell.setCellValue("区号");
//		cell.setCellStyle(style);
//		cell=row.createCell(3);
//		cell.setCellValue("排号");
//		cell.setCellStyle(style);
//		cell=row.createCell(4);
//		cell.setCellValue("架号");
//		cell.setCellStyle(style);
//		cell=row.createCell(5);
//		cell.setCellValue("位号");
//		cell.setCellStyle(style);
//		cell=row.createCell(6);
//		cell.setCellValue("目的地");
//		cell.setCellStyle(style);
//		for(int i=0;i<list.size();i++){
//			row=sheet.createRow(i+1);
//			RepertoryOrderVO vo=list.get(i);
//			cell=row.createCell(0);
//			cell.setCellValue(vo.id);
//			cell.setCellStyle(style);
//			cell=row.createCell(1);
//			cell.setCellValue(vo.time);
//			cell.setCellStyle(style);
//			cell=row.createCell(2);
//			cell.setCellValue(vo.areaNumber);
//			cell.setCellStyle(style);
//			cell=row.createCell(3);
//			cell.setCellValue(vo.rowNumber);
//			cell.setCellStyle(style);
//			cell=row.createCell(4);
//			cell.setCellValue(vo.frameNumber);
//			cell.setCellStyle(style);
//			cell=row.createCell(5);
//			cell.setCellValue(vo.placeNumber);
//			cell.setCellStyle(style);
//			cell=row.createCell(6);
//			cell.setCellValue(vo.destination);
//			cell.setCellStyle(style);		
//		}
//		String[]s=time.split(" ");
//		String[]date=s[0].split("-");
//		String[]hour=s[1].split(":");
//		try{		
//			FileOutputStream fout=new FileOutputStream("D:/"+repertoryname+"在"+date[0]+"年"+date[1]+"月"+date[2]+"日"+hour[0]+"时"+hour[1]+"分"+hour[2]+"秒"+"库存盘点.xls");
//			wb.write(fout);
//			fout.close();
//			wb.close();
//		}catch(Exception e){
//			e.printStackTrace();
//		}	
	}

	public String createRepertoryInId() {
		// TODO 自动生成的方法存根
		String s="";
		try{
		s=(repertoryin.showAllByAgency(user.getAgencyNum()).size()+1)+"";
		}catch(RemoteException e){
			e.printStackTrace();
		}
		int num=s.length();
		for(int i=0;i<5-num;i++)
			s="0"+s;
		return user.getAgencyNum()+s;
	}

	public String createRepertoryOutId() {
		// TODO 自动生成的方法存根
		String s="";
		try{
		s=(repertoryout.showAllByAgency(user.getAgencyNum()).size()+1)+"";
		}catch(RemoteException e){
			e.printStackTrace();
		}
		int num=s.length();
		for(int i=0;i<5-num;i++)
			s="0"+s;
		return user.getAgencyNum()+s;
	}
}
