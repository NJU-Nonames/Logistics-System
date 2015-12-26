package presentation.mainui;

import config.XMLReader;
import businesslogic.rmi.RMIHelper;

public class Main {

	public static void main(String args[]){
		new MainFrame();
		RMIHelper.init();
	    new Connection();
		System.out.println("IP:"+XMLReader.loadipconfig().getIP());
	}
	
}
