package presentation.mainui;

import java.awt.CardLayout;
import java.net.ConnectException;

import javax.swing.JFrame;
import javax.swing.JPanel;

import businesslogic.userbl.UserManageBLImpl;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;
import businesslogicservice.userblservice.UserManageBLService;
import presentation.img.Img;

/**
 * @author 这菜咸了
 * 系统总main函数
 */
public class MainFrame extends JFrame{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9098438670455829981L;
	/**
	 * mainFrame 的宽
	 */
	public static final int w = 512;
	/**
	 * mainFrame的高
	 */
	public static final int h = 384;
	private int state;//0表示主，1表示查询订单，2表示登陆
	private int stated;//以前的状态
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
	
	MainPanel mainpanel;
	SearchPanel searchpanel;
	LoginPanel loginpanel;
	
	

	SearchPkgInformationBLService bl1;
	UserManageBLService bl2;
	
	public MainFrame(){
		this.setUndecorated(true);
		this.setSize(w,h);
		this.setLocationRelativeTo(null);
		this.setVisible(true);
		state=0;
		stated=0;
		changed=false;
		
		card=new CardLayout();
		j = new JPanel();
        j.setLayout(card);
        add(j);
		
		this.setIconImage(Img.MAINICON);
		

		//bl1 = new SearchPkgInformationBLImpl();
		bl1 = null;
		bl2 = new UserManageBLImpl();
		mainpanel = new MainPanel(this);
		searchpanel = new SearchPanel(bl1);
		loginpanel = new LoginPanel(this, bl2);
		j.add(mainpanel);
		j.add(searchpanel);
		j.add(loginpanel);
		
		new Thread(new Runnable(){
			public void run() {
				while(true){
					if(changed){
						changed=false;
						int a;
						if(state-stated>0)
							a=state-stated;
						else
							a=state+3-stated;
						for(int i=0;i<a;i++)
							card.next(j);
						
					}
				}
			}
		}).start();
	}
}
