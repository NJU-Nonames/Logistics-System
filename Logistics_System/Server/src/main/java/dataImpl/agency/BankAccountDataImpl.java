package dataImpl.agency;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;
import java.util.ArrayList;

import com.mysql.jdbc.ResultSet;

import po.agency.BankAccountPO;
import data.DataJDBCConnection;
import dataservice.agency.BankAccountDataService;

public class BankAccountDataImpl  extends UnicastRemoteObject implements BankAccountDataService,Serializable {

	public BankAccountDataImpl() throws RemoteException {
		super();
	}

	public void add(BankAccountPO countpo) {
		String sql="insert into bankaccount values ('"+countpo.getNumber()+"','"+countpo.getName()+"',"+countpo.getMoney()+")";
		DataJDBCConnection.update(sql);
	}

	public void delete(String name) {
		String sql="delete from bankaccount where name='"+name+"'";
		DataJDBCConnection.update(sql);
	}

	public void update(BankAccountPO countpo) {
		this.delete(countpo.getName());
		this.add(countpo);
	}

	public BankAccountPO find(String keyword) {
		BankAccountPO bankAccount=null;
		String sql;
		if(keyword.charAt(0)<='9'&&keyword.charAt(0)>='0')
		     sql="select * from bankaccount where number='"+keyword+"'";
		else
			sql="select * from bankaccount where name like '%"+keyword+"%'";
		
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			rs.next();
			bankAccount=new BankAccountPO(rs.getString("name"), rs.getString("number"), Double.parseDouble(rs.getString("money")));
		} catch (SQLException e) {
			return null;
		}
		
		return bankAccount;
	}

	public ArrayList<BankAccountPO> showAll() {
		ArrayList<BankAccountPO> accountlist =new ArrayList<BankAccountPO>();
		BankAccountPO bankaccount;
		String sql="select * from bankaccount";
		ResultSet rs=(ResultSet) DataJDBCConnection.find(sql);
		try {
			while(rs.next())
			{
				bankaccount=new BankAccountPO(rs.getString("name"), rs.getString("number"), Double.parseDouble(rs.getString("money")));
				accountlist.add(bankaccount);
			}

		} catch (SQLException e) {
			return null;
		}
		return accountlist;
	}

}
