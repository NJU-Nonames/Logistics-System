package presentation.adminui;

import java.awt.Dimension;
import java.awt.Toolkit;
import javax.swing.JFrame;

public class AdminFrame extends JFrame{
	/**
	 * 主办公系统界面Frame 的宽
	 */
	private static final int SYSTEMDEFALUT_WIDTH = 1024;
	/**
	 * 主办公系统界面Frame的高
	 */
	private static final int SYSTEMDEFALUT_HIGHT = 768;
	
	public AdminFrame(){
		//remain updating
		this.setTitle("物流系统大作业——系统管理员用户界面");
		
		this.setSize(SYSTEMDEFALUT_WIDTH,SYSTEMDEFALUT_HIGHT);
		//不可随意移动
		this.setResizable(false);
		//设置显示在中间
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation((screen.width -this.getWidth())/2, (screen.height -this.getHeight())/2);
		
		this.setVisible(true);
		
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
