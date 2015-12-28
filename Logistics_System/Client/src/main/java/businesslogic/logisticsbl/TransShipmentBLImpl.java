package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.constantinfo.DistanceChartPO;
import po.list.OrderListPO;
import po.list.TransShipmentListPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.constantinfo.ConstantDataService;
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
	ConstantDataService constant=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public TransShipmentBLImpl(CurrentUser currentuser){
		transshipment=(TransShipmentListDataService)RMIHelper.find("TransShipmentListDataService");
		orderlist=(OrderListDataService)RMIHelper.find("OrderListDataService");
		user=currentuser;
		constant=(ConstantDataService)RMIHelper.find("ConstantDataService");
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
				transpo=new TransShipmentListPO(transShipment.getDate(),transShipment.getTransitDocNumber(),transShipment.getFlightNumber(),transShipment.getDeparturePlace(),transShipment.getDesitination(),transShipment.getContainerNumber(),transShipment.getSupercargoMan(),transShipment.getBarcodes(),transShipment.getPrice(),transShipment.getCheckType());
				transshipment.add(transpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"添加中转单,单号为"+transShipment.getTransitDocNumber(),user.getAdmin()));
			}catch(RemoteException e){
				e.printStackTrace();			
		}
		return new ResultMessage(true,"中转单添加成功!");
	}
	public String createTransShipmentListId() {
		// TODO 自动生成的方法存根
		String s="";
		try{
		s=(transshipment.showAllByAgency(user.getAgencyNum()).size()+1)+"";
		}catch(RemoteException e){
			e.printStackTrace();
		}
		int num=s.length();
		for(int i=0;i<7-num;i++)
			s="0"+s;
        SimpleDateFormat df1=new SimpleDateFormat("yyyyMMdd");
		return user.getAgencyNum()+df1.format(new Date())+s;
	}
	@Override
	public double createOrderFare(String barcode) {
		// TODO 自动生成的方法存根
		OrderListPO orderpo=null;
		try{
		orderpo=orderlist.find(barcode);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		String departurePlace=orderpo.getSenderAddress().substring(0,2);
		String arrivalPlace=orderpo.getRealreceiver().substring(0,2);
		String[][] chart=null;
		try{
			chart=constant.showDistanceChart().getDistanceChart(); 
		}catch(RemoteException e){
			e.printStackTrace();
		}
		int distance=0;
		for(int i=0;i<chart.length;i++)
			if(chart[0][i].equals(departurePlace)){
				for(int j=0;j<chart.length;j++)
					if(chart[j][0].equals(arrivalPlace)){
						distance=Integer.parseInt(chart[i][j]);
						break;
					}
				break;
			}
			double price=0;
			try{
					switch(orderpo.getCategory()){
					case STANDARD:price=constant.showPriceChart().getTruck_kilo_t();break;
					case ECONOMIC:price=constant.showPriceChart().getTrain_kilo_t();break; 
					case EXPRESS:price=constant.showPriceChart().getAirplane_kilo_t();break;
					default:break;
				}
			}catch(RemoteException e){
					e.printStackTrace();
				}
			price=price*distance*orderpo.getWeight()/1000;
			return price;
	}
	
}
	
