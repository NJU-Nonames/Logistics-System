package businesslogic.chartbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.moneyInfomation.MoneyInListPO;
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
import vo.ListVO;
import vo.MoneyInListVO;
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
