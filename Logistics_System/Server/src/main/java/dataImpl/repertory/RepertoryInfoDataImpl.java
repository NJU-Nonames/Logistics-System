package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.repertory.GoodsInfoPO;
import po.repertory.RepertoryInPO;
import po.repertory.RepertoryInfoPO;
import po.repertory.RepertoryOutPO;
import dataservice.repertory.RepertoryInfoDataService;

public class RepertoryInfoDataImpl extends UnicastRemoteObject implements RepertoryInfoDataService,Serializable {

	public RepertoryInfoDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public void add(GoodsInfoPO goods, RepertoryInPO repertoryPO)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public void delete(String barCode, RepertoryOutPO repertoryPO)
			throws RemoteException {
		// TODO Auto-generated method stub
		
	}

	public RepertoryInfoPO show() {
		// TODO Auto-generated method stub
		return null;
	}


}
