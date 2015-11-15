package presentation.mainui;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

import presentation.img.Img;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;

public class SearchPanel extends JPanel{
	private SearchPkgInformationBLService bl;
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BG, 0, 0, MainFrame.w/2, MainFrame.h/2, null);
        g.drawLine(400, 0, 0, 400);
	}
	public SearchPanel(SearchPkgInformationBLService bl){
		this.bl=bl;
		
	}
}
