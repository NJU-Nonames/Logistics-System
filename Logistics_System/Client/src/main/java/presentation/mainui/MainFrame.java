package presentation.mainui;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import presentation.img.Img;

/**
 * @author 这菜咸了
 * 系统总main函数
 */
public class MainFrame extends JFrame{
	
	
	/**
	 * mainFrame 的宽
	 */
	private static final int MAINFRAME_WIDTH = 512;
	/**
	 * mainFrame的高
	 */
	private static final int MAINFRAME_HIGHT = 384;
	
	public MainFrame(){
		//remain updating
		this.setTitle("物流系统大作业——叫什么名字队");
		
		this.setUndecorated(true);
		
		this.setSize(MAINFRAME_WIDTH,MAINFRAME_HIGHT);
		//不可随意移动
		this.setResizable(false);
		//设置显示在中间
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width -this.getWidth())/2, (screen.height -this.getHeight())/2);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		this.setIconImage(Img.MAINICON);
	}

}
