package businesslogicservice.logisticsblservice;

import config.XMLReader;

public class CaculateRepertory {
	
	private static int capacity=XMLReader.loadrepertoryconfig().getCapacity();
	
	private static double PERCENT=XMLReader.loadrepertoryconfig().getPercent();

	public static double caculatePercent(int num){
		return (double)num/capacity;	
	}
	
	public static boolean isdangerous(double percent){
		if(percent<PERCENT)
			return false;
		else
			return true;
	}
}
