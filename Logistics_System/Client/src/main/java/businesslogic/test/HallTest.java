package businesslogic.test;

import java.util.ArrayList;

import presentation.mainui.CurrentUser;
import utility.CheckType;
import utility.GoodsState;
import vo.DeliveringListVO;
import vo.GoodsInfoVO;
import vo.HallArrivalListVO;
import vo.LoadListVO;
import vo.TransArrivalListVO;
import vo.TransShipmentListVO;
import businesslogic.logisticsbl.DeliverAndReceiveBLImpl;
import businesslogic.logisticsbl.LoadBLImpl;
import businesslogic.logisticsbl.RepertoryManageBLImpl;
import businesslogic.logisticsbl.TransShipmentBLImpl;
import businesslogic.logisticsbl.TransferCenterReceiveBLImpl;

public class HallTest {
	LoadBLImpl load=new LoadBLImpl(new CurrentUser("亮剑", "北京市朝阳营业厅", "010001", "liangjian"));
	TransferCenterReceiveBLImpl transarrival=new TransferCenterReceiveBLImpl(new CurrentUser("小明","北京市中转中心", "010000", "xiaoming"));
	TransShipmentBLImpl transshipment=new TransShipmentBLImpl(new CurrentUser("小明","北京市中转中心", "010000", "xiaoming"));
	TransferCenterReceiveBLImpl transarrival1=new TransferCenterReceiveBLImpl(new CurrentUser("小亮","南京市中转中心", "025000", "xiaoliang"));
	LoadBLImpl load1=new LoadBLImpl(new CurrentUser("小亮","南京市中转中心","025000","xiaoliang"));
	DeliverAndReceiveBLImpl deliverandreceive=new DeliverAndReceiveBLImpl(new CurrentUser("李四","南京市鼓楼营业厅","025001","lisi"));
	public static void main(String[]args){
		HallTest t=new HallTest();
		t.test();
	}
	public void test(){
		ArrayList<String>barcodes=new ArrayList<String>();
		barcodes.add("010001201511300001");
		//load.createLoadlist(new LoadListVO("01000100001", "2015-11-30 12:45:30", "010001", "010001201511300001", "南京市", "京A00000", "TFboys", "厂长", barcodes,CheckType.UNDERCHECK));
		GoodsInfoVO good=new GoodsInfoVO("010001201511300001", GoodsState.COMPLETE, "北京市");
		ArrayList<GoodsInfoVO> goodsinfolist=new ArrayList<GoodsInfoVO>();
		goodsinfolist.add(good);
		//transarrival.createTransArrivalList(new TransArrivalListVO("01000000001", "01000000001", "010000", "2015-11-30 13:25:29", goodsinfolist, CheckType.UNDERCHECK));
		//transshipment.createShiplist(new TransShipmentListVO("2015-11-30 14:45:26","01000000001","CE87","北京市","南京市","2","羊驼",barcodes,CheckType.UNDERCHECK));
		//transarrival1.createTransArrivalList(new TransArrivalListVO("02500000001", "01000000001", "025000", "2015-12-01 08:09:10", goodsinfolist, CheckType.UNDERCHECK));
		//load1.createLoadlist(new LoadListVO("02500000001", "2015-12-01 10:45:30", "025000", "010001201511300001", "南京市鼓楼营业厅", "苏A00000", "王家玮", "汤大业", barcodes,CheckType.UNDERCHECK));
		//deliverandreceive.createHallArrivalList(new HallArrivalListVO("02500100001", "2015-12-01 10:48:45", "02", "南京市中转中心", GoodsState.COMPLETE, barcodes	, CheckType.UNDERCHECK));
		deliverandreceive.createDeliveringList(new DeliveringListVO("02500100001", "2015-12-01 12:46:58",barcodes, "张三", CheckType.UNDERCHECK));
	}
}
