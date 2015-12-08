package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.list.DeliveringListPO;
import po.list.HallArrivalListPO;
import po.list.LoadListPO;
import po.list.OrderListPO;
import po.list.TransArrivalListPO;
import po.list.TransShipmentListPO;
import po.moneyInfomation.MoneyInListPO;
import po.moneyInfomation.MoneyOutListPO;
import po.repertory.GoodsInfoPO;
import po.repertory.RepertoryInPO;
import po.repertory.RepertoryOutPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.list.DeliveringListDataService;
import dataservice.list.HallArrivalListDataService;
import dataservice.list.LoadListDataService;
import dataservice.list.OrderListDataService;
import dataservice.list.TransArrivalListDataService;
import dataservice.list.TransShipmentListDataService;
import dataservice.moneyInformation.MoneyInListDataService;
import dataservice.moneyInformation.MoneyOutListDataService;
import dataservice.repertory.RepertoryInDataService;
import dataservice.repertory.RepertoryOutDataService;
import dataservice.system.SystemLogDataService;
import utility.CheckType;
import utility.DocType;
import utility.ResultMessage;
import vo.DeliveringListVO;
import vo.GoodsInfoVO;
import vo.HallArrivalListVO;
import vo.ListVO;
import vo.LoadListVO;
import vo.MoneyInListVO;
import vo.MoneyOutListVO;
import vo.OrderListVO;
import vo.RepertoryInVO;
import vo.RepertoryOutVO;
import vo.TransArrivalListVO;
import vo.TransShipmentListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.chartblservice.CheckBLService;

public class CheckBLImpl implements CheckBLService {
	MoneyInListDataService moneyin=null;
	MoneyOutListDataService moneyout=null;
	RepertoryInDataService repertoryin=null;
	RepertoryOutDataService repertoryout=null;
	OrderListDataService order=null;
	LoadListDataService load=null;
	HallArrivalListDataService hallarrival=null;
	DeliveringListDataService deliver=null;
	TransArrivalListDataService transarrival=null;
	TransShipmentListDataService transshipment=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public CheckBLImpl(CurrentUser currentuser){
		moneyin=(MoneyInListDataService)RMIHelper.find("MoneyInListDataService");
		moneyout=(MoneyOutListDataService)RMIHelper.find("MoneyOutListDataService");
		repertoryin=(RepertoryInDataService)RMIHelper.find("RepertoryInDataService");
		repertoryout=(RepertoryOutDataService)RMIHelper.find("RepertoryOutDataService");
		order=(OrderListDataService)RMIHelper.find("OrderListDataService");
		load=(LoadListDataService)RMIHelper.find("LoadListDataService");
		hallarrival=(HallArrivalListDataService)RMIHelper.find("HallArrivalListDataService");
		deliver=(DeliveringListDataService)RMIHelper.find("DeliveringListDataService");
		transarrival=(TransArrivalListDataService)RMIHelper.find("TransArrivalListDataService");
		transshipment=(TransShipmentListDataService)RMIHelper.find("TransShipmentListDataService");	
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}
	

	public ArrayList<? extends ListVO> getAll(DocType docType, String time1,String time2) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				ArrayList<MoneyInListPO> moneyinpo=moneyin.showAll(time1, time2);
				ArrayList<MoneyInListVO> moneyinvo=new ArrayList<MoneyInListVO>();
				if(moneyinpo==null)
					return null;
				for(MoneyInListPO po:moneyinpo){
					moneyinvo.add(new MoneyInListVO(po.getId(), po.getDate(), po.getMoneySum(), po.getStaffId(), po.getBarcode(), po.getCheckType()));
				}
				return moneyinvo;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListPO> moneyoutpo=moneyout.showAll(time1, time2);
				ArrayList<MoneyOutListVO> moneyoutvo=new ArrayList<MoneyOutListVO>();
				if(moneyoutpo==null)
					return null;
				for(MoneyOutListPO po:moneyoutpo){
					moneyoutvo.add(new MoneyOutListVO(po.getId(), po.getDate(), po.getMoney(), po.getPayer(), po.getAccountNum(), po.getClause(), po.getNote(), po.getCheckType()));
				}
				return moneyoutvo;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInPO> repertoryinpo=repertoryin.showAll(time1, time2);
				ArrayList<RepertoryInVO> repertoryinvo=new ArrayList<RepertoryInVO>();
				if(repertoryinpo==null)
					return null;
				for(RepertoryInPO po:repertoryinpo){
					repertoryinvo.add(new RepertoryInVO(po.getId(), po.getNum(), po.getTime(), po.getDestination(), po.getAreacode(), po.getRownumber(), po.getFramenumber(), po.getPlacenumber(), po.getCheckType()));
				}
				return repertoryinvo;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutPO> repertoryoutpo=repertoryout.showAll(time1, time2);
				ArrayList<RepertoryOutVO> repertoryoutvo=new ArrayList<RepertoryOutVO>();
				if(repertoryoutpo==null)
					return null;
				for(RepertoryOutPO po:repertoryoutpo){
					repertoryoutvo.add(new RepertoryOutVO(po.getId(), po.getCode(), po.getTime(), po.getDestination(), po.getTransportation(), po.getTransCode(),  po.getCheckType()));
				}
				return repertoryoutvo;
			case SENDING_NOTE:
				ArrayList<OrderListPO> orderpo=order.showAll(time1, time2);
				ArrayList<OrderListVO> ordervo=new ArrayList<OrderListVO>();
				if(orderpo==null)
					return null;
				for(OrderListPO po:orderpo){
					ordervo.add(new OrderListVO(po.getSenderName(), po.getSenderAddress(), po.getSenderTeleNumber(), po.getReceiverName(), po.getReceiverAddress(), po.getReceiverTeleNumber(), po.getNumber(), po.getWeight(), po.getVolume(), po.getName(), po.getCategory(), po.getPkgState(), po.getPackPrice(), po.getBarCode(), po.getPkgType(), po.getDepartTime(), po.getArriveTime(), po.getCheckType(),po.getRealreceiver(),po.getRealreceivertelenumber()));
				}
				return ordervo;
			case LOADING_NOTE:
				ArrayList<LoadListPO> loadpo=load.showAll(time1, time2);
				ArrayList<LoadListVO> loadvo=new ArrayList<LoadListVO>();
				if(loadpo==null)
					return null;
				for(LoadListPO po:loadpo){
					loadvo.add(new LoadListVO( po.getDate(), po.getHallNumber(), po.getTransportationNumber(), po.getDestination(), po.getCarNumber(), po.getGuardMan(), po.getSupercargoMan(), po.getBarcodes(), po.getCheckType()));
				}
				return loadvo;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListPO> hallarrivalpo=hallarrival.showAll(time1, time2);
				ArrayList<HallArrivalListVO> hallarrivalvo=new ArrayList<HallArrivalListVO>();
				if(hallarrivalpo==null)
					return null;
				for(HallArrivalListPO po:hallarrivalpo){
					ArrayList<GoodsInfoVO> goodsvolist=new ArrayList<GoodsInfoVO>();
					for(GoodsInfoPO goodspo:po.getGoodsInfoPO()){
						goodsvolist.add(new GoodsInfoVO(goodspo.getBarcode(),goodspo.getState()));
					}
					hallarrivalvo.add(new HallArrivalListVO(po.getId(), po.getDate(), po.getTransferNumber(), po.getDepartureplace(),goodsvolist,po.getCheckType()));
				}
				return hallarrivalvo;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListPO> deliverlistpo=deliver.showAll(time1, time2);
				ArrayList<DeliveringListVO> deliverlistvo=new ArrayList<DeliveringListVO>();
				if(deliverlistpo==null)
					return null;
		        for(DeliveringListPO po:deliverlistpo){		
		        	deliverlistvo.add(new DeliveringListVO(po.getId(), po.getDate(), po.getBarCode(), po.getDeliveryMan(), po.getCheckType()));
		        }
		        return deliverlistvo;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListPO> transarrivalpo=transarrival.showAll(time1, time2);
				ArrayList<TransArrivalListVO> transarrivalvo=new ArrayList<TransArrivalListVO>();
				if(transarrivalpo==null)
					return null;
				for(TransArrivalListPO po:transarrivalpo){
				ArrayList<GoodsInfoVO> goodvo=new ArrayList<GoodsInfoVO>();
					for(GoodsInfoPO goods:po.getGoodsInfoPOs()){
						goodvo.add(new GoodsInfoVO(goods.getBarcode(), goods.getState()));
					}
					transarrivalvo.add(new TransArrivalListVO( po.getId(),po.getTransferNumber(), po.getCenterNumber(), po.getDate(), goodvo,po.getDepartureplace(), po.getCheckType()));
				}
				return transarrivalvo;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListPO> transshipmentpo=transshipment.showAll(time1, time2);
				ArrayList<TransShipmentListVO> transshipmentvo=new ArrayList<TransShipmentListVO>();
				if(transshipmentpo==null)
					return null;
				for(TransShipmentListPO po:transshipmentpo){
					transshipmentvo.add(new TransShipmentListVO(po.getDate(), po.getTransitDocNumber(), po.getFlightNumber(), po.getDeparturePlace(), po.getDestination(), po.getContainerNumber(), po.getSupercargoMan(), po.getBarcodes(), po.getPrice(),po.getCheckType()));
				}
				return transshipmentvo;		
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean passAllDoc(DocType docType, String time) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				ArrayList<MoneyInListPO> moneyinpo=moneyin.showAll(time, time);
				if(moneyinpo==null)
					return false;
				for(MoneyInListPO po:moneyinpo){
					po.setCheckType(CheckType.PASS);
					moneyin.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过收款单",user.getAdmin()));
				return true;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListPO> moneyoutpo=moneyout.showAll(time, time);
				if(moneyoutpo==null)
					return false;
				for(MoneyOutListPO po:moneyoutpo){
					po.setCheckType(CheckType.PASS);
					moneyout.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过付款单",user.getAdmin()));
				return true;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInPO> repertoryinpo=repertoryin.showAll(time, time);
				if(repertoryinpo==null)
					return false;
				for(RepertoryInPO po:repertoryinpo){
					po.setCheckType(CheckType.PASS);
					repertoryin.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过入库单",user.getAdmin()));
				return true;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutPO> repertoryoutpo=repertoryout.showAll(time, time);
				if(repertoryoutpo==null)
					return false;
				for(RepertoryOutPO po:repertoryoutpo){
					po.setCheckType(CheckType.PASS);
					repertoryout.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过出库单",user.getAdmin()));
				return true;
			case SENDING_NOTE:
				ArrayList<OrderListPO> orderpo=order.showAll(time, time);
				if(orderpo==null)
					return false;
				for(OrderListPO po:orderpo){
					po.setCheckType(CheckType.PASS);
					order.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过快递单",user.getAdmin()));
				return true;
			case LOADING_NOTE:
				ArrayList<LoadListPO> loadpo=load.showAll(time, time);
				if(loadpo==null)
					return false;
				for(LoadListPO po:loadpo){
					po.setCheckType(CheckType.PASS);
					load.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过装车单",user.getAdmin()));
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListPO> hallarrivalpo=hallarrival.showAll(time, time);
				if(hallarrivalpo==null)
					return false;
				for(HallArrivalListPO po:hallarrivalpo){
					po.setCheckType(CheckType.PASS);
					hallarrival.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过营业厅到达单",user.getAdmin()));
				return true;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListPO> deliverlistpo=deliver.showAll(time, time);
				if(deliverlistpo==null)
					return false;
				for(DeliveringListPO po:deliverlistpo){
					po.setCheckType(CheckType.PASS);
					deliver.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过派件单",user.getAdmin()));
				return true;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListPO> transarrivalpo=transarrival.showAll(time, time);
				if(transarrivalpo==null)
					return false;
				for(TransArrivalListPO po:transarrivalpo){
					po.setCheckType(CheckType.PASS);
					transarrival.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过中转中心到达单",user.getAdmin()));
				return true;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListPO> transshipmentpo=transshipment.showAll(time, time);
				if(transshipmentpo==null)
					return false;
				for(TransShipmentListPO po:transshipmentpo){
					po.setCheckType(CheckType.PASS);
					transshipment.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过中转单",user.getAdmin()));
				return true;
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return false;
	}		

	public boolean passSelectedDoc(DocType docType, ArrayList<? extends ListVO> listVO) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				ArrayList<MoneyInListVO> moneyinvo=(ArrayList<MoneyInListVO>)listVO;
				for(MoneyInListVO vo:moneyinvo){
				MoneyInListPO po=moneyin.findOnID(vo.getId());
				po.setCheckType(CheckType.PASS);
				moneyin.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过收款单",user.getAdmin()));
				return true;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListVO> moneyoutvo=(ArrayList<MoneyOutListVO>)listVO;
				for(MoneyOutListVO vo:moneyoutvo){
					MoneyOutListPO po=moneyout.findOnID(vo.getId());
					po.setCheckType(CheckType.PASS);
					moneyout.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过付款单",user.getAdmin()));
				return true;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInVO> repertoryinvo=(ArrayList<RepertoryInVO>)listVO;
				for(RepertoryInVO vo:repertoryinvo){
					RepertoryInPO po=repertoryin.findOnID(vo.getId());
					po.setCheckType(CheckType.PASS);
					repertoryin.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过入库单",user.getAdmin()));
				return true;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutVO> repertoryoutvo=(ArrayList<RepertoryOutVO>)listVO;
				for(RepertoryOutVO vo:repertoryoutvo){
					RepertoryOutPO po=repertoryout.findOnID(vo.getId());
					po.setCheckType(CheckType.PASS);
					repertoryout.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过出库单",user.getAdmin()));
				return true;
			case SENDING_NOTE:
				ArrayList<OrderListVO> ordervo=(ArrayList<OrderListVO>)listVO;
				for(OrderListVO vo:ordervo){
					OrderListPO po=order.find(vo.getBarCode());
					po.setCheckType(CheckType.PASS);
					order.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过快递单",user.getAdmin()));
				return true;
			case LOADING_NOTE:
				ArrayList<LoadListVO> loadvo=(ArrayList<LoadListVO>)listVO;
				for(LoadListVO vo:loadvo){
					LoadListPO po=load.find(vo.getTranspotationNumber());
					po.setCheckType(CheckType.PASS);
					load.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过装车单",user.getAdmin()));
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListVO> hallarrivalvo=(ArrayList<HallArrivalListVO>)listVO;
				for(HallArrivalListVO vo:hallarrivalvo){
					HallArrivalListPO po=hallarrival.find(vo.getId());
				    po.setCheckType(CheckType.PASS);
				    hallarrival.update(po);	
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过营业厅到达单",user.getAdmin()));
				return true;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListVO> delivervo=(ArrayList<DeliveringListVO>)listVO;
				for(DeliveringListVO vo:delivervo){
					DeliveringListPO po=deliver.find(vo.getId());
					po.setCheckType(CheckType.PASS);
					deliver.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过收款单",user.getAdmin()));
				return true;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListVO> transarrivalvo=(ArrayList<TransArrivalListVO>)listVO;
				for(TransArrivalListVO vo:transarrivalvo){
					TransArrivalListPO po=transarrival.find(vo.getTransferNumber());
					po.setCheckType(CheckType.PASS);
					transarrival.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过中转中心到达单",user.getAdmin()));
				return true;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListVO> transshipmentvo=(ArrayList<TransShipmentListVO> )listVO;
				for(TransShipmentListVO vo:transshipmentvo){
					TransShipmentListPO po=transshipment.find(vo.getTransitDocNumber());
					po.setCheckType(CheckType.PASS);
					transshipment.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过中转单",user.getAdmin()));
				return true;
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean failSelectedDoc(DocType docType, ArrayList<? extends ListVO> listVO) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				ArrayList<MoneyInListVO> moneyinvo=(ArrayList<MoneyInListVO>)listVO;
				for(MoneyInListVO vo:moneyinvo){
				MoneyInListPO po=moneyin.findOnID(vo.getId());
				po.setCheckType(CheckType.NOTPASS);
				moneyin.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过收款单",user.getAdmin()));
				return true;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListVO> moneyoutvo=(ArrayList<MoneyOutListVO>)listVO;
				for(MoneyOutListVO vo:moneyoutvo){
					MoneyOutListPO po=moneyout.findOnID(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					moneyout.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过付款单",user.getAdmin()));
				return true;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInVO> repertoryinvo=(ArrayList<RepertoryInVO>)listVO;
				for(RepertoryInVO vo:repertoryinvo){
					RepertoryInPO po=repertoryin.findOnID(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					repertoryin.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过入库单",user.getAdmin()));
				return true;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutVO> repertoryoutvo=(ArrayList<RepertoryOutVO>)listVO;
				for(RepertoryOutVO vo:repertoryoutvo){
					RepertoryOutPO po=repertoryout.findOnID(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					repertoryout.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过出库单",user.getAdmin()));
				return true;
			case SENDING_NOTE:
				ArrayList<OrderListVO> ordervo=(ArrayList<OrderListVO>)listVO;
				for(OrderListVO vo:ordervo){
					OrderListPO po=order.find(vo.getBarCode());
					po.setCheckType(CheckType.NOTPASS);
					order.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过快递单",user.getAdmin()));
				return true;
			case LOADING_NOTE:
				ArrayList<LoadListVO> loadvo=(ArrayList<LoadListVO>)listVO;
				for(LoadListVO vo:loadvo){
					LoadListPO po=load.find(vo.getTranspotationNumber());
					po.setCheckType(CheckType.NOTPASS);
					load.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过装车单",user.getAdmin()));
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListVO> hallarrivalvo=(ArrayList<HallArrivalListVO>)listVO;
				for(HallArrivalListVO vo:hallarrivalvo){
					HallArrivalListPO po=hallarrival.find(vo.getId());
				    po.setCheckType(CheckType.NOTPASS);
				    hallarrival.update(po);	
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过营业厅到达单",user.getAdmin()));
				return true;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListVO> delivervo=(ArrayList<DeliveringListVO>)listVO;
				for(DeliveringListVO vo:delivervo){
					DeliveringListPO po=deliver.find(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					deliver.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过派件单",user.getAdmin()));
				return true;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListVO> transarrivalvo=(ArrayList<TransArrivalListVO>)listVO;
				for(TransArrivalListVO vo:transarrivalvo){
					TransArrivalListPO po=transarrival.find(vo.getTransferNumber());
					po.setCheckType(CheckType.NOTPASS);
					transarrival.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过中转中心到达单",user.getAdmin()));
				return true;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListVO> transshipmentvo=(ArrayList<TransShipmentListVO> )listVO;
				for(TransShipmentListVO vo:transshipmentvo){
					TransShipmentListPO po=transshipment.find(vo.getTransitDocNumber());
					po.setCheckType(CheckType.NOTPASS);
					transshipment.update(po);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过中转单",user.getAdmin()));
				return true;
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return false;
	}

	public boolean ChangeDoc(DocType docType, ListVO listVO) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				MoneyInListVO moneyinvo=(MoneyInListVO)listVO;
				MoneyInListPO moneyinpo=new MoneyInListPO(moneyinvo.getId(),moneyinvo.getDate(),moneyinvo.getMoneySum(),moneyinvo.getStaffId(),moneyinvo.getBarcode(),moneyinvo.getCheckType());
				moneyin.update(moneyinpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变收款单信息",user.getAdmin()));
				return true;
			case MONET_OUT_NOTE:
				MoneyOutListVO moneyoutvo=(MoneyOutListVO)listVO;
				MoneyOutListPO moneyoutpo=new MoneyOutListPO(moneyoutvo.getId(), moneyoutvo.getDate(), moneyoutvo.getMoney(), moneyoutvo.getPayer(), moneyoutvo.getAccountNum(), moneyoutvo.getClause(), moneyoutvo.getNote(), moneyoutvo.getCheckType());
				moneyout.update(moneyoutpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变付款单信息",user.getAdmin()));
				return true;
			case IN_STOREAGE_NOTE:
				RepertoryInVO repertoryinvo=(RepertoryInVO)listVO;
				RepertoryInPO repertoryinpo=new RepertoryInPO(repertoryinvo.getId(),repertoryinvo.getNum(),repertoryinvo.getTime(),repertoryinvo.getDestination(),repertoryinvo.getAreacode(),repertoryinvo.getRownumber(),repertoryinvo.getFramenumber(),repertoryinvo.getFramenumber(),repertoryinvo.getCheckType());
				repertoryin.update(repertoryinpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变入库单信息",user.getAdmin()));
				return true;
			case OUT_STOREAGE_NOTE:
				RepertoryOutVO repertoryoutvo=(RepertoryOutVO)listVO;
				RepertoryOutPO repertoryoutpo=new RepertoryOutPO(repertoryoutvo.getId(),repertoryoutvo.getCode(),repertoryoutvo.getTime(),repertoryoutvo.getDestination(),repertoryoutvo.getTransportation(),repertoryoutvo.getTransCode(),repertoryoutvo.getCheckType());
				repertoryout.update(repertoryoutpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变出库单信息",user.getAdmin()));
				return true;
			case SENDING_NOTE:
				OrderListVO ordervo=(OrderListVO)listVO;
				OrderListPO orderpo=new OrderListPO(ordervo.getSenderName(),ordervo.getSenderAddress(),ordervo.getSenderTeleNumber(),ordervo.getReceiverName(),ordervo.getReceiverAddress(),ordervo.getReceiverTeleNumber(),ordervo.getNumber(),ordervo.getWeight(),ordervo.getVolume(),ordervo.getName(),ordervo.getCategory(),ordervo.getPkgState(),ordervo.getPackPrice(),ordervo.getBarCode(),ordervo.getPkgType(),ordervo.getDepartTime(),ordervo.getArriveTime(),ordervo.getCheckType(),ordervo.realreceiver,ordervo.realreceivertelenumber);
				order.update(orderpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变快递单信息",user.getAdmin()));
				return true;
			case LOADING_NOTE:
				LoadListVO loadvo=(LoadListVO)listVO;
				LoadListPO loadpo=new LoadListPO(loadvo.getDate(),loadvo.getHallNumber(),loadvo.getTranspotationNumber(),loadvo.getDestination(),loadvo.getCarNumber(),loadvo.getGuardMan(),loadvo.getSupercargoMan(),loadvo.getBarcodes(),loadvo.getCheckType());
				load.update(loadpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变装车单信息",user.getAdmin()));
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				HallArrivalListVO hallarrivalvo=(HallArrivalListVO)listVO;
				ArrayList<GoodsInfoPO> goodspolist=new ArrayList<GoodsInfoPO>();
				for(GoodsInfoVO goodspo:hallarrivalvo.getGoodsInfoVO()){
					goodspolist.add(new GoodsInfoPO(goodspo.getBarcode(),goodspo.getState()));
				}
				HallArrivalListPO hallarrivalpo=new HallArrivalListPO(hallarrivalvo.getId(),hallarrivalvo.getDate(),hallarrivalvo.getTransferNumber(),hallarrivalvo.getDepartureplace(),goodspolist,hallarrivalvo.getCheckType());
				hallarrival.update(hallarrivalpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变营业厅到达单信息",user.getAdmin()));
				return true;
			case DELIVERYING_NOTE:
				DeliveringListVO delivervo=(DeliveringListVO)listVO;
				DeliveringListPO deliverpo=new DeliveringListPO(delivervo.getId(),delivervo.getDate(),delivervo.getBarCode(),delivervo.getDeliveryMan(),delivervo.getCheckType());
				deliver.update(deliverpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变派件单信息",user.getAdmin()));
				return true;
			case CENTER_ARRIVAL_NOTE:
				TransArrivalListVO transarrivalvo=(TransArrivalListVO)listVO;
				ArrayList<GoodsInfoPO> goodpo=new ArrayList<GoodsInfoPO>();
				for(GoodsInfoVO goodvo:transarrivalvo.getGoodsInfoVOs()){
					goodpo.add(new GoodsInfoPO(goodvo.getBarcode(), goodvo.getState()));
				}
				TransArrivalListPO transarrivalpo=new TransArrivalListPO(transarrivalvo.getId(),transarrivalvo.getTransferNumber(),transarrivalvo.getCenterNumber(),transarrivalvo.getDate(),transarrivalvo.getDepartureplace(),goodpo,transarrivalvo.getCheckType());
				transarrival.update(transarrivalpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变中转中心到达单信息",user.getAdmin()));
				return true;
			case TRANSIT_NOTE:
				TransShipmentListVO transshipmentvo=(TransShipmentListVO)listVO;
				TransShipmentListPO transshipmentpo=new TransShipmentListPO(transshipmentvo.getDate(),transshipmentvo.getTransitDocNumber(),transshipmentvo.getFlightNumber(),transshipmentvo.getDeparturePlace(),transshipmentvo.getDesitination(),transshipmentvo.getContainerNumber(),transshipmentvo.getSupercargoMan(),transshipmentvo.getBarcodes(),transshipmentvo.getPrice(),transshipmentvo.getCheckType());
				transshipment.update(transshipmentpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变中转单信息",user.getAdmin()));
				return true;
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return false;
	}


	public ResultMessage passAllSelected(DocType docType, ArrayList<String> id) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				for(String Id:id){
				MoneyInListPO moneyinpo=moneyin.findOnID(Id);
				moneyinpo.setCheckType(CheckType.PASS);
				moneyin.update(moneyinpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有收款单",user.getAdmin()));
				return new ResultMessage(true,"审核通过所有收款单!");
			case MONET_OUT_NOTE:
				for(String Id:id){
				MoneyOutListPO moneyoutpo=moneyout.findOnID(Id);
				moneyoutpo.setCheckType(CheckType.PASS);
				moneyout.update(moneyoutpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有付款单",user.getAdmin()));
				return new ResultMessage(true, "审核通过所有付款单!");
			case IN_STOREAGE_NOTE:
				for(String Id:id){
				RepertoryInPO repertoryinpo=repertoryin.findOnID(Id);
				repertoryinpo.setCheckType(CheckType.PASS);
				repertoryin.update(repertoryinpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有入库单",user.getAdmin()));
				return new ResultMessage(true,"审核通过所有入库单!");
			case OUT_STOREAGE_NOTE:
				for(String Id:id){
				RepertoryOutPO repertoryoutpo=repertoryout.findOnID(Id);
				repertoryoutpo.setCheckType(CheckType.PASS);
				repertoryout.update(repertoryoutpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有出库单",user.getAdmin()));
				return new ResultMessage(true,"审核通过所有出库单!");
			case SENDING_NOTE:
				for(String Id:id){
				OrderListPO orderpo=order.find(Id);
				orderpo.setCheckType(CheckType.PASS);
				order.update(orderpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有快递单",user.getAdmin()));
				return new ResultMessage(true,"审核通过所有快递单!");
			case LOADING_NOTE:
				for(String Id:id){
				LoadListPO loadpo=load.find(Id);
				loadpo.setCheckType(CheckType.PASS);
				load.update(loadpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有装车单",user.getAdmin()));
				return new ResultMessage(true,"审核通过所有装车单!");
			case BUSINESSHALL_ARRIVAL_NOTE:
				for(String Id:id){
				HallArrivalListPO hallarrivalpo=hallarrival.find(Id);
				hallarrivalpo.setCheckType(CheckType.PASS);
				hallarrival.update(hallarrivalpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有营业厅到达单",user.getAdmin()));
				return new ResultMessage(true, "审核通过所有营业厅到达单!");
			case DELIVERYING_NOTE:
				for(String Id:id){
				DeliveringListPO deliverpo=deliver.find(Id);
				deliverpo.setCheckType(CheckType.PASS);
				deliver.update(deliverpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有派件单",user.getAdmin()));
				return new ResultMessage(true, "审核通过所有派件单!");
			case CENTER_ARRIVAL_NOTE:
				for(String Id:id){
				TransArrivalListPO transarrivalpo=transarrival.find(Id);
				transarrivalpo.setCheckType(CheckType.PASS);
				transarrival.update(transarrivalpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有中转中心到达单",user.getAdmin()));
				return new ResultMessage(true,"审核通过所有中转中心到达单!");
			case TRANSIT_NOTE:
				for(String Id:id){
				TransShipmentListPO transshipmentpo=transshipment.find(Id);
				transshipmentpo.setCheckType(CheckType.PASS);
				transshipment.update(transshipmentpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核通过所有中转单",user.getAdmin()));
				return new ResultMessage(true,"审核通过所有中转单!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}


	public ResultMessage failAllSelected(DocType docType, ArrayList<String> id) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				for(String Id:id){
				MoneyInListPO moneyinpo=moneyin.findOnID(Id);
				moneyinpo.setCheckType(CheckType.NOTPASS);
				moneyin.update(moneyinpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有收款单",user.getAdmin()));
				return new ResultMessage(true,"审核未通过所有收款单!");
			case MONET_OUT_NOTE:
				for(String Id:id){
				MoneyOutListPO moneyoutpo=moneyout.findOnID(Id);
				moneyoutpo.setCheckType(CheckType.NOTPASS);
				moneyout.update(moneyoutpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有付款单",user.getAdmin()));
				return new ResultMessage(true, "审核未通过所有付款单!");
			case IN_STOREAGE_NOTE:
				for(String Id:id){
				RepertoryInPO repertoryinpo=repertoryin.findOnID(Id);
				repertoryinpo.setCheckType(CheckType.NOTPASS);
				repertoryin.update(repertoryinpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有入库单",user.getAdmin()));
				return new ResultMessage(true,"审核未通过所有入库单!");
			case OUT_STOREAGE_NOTE:
				for(String Id:id){
				RepertoryOutPO repertoryoutpo=repertoryout.findOnID(Id);
				repertoryoutpo.setCheckType(CheckType.NOTPASS);
				repertoryout.update(repertoryoutpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有出库单",user.getAdmin()));
				return new ResultMessage(true,"审核未通过所有出库单!");
			case SENDING_NOTE:
				for(String Id:id){
				OrderListPO orderpo=order.find(Id);
				orderpo.setCheckType(CheckType.NOTPASS);
				order.update(orderpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有快递单",user.getAdmin()));
				return new ResultMessage(true,"审核未通过所有快递单!");
			case LOADING_NOTE:
				for(String Id:id){
				LoadListPO loadpo=load.find(Id);
				loadpo.setCheckType(CheckType.NOTPASS);
				load.update(loadpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有装车单",user.getAdmin()));
				return new ResultMessage(true,"审核未通过所有装车单!");
			case BUSINESSHALL_ARRIVAL_NOTE:
				for(String Id:id){
				HallArrivalListPO hallarrivalpo=hallarrival.find(Id);
				hallarrivalpo.setCheckType(CheckType.NOTPASS);
				hallarrival.update(hallarrivalpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有营业厅到达单",user.getAdmin()));
				return new ResultMessage(true, "审核未通过所有营业厅到达单!");
			case DELIVERYING_NOTE:
				for(String Id:id){
				DeliveringListPO deliverpo=deliver.find(Id);
				deliverpo.setCheckType(CheckType.NOTPASS);
				deliver.update(deliverpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有派件单",user.getAdmin()));
				return new ResultMessage(true, "审核未通过所有派件单!");
			case CENTER_ARRIVAL_NOTE:
				for(String Id:id){
				TransArrivalListPO transarrivalpo=transarrival.find(Id);
				transarrivalpo.setCheckType(CheckType.NOTPASS);
				transarrival.update(transarrivalpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有中转中心到达单",user.getAdmin()));
				return new ResultMessage(true,"审核未通过所有中转中心到达单!");
			case TRANSIT_NOTE:
				for(String Id:id){
				TransShipmentListPO transshipmentpo=transshipment.find(Id);
				transshipmentpo.setCheckType(CheckType.NOTPASS);
				transshipment.update(transshipmentpo);
				}
				system.add(new SystemLogPO((String)df.format(new Date()),"审核未通过所有中转单",user.getAdmin()));
				return new ResultMessage(true,"审核未通过所有中转单!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

}
