package presentation.courierui;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businesslogic.logisticsbl.ReceivePkgBLImpl;
import businesslogic.logisticsbl.SearchPkgInformationBLImpl;
import businesslogic.logisticsbl.SendPkgBLImpl;
import businesslogicservice.logisticsblservice.ReceivePkgBLService;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;
import businesslogicservice.logisticsblservice.SendPkgBLService;
import presentation.img.Img;
import presentation.mainui.CurrentUser;

public class CourierFrame extends JFrame{
	
	private static final long serialVersionUID = 4881080784503653011L;
	public static final int w = 1024;
	public static final int h = 768;
	
	
	private CurrentUser currentUser;
	private int state;
	private int stated;

	public void setState(int x){
		state=x;
	}
	public int getState(){
		return state;
	}
	public void setStated(int x){
		stated=x;
	}
	
	JPanel j;
	CardLayout card;

	//面板对象
	SendPkg sendPkg;//寄件
	ReceivePkg receivePkg;//收件
	SearchPkgInformation searchPkgInformation;//快递信息查询
	
	

	SendPkgBLService sendPkgBLService;
	ReceivePkgBLService receivePkgBLService;
	SearchPkgInformationBLService searchPkgInformationBLService;

	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	public CourierFrame(CurrentUser currentUser){
		this.currentUser=currentUser;
		//this.currentUser=new CurrentUser("王大锤","南京营业厅","025001","admin");
		this.setUndecorated(true);
		this.addMouseListener(new MouseAdapter() { 
			public void mousePressed(MouseEvent e) { 
				 isDraging = true; 
				 xx = e.getX(); 
				 yy = e.getY(); 
			}

			public void mouseReleased(MouseEvent e) { 
				 isDraging = false; 
			}
		});
		
		
		this.addMouseMotionListener(new MouseMotionAdapter() {
			public void mouseDragged(MouseEvent e) { 
			if (isDraging) { 
				 int left = getLocation().x; 
				 int top = getLocation().y; 
				 setLocation(left + e.getX() - xx, top + e.getY() - yy); 
			}
			}
		});
		this.setSize(w,h);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		state=1;
		stated=1;
		isDraging=false;
		
		card=new CardLayout();
		j = new JPanel();
        j.setLayout(card);
        add(j);
		
		this.setIconImage(Img.CourierICON);
		

		sendPkgBLService=new SendPkgBLImpl(this.currentUser);
		receivePkgBLService=new ReceivePkgBLImpl(this.currentUser);
		searchPkgInformationBLService=new SearchPkgInformationBLImpl(this.currentUser);

		sendPkg=new SendPkg(this,sendPkgBLService, currentUser);
		receivePkg=new ReceivePkg(this, receivePkgBLService, currentUser);
		searchPkgInformation=new SearchPkgInformation(this, searchPkgInformationBLService, currentUser);

		j.add(sendPkg);
		j.add(receivePkg);
		j.add(searchPkgInformation);
		
	}
	
	public void change(){
		int a;
		if(state-stated>0)
			a=state-stated;
		else
			a=state+3-stated;
		for(int i=0;i<a;i++)
			card.next(j);
	}
}
