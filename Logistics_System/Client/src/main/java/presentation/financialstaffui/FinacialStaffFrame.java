/**
 * 2015年11月15日
 *author:
 *description:
 */
package presentation.financialstaffui;

import java.awt.CardLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.img.Img;
import presentation.mainui.CurrentUser;
import businesslogic.financebl.AccountBLImpl;
import businesslogicservice.financeblservice.AccountBLService;
import businesslogicservice.financeblservice.BaseDataSettingBLService;
import businesslogicservice.financeblservice.CostManagementBLService;
import businesslogicservice.financeblservice.SettlementManageBLService;

/**
 * @author 谭期友
 *
 */
public class FinacialStaffFrame extends JFrame{
	
	private static final long serialVersionUID = 4881080784503653011L;
	public static final int w = 1024;
	public static final int h = 768;
	
	
	private CurrentUser currentUser;
	private int state;//1表示账户管理，2表示成本管理,3表示结算管理，4表示统计报表，5表示期初建帐,6表示查看系统日志
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

	//面板对象
	AccountManage accountManage;//账户管理
	CostManage costManage;//成本管理
	SettlementManage settlementManage;//结算管理
	Statistic statistic;//统计报表
	BaseDataSetting baseDataSetting;//期初建账
	SystemLog systemLog;//查看系统日志
	
	

	AccountBLService accountBLService;
	BaseDataSettingBLService baseDataSettingBLService;//期初建账
	CostManagementBLService costManagementBLService;
	SettlementManageBLService settlementManageBLService;

	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	public FinacialStaffFrame(){
		//this.currentUser=currentUser;
		this.currentUser=new CurrentUser("王大锤","南京中转中心","025000","admin");
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
		
		this.setIconImage(Img.FinacialStaffICON);
		

		//accountBLService=null;
		accountBLService=new AccountBLImpl(this.currentUser);
		baseDataSettingBLService=null;//期初建账
		costManagementBLService=null;
		settlementManageBLService=null;
		
		accountManage=new AccountManage(this, accountBLService, currentUser);
		baseDataSetting=new BaseDataSetting(this, currentUser);
		costManage=new CostManage(this, currentUser);
		settlementManage=new SettlementManage(this, currentUser);
		statistic=new Statistic(this, currentUser);
		systemLog=new SystemLog(this, currentUser);

		j.add(accountManage);
		j.add(costManage);
		j.add(settlementManage);
		j.add(statistic);
		j.add(baseDataSetting);
		j.add(systemLog);
		
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
