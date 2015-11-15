package businesslogic.test.logisticsbl;

import businesslogic.logisticsbl.Order;


public class MockOrder extends Order{

	double price;
	public MockOrder(double p){
		this.price=p;
	}
	
	public double getPrice(){
		return price;
	}
	

}
