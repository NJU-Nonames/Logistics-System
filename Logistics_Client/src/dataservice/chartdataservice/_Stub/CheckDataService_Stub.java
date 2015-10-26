package dataservice.chartdataservice._Stub;

import java.util.ArrayList;

import po.ListPO;
import po.OrderListPO;
import businesslogic.utilitybl.DocType;
import dataservice.chartdataservice.CheckDataService;

public class CheckDataService_Stub implements CheckDataService{
	public ArrayList<ListPO> getDoc(DocType docType,String time){
		ArrayList<ListPO> list=new ArrayList<ListPO>();
		list.add(new OrderListPO(time, time, time, time, time, 0, 0, time, null, null, 0, time));
		System.out.println("成功!");
		return list;
	}
	public boolean changeDoc(ArrayList<ListPO> listPO){
		System.out.println("修改成功!");
		return true;
	}
}
