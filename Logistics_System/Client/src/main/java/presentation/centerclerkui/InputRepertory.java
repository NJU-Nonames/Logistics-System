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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogic.logisticsbl.RepertoryManageBLImpl;
import businesslogicservice.logisticsblservice.RepertoryManageBLService;
import presentation.centerrepertoryclerkui.CenterRepertoryClerkFrame;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import vo.RepertoryInVO;

/**
 * @author 谭期友
 *
 */
public class InputRepertory extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private RepertoryManageBLService bl;
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
	private MyButton goto_LoadManage;
	//详细操作按钮以及其他组件
    JLabel inId;
	private JTextField _orderId=new JTextField();
	private JTextField _destiPlace=new JTextField();
	private JTextField _q=new JTextField();
	private JTextField _p=new JTextField();
	private JTextField _j=new JTextField();
	private JTextField _w=new JTextField();
	
	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色
	
	private MyButton confirm;
	private MyButton cancel;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, CenterClerkFrame.w/6, CenterClerkFrame.h/6, CenterClerkFrame.w, CenterClerkFrame.h, null);
        g.drawImage(Img.BACKGROUND1, CenterClerkFrame.w/6, 0, CenterClerkFrame.w, CenterClerkFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, CenterClerkFrame.w/6, CenterClerkFrame.h, null);
        g.drawLine(CenterClerkFrame.w/6-1, 0, CenterClerkFrame.w/6-1, CenterClerkFrame.h);
        g.drawLine(CenterClerkFrame.w/6, 0, CenterClerkFrame.w/6, CenterClerkFrame.h);
        g.drawLine(CenterClerkFrame.w/6+1, 0, CenterClerkFrame.w/6+1, CenterClerkFrame.h);
        g.drawLine(CenterClerkFrame.w/6, CenterClerkFrame.h/6, CenterClerkFrame.w, CenterClerkFrame.h/6);
        g.drawLine(CenterClerkFrame.w/6, CenterClerkFrame.h/6+1, CenterClerkFrame.w, CenterClerkFrame.h/6+1);
       
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CenterClerkFrame.h-50, CenterClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CenterClerkFrame.w/2, 13+CenterClerkFrame.h-30);
        }
	}
	
	public InputRepertory(CenterClerkFrame frame, CurrentUser currentUser){
		this.frame=frame;
		this.bl=new RepertoryManageBLImpl(currentUser);
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
        min = new MyButton(30, 30, Img.MINI_0, Img.MINI_1, Img.MINI_2);
        min.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				frame.setExtendedState(JFrame.ICONIFIED);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        _return = new MyButton(30, 30, Img.RETURN_0, Img.RETURN_1, Img.RETURN_2);
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
        goto_TransferCenterReceive = new MyButton(frame.getWidth()/6, 30, Img.GOZHONGZHUAN_0, Img.GOZHONGZHUAN_1, Img.GOZHONGZHUAN_2);
        goto_TransferCenterReceive.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(1);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_TransShipment = new MyButton(frame.getWidth()/6, 30, Img.GOZHUANGYUN_0, Img.GOZHUANGYUN_1, Img.GOZHUANGYUN_2);
        goto_TransShipment.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(2);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        goto_InputRepertory = new MyButton(frame.getWidth()/6, 30, Img.GORUKU_2, Img.GORUKU_2, Img.GORUKU_2);
        goto_InputRepertory.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(3);
				frame.change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        
        goto_LoadManage=new MyButton(frame.getWidth()/6, 30, Img.GOLOAD_0, Img.GOLOAD_1, Img.GOLOAD_2);
        goto_LoadManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(4);
				frame.change();
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
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="入库管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);
        
        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.DARK_GRAY);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="中转中心业务员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.DARK_GRAY);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
        
        
        JLabel orderId=new JLabel("入库订单编号：");
        orderId.setSize((int)(16*"入库订单编号：".length()*1.07f), 16);
        orderId.setFont(new Font("宋体", Font.BOLD, 15));
        orderId.setLocation(CenterClerkFrame.w/6+20,128+70);
        
        JLabel destiPlace=new JLabel("目的地:");
        destiPlace.setSize((int)(16*"目的地:".length()*1.07f), 16);
        destiPlace.setFont(new Font("宋体", Font.BOLD, 15));
        destiPlace.setLocation(CenterClerkFrame.w/6+20,128+165);
        
        JLabel location=new JLabel("库存位置：");
        location.setSize((int)(16*"库存位置：".length()*1.07f), 16);
        location.setFont(new Font("宋体", Font.BOLD, 15));
        location.setLocation(CenterClerkFrame.w/6+20,128+270);
        
        _q.setSize((int)(20*1.07f), 20);
        _q.setLocation(location.getX()+location.getWidth(),location.getY()-3);
        
        JLabel q=new JLabel("区");
        q.setSize((int)(16*1.07f),16);
        q.setFont(new Font("宋体", Font.BOLD, 15));
        q.setLocation(_q.getX()+_q.getWidth()+10,location.getY());
        
        _p.setSize((int)(20*1.07f), 20);
        _p.setLocation(q.getX()+q.getWidth()+30,location.getY()-3);
        
        JLabel p=new JLabel("排");
        p.setSize((int)(16*1.07f), 16);
        p.setFont(new Font("宋体", Font.BOLD, 15));
        p.setLocation(_p.getX()+_p.getWidth()+10,location.getY());
        
        _j.setSize((int)(20*1.07f), 20);
        _j.setLocation(p.getX()+p.getWidth()+30,location.getY()-3);
        
        JLabel j=new JLabel("架");
        j.setSize((int)(16*1.07f), 16);
        j.setFont(new Font("宋体", Font.BOLD, 15));
        j.setLocation(_j.getX()+_j.getWidth()+10,location.getY());
        
        _w.setSize((int)(20*1.07f), 20);
        _w.setLocation(j.getX()+j.getWidth()+30,location.getY()-3);
        
        JLabel w=new JLabel("位");
        w.setSize((int)(16*1.07f), 16);
        w.setFont(new Font("宋体", Font.BOLD, 15));
        w.setLocation(_w.getX()+_w.getWidth()+10,location.getY());
        
        inId=new JLabel("本入库单编号："+bl.createRepertoryInId());
        inId.setSize((int)(16*("本入库单编号："+bl.createRepertoryInId()).length()*1.07f), 16);
        inId.setFont(new Font("宋体", Font.BOLD, 15));
        inId.setLocation(location.getX(),location.getY()+location.getHeight()+90);
        
        confirm=new MyButton(90, 30, Img.CONFIRM_0, Img.CONFIRM_1, Img.CONFIRM_2);
        confirm.setLocation(CenterClerkFrame.w/2-50,location.getY()+location.getHeight()+160);
    	confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	
    	cancel=new MyButton(90, 30, Img.CANCEL_0, Img.CANCEL_1, Img.CANCEL_2);
    	cancel.setLocation(CenterClerkFrame.w/3*2-50,confirm.getY());
     	cancel.addMouseListener(new MouseListener(){
 			public void mouseClicked(MouseEvent arg0) {
 				_cancel();
 			}
 			public void mouseEntered(MouseEvent arg0) {}
 			public void mouseExited(MouseEvent arg0) {}
 			public void mousePressed(MouseEvent arg0) {}
 			public void mouseReleased(MouseEvent arg0) {}
         });
     	
        //最基本按钮
    	close.setLocation(CenterRepertoryClerkFrame.w-30,0);
    	min.setLocation(CenterRepertoryClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_InputRepertory.setLocation(0,250);
    	goto_TransferCenterReceive.setLocation(0,150);
    	goto_TransShipment.setLocation(0,200);
    	goto_LoadManage.setLocation(0,300);
    	
    	//其他组件
    	_orderId.setSize((int)(170*1.07f), 20);
        _orderId.setLocation(orderId.getX()+orderId.getWidth(),orderId.getY()-3);

        _destiPlace.setSize((int)(170*1.07f), 20);
        _destiPlace.setLocation(destiPlace.getX()+destiPlace.getWidth(),destiPlace.getY()-3);
		
        
        
        
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        
        add(orderId);
        add(destiPlace);
        add(location);
        add(q);
        add(p);
        add(j);
        add(w);
        add(inId);
        
        add(_orderId);
        add(_destiPlace);
        add(_q);
        add(_p);
        add(_j);
        add(_w);

    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_TransferCenterReceive);
    	add(goto_TransShipment);
    	add(goto_InputRepertory);
    	add(goto_LoadManage);
    	
    	add(confirm);
    	add(cancel);
	}

	private void clear(){
		_orderId.setText("");
		_destiPlace.setText("");
		_q.setText("");
		_p.setText("");
		_j.setText("");
		_w.setText("");
		willprintMessage=false;
		inId.setText("本入库单编号："+bl.createRepertoryInId());
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
	void _confirm(){

		String orderId = _orderId.getText();
		String t="";
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		t=format.format(date_);
		String desti = _destiPlace.getText();
		String q=_q.getText();
		String p=_p.getText();
		String j=_j.getText();
		String w=_w.getText();
		if(orderId.compareTo("")==0||desti.compareTo("")==0||q.compareTo("")==0
	||p.compareTo("")==0||j.compareTo("")==0||w.compareTo("")==0){
			printMessage("入库单输入不完整！", Color.RED);
			return;
		}
		RepertoryInVO result = new RepertoryInVO(bl.createRepertoryInId(),orderId,t,desti,q,p,j,w,CheckType.UNDERCHECK);
		String s = bl.createInputRepertory(result).getMessage();
		if(s.compareTo("创建入库单成功!")==0){
			printMessage(s, Color.GREEN);
			clear();
		}
		else if(s.compareTo("创建入库单成功!仓位到达报警线，请进行库存调整修改位置。")==0){
			printMessage(s, Color.YELLOW);
			clear();
		}
		else{
			printMessage(s, Color.RED);
		}
	
		
	}
	void _cancel(){
		clear();
	}
}
