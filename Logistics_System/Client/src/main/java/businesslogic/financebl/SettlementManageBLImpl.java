package businesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.StaffPO;
import po.moneyInfomation.MoneyInListPO;
import po.moneyInfomation.MoneyOutListPO;
import dataservice.agency.StaffDataService;
import dataservice.moneyInformation.MoneyInListDataService;
import utility.ResultMessage;
import vo.MoneyInListVO;
import vo.MoneyOutListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.SettlementManageBLService;

public class SettlementManageBLImpl implements SettlementManageBLService {
    MoneyInListDataService moneyinlistdataservice=null;
    StaffDataService staffdataservice=null;
    public SettlementManageBLImpl(){
    	this.moneyinlistdataservice=(MoneyInListDataService)RMIHelper.find("MoneyInListDataService");
    }

	public ArrayList<MoneyInListVO> searchbyhall(String start_day,
			String end_day, String hall_id) {
		// TODO 自动生成的方法存根
		staffdataservice=(StaffDataService)RMIHelper.find("StaffDataService");
		ArrayList<MoneyInListVO> moneyinvo=search(start_day,end_day);
		ArrayList<MoneyInListVO> moneyin=new ArrayList<MoneyInListVO>();
		try{
			for(MoneyInListVO vo:moneyinvo){
				StaffPO staff=staffdataservice.find(vo.getStaffId());
				if(staff.getId().substring(0,6).equals(hall_id))
					moneyin.add(vo);
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return moneyin;
	}
	public ArrayList<MoneyInListVO> search(String start_day, String end_day) {
		// TODO 自动生成的方法存根
		ArrayList<MoneyInListVO> moneyinvo=new ArrayList<MoneyInListVO>();
		ArrayList<MoneyInListPO> moneyinpo=new ArrayList<MoneyInListPO>();
		try{
			moneyinpo=moneyinlistdataservice.showAll(start_day, end_day);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(MoneyInListPO po:moneyinpo){
			moneyinvo.add(new MoneyInListVO(po.getId(),po.getDate(),po.getMoneySum(),po.getStaffId(),po.getBarcode(),po.getCheckType()));
		}
		
		return moneyinvo;
	
	}
	public ResultMessage createMoneyInList(MoneyInListVO moneyin) {
		// TODO 自动生成的方法存根
		MoneyInListPO moneyinpo=new MoneyInListPO(moneyin.getId(),moneyin.getDate(),moneyin.getMoneySum(),moneyin.getStaffId(),moneyin.getBarcode(),moneyin.getCheckType());
		try{
			moneyinlistdataservice.add(moneyinpo);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(true,"添加收款单成功!");
	}

}
