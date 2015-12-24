package presentation.mainui;

import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import dataservice.system.ConnectedDataService;
import businesslogic.rmi.RMIHelper;

public class Connection implements Runnable{

	private TestConnection test;
	
	public Connection(){
		Connection.number=0;
		test=new TestConnection();
		new Thread(this).start();
		new Thread(test).start();
	}
	public static int number=0;
	@Override
	public void run() {
		System.out.println("create_connection");
		while(true){
			try {
				Thread.sleep(1000);
				Object service = (Object) Naming.lookup("rmi://"+RMIHelper.IP+":"+RMIHelper.PORT+"/"+"ConnectedDataService");
				number++;
				if(!test.isopen){
					 System.out.println("end_connection");
					break;
				   
				}
			} catch (InterruptedException | MalformedURLException | RemoteException | NotBoundException e) {
				System.out.println("end_connection");
				break;
			}
		}
	}
	
	public class TestConnection implements Runnable{

		
		 int testnumber=0;
		 boolean isopen;
		 ReconnectedFrame frame;
		public TestConnection(){
			isopen=true;
			testnumber=0;
		}
		@Override
		public void run() {
			System.out.println("createTest");
			while(true){
				try {
					Thread.sleep(1000);
					testnumber=Connection.number;
					Thread.sleep(3000);
					if(Connection.number-testnumber<2)
						break;
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			System.out.println("end_test");
			isopen=false;
			frame=new ReconnectedFrame();
			frame.setVisible(true);
			new Thread(frame).start();
		}
			
		}



}
