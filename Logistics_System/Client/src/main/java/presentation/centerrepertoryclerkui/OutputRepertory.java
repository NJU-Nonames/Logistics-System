/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.centerrepertoryclerkui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

import presentation.centerclerkui.CenterClerkFrame;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;

/**
 * @author 谭期友
 *
 */
public class OutputRepertory extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	//private AccountBLService bl;
	private CenterRepertoryClerkFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_InputRepertory;
	private MyButton goto_OutputRepertory;
	private MyButton goto_ViewRepertory;
	private MyButton goto_Inventory;
	private JRadioButton _plane;
	private JRadioButton _trains;
	private JRadioButton _truck;
	//详细操作按钮以及其他组件
	private JTextField _orderId=new JTextField();
	private JTextField _destiPlace=new JTextField();
	private JTextField _transId=new JTextField() ;
	
	private MyButton confirm;
	private MyButton cancel;
	

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(CenterRepertoryClerkFrame.w/6, 10, CenterRepertoryClerkFrame.w/6, CenterRepertoryClerkFrame.h-10);
        g.drawLine(CenterRepertoryClerkFrame.w/6+10, CenterRepertoryClerkFrame.h/6, CenterRepertoryClerkFrame.w, CenterRepertoryClerkFrame.h/6);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+80, CenterClerkFrame.w-100, CenterClerkFrame.h/6+80);
        
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CenterRepertoryClerkFrame.h-50, CenterRepertoryClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CenterRepertoryClerkFrame.w/2, 13+CenterRepertoryClerkFrame.h-30);
        }
	}
	
	public OutputRepertory(CenterRepertoryClerkFrame frame, CurrentUser currentUser){
		this.frame=frame;
		//this.bl=bl;
		this.currentUser=currentUser;
		willprintMessage=false;
		result="";
		co=Color.RED;
		this.setLayout(null);

		//初始化组件
		initComponent();
	}
	private void initComponent() {
		//最基本按钮
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
        min = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        min.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        _return = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        _return.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				frame.dispose();
				new MainFrame();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        //功能按钮
        goto_InputRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_InputRepertory.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(1);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_OutputRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_OutputRepertory.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(2);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_ViewRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_ViewRepertory.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(3);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_Inventory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_Inventory.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(4);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	//详细操作按钮
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="出库管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        String s="仓库管理员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(CenterRepertoryClerkFrame.w/6,128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(CenterRepertoryClerkFrame.w/6+(int)(30*s.length()*1.07f),128-30);
        
        String str=currentUser.getAgencyName()+"       "+"编号："+currentUser.getAgencyNum();
        JLabel agencyNameLabel = new JLabel(str);
        agencyNameLabel.setSize((int)(16*str.length()*1.07f), 16);
        agencyNameLabel.setFont(new Font("宋体", Font.BOLD, 15));
        agencyNameLabel.setLocation(CenterClerkFrame.w/6+20,128+50);
        
        Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time_="出库时间:  "+format.format(date_);
		JLabel timeLabel = new JLabel(time_);
        timeLabel.setSize((int)(16*time_.length()*1.07f), 16);
        timeLabel.setFont(new Font("宋体", Font.BOLD, 15));
        timeLabel.setLocation(CenterClerkFrame.w-timeLabel.getWidth()+80,128+50); 
        
        JLabel orderId=new JLabel("出库订单编号：");
        orderId.setSize((int)(16*"出库订单编号：".length()*1.07f), 16);
        orderId.setFont(new Font("宋体", Font.BOLD, 15));
        orderId.setLocation(agencyNameLabel.getX(),128+100);
        
        JLabel destiPlace=new JLabel("目的地：");
        destiPlace.setSize((int)(16*"目的地：".length()*1.07f), 16);
        destiPlace.setFont(new Font("宋体", Font.BOLD, 15));
        destiPlace.setLocation(agencyNameLabel.getX(),orderId.getY()+100);
        
        JLabel transWays=new JLabel("装运方式: ");
        transWays.setSize((int)(16*"装运方式： ".length()*1.07f), 16);
        transWays.setFont(new Font("宋体", Font.BOLD, 15));
        transWays.setLocation(agencyNameLabel.getX(),destiPlace.getY()+100);
        
        JLabel transId=new JLabel("中转单编号:");
        transId.setSize((int)(16*"中转订单编号:".length()*1.07f), 16);
        transId.setFont(new Font("宋体", Font.BOLD, 15));
        transId.setLocation(agencyNameLabel.getX(),transWays.getY()+100);
    	
        //最基本按钮
    	close.setLocation(CenterRepertoryClerkFrame.w-30,0);
    	min.setLocation(CenterRepertoryClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_InputRepertory.setLocation(20,150);
    	goto_OutputRepertory.setLocation(20,200);
    	goto_ViewRepertory.setLocation(20,250);
    	goto_Inventory.setLocation(20,300);
    	
    	//其他组件
    	_plane=new JRadioButton("航运",true);
        _plane.setSize((int)(100*1.07f), 20);
        _plane.setFont(new Font("宋体", Font.BOLD, 17));
        _plane.setLocation(transWays.getX()+transWays.getWidth(),transWays.getY()-3);
        _plane.setOpaque(false);
        _trains=new JRadioButton("铁运",true);
        _trains.setSize((int)(100*1.07f), 20);
        _trains.setFont(new Font("宋体", Font.BOLD, 17));
        _trains.setLocation(_plane.getX()+_plane.getWidth(),transWays.getY()-3);
        _trains.setOpaque(false);
        _truck=new JRadioButton("汽运",true);
        _truck.setSize((int)(100*1.07f), 20);
        _truck.setFont(new Font("宋体", Font.BOLD, 17));
        _truck.setLocation(_trains.getX()+_trains.getWidth(),transWays.getY()-3);
        _truck.setOpaque(false);
        ButtonGroup group1 = new ButtonGroup();
        group1.add(_plane);group1.add(_trains);group1.add(_truck);
        
        _transId.setSize((int)(170*1.07f), 20);
        _transId.setLocation(transId.getX()+transId.getWidth(),transId.getY()-3);

        _destiPlace.setSize((int)(170*1.07f), 20);
        _destiPlace.setLocation(destiPlace.getX()+destiPlace.getWidth(),destiPlace.getY());
        
        _orderId.setSize((int)(170*1.07f), 20);
        _orderId.setLocation(orderId.getX()+orderId.getWidth(),orderId.getY());
		
        confirm=new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        confirm.setLocation(CenterClerkFrame.w/2,transId.getY()+transId.getHeight()+100);
    	confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	
    	cancel=new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	cancel.setLocation(CenterClerkFrame.w/3*2,confirm.getY());
     	cancel.addMouseListener(new MouseListener(){
 			public void mouseClicked(MouseEvent arg0) {
 				_cancel();
 			}
 			public void mouseEntered(MouseEvent arg0) {}
 			public void mouseExited(MouseEvent arg0) {}
 			public void mousePressed(MouseEvent arg0) {}
 			public void mouseReleased(MouseEvent arg0) {}
         });
     	
     	
        add(titleLabel);
        add(funLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        add(agencyNameLabel);
        add(timeLabel);
        add(orderId);
        add(destiPlace);
        add(transWays);
        add(transId);
        
        add(_plane);
        add(_trains);
        add(_truck);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_InputRepertory);
    	add(goto_OutputRepertory);
    	add(goto_ViewRepertory);
    	add(goto_Inventory);
    	add(_orderId);
    	add(_destiPlace);
    	add(_transId);
    	
    	add(confirm);
    	add(cancel);
 
	}

	private void clear(){
		_orderId.setText("");
		_destiPlace.setText("");
		_transId.setText("");
		_plane.setSelected(true);
		_trains.setSelected(false);
		_truck.setSelected(false);
		willprintMessage=false;
		repaint();
	}
	
	
	private void printMessage(String message, Color c){
		result=message;
		co=c;
		if(!willprintMessage){
			willprintMessage=true;
			repaint();
			new Thread(new Runnable(){
				public void run() {
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO 自动生成的 catch 块
						e.printStackTrace();
					}

					willprintMessage=false;
					repaint();
				}
			}).start();
		}
	}
	public void _confirm(){
		
	}
	public void _cancel(){
		clear();
	}
}
