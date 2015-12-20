package presentation.mainui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import businesslogic.rmi.RMIHelper;

public class Connection implements Runnable{

	@Override
	public void run() {
		while(true){
			try {
				Thread.sleep(1000);
				Object service = (Object) Naming.lookup("rmi://"+RMIHelper.IP+":"+RMIHelper.PORT+"/"+"ConnectedDataService");
				
			} catch (InterruptedException | MalformedURLException | RemoteException | NotBoundException e) {
				new ReconnectedFrame().run();
				break;
			}
		}
		
	}

}
