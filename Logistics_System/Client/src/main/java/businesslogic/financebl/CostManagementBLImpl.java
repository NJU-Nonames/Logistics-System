package businesslogic.financebl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.moneyInfomation.MoneyOutListPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.moneyInformation.MoneyOutListDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.MoneyOutListVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.CostManagementBLService;

public class CostManagementBLImpl implements CostManagementBLService{
    MoneyOutListDataService moneyoutlistdataservice=null;
    CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public CostManagementBLImpl(CurrentUser currentuser){
    	this.moneyoutlistdataservice=(MoneyOutListDataService)RMIHelper.find("MoneyOutListDataService");
    	user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
    }
	public ResultMessage createMoneyOutlist(MoneyOutListVO moneyOut) {
		// TODO Auto-generated method stub
		MoneyOutListPO moneyoutpo=null;
		try{
			moneyoutpo=moneyoutlistdataservice.findOnID(moneyOut.getId());
			if(moneyoutpo==null){
				moneyoutpo=new MoneyOutListPO(moneyOut.getId(),moneyOut.getDate(),moneyOut.getMoney(),moneyOut.getPayer(),moneyOut.getAccountNum(),moneyOut.getClause(),moneyOut.getNote(),moneyOut.getCheckType());
				moneyoutlistdataservice.add(moneyoutpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"创建付款单,单号为"+moneyOut.getId(),user.getAdmin()));
				return new ResultMessage(true,"添加付款单成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"付款单已存在!");
	}
	public ArrayList<MoneyOutListVO> search(String start_day, String end_day) {
		// TODO 自动生成的方法存根
		ArrayList<MoneyOutListVO> moneyoutvo=new ArrayList<MoneyOutListVO>();
		ArrayList<MoneyOutListPO> moneyoutpo=new ArrayList<MoneyOutListPO>();
		try{
			moneyoutpo=moneyoutlistdataservice.showAll(start_day, end_day);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(moneyoutpo==null)
			return null;
		for(MoneyOutListPO po:moneyoutpo){
			moneyoutvo.add(new MoneyOutListVO(po.getId(),po.getDate(),po.getMoney(),po.getPayer(),po.getAccountNum(),po.getClause(),po.getNote(),po.getCheckType()));
		}
		return moneyoutvo;
	}

}
