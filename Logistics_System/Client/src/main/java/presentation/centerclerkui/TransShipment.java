/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.centerclerkui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;

/**
 * @author 谭期友
 *
 */
public class TransShipment extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	//private AccountBLService bl;
	private CenterClerkFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_TransferCenterReceive;
	private MyButton goto_TransShipment;
	private MyButton goto_InputRepertory;
	private JRadioButton _plane;
	private JRadioButton _trains;
	private JRadioButton _truck;
	private JTextField _transId=new JTextField() ;
	private JTextField _arrivePlace=new JTextField() ;
	private JTextField _counterId=new JTextField() ;
	private JTextField _supervisor=new JTextField() ;
	
//	private DefaultTableModel orderIdTableModel;//订单表格模型
//	private JTable orderIdTable;//订单表格
	//详细操作按钮以及其他组件=

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色


	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(CenterClerkFrame.w/6, 10, CenterClerkFrame.w/6, CenterClerkFrame.h-10);
        g.drawLine(CenterClerkFrame.w/6+10, CenterClerkFrame.h/6, CenterClerkFrame.w, CenterClerkFrame.h/6);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+80, CenterClerkFrame.w-100, CenterClerkFrame.h/6+80);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+168, CenterClerkFrame.w-100, CenterClerkFrame.h/6+168);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+218, CenterClerkFrame.w-100, CenterClerkFrame.h/6+218);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+268, CenterClerkFrame.w-100, CenterClerkFrame.h/6+268);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CenterClerkFrame.h-50, CenterClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CenterClerkFrame.w/2, 13+CenterClerkFrame.h-30);
        }
	}
	
	public TransShipment(CenterClerkFrame frame, CurrentUser currentUser){
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
        goto_TransferCenterReceive = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_TransferCenterReceive.addMouseListener(new MouseListener(){
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
        goto_TransShipment = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_TransShipment.addMouseListener(new MouseListener(){
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
        goto_InputRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_InputRepertory.addMouseListener(new MouseListener(){
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
    	//详细操作按钮
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="装运管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        String s="中转中心业务员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(CenterClerkFrame.w/6,128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(CenterClerkFrame.w/6+(int)(30*s.length()*1.07f),128-30);
    	
        String str=currentUser.getAgencyName()+"       "+"编号："+currentUser.getAgencyNum();
        JLabel agencyNameLabel = new JLabel(str);
        agencyNameLabel.setSize((int)(16*str.length()*1.07f), 16);
        agencyNameLabel.setFont(new Font("宋体", Font.BOLD, 15));
        agencyNameLabel.setLocation(CenterClerkFrame.w/6+20,128+50);
        
        Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time_="时间:   "+format.format(date_);
		JLabel timeLabel = new JLabel(time_);
        timeLabel.setSize((int)(16*time_.length()*1.07f), 16);
        timeLabel.setFont(new Font("宋体", Font.BOLD, 15));
        timeLabel.setLocation(CenterClerkFrame.w-timeLabel.getWidth()+80,128+50);
       
        JLabel transWays=new JLabel("装运方式:");
        transWays.setSize((int)(16*"装运方式:".length()*1.07f), 16);
        transWays.setFont(new Font("宋体", Font.BOLD, 15));
        transWays.setLocation(agencyNameLabel.getX(),128+100);
        
        JLabel transId=new JLabel("运输编号: ");
        transId.setSize((int)(16*"运输编号： ".length()*1.07f), 16);
        transId.setFont(new Font("宋体", Font.BOLD, 15));
        transId.setLocation(agencyNameLabel.getX(),128+140);
        
        String _tip1="提示：请在此输入相应的运输编号，如航运则输入航运编号";
        JLabel tip1=new JLabel(_tip1);
        tip1.setSize((int)(16*_tip1.length()*1.07f), 16);
        tip1.setFont(new Font("宋体", Font.BOLD, 15));
        tip1.setForeground(Color.RED);
        tip1.setLocation(CenterClerkFrame.w-tip1.getWidth(),128+140);
        
        String _departPlace="出发地:"+currentUser.getAgencyName();
        JLabel departPlace=new JLabel(_departPlace);
        departPlace.setSize((int)(16*_departPlace.length()*1.07f), 16);
        departPlace.setFont(new Font("宋体", Font.BOLD, 15));
        departPlace.setLocation(agencyNameLabel.getX(),128+188);
        
        JLabel arrivePlace = new JLabel("到达地：");
        arrivePlace.setSize((int)(16*"到达地：".length()*1.07f), 16);
        arrivePlace.setFont(new Font("宋体", Font.BOLD, 15));
        arrivePlace.setLocation(departPlace.getX()+departPlace.getWidth()+80,128+188);
        
        JLabel counterId = new JLabel("货柜号：");
        counterId.setSize((int)(16*"货柜号：".length()*1.07f), 16);
        counterId.setFont(new Font("宋体", Font.BOLD, 15));
        counterId.setLocation(agencyNameLabel.getX(),128+238);
        
        JLabel supervisor = new JLabel("监装员:");
        supervisor.setSize((int)(16*"监装员:".length()*1.07f), 16);
        supervisor.setFont(new Font("宋体", Font.BOLD, 15));
        supervisor.setLocation(arrivePlace.getX(),128+238);
        //最基本按钮
    	close.setLocation(CenterClerkFrame.w-30,0);
    	min.setLocation(CenterClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_TransferCenterReceive.setLocation(20,150);
    	goto_TransShipment.setLocation(20,200);
    	goto_InputRepertory.setLocation(20,250);
    	
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
		
        _arrivePlace.setSize((int)(210*1.07f), 20);
        _arrivePlace.setLocation(arrivePlace.getX()+arrivePlace.getWidth(),arrivePlace.getY()-3);
        
        _counterId.setSize((int)(120*1.07f), 20);
        _counterId.setLocation(counterId.getX()+counterId.getWidth(),counterId.getY()-3);
        
        _supervisor.setSize((int)(120*1.07f), 20);
        _supervisor.setLocation(supervisor.getX()+supervisor.getWidth(),supervisor.getY()-3);
        
        /*
         *可复用，画出可以添加删改的订单序列表格
         */
//        Vector<String> vColumns = new Vector<String>();
//        vColumns.add("订单号");
//        
//        Vector<String> vColumns = new Vector<String>(); 
        
        add(titleLabel);
        add(funLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        add(agencyNameLabel);
        add(timeLabel);
        add(transWays);
        add(transId);
        add(tip1);
        add(departPlace);
        add(arrivePlace);
        add(counterId);
        add(supervisor);
        
        
        add(_plane);
        add(_trains);
        add(_truck);
        
        add(_transId);
        add(_arrivePlace);
        add(_counterId);
        add(_supervisor);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_TransferCenterReceive);
    	add(goto_TransShipment);
    	add(goto_InputRepertory);

    	
	}

	private void clear(){
//		.setText("");
//		.setText("");
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
}
