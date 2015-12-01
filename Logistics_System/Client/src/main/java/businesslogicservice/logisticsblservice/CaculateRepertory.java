package businesslogicservice.logisticsblservice;

public class CaculateRepertory {

	public static double caculatePercent(int num){
		return (double)num/1000;	
	}
	
	public static boolean isdangerous(double percent){
		if(percent<0.9)
			return false;
		else
			return true;
	}
}
