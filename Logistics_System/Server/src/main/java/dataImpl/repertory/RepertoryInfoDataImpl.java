package dataImpl.repertory;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.repertory.GoodsInfoPO;
import po.repertory.RepertoryInPO;
import po.repertory.RepertoryOutPO;
import dataservice.repertory.RepertoryInfoDataService;

public class RepertoryInfoDataImpl extends UnicastRemoteObject implements RepertoryInfoDataService,Serializable {

	public RepertoryInfoDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean add(GoodsInfoPO goods, RepertoryInPO repertoryPO) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean delete(GoodsInfoPO goods, RepertoryOutPO repertoryPO) {
		// TODO Auto-generated method stub
		return false;
	}

}
