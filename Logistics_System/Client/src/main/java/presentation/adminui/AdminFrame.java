package presentation.adminui;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.img.Img;
import presentation.mainui.CurrentUser;

public class AdminFrame extends JFrame{
	
	private static final long serialVersionUID = 4881080784503653011L;
	public static final int w = 1024;
	public static final int h = 768;
	
	
	private CurrentUser currentUser;

	//面板对象
	UserManage userManage;//用户管理
	
	

//	AccountBLService accountBLService;
//	BaseDataSettingBLService baseDataSettingBLService;
//	CostManagementBLService costManagementBLService;
//	SettlementManageBLService settlementManageBLService;

	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	public AdminFrame(CurrentUser currentUser){
		this.currentUser=currentUser;
		//this.currentUser=new CurrentUser("王大锤","南京中转中心","025000","admin");
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
		isDraging=false;
		
		this.setIconImage(Img.AdminICON);
		

//		accountBLService=null;
//		baseDataSettingBLService=null;
//		costManagementBLService=null;
//		settlementManageBLService=null;

		userManage=new UserManage(this, currentUser);

		add(userManage);
	}
}
