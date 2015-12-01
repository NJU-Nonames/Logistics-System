package businesslogic.logisticsbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.constantinfo.DistanceChartPO;
import po.list.OrderListPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.constantinfo.ConstantDataService;
import dataservice.list.OrderListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.OrderListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.logisticsblservice.SendPkgBLService;

public class SendPkgBLImpl implements SendPkgBLService {
	OrderListDataService service1=null;
	ConstantDataService service2=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public SendPkgBLImpl(CurrentUser currentuser){
		this.service1=(OrderListDataService)RMIHelper.find("OrderListDataService");
		this.service2=(ConstantDataService)RMIHelper.find("ConstantDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");	
	}
	public OrderListVO createMoneyAndDate(OrderListVO orderListVO) {
		try {
			ArrayList<OrderListPO> list=service1.showAll("2015-9-1", "2015-12-31");
			int days=0;
			int count=0;
			if(list!=null)
			for(OrderListPO orderListPO:list){
				if(orderListPO.getSenderAddress().substring(0, 2).equals(orderListVO.getSenderAddress().substring(0,2))&&
						orderListPO.getReceiverAddress().substring(0,2).equals(orderListVO.getReceiverAddress().substring(0, 2))&&
						orderListPO.getCategory().equals(orderListVO.getCategory())){
					count++;
					String[] temp=orderListPO.getDepartTime().split(" ");
					String[] temp1=temp[0].split("-");
					String[] temp0=orderListPO.getArriveTime().split(" ");
					String[] temp2=temp0[0].split("-");
					days+=((Integer.parseInt(temp2[0])-Integer.parseInt(temp1[0]))*360
							+(Integer.parseInt(temp2[1])-Integer.parseInt(temp1[1]))*30
							+Integer.parseInt(temp2[2])-Integer.parseInt(temp1[2]));
					//估计值，按照一年360天，一月30天计算，有时误差可能较大
				}
			}
			if(count!=0){
				days=days/count;
			}
			orderListVO.setArriveTime(days+"");
			//估计时间完成
			String cityName1=orderListVO.getSenderAddress();
			String cityName2=orderListVO.getReceiverAddress();
			for(int i=0;i<cityName1.length();i++){
				if(cityName1.charAt(i)=='市'){
					cityName1=cityName1.substring(0,i+1);
					break;
				}
			}
			for(int i=0;i<cityName2.length();i++){
				if(cityName2.charAt(i)=='市'){
					cityName2=cityName2.substring(0,i+1);
					break;
				}
			}
			DistanceChartPO distanceChart=service2.showDistanceChart();
			String[][] chart = distanceChart.getDistanceChart();
			int distance=0;
			for(int i=0;i<chart.length;i++){
				if(chart[0][i]==cityName1){
					for(int j=0;j<chart.length;j++){
						if(chart[j][0]==cityName2){
							distance=Integer.parseInt(chart[i][j]);
							break;
						}
					}
					break;
				}
			}
			
			double price_kiloGram=0.0;
			switch(orderListVO.getCategory()){
				case STANDARD:price_kiloGram=service2.showPriceChart().getStandard();break;
				case ECONOMIC:price_kiloGram=service2.showPriceChart().getEconomic();break; 
				case EXPRESS:price_kiloGram=service2.showPriceChart().getExpress();break;
				default:break;
			}
			
			double price=price_kiloGram*distance*orderListVO.getWeight()/1000;
			price_kiloGram=service2.showPriceChart().getEconomic();
			price+=price_kiloGram*60*orderListVO.getWeight()/1000;
			switch(orderListVO.getPkgType()){
				case WOODEN:price+=10;break;
				case PAPER:price+=5;break;
				case PLASTIC:price+=1;break;
				default: break;
			}
			orderListVO.setPackPrice(price);
			//计算价格完成
		} catch (RemoteException e) {
			e.printStackTrace();
		}	
		return orderListVO;
	}

	public ResultMessage createOrderList(OrderListVO orderListVO) {
		// TODO Auto-generated method stub
		OrderListPO result=new OrderListPO(orderListVO.getSenderName(), orderListVO.getSenderAddress(), orderListVO.getSenderTeleNumber(),
				orderListVO.getReceiverName(), orderListVO.getReceiverAddress(), orderListVO.getReceiverTeleNumber(),
				orderListVO.getNumber(),orderListVO.getWeight(),orderListVO.getVolume(),orderListVO.getName(),orderListVO.getCategory()
				,orderListVO.getPkgState(),orderListVO.getPackPrice(),orderListVO.getBarCode(),orderListVO.getPkgType(),orderListVO.getDepartTime(),orderListVO.getArriveTime(),orderListVO.getCheckType());
		try{
			service1.add(result);
			system.add(new SystemLogPO((String)df.format(new Date()),"添加快递单,单号为"+orderListVO.getBarCode(),user.getAdmin()));
		}catch (RemoteException e) {
			e.printStackTrace();
		}
		return new ResultMessage(true, "成功保存订单!");
	}
}
