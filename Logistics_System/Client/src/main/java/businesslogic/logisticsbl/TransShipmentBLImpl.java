package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.list.OrderListPO;
import po.list.TransShipmentListPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.list.OrderListDataService;
import dataservice.list.TransShipmentListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.TransShipmentListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.TransShipmentBLService;

public class TransShipmentBLImpl implements TransShipmentBLService{
	TransShipmentListDataService transshipment=null;
	OrderListDataService orderlist=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public TransShipmentBLImpl(CurrentUser currentuser){
		transshipment=(TransShipmentListDataService)RMIHelper.find("TransShipmentListDataService");
		orderlist=(OrderListDataService)RMIHelper.find("OrderListDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}
	public ResultMessage createShiplist(TransShipmentListVO transShipment) {
		// TODO 自动生成的方法存根
		try{
			for(String barcode:transShipment.getBarcodes()){
				OrderListPO orderpo=orderlist.find(barcode);
				ArrayList<String> orderpath=orderpo.getPkgState();
				orderpath.add((String)df.format(new Date())+" 快递运出"+user.getAgencyName());
				orderpo.setPkgState(orderpath);
				orderlist.update(orderpo);
			 }
			}catch(RemoteException e){
				e.printStackTrace();
			}
		TransShipmentListPO transpo=null;
			try{
				transpo=transshipment.find(transShipment.getTransitDocNumber());
				if(transpo!=null)
					return new ResultMessage(false,"该中转单已经存在!");
				transpo=new TransShipmentListPO(transShipment.getDate(),transShipment.getTransitDocNumber(),transShipment.getFlightNumber(),transShipment.getDeparturePlace(),transShipment.getDesitination(),transShipment.getContainerNumber(),transShipment.getSupercargoMan(),transShipment.getBarcodes(),transShipment.getCheckType());
				transshipment.add(transpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"添加中转单,单号为"+transShipment.getTransitDocNumber(),user.getAdmin()));
			}catch(RemoteException e){
				e.printStackTrace();			
		}
		return new ResultMessage(true,"中转单添加成功!");
	}
	public String createTransShipmentListId() {
		// TODO 自动生成的方法存根
		return null;
	}

}
