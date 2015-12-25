package presentation.mainui;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

import presentation.img.Img;

public class MainPanel extends JPanel{
	
	private MainFrame mf;
	
	private MyButton close;
	private MyButton min;//最小化
	private MyButton goto_login;
	private MyButton goto_search;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.UPLINE, 0, 0, MainFrame.w, MainFrame.h/2, null);
        g.drawLine(MainFrame.w/2, MainFrame.h/2+30, MainFrame.w/2, MainFrame.h-30);
	}
	
	public MainPanel(MainFrame mf){
		this.mf=mf;
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
        goto_search = new MyButton(100, 130, Img.GOTO_SEARCH_0, Img.GOTO_SEARCH_1, Img.GOTO_SEARCH_2);
        goto_search.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				mf.setStated(mf.getState());
				mf.setState(1);
				mf.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_login = new MyButton(100, 130, Img.GOTO_LOGIN_0, Img.GOTO_LOGIN_1, Img.GOTO_LOGIN_2);
     //   goto_login.setSize(100, 150);
        goto_login.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				mf.setStated(mf.getState());
				mf.setState(2);
				mf.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        
        
    	close.setLocation(MainFrame.w-30,0);
    	min.setLocation(MainFrame.w-80,0);
    	goto_search.setLocation(MainFrame.w*1/4-goto_login.getW()/2,MainFrame.h*2/3-goto_login.getH()/2+20);
    	goto_login.setLocation(MainFrame.w*3/4-goto_login.getW()/2,MainFrame.h*2/3-goto_login.getH()/2+20);
    	
    	
        add(close);
        add(min);
        add(goto_search);
        add(goto_login);
	}
}
