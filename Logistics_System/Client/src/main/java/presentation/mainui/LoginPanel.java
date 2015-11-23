package presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.adminui.AdminFrame;
import presentation.businessofficeclerkui.BusinessOfficeClerkFrame;
import presentation.centerclerkui.CenterClerkFrame;
import presentation.centerrepertoryclerkui.CenterRepertoryClerkFrame;
import presentation.courierui.CourierFrame;
import presentation.financialstaffui.FinacialStaffFrame;
import presentation.img.Img;
import presentation.topmanagerui.TopManagerFrame;
import utility.ExpressType;
import utility.UserType;
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
	private JTextField passwordField;
	
	private boolean Invalid;//输入是否非法
	private String result;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BG, 0, 0, MainFrame.w, MainFrame.h/2, null);
        
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
		close = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        close.addMouseListener(new MouseListener(){		//( new 接口(){重写的方法} )
			public void mouseClicked(MouseEvent arg0) {
				System.exit(0);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        min = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        min.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				mf.setExtendedState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        login = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        login.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				userlogin();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        _return = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        userLabel.setSize(60, 20);
        userLabel.setFont(new Font("楷体", Font.BOLD, 18));
        userField = new JTextField();
        userField.setSize(100, 20);
        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setFont(new Font("楷体", Font.BOLD, 18));
        passwordLabel.setSize(60, 20);
        passwordField = new JTextField();
        passwordField.setSize(100, 20);

        
        userLabel.setLocation(MainFrame.w/2-100,MainFrame.h*3/4-60);
        userField.setLocation(MainFrame.w/2-50,MainFrame.h*3/4-60);
        passwordLabel.setLocation(MainFrame.w/2-100,MainFrame.h*3/4-30);
        passwordField.setLocation(MainFrame.w/2-50,MainFrame.h*3/4-30);
    	close.setLocation(MainFrame.w-30,0);
    	min.setLocation(MainFrame.w-80,0);
    	login.setLocation(MainFrame.w-100,MainFrame.h*3/4-60);
    	_return.setLocation(MainFrame.w-100,MainFrame.h*3/4-30);
    	
    	
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
//		String username = userField.getText();
//		String paw = passwordField.getText();
//
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
//		
//
//		UserVO vo = bl.login(username, paw);
//		if(vo==null){
//			Invalid=true;
//			result = "密码错误！";
//			repaint();
//			new Thread(new Runnable(){
//				public void run() {
//					try {
//						Thread.sleep(3000);
//					} catch (InterruptedException e) {
//						// TODO 自动生成的 catch 块
//						e.printStackTrace();
//					}
//
//					Invalid=false;
//					repaint();
//				}
//			}).start();
//		}else{
			mf.dispose();
//			switch(uservo.getPosition()){
//			case UserType.COURIER:break;
//			case UserType.BUSINESS_OFFICE_CLERK:break;
//			case UserType.CENTER_CLERK:break;
//			case UserType.CENTER_REPERTORY_CLERK:break;
//			case UserType.FINANCIAL_STAFF_LOW:
//			case UserType.FINANCIAL_STAFF_HIGH:new FinacialStaffFrame();break;
//			case UserType.TOP_MANAGER:break;
//			case UserType.ADMIN:break;
//			}
//		}
			new FinacialStaffFrame();
			//new TopManagerFrame();
			//new BusinessOfficeClerkFrame();
			//new CenterRepertoryClerkFrame();
			//new CourierFrame();
			//new CenterClerkFrame();
			//new AdminFrame();
	}
}

