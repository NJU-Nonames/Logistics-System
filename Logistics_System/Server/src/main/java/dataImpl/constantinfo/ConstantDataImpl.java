package dataImpl.constantinfo;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import po.constantinfo.DistanceChartPO;
import po.constantinfo.PriceChartPO;
import dataservice.constantinfo.ConstantDataService;

public class ConstantDataImpl extends UnicastRemoteObject implements ConstantDataService,Serializable {

	public ConstantDataImpl() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}

	public boolean setDistance(String newDistance, String cityA, String cityB) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean setPrice(String newPrice, String otherInformation) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean addCity(String name) {
		// TODO Auto-generated method stub
		return false;
	}

	public DistanceChartPO showDistanceChart() {
		// TODO Auto-generated method stub
		return null;
	}

	public PriceChartPO showPriceChart() {
		// TODO Auto-generated method stub
		return null;
	}

}
