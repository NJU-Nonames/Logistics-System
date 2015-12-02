/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.businessofficeclerkui;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businesslogic.financebl.SettlementManageBLImpl;
import businesslogic.logisticsbl.DeliverAndReceiveBLImpl;
import businesslogic.logisticsbl.DriverManageBLImpl;
import businesslogic.logisticsbl.LoadBLImpl;
import businesslogic.logisticsbl.SearchPkgInformationBLImpl;
import businesslogic.logisticsbl.TruckManagementBLImpl;
import businesslogicservice.financeblservice.SettlementManageBLService;
import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;
import businesslogicservice.logisticsblservice.DriverManageBLService;
import businesslogicservice.logisticsblservice.LoadBLService;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;
import businesslogicservice.logisticsblservice.TruckManageBLService;
import presentation.img.Img;
import presentation.mainui.CurrentUser;

/**
 * @author 谭期友
 *
 */
public class BusinessOfficeClerkFrame extends JFrame{
	
	private static final long serialVersionUID = 4881080784503653011L;
	public static final int w = 1024;
	public static final int h = 768;
	
	
	private CurrentUser currentUser;
	private int state;
	private int stated;
	boolean changed;
	public void setState(int x){
		state=x;
	}
	public int getState(){
		return state;
	}
	public void setStated(int x){
		stated=x;
	}
	public void setChanged(boolean x){
		changed=x;
	}
	JPanel j;
	CardLayout card;

	//面板对象
	LoadManage loadManage;//车辆装车管理
	Receive receive;//接收
	Deliver deliver;//派件
	CheckList checkList;//核对收款单
	TruckManage truckManage;//车辆信息管理
	DriverManage driverManage;//司机信息管理
	
	
	SettlementManageBLService settlementManageBLService;
	SearchPkgInformationBLService searchPkgInformationBLService;
	DeliverAndReceiveBLService deliverAndReceiveBLService;
	LoadBLService loadBLService;
	TruckManageBLService truckManageBLService;
	DriverManageBLService driverManageBLService;

	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	public BusinessOfficeClerkFrame(){
		//this.currentUser=currentUser;
		this.currentUser=new CurrentUser("王大锤","南京营业厅","025001","admin");
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
		changed=false;
		isDraging=false;
		
		card=new CardLayout();
		j = new JPanel();
        j.setLayout(card);
        add(j);
		
		this.setIconImage(Img.BusinessOfficeClerkICON);
		
		
		settlementManageBLService=new SettlementManageBLImpl(this.currentUser);
		searchPkgInformationBLService=new SearchPkgInformationBLImpl(this.currentUser);
		deliverAndReceiveBLService=new DeliverAndReceiveBLImpl(this.currentUser);
		loadBLService=new LoadBLImpl(this.currentUser);
		truckManageBLService=new TruckManagementBLImpl(this.currentUser);
		driverManageBLService=new DriverManageBLImpl(this.currentUser);
		
		loadManage=new LoadManage(this, loadBLService, searchPkgInformationBLService, currentUser);
		receive=new Receive(this, deliverAndReceiveBLService, searchPkgInformationBLService, currentUser);
		deliver=new Deliver(this, deliverAndReceiveBLService, searchPkgInformationBLService, currentUser);
		checkList=new CheckList(this, settlementManageBLService, searchPkgInformationBLService, currentUser);
		truckManage=new TruckManage(this, truckManageBLService, currentUser);
		driverManage=new DriverManage(this, driverManageBLService, currentUser);

		j.add(loadManage);
		j.add(receive);
		j.add(deliver);
		j.add(checkList);
		j.add(truckManage);
		j.add(driverManage);
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					if(changed){
						changed=false;
						int a;
						if(state-stated>0)
							a=state-stated;
						else
							a=state+6-stated;
						for(int i=0;i<a;i++)
							card.next(j);
						
					}
				}
			}
		}).start();
	}
}
