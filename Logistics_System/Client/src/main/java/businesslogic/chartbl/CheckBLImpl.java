package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

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
import po.repertory.RepertoryInfoPO;
import po.repertory.RepertoryOutPO;
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
import utility.CheckType;
import utility.DocType;
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
	
	public CheckBLImpl(){
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
	}
	

	public ArrayList<? extends ListVO> getAll(DocType docType, String time) {
		// TODO Auto-generated method stub
		try{
			switch(docType){
			case MONEY_IN_NOTE:
				ArrayList<MoneyInListPO> moneyinpo=moneyin.showAll(time, time);
				ArrayList<MoneyInListVO> moneyinvo=new ArrayList<MoneyInListVO>();
				for(MoneyInListPO po:moneyinpo){
					moneyinvo.add(new MoneyInListVO(po.getId(), po.getDate(), po.getMoneySum(), po.getStaffId(), po.getBarcode(), po.getCheckType()));
				}
				return moneyinvo;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListPO> moneyoutpo=moneyout.showAll(time, time);
				ArrayList<MoneyOutListVO> moneyoutvo=new ArrayList<MoneyOutListVO>();
				for(MoneyOutListPO po:moneyoutpo){
					moneyoutvo.add(new MoneyOutListVO(po.getId(), po.getDate(), po.getMoney(), po.getPayer(), po.getAccountNum(), po.getClause(), po.getNote(), po.getCheckType()));
				}
				return moneyoutvo;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInPO> repertoryinpo=repertoryin.showAll(time, time);
				ArrayList<RepertoryInVO> repertoryinvo=new ArrayList<RepertoryInVO>();
				for(RepertoryInPO po:repertoryinpo){
					repertoryinvo.add(new RepertoryInVO(po.getId(), po.getNum(), po.getTime(), po.getDestnation(), po.getAreacode(), po.getRownumber(), po.getFramenumber(), po.getPlacenumber(), po.getCheckType()));
				}
				return repertoryinvo;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutPO> repertoryoutpo=repertoryout.showAll(time, time);
				ArrayList<RepertoryOutVO> repertoryoutvo=new ArrayList<RepertoryOutVO>();
				for(RepertoryOutPO po:repertoryoutpo){
					repertoryoutvo.add(new RepertoryOutVO(po.getId(), po.getCode(), po.getTime(), po.getDestnation(), po.getTransportation(), po.getTransCode(), po.getVehicleCode(), po.getCheckType()));
				}
				return repertoryoutvo;
			case SENDING_NOTE:
				ArrayList<OrderListPO> orderpo=order.showAll(time, time);
				ArrayList<OrderListVO> ordervo=new ArrayList<OrderListVO>();
				for(OrderListPO po:orderpo){
					ordervo.add(new OrderListVO(po.getSenderName(), po.getSenderAddress(), po.getSenderTeleNumber(), po.getReceiverName(), po.getReceiverAddress(), po.getReceiverTeleNumber(), po.getNumber(), po.getWeight(), po.getVolume(), po.getName(), po.getCategory(), po.getPkgState(), po.getPackPrice(), po.getBarCode(), po.getPkgType(), po.getDepartTime(), po.getArriveTime(), po.getCheckType()));
				}
				return ordervo;
			case LOADING_NOTE:
				ArrayList<LoadListPO> loadpo=load.showAll(time, time);
				ArrayList<LoadListVO> loadvo=new ArrayList<LoadListVO>();
				for(LoadListPO po:loadpo){
					loadvo.add(new LoadListVO(po.getId(), po.getDate(), po.getHallNumber(), po.getTransportationNumber(), po.getDestination(), po.getCarNumber(), po.getGuardMan(), po.getSupercargoMan(), po.getBarcodes(), po.getCheckType()));
				}
				return loadvo;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListPO> hallarrivalpo=hallarrival.showAll(time, time);
				ArrayList<HallArrivalListVO> hallarrivalvo=new ArrayList<HallArrivalListVO>();
				for(HallArrivalListPO po:hallarrivalpo){
					hallarrivalvo.add(new HallArrivalListVO(po.getId(), po.getDate(), po.getTransferNumber(), po.getFrom(), po.getState(), po.getBarCodes(),po.getCheckType()));
				}
				return hallarrivalvo;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListPO> deliverlistpo=deliver.showAll(time, time);
				ArrayList<DeliveringListVO> deliverlistvo=new ArrayList<DeliveringListVO>();
		        for(DeliveringListPO po:deliverlistpo){		
		        	deliverlistvo.add(new DeliveringListVO(po.getId(), po.getDate(), po.getBarCode(), po.getDeliveryMan(), po.getCheckType()));
		        }
		        return deliverlistvo;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListPO> transarrivalpo=transarrival.showAll(time, time);
				ArrayList<TransArrivalListVO> transarrivalvo=new ArrayList<TransArrivalListVO>();
				for(TransArrivalListPO po:transarrivalpo){
				ArrayList<GoodsInfoVO> goodvo=new ArrayList<GoodsInfoVO>();
					for(GoodsInfoPO goods:po.getGoodsInfoPOs())
						goodvo.add(new GoodsInfoVO(goods.getBarcode(), goods.getState(),goods.getDeparturePlace()));
					transarrivalvo.add(new TransArrivalListVO(po.getId(), po.getTransferNumber(), po.getCenterNumber(), po.getDate(), goodvo, po.getCheckType()));
				}
				return transarrivalvo;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListPO> transshipmentpo=transshipment.showAll(time, time);
				ArrayList<TransShipmentListVO> transshipmentvo=new ArrayList<TransShipmentListVO>();
				for(TransShipmentListPO po:transshipmentpo){
					transshipmentvo.add(new TransShipmentListVO(po.getDate(), po.getTransitDocNumber(), po.getFlightNumber(), po.getDeparturePlace(), po.getDestination(), po.getContainerNumber(), po.getSupercargoMan(), po.getBarcodes(), po.getCheckType()));
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
				for(MoneyInListPO po:moneyinpo){
					po.setCheckType(CheckType.PASS);
					moneyin.update(po);
				}
				return true;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListPO> moneyoutpo=moneyout.showAll(time, time);
				for(MoneyOutListPO po:moneyoutpo){
					po.setCheckType(CheckType.PASS);
					moneyout.update(po);
				}
				return true;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInPO> repertoryinpo=repertoryin.showAll(time, time);
				for(RepertoryInPO po:repertoryinpo){
					po.setCheckType(CheckType.PASS);
					repertoryin.update(po);
				}
				return true;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutPO> repertoryoutpo=repertoryout.showAll(time, time);
				for(RepertoryOutPO po:repertoryoutpo){
					po.setCheckType(CheckType.PASS);
					repertoryout.update(po);
				}
				return true;
			case SENDING_NOTE:
				ArrayList<OrderListPO> orderpo=order.showAll(time, time);
				for(OrderListPO po:orderpo){
					po.setCheckType(CheckType.PASS);
					order.update(po);
				}
				return true;
			case LOADING_NOTE:
				ArrayList<LoadListPO> loadpo=load.showAll(time, time);
				for(LoadListPO po:loadpo){
					po.setCheckType(CheckType.PASS);
					load.update(po);
				}
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListPO> hallarrivalpo=hallarrival.showAll(time, time);
				for(HallArrivalListPO po:hallarrivalpo){
					po.setCheckType(CheckType.PASS);
					hallarrival.update(po);
				}
				return true;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListPO> deliverlistpo=deliver.showAll(time, time);
				for(DeliveringListPO po:deliverlistpo){
					po.setCheckType(CheckType.PASS);
					deliver.update(po);
				}
				return true;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListPO> transarrivalpo=transarrival.showAll(time, time);
				for(TransArrivalListPO po:transarrivalpo){
					po.setCheckType(CheckType.PASS);
					transarrival.update(po);
				}
				return true;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListPO> transshipmentpo=transshipment.showAll(time, time);
				for(TransShipmentListPO po:transshipmentpo){
					po.setCheckType(CheckType.PASS);
					transshipment.update(po);
				}
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
				return true;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListVO> moneyoutvo=(ArrayList<MoneyOutListVO>)listVO;
				for(MoneyOutListVO vo:moneyoutvo){
					MoneyOutListPO po=moneyout.findOnID(vo.getId());
					po.setCheckType(CheckType.PASS);
					moneyout.update(po);
				}
				return true;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInVO> repertoryinvo=(ArrayList<RepertoryInVO>)listVO;
				for(RepertoryInVO vo:repertoryinvo){
					RepertoryInPO po=repertoryin.findOnID(vo.getId());
					po.setCheckType(CheckType.PASS);
					repertoryin.update(po);
				}
				return true;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutVO> repertoryoutvo=(ArrayList<RepertoryOutVO>)listVO;
				for(RepertoryOutVO vo:repertoryoutvo){
					RepertoryOutPO po=repertoryout.findOnID(vo.getId());
					po.setCheckType(CheckType.PASS);
					repertoryout.update(po);
				}
				return true;
			case SENDING_NOTE:
				ArrayList<OrderListVO> ordervo=(ArrayList<OrderListVO>)listVO;
				for(OrderListVO vo:ordervo){
					OrderListPO po=order.find(vo.getBarCode());
					po.setCheckType(CheckType.PASS);
					order.update(po);
				}
				return true;
			case LOADING_NOTE:
				ArrayList<LoadListVO> loadvo=(ArrayList<LoadListVO>)listVO;
				for(LoadListVO vo:loadvo){
					LoadListPO po=load.find(vo.getId());
					po.setCheckType(CheckType.PASS);
					load.update(po);
				}
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListVO> hallarrivalvo=(ArrayList<HallArrivalListVO>)listVO;
				for(HallArrivalListVO vo:hallarrivalvo){
					HallArrivalListPO po=hallarrival.find(vo.getId());
				    po.setCheckType(CheckType.PASS);
				    hallarrival.update(po);	
				}
				return true;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListVO> delivervo=(ArrayList<DeliveringListVO>)listVO;
				for(DeliveringListVO vo:delivervo){
					DeliveringListPO po=deliver.find(vo.getId());
					po.setCheckType(CheckType.PASS);
					deliver.update(po);
				}
				return true;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListVO> transarrivalvo=(ArrayList<TransArrivalListVO>)listVO;
				for(TransArrivalListVO vo:transarrivalvo){
					TransArrivalListPO po=transarrival.find(vo.getId());
					po.setCheckType(CheckType.PASS);
					transarrival.update(po);
				}
				return true;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListVO> transshipmentvo=(ArrayList<TransShipmentListVO> )listVO;
				for(TransShipmentListVO vo:transshipmentvo){
					TransShipmentListPO po=transshipment.find(vo.getTransitDocNumber());
					po.setCheckType(CheckType.PASS);
					transshipment.update(po);
				}
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
				return true;
			case MONET_OUT_NOTE:
				ArrayList<MoneyOutListVO> moneyoutvo=(ArrayList<MoneyOutListVO>)listVO;
				for(MoneyOutListVO vo:moneyoutvo){
					MoneyOutListPO po=moneyout.findOnID(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					moneyout.update(po);
				}
				return true;
			case IN_STOREAGE_NOTE:
				ArrayList<RepertoryInVO> repertoryinvo=(ArrayList<RepertoryInVO>)listVO;
				for(RepertoryInVO vo:repertoryinvo){
					RepertoryInPO po=repertoryin.findOnID(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					repertoryin.update(po);
				}
				return true;
			case OUT_STOREAGE_NOTE:
				ArrayList<RepertoryOutVO> repertoryoutvo=(ArrayList<RepertoryOutVO>)listVO;
				for(RepertoryOutVO vo:repertoryoutvo){
					RepertoryOutPO po=repertoryout.findOnID(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					repertoryout.update(po);
				}
				return true;
			case SENDING_NOTE:
				ArrayList<OrderListVO> ordervo=(ArrayList<OrderListVO>)listVO;
				for(OrderListVO vo:ordervo){
					OrderListPO po=order.find(vo.getBarCode());
					po.setCheckType(CheckType.NOTPASS);
					order.update(po);
				}
				return true;
			case LOADING_NOTE:
				ArrayList<LoadListVO> loadvo=(ArrayList<LoadListVO>)listVO;
				for(LoadListVO vo:loadvo){
					LoadListPO po=load.find(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					load.update(po);
				}
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				ArrayList<HallArrivalListVO> hallarrivalvo=(ArrayList<HallArrivalListVO>)listVO;
				for(HallArrivalListVO vo:hallarrivalvo){
					HallArrivalListPO po=hallarrival.find(vo.getId());
				    po.setCheckType(CheckType.NOTPASS);
				    hallarrival.update(po);	
				}
				return true;
			case DELIVERYING_NOTE:
				ArrayList<DeliveringListVO> delivervo=(ArrayList<DeliveringListVO>)listVO;
				for(DeliveringListVO vo:delivervo){
					DeliveringListPO po=deliver.find(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					deliver.update(po);
				}
				return true;
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListVO> transarrivalvo=(ArrayList<TransArrivalListVO>)listVO;
				for(TransArrivalListVO vo:transarrivalvo){
					TransArrivalListPO po=transarrival.find(vo.getId());
					po.setCheckType(CheckType.NOTPASS);
					transarrival.update(po);
				}
				return true;
			case TRANSIT_NOTE:
				ArrayList<TransShipmentListVO> transshipmentvo=(ArrayList<TransShipmentListVO> )listVO;
				for(TransShipmentListVO vo:transshipmentvo){
					TransShipmentListPO po=transshipment.find(vo.getTransitDocNumber());
					po.setCheckType(CheckType.NOTPASS);
					transshipment.update(po);
				}
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
				return true;
			case MONET_OUT_NOTE:
				MoneyOutListVO moneyoutvo=(MoneyOutListVO)listVO;
				MoneyOutListPO moneyoutpo=new MoneyOutListPO(moneyoutvo.getId(), moneyoutvo.getDate(), moneyoutvo.getMoney(), moneyoutvo.getPayer(), moneyoutvo.getAccountNum(), moneyoutvo.getClause(), moneyoutvo.getNote(), moneyoutvo.getCheckType());
				moneyout.update(moneyoutpo);
				return true;
			case IN_STOREAGE_NOTE:
				RepertoryInVO repertoryinvo=(RepertoryInVO)listVO;
				RepertoryInPO repertoryinpo=new RepertoryInPO(repertoryinvo.getId(),repertoryinvo.getNum(),repertoryinvo.getTime(),repertoryinvo.getDestnation(),repertoryinvo.getAreacode(),repertoryinvo.getRownumber(),repertoryinvo.getFramenumber(),repertoryinvo.getFramenumber(),repertoryinvo.getCheckType());
				repertoryin.update(repertoryinpo);
				return true;
			case OUT_STOREAGE_NOTE:
				RepertoryOutVO repertoryoutvo=(RepertoryOutVO)listVO;
				RepertoryOutPO repertoryoutpo=new RepertoryOutPO(repertoryoutvo.getId(),repertoryoutvo.getCode(),repertoryoutvo.getTime(),repertoryoutvo.getDestnation(),repertoryoutvo.getTransportation(),repertoryoutvo.getTransCode(),repertoryoutvo.getVehicleCode(),repertoryoutvo.getCheckType());
				repertoryout.update(repertoryoutpo);
				return true;
			case SENDING_NOTE:
				OrderListVO ordervo=(OrderListVO)listVO;
				OrderListPO orderpo=new OrderListPO(ordervo.getSenderName(),ordervo.getSenderAddress(),ordervo.getSenderTeleNumber(),ordervo.getReceiverName(),ordervo.getReceiverAddress(),ordervo.getReceiverTeleNumber(),ordervo.getNumber(),ordervo.getWeight(),ordervo.getVolume(),ordervo.getName(),ordervo.getCategory(),ordervo.getPkgState(),ordervo.getPackPrice(),ordervo.getBarCode(),ordervo.getPkgType(),ordervo.getDepartTime(),ordervo.getArriveTime(),ordervo.getCheckType());
				order.update(orderpo);
				return true;
			case LOADING_NOTE:
				LoadListVO loadvo=(LoadListVO)listVO;
				LoadListPO loadpo=new LoadListPO(loadvo.getId(),loadvo.getDate(),loadvo.getHallNumber(),loadvo.getTranspotationNumber(),loadvo.getDestination(),loadvo.getCarNumber(),loadvo.getGuardMan(),loadvo.getSupercargoMan(),loadvo.getBarcodes(),loadvo.getCheckType());
				load.update(loadpo);
				return true;
			case BUSINESSHALL_ARRIVAL_NOTE:
				HallArrivalListVO hallarrivalvo=(HallArrivalListVO)listVO;
				HallArrivalListPO hallarrivalpo=new HallArrivalListPO(hallarrivalvo.getId(),hallarrivalvo.getDate(),hallarrivalvo.getTransferNumber(),hallarrivalvo.getFrom(),hallarrivalvo.getState(),hallarrivalvo.getBarCodes(),hallarrivalvo.getCheckType());
				hallarrival.update(hallarrivalpo);
				return true;
			case DELIVERYING_NOTE:
				DeliveringListVO delivervo=(DeliveringListVO)listVO;
				DeliveringListPO deliverpo=new DeliveringListPO(delivervo.getId(),delivervo.getDate(),delivervo.getBarCode(),delivervo.getDeliveryMan(),delivervo.getCheckType());
				deliver.update(deliverpo);
				return true;
			case CENTER_ARRIVAL_NOTE:
				TransArrivalListVO transarrivalvo=(TransArrivalListVO)listVO;
				ArrayList<GoodsInfoPO> goodpo=new ArrayList<GoodsInfoPO>();
				for(GoodsInfoVO goodvo:transarrivalvo.getGoodsInfoVOs()){
					goodpo.add(new GoodsInfoPO(goodvo.getBarcode(), goodvo.getState(), goodvo.getDeparturePlace()));
				}
				TransArrivalListPO transarrivalpo=new TransArrivalListPO(transarrivalvo.getId(),transarrivalvo.getTransferNumber(),transarrivalvo.getCenterNumber(),transarrivalvo.getDate(),goodpo,transarrivalvo.getCheckType());
				transarrival.update(transarrivalpo);
				return true;
			case TRANSIT_NOTE:
				TransShipmentListVO transshipmentvo=(TransShipmentListVO)listVO;
				TransShipmentListPO transshipmentpo=new TransShipmentListPO(transshipmentvo.getDate(),transshipmentvo.getTransitDocNumber(),transshipmentvo.getFlightNumber(),transshipmentvo.getDeparturePlace(),transshipmentvo.getDesitination(),transshipmentvo.getContainerNumber(),transshipmentvo.getSupercargoMan(),transshipmentvo.getBarcodes(),transshipmentvo.getCheckType());
				transshipment.update(transshipmentpo);
				return true;
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return false;
	}

}
