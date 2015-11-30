package businesslogic.financebl;

import java.rmi.RemoteException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import po.agency.BankAccountPO;
import po.system.SystemLogPO;
import presentation.mainui.CurrentUser;
import dataservice.agency.BankAccountDataService;
import dataservice.system.SystemLogDataService;
import utility.ResultMessage;
import vo.BankAccountVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.AccountBLService;

public class AccountBLImpl implements AccountBLService {
	BankAccountDataService bankaccountdataservice=null;
	CurrentUser user=null;
	SystemLogDataService system=null;
	SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	public AccountBLImpl(CurrentUser currentuser){
		this.bankaccountdataservice=(BankAccountDataService)RMIHelper.find("BankAccountDataService");
		user=currentuser;
		system=(SystemLogDataService)RMIHelper.find("SystemLogDataService");
	}

	public ResultMessage createCount(BankAccountVO countVo) {
		// TODO Auto-generated method stub
		BankAccountPO bankpo=null;
		try{
			bankpo=bankaccountdataservice.find(countVo.getName());
			if(bankpo==null){
				bankpo=new BankAccountPO(countVo.getName(),countVo.getNumber(),countVo.getMoney());
				bankaccountdataservice.add(bankpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"添加账户信息",user.getname()));
				return new ResultMessage(true,"添加账户成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"账户已存在!");
	}

	public ResultMessage removeCount(String name) {
		// TODO Auto-generated method stub
		BankAccountPO bankpo=null;
		try{
			bankpo=bankaccountdataservice.find(name);
			if(bankpo!=null){
				bankaccountdataservice.delete(name);
				system.add(new SystemLogPO((String)df.format(new Date()),"删除账户信息",user.getname()));
				return new ResultMessage(true,"账户删除成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"要删除的账户不存在!");
	}
//只可以修改账户的名字
	public ResultMessage updateCount(BankAccountVO countVo) {
		// TODO Auto-generated method stub
		BankAccountPO bankpo=null;
		try{
			bankpo=bankaccountdataservice.find(countVo.getNumber());
			if(bankpo!=null){
				bankpo.setName(countVo.getName());
				bankaccountdataservice.update(bankpo);
				system.add(new SystemLogPO((String)df.format(new Date()),"改变账户信息",user.getname()));
				return new ResultMessage(true,"更新账户信息成功!");
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return new ResultMessage(false,"要更新的账户不存在!");
	}

	public BankAccountVO searchCount(String keyword) {
		// TODO Auto-generated method stub
		BankAccountPO bankpo=null;
		try{
			bankpo=bankaccountdataservice.find(keyword);
		}catch(RemoteException e){
			e.printStackTrace();
		}
		if(bankpo!=null)
			return new BankAccountVO(bankpo.getName(),bankpo.getNumber(),bankpo.getMoney());
		else
			return null;
	}

	public ArrayList<BankAccountVO> show() {
		// TODO Auto-generated method stub
		ArrayList<BankAccountVO> bankvo=new ArrayList<BankAccountVO>();
		ArrayList<BankAccountPO> bankpo=new ArrayList<BankAccountPO>();
		try{
			bankpo=bankaccountdataservice.showAll();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(BankAccountPO po:bankpo){
			bankvo.add(new BankAccountVO(po.getName(),po.getNumber(),po.getMoney()));
		}
		return bankvo;
	}

}




