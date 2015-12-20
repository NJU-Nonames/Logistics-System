package presentation.mainui;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
import java.net.MalformedURLException;
import java.rmi.Naming;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import businesslogic.rmi.RMIHelper;
import presentation.img.Img;

public class ReconnectedFrame extends JFrame implements Runnable{
	
	private static final int w = 256;
	private static final int h = 192;
	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	
	public static boolean isConnected=false;//是否连接
	MessagePanel message=null;
	
	public ReconnectedFrame(){
		this.setUndecorated(true);
		this.setSize(w,h);
		this.setLocationRelativeTo(null);
		this.message=new MessagePanel();
		this.add(message);
		this.setVisible(true);
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
		
	}
	
	public class MessagePanel extends JPanel{
		
		MyButton connected,close;
		JLabel text,state;//信息
		public MessagePanel(){
			this.setLayout(null);
			
			//连接按钮
			connected=new MyButton(90, 30, Img.RECONNECTED_0,Img.RECONNECTED_1, Img.RECONNECTED_2);
			connected.addMouseListener(new MouseListener() {
				public void mouseClicked(MouseEvent arg0) {
					MessagePanel.this.reconnected();
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {
					state.setText("正在尝试重新连接...");
				}
				public void mouseReleased(MouseEvent arg0) {}
			});
			connected.setLocation(256/2-45,150);
			this.add(connected);
			
			close = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
	        close.addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent arg0) {
					System.exit(0);
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseReleased(MouseEvent arg0) {}
	        });
	        close.setLocation(200,10);
	        this.add(close);
			
			//信息
			text=new JLabel();
			text.setSize(200,30);
			text.setText("服务器连接异常，请尝试重连。");
			text.setLocation(20, 40);
			this.add(text);
			
			state=new JLabel();
			state.setSize(200,30);
			state.setText("服务器连接失败。");
			state.setLocation(20, 60);
			this.add(state);
			
		}
		
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.drawImage(Img.BACKGROUND2, 0, 0, this.getWidth(), this.getHeight(), null);
		}
		
		

		public void reconnected(){
			boolean Connection=true;
			try {
				Object service = (Object) Naming.lookup("rmi://"+RMIHelper.IP+":"+RMIHelper.PORT+"/"+"ConnectedDataService");
			} catch (MalformedURLException | RemoteException
					| NotBoundException e) {
				Connection=false;
			} 
			try{
				this.repaint();
				Thread.sleep(1000);
			}catch(Exception e){}
			
			if(Connection){
				ReconnectedFrame.isConnected=true;
			    state.setText("连接成功！");
			}else{
				state.setText("连接失败.请重试..");
			}
		}

		
	}

	@Override
	public void run() {
		while(!isConnected)
		{
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
		this.setVisible(false);
		
	}
	
}

