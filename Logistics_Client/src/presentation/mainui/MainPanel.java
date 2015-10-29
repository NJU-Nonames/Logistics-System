package presentation.mainui;

import java.awt.Graphics;

import javax.swing.JPanel;

public class MainPanel extends JPanel{
	
	MainFrame mainFrame;
	TitlePanel titlePanel;
	BusinessPanel businessPanel;
	
	
	
	
	public MainPanel(MainFrame mainFrame){
		this.mainFrame=mainFrame;
		
		mainFrame.setContentPane(this);
		//设置自由布局
		this.setLayout(null);
		
		//this.add(comp)
		
	}
	
	public void paintComponent(Graphics g){
		super.paintComponent(g);
	}

}
