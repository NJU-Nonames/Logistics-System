package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.list.DeliveringListPO;
import po.list.HallArrivalListPO;
import po.list.LoadListPO;
import po.list.OrderListPO;
import po.list.TransArrivalListPO;
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
			case CENTER_ARRIVAL_NOTE:
				ArrayList<TransArrivalListPO> transarrivalpo=transarrival.showAll(time, time);
				ArrayList<TransArrivalListVO> transarrivalvo=new ArrayList<TransArrivalListVO>();
				for(TransArrivalListPO po:transarrivalpo){
				ArrayList<GoodsInfoVO> goodvo=null;
					for(GoodsInfoPO goods:po.getGoodsInfoPOs())
						goodvo.add(new GoodsInfoVO(goods.getBarcode(), goods., goods.getDeparturePlace()));
					transarrivalvo.add(new TransArrivalListVO(po.getId(), po.getTransferNumber(), po.getCenterNumber(), po.getDate(), po.getGoodsInfoPOs(), po.getCheckType()));
				}
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return null;
	}

	public boolean passAllDoc(DocType docType, String time) {
		// TODO Auto-generated method stub
		return false;
	}		

	public boolean passSelectedDoc(DocType docType, ArrayList<? extends ListVO> listVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean failSelectedDoc(DocType docType, ArrayList<? extends ListVO> listVO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean ChangeDoc(DocType docType, ListVO listVO) {
		// TODO Auto-generated method stub
		return false;
	}

}
