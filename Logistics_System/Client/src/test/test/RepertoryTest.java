package businesslogic.test;

import presentation.mainui.CurrentUser;
import utility.CheckType;
import utility.TransportationType;
import vo.RepertoryInVO;
import vo.RepertoryOutVO;
import businesslogic.logisticsbl.RepertoryManageBLImpl;

public class RepertoryTest {
	RepertoryManageBLImpl repertory=new RepertoryManageBLImpl(new CurrentUser("小亮","南京市中转中心","025000","xiaoliang"));
	public static void main(String args[]){
		RepertoryTest t=new RepertoryTest();
		t.test();
	}
	public void test(){
		//repertory.createInputRepertory(new RepertoryInVO("02500000001","025001201511300925","2015-11-30 10:30:04","北京市","1","1","1","1",CheckType.UNDERCHECK));
		//repertory.createInputRepertory(new RepertoryInVO("02500000002","025001201511300926","2015-11-30 10:30:05","广州市","1","1","1","2",CheckType.UNDERCHECK));
		//repertory.createInputRepertory(new RepertoryInVO("02500000003","025001201511300927","2015-11-30 10:30:06","上海市","1","1","1","3",CheckType.UNDERCHECK));
		//repertory.createInputRepertory(new RepertoryInVO("02500000003","025001201511300927","2015-11-30 10:30:07","上海市","1","1","1","3",CheckType.UNDERCHECK));
		//repertory.createOutputRepertory(new RepertoryOutVO("02500000001","025001201511300925","2015-11-30 14:09:25","北京市",TransportationType.AIRPLANE,"02500000001","CZ3903",CheckType.UNDERCHECK));
		//repertory.createOutputRepertory(new RepertoryOutVO("02500000002","025001201511300926","2015-11-30 14:09:26","广州市",TransportationType.TRAIN,"02500000002","G403",CheckType.UNDERCHECK));
		//repertory.createOutputRepertory(new RepertoryOutVO("02500000003","025001201511300927","2015-11-30 14:09:27","上海市",TransportationType.TURCK,"02500000003","苏E00001",CheckType.UNDERCHECK));
		//repertory.createOutputRepertory(new RepertoryOutVO("02500000003","025001201511300927","2015-11-30 14:09:28","上海市",TransportationType.TURCK,"02500000004","苏E00001",CheckType.UNDERCHECK));
	}
}
