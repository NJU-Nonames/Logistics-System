package businesslogic.financebl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import po.agency.BankAccountPO;
import dataservice.agency.BankAccountDataService;
import utility.ResultMessage;
import vo.BankAccountVO;
import businesslogic.rmi.RMIHelper;
import businesslogicservice.financeblservice.AccountBLService;

/*public class AccountBLImpl implements AccountBLService {
	BankAccountDataService bankaccountdataservice=null;
	public AccountBLImpl(){
		this.bankaccountdataservice=(BankAccountDataService)RMIHelper.find("BankAccountDataService");
	}

	public ResultMessage createCount(BankAccountVO countVo) {
		// TODO Auto-generated method stub
		BankAccountPO bankpo=null;
		try{
			bankpo=bankaccountdataservice.find(countVo.getName());
			if(bankpo==null){
				bankpo=new BankAccountPO(countVo.getName(),countVo.getNumber(),countVo.getMoney());
				bankaccountdataservice.add(bankpo);
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

}*/
public class AccountBLImpl implements AccountBLService {
	BankAccountDataService bankaccountdataservice=null;
	public AccountBLImpl(){
		//this.bankaccountdataservice=(BankAccountDataService)RMIHelper.find("BankAccountDataService");
	}

	public ResultMessage createCount(BankAccountVO countVo) {
		// TODO Auto-generated method stub
//		BankAccountPO bankpo=null;
//		try{
//			bankpo=bankaccountdataservice.find(countVo.getName());
//			if(bankpo==null){
//				bankpo=new BankAccountPO(countVo.getName(),countVo.getNumber(),countVo.getMoney());
//				bankaccountdataservice.add(bankpo);
				return new ResultMessage(true,"添加账户成功!");
//			}
//		}catch(RemoteException e){
//			e.printStackTrace();
//		}
//		return new ResultMessage(false,"账户已存在!");
	}

	public ResultMessage removeCount(String name) {
		// TODO Auto-generated method stub
//		BankAccountPO bankpo=null;
//		try{
//			bankpo=bankaccountdataservice.find(name);
//			if(bankpo!=null){
//				bankaccountdataservice.delete(name);
				return new ResultMessage(true,"账户删除成功!");
//			}
//		}catch(RemoteException e){
//			e.printStackTrace();
//		}
//		return new ResultMessage(false,"要删除的账户不存在!");
	}
//只可以修改账户的名字
	public ResultMessage updateCount(BankAccountVO countVo) {
		// TODO Auto-generated method stub
//		BankAccountPO bankpo=null;
//		try{
//			bankpo=bankaccountdataservice.find(countVo.getNumber());
//			if(bankpo!=null){
//				bankpo.setName(countVo.getName());
//				bankaccountdataservice.update(bankpo);
				return new ResultMessage(true,"更新账户信息成功!");
//			}
//		}catch(RemoteException e){
//			e.printStackTrace();
//		}
//		return new ResultMessage(false,"要更新的账户不存在!");
	}

	public BankAccountVO searchCount(String keyword) {
		// TODO Auto-generated method stub
//		BankAccountPO bankpo=null;
//		try{
//			bankpo=bankaccountdataservice.find(keyword);
//		}catch(RemoteException e){
//			e.printStackTrace();
//		}
//		return new BankAccountVO(bankpo.getName(),bankpo.getNumber(),bankpo.getMoney());
		return new BankAccountVO("啊呆","1234567890123456789",1250035.74);
	}

	public ArrayList<BankAccountVO> show() {
		// TODO Auto-generated method stub
		ArrayList<BankAccountVO> bankvo=new ArrayList<BankAccountVO>();
		/*ArrayList<BankAccountPO> bankpo=new ArrayList<BankAccountPO>();
		try{
			bankpo=bankaccountdataservice.showAll();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		for(BankAccountPO po:bankpo){
			bankvo.add(new BankAccountVO(po.getName(),po.getNumber(),po.getMoney()));
		}*/
		bankvo.add(new BankAccountVO("啊呆","1234567890123456789",1250035.74));
		bankvo.add(new BankAccountVO("孙悟空","1234567890123456789",25.74));
		bankvo.add(new BankAccountVO("猪八戒","1234567890123456789",17.74));
		bankvo.add(new BankAccountVO("唐三藏","6222022995656541562",95.74));
		bankvo.add(new BankAccountVO("撒旦","6222022995656541561",27.74));
		bankvo.add(new BankAccountVO("啊呆","1234567890123456789",1250035.74));
		bankvo.add(new BankAccountVO("孙悟空","1234567890123456789",25.74));
		bankvo.add(new BankAccountVO("猪八戒","1234567890123456789",17.74));
		bankvo.add(new BankAccountVO("唐三藏","6222022995656541562",95.74));
		bankvo.add(new BankAccountVO("撒旦","6222022995656541561",27.74));
		bankvo.add(new BankAccountVO("啊呆","1234567890123456789",1250035.74));
		bankvo.add(new BankAccountVO("孙悟空","1234567890123456789",25.74));
		bankvo.add(new BankAccountVO("猪八戒","1234567890123456789",17.74));
		bankvo.add(new BankAccountVO("唐三藏","6222022995656541562",95.74));
		bankvo.add(new BankAccountVO("撒旦","6222022995656541561",27.74));
		bankvo.add(new BankAccountVO("啊呆","1234567890123456789",1250035.74));
		bankvo.add(new BankAccountVO("孙悟空","1234567890123456789",25.74));
		bankvo.add(new BankAccountVO("猪八戒","1234567890123456789",17.74));
		bankvo.add(new BankAccountVO("唐三藏","6222022995656541562",95.74));
		bankvo.add(new BankAccountVO("撒旦","6222022995656541561",27.74));
		bankvo.add(new BankAccountVO("啊呆","1234567890123456789",1250035.74));
		bankvo.add(new BankAccountVO("孙悟空","1234567890123456789",25.74));
		bankvo.add(new BankAccountVO("猪八戒","1234567890123456789",17.74));
		bankvo.add(new BankAccountVO("你妈逼","6222022995656541562",95.74));
		bankvo.add(new BankAccountVO("撒旦","6222022995656541561",27.74));
		return bankvo;
	}

}


