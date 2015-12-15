package presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.text.DefaultCaret;

import presentation.adminui.AdminFrame;
import presentation.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.centerclerkui.CenterClerkFrame;
import presentation.centerrepertoryclerkui.CenterRepertoryClerkFrame;
import presentation.courierui.CourierFrame;
import presentation.financialstaffhighui.FinacialStaffHighFrame;
import presentation.financialstafflowui.FinacialStaffLowFrame;
import presentation.img.Img;
import presentation.topmanagerui.TopManagerFrame;
import utility.ExpressType;
import utility.UserType;
import utility.Position;
import vo.StaffVO;
import vo.UserVO;
import businesslogicservice.userblservice.UserManageBLService;

public class LoginPanel extends JPanel{
	
	private static final long serialVersionUID = -42431647139763410L;
	private UserManageBLService bl;
	private MainFrame mf;
	
	private MyButton close;
	private MyButton min;
	private MyButton login;
	private MyButton _return;
	
	private JTextField userField;
	private JPasswordField passwordField;
	
	private boolean Invalid;//输入是否非法
	private String result;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.UPLINE, 0, 0, MainFrame.w, MainFrame.h/2, null);
        
        if(Invalid){
        	g.drawImage(Img.BLACK_BG, 0, MainFrame.h-50, MainFrame.w, 50, null);
        	
            g.setColor(Color.RED);
            g.setFont(new Font("楷体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+MainFrame.w/2, 13+MainFrame.h-30);
        }
	}
	
	public LoginPanel(MainFrame mf, UserManageBLService bl){
		this.mf=mf;
		this.bl=bl;
		Invalid=false;
		result="";
		this.setLayout(null);

		//初始化组件
		initComponent();
	}
	private void initComponent() {
		close = new MyButton(30, 30, Img.CLOSE1_0, Img.CLOSE_1, Img.CLOSE_2);
        close.addMouseListener(new MouseListener(){		//( new 接口(){重写的方法} )
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        min = new MyButton(30, 30, Img.MINI1_0, Img.MINI_1, Img.MINI_2);
        min.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				mf.setExtendedState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        login = new MyButton(90, 30, Img.LOGIN_0, Img.LOGIN_1, Img.LOGIN_2);
        login.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				userlogin();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        _return = new MyButton(90, 30, Img.RETURNING_0, Img.RETURNING_1, Img.RETURNING_2);
        _return.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();//清空文本域和错误提示
				mf.setStated(mf.getState());
				mf.setState(0);
				mf.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        JLabel userLabel = new JLabel("账号：");
        userLabel.setSize(80, 27);
        userLabel.setFont(new Font("楷体", Font.BOLD, 25));
        userField = new JTextField();
        userField.setSize(150, 27);
        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setFont(new Font("楷体", Font.BOLD, 25));
        passwordLabel.setSize(80, 27);
        passwordField = new JPasswordField();
        passwordField.setSize(150, 27);

        
        userLabel.setLocation(MainFrame.w/2-160,MainFrame.h*3/4-50);
        userField.setLocation(MainFrame.w/2-75,MainFrame.h*3/4-50);
        passwordLabel.setLocation(MainFrame.w/2-160,MainFrame.h*3/4-10);
        passwordField.setLocation(MainFrame.w/2-75,MainFrame.h*3/4-10);
    	close.setLocation(MainFrame.w-30,0);
    	min.setLocation(MainFrame.w-80,0);
    	login.setLocation(MainFrame.w-150,MainFrame.h*3/4-53);
    	_return.setLocation(MainFrame.w-150,MainFrame.h*3/4-13);
    	
    	
    	add(userLabel);
    	add(userField);
    	add(passwordLabel);
    	add(passwordField);
        add(close);
        add(min);
        add(login);
        add(_return);
	}

	private void clear(){
		userField.setText("");
		passwordField.setText("");
		Invalid=false;
		repaint();
	}
	private void userlogin(){
		String username = userField.getText();
		String paw = new String(passwordField.getPassword());

//		result = CheckFormat.checkUserNum(username);
//		if(result.compareTo("格式正确")!=0){
//			if(!Invalid){
//				Invalid=true;
//				repaint();
//				new Thread(new Runnable(){
//					public void run() {
//						try {
//							Thread.sleep(3000);
//						} catch (InterruptedException e) {
//							// TODO 自动生成的 catch 块
//							e.printStackTrace();
//						}
//						
//						Invalid=false;
//						repaint();
//					}
//				}).start();
//			}
//			return;
//		}
		

		StaffVO vo = bl.login(username, paw);
		if(vo==null){
			Invalid=true;
			result = "密码错误！";
			repaint();
			new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

					Invalid=false;
					repaint();
				}
			}).start();
		}else{
			mf.dispose();
			switch(vo.getPostion()){
			case COURIER:new CourierFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			case BUSINESS_OFFICE_CLERK:new BusinessOfficeClerkFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			case CENTER_CLERK:new CenterClerkFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			case CENTER_REPERTORY_CLERK:new CenterRepertoryClerkFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			case FINANCIAL_STAFF_LOW:new FinacialStaffHighFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			case FINANCIAL_STAFF_HIGH:new FinacialStaffLowFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			case TOP_MANAGER:new TopManagerFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			case ADMIN:new AdminFrame(new CurrentUser(vo.getName(), vo.getAgencyName(), vo.getAgencyId(), username));break;
			default:break;
			}
		}
//			new FinacialStaffFrame(new CurrentUser("王大锤","南京中转中心","025000","admin"));
//			new TopManagerFrame(new CurrentUser("王大锤","南京中转中心","025000","admin"));
//			new BusinessOfficeClerkFrame();
//			new CenterRepertoryClerkFrame();
//			new CourierFrame(new CurrentUser("王大锤","南京中转中心","025000","admin"));
//			new CenterClerkFrame();
//			new AdminFrame();
	}
}

