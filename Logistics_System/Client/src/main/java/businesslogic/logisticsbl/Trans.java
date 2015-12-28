package businesslogic.logisticsbl;

public class Trans {
	static TransShipmentBLImpl bl=new TransShipmentBLImpl(null);
	public static void main(String []args){
		System.out.println(bl.createOrderFare("010001201511300001"));
	}

}
