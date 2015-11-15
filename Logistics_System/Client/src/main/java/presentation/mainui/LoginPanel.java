package presentation.mainui;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import presentation.img.Img;
import utility.ResultMessage;
import vo.UserVO;
import businesslogicservice.userblservice.UserManageBLService;

public class LoginPanel extends JPanel{
	
	private UserManageBLService bl;
	private MainFrame mf;
	
	private MyButton close;
	private MyButton min;
	private MyButton login;
	private MyButton _return;
	
	private JTextField userField;
	private JTextField passwordField;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BG, 0, 0, MainFrame.w, MainFrame.h/2, null);
	}
	
	public LoginPanel(MainFrame mf, UserManageBLService bl){
		this.mf=mf;
		this.bl=bl;
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
				clear();//清空文本域
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
        userField = new JTextField();
        userField.setSize(100, 20);
        JLabel passwordLabel = new JLabel("密码：");
        passwordLabel.setSize(60, 20);
        passwordField = new JTextField();
        passwordField.setSize(100, 20);

        
        userLabel.setLocation(MainFrame.w/2-100,MainFrame.h*3/4-60);
        userField.setLocation(MainFrame.w/2-50,MainFrame.h*3/4-60);
        passwordLabel.setLocation(MainFrame.w/2-100,MainFrame.h*3/4-30);
        passwordField.setLocation(MainFrame.w/2-50,MainFrame.h*3/4-30);
    	close.setLocation(MainFrame.w-30,0);
    	min.setLocation(MainFrame.w-80,0);
    	login.setLocation(MainFrame.w-100,MainFrame.h*3/4);
    	_return.setLocation(MainFrame.w-100,MainFrame.h*3/4+40);
    	
    	
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
	}
	private void userlogin(){
		String username = userField.getText();
		String paw = passwordField.getText();

		UserVO uservo = bl.login(username, paw);
		if(uservo==null)
			//showerror();
			System.out.println("密码错误");
		else
			System.out.println("密码正确");
	}
//	private void showerror(){
		//this.setBackground(Color.RED);
		//JOptionPane.showMessageDialog(null, "查无此用户！","", JOptionPane.ERROR_MESSAGE);
//	}
}

