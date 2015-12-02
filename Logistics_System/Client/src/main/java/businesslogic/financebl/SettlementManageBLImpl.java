package businesslogic.financebl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import po.moneyInfomation.MoneyInListPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.moneyInformation.MoneyInListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.MoneyInListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.SettlementManageBLService;

public class SettlementManageBLImpl implements SettlementManageBLService {
    MoneyInListDataService moneyinlistdataservice=null;
    CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public SettlementManageBLImpl(CurrentUser currentuser){
    	this.moneyinlistdataservice=(MoneyInListDataService)RMIHelper.find("MoneyInListDataService");
    	user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
    }

	public ArrayList<MoneyInListVO> searchbyhall(String start_day,
			String end_day, String hall_id) {
		// TODO 自动生成的方法存根
		ArrayList<MoneyInListVO> moneyinvo=search(start_day,end_day);
		if(moneyinvo==null)
			return null;
		ArrayList<MoneyInListVO> moneyin=new ArrayList<MoneyInListVO>();
			for(MoneyInListVO vo:moneyinvo){
				if(vo.getStaffId().substring(0,6).equals(hall_id))
					moneyin.add(vo);
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
		if(moneyinpo==null)
			return null;
		for(MoneyInListPO po:moneyinpo){
			moneyinvo.add(new MoneyInListVO(po.getId(),po.getDate(),po.getMoneySum(),po.getStaffId(),po.getBarcode(),po.getCheckType()));
		}
		return moneyinvo;
	
	}
	public ResultMessage createMoneyInList(MoneyInListVO moneyin) {
		// TODO 自动生成的方法存根
		MoneyInListPO moneyinpo=null;
		try{
			moneyinpo=moneyinlistdataservice.findOnID(moneyin.getId());
			if(moneyinpo==null){
				moneyinpo=new MoneyInListPO(moneyin.getId(),moneyin.getDate(),moneyin.getMoneySum(),moneyin.getStaffId(),moneyin.getBarcode(),moneyin.getCheckType());
				moneyinlistdataservice.add(moneyinpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"创建收款单,单号为"+moneyin.getId(),user.getAdmin()));
				return new ResultMessage(true,"添加收款单成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"收款单已存在!");
	}

}
