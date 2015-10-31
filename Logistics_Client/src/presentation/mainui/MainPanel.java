package presentation.mainui;


import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;

import presentation.img.Img;

public class MainPanel extends JPanel implements MouseListener{
	
	
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
	
	public void paint(Graphics g){
		super.paint(g);
		g.drawImage(Img.MAINICON, 0,0, mainFrame.getX(), mainFrame.getY(),  0,0, mainFrame.getX(), mainFrame.getY(), null);
	}




	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}




	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	

}
