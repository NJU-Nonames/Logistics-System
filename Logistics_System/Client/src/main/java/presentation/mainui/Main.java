package presentation.mainui;

import businesslogic.rmi.RMIHelper;

public class Main {

	public static void main(String args[]){
		new MainFrame();
		RMIHelper.init();
	    new Connection();
	}
	
}
