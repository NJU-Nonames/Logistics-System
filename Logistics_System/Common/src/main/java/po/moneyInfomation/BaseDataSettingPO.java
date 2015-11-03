package po.moneyInfomation;

import java.util.ArrayList;

import po.agency.AgencyPO;
import po.agency.BankAccountPO;
import po.agency.TruckPO;
import po.repertory.RepertoryInfoPO;

/**
 * @author 这菜咸了
 * 期初建账信息
 */
public class BaseDataSettingPO {

	private ArrayList<AgencyPO> agencies;
	
	private ArrayList<TruckPO> Trucks;
	
	private ArrayList<RepertoryInfoPO> repertories;
	
	private ArrayList<BankAccountPO> bankAccountPO;

	public BaseDataSettingPO(ArrayList<AgencyPO> agencies,
			ArrayList<TruckPO> trucks, ArrayList<RepertoryInfoPO> repertories,
			ArrayList<BankAccountPO> bankAccountPO) {
		super();
		this.agencies = agencies;
		Trucks = trucks;
		this.repertories = repertories;
		this.bankAccountPO = bankAccountPO;
	}

	public ArrayList<AgencyPO> getAgencies() {
		return agencies;
	}

	public void setAgencies(ArrayList<AgencyPO> agencies) {
		this.agencies = agencies;
	}

	public ArrayList<TruckPO> getTrucks() {
		return Trucks;
	}

	public void setTrucks(ArrayList<TruckPO> trucks) {
		Trucks = trucks;
	}

	public ArrayList<RepertoryInfoPO> getRepertories() {
		return repertories;
	}

	public void setRepertories(ArrayList<RepertoryInfoPO> repertories) {
		this.repertories = repertories;
	}

	public ArrayList<BankAccountPO> getBankAccountPO() {
		return bankAccountPO;
	}

	public void setBankAccountPO(ArrayList<BankAccountPO> bankAccountPO) {
		this.bankAccountPO = bankAccountPO;
	}
	
	
}
