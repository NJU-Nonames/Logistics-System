/**
 * 2015年11月10日
 *author:
 *description:
 */
package presentation.mainui;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;


/**
 * @author 谭期友
 *
 */
public class MyButton extends JPanel implements MouseListener{
	/**
	 * 
	 */
	private static final long serialVersionUID = 5568214429555149934L;
	private int state;//0表示正常，1表示Entered，2表示按下
	private int w, h;
	private Image Exited, Entered, Pressed;
	
	public int getW() {
		return w;
	}


	public int getH() {
		return h;
	}
	
	public void setState(int num){
		this.state=num;
		repaint();
	}


	public MyButton(int w, int h, Image Exited, Image Entered, Image Pressed){
		this.w=w;
		this.h=h;
		this.Exited=Exited;
		this.Entered=Entered;
		this.Pressed=Pressed;
		state=0;
		setSize(w, h);
		this.setOpaque(false);
		this.addMouseListener(this);
	}

	
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        switch(state){
        case 0:g.drawImage(this.Exited, 0, 0, w, h, null);break;
        case 1:g.drawImage(this.Entered, 0, 0, w, h, null);break;
        case 2:g.drawImage(this.Pressed, 0, 0, w, h, null);break;
        }
	}

	/* （非 Javadoc）
	 * @see java.awt.event.MouseListener#mouseClicked(java.awt.event.MouseEvent)
	 */
	public void mouseClicked(MouseEvent arg0) {
		
	}

	/* （非 Javadoc）
	 * @see java.awt.event.MouseListener#mouseEntered(java.awt.event.MouseEvent)
	 */
	public void mouseEntered(MouseEvent arg0) {
		// TODO 自动生成的方法存根

		state=1;
		repaint();
	}

	/* （非 Javadoc）
	 * @see java.awt.event.MouseListener#mouseExited(java.awt.event.MouseEvent)
	 */
	public void mouseExited(MouseEvent arg0) {
		// TODO 自动生成的方法存根

		state=0;
		repaint();
	}

	/* （非 Javadoc）
	 * @see java.awt.event.MouseListener#mousePressed(java.awt.event.MouseEvent)
	 */
	public void mousePressed(MouseEvent arg0) {
		// TODO 自动生成的方法存根

		state=2;
		repaint();
	}

	/* （非 Javadoc）
	 * @see java.awt.event.MouseListener#mouseReleased(java.awt.event.MouseEvent)
	 */
	public void mouseReleased(MouseEvent arg0) {
		// TODO 自动生成的方法存根

		state=1;
		repaint();
	}
}

