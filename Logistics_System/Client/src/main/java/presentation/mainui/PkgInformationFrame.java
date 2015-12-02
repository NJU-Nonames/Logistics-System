/**
 * 2015年11月20日
 *author:
 *description:
 */
package presentation.mainui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import presentation.img.Img;

/**
 * @author 谭期友
 *
 */
public class PkgInformationFrame extends JFrame{
	
	private static final long serialVersionUID = 4881080784503653011L;
	public static final int w = 450;
	public static final int h = 600;

	//面板对象
	Mypanel mypanel;

	private boolean isDraging;//是否被拖住
	private int xx;
	private int yy;
	
	public PkgInformationFrame(){
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
		
		this.setIconImage(Img.MainICON);

		mypanel=new Mypanel();

		add(mypanel);
	}
	
	
	private class Mypanel extends JPanel{

		private static final long serialVersionUID = -1194559040892610991L;
		
		private MyButton confirm;

		protected void paintComponent(Graphics g){
	        super.paintComponent(g);
	        setBackground(Color.WHITE);
	        g.drawLine(10, 80, w-10, 80);
		}
		
		public Mypanel(){
			this.setLayout(null);

			//初始化组件
			initComponent();
		}
		private void initComponent() {
			confirm = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
			confirm.addMouseListener(new MouseListener(){
				public void mouseClicked(MouseEvent arg0) {
					PkgInformationFrame.this.dispose();
				}
				public void mouseEntered(MouseEvent arg0) {}
				public void mouseExited(MouseEvent arg0) {}
				public void mousePressed(MouseEvent arg0) {}
				public void mouseReleased(MouseEvent arg0) {}
	        });
	    	//最基本元素
	        JLabel titleLabel = new JLabel("物流信息查询");
	        titleLabel.setSize((int)(40*6*1.07f), 40);
	        titleLabel.setFont(new Font("宋体", Font.BOLD, 40));
	        titleLabel.setForeground(Color.BLACK);
	        titleLabel.setLocation(w/2-(int)(40*6*1.07f)/2,20);
	        
			confirm.setLocation(w-50,h-50);
			

			
	    	add(titleLabel);
	    	add(confirm);
		}
	}
}
