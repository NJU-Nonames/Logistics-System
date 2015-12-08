/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.courierui;

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

import businesslogicservice.logisticsblservice.ReceivePkgBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.ResultMessage;
import vo.OrderListVO;
import vo.ReceiverVO;

/**
 * @author 谭期友
 *
 */
public class ReceivePkg extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private ReceivePkgBLService bl;
	private CourierFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_SendPkg;
	private MyButton goto_ReceivePkg;
	private MyButton goto_SearchPkgInformation;
	//详细操作按钮以及其他组件
	private MyButton selected;
	private MyButton confirm;

	private JTextField order;	
	private JTextField r_name;	
	private JTextField r_phone;	
	private JTextField r_date;
	private JLabel name1Label;
	private JLabel phone1Label;
	private JLabel add1Label;
	private JLabel name2Label;
	private JLabel phone2Label;
	private JLabel add2Label;
	private JLabel nameLabel;
	private JLabel weightLabel;
	private JLabel priceLabel;
	private JLabel senddateLabel;
	private String orderlist;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, CourierFrame.w/6, CourierFrame.h/6, CourierFrame.w, CourierFrame.h, null);
        g.drawImage(Img.BACKGROUND1, CourierFrame.w/6, 0, CourierFrame.w, CourierFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, CourierFrame.w/6, CourierFrame.h, null);
        g.drawLine(CourierFrame.w/6, 10, CourierFrame.w/6, CourierFrame.h-10);
        g.drawLine(CourierFrame.w/6+10, CourierFrame.h/6, CourierFrame.w, CourierFrame.h/6);
        g.drawLine(CourierFrame.w/6+20, 128+80+30, CourierFrame.w-20, 128+80+30);
        g.drawLine(CourierFrame.w/6+20, 128+80+150+30, CourierFrame.w-20, 128+80+150+30);

        if(willprintMessage){
        	g.drawImage(Img.BACKGROUND2, CourierFrame.w/6, CourierFrame.h/6, CourierFrame.w, CourierFrame.h, null);
            g.drawImage(Img.BACKGROUND1, CourierFrame.w/6, 0, CourierFrame.w, CourierFrame.h/6, null);
            g.drawImage(Img.BACKGROUND0, 0, 0, CourierFrame.w/6, CourierFrame.h, null);
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CourierFrame.w/2, 13+CourierFrame.h-30);
        }
	}
	
	public ReceivePkg(CourierFrame frame, ReceivePkgBLService bl, CurrentUser currentUser){
		this.frame=frame;
		this.bl=bl;
		this.currentUser=currentUser;
		willprintMessage=false;
		result="";
		orderlist="";
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
        goto_SendPkg = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_SendPkg.addMouseListener(new MouseListener(){
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
        goto_ReceivePkg = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_ReceivePkg.addMouseListener(new MouseListener(){
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
        goto_SearchPkgInformation = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_SearchPkgInformation.addMouseListener(new MouseListener(){
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
        selected = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        selected.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				selecte();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        confirm = new MyButton(100, 35, Img.CONFIRM_0, Img.CONFIRM_1, Img.CONFIRM_2);
        confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				receive();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="收件";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.RED);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="快递员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
    	//最基本按钮
    	close.setLocation(CourierFrame.w-30,0);
    	min.setLocation(CourierFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_SendPkg.setLocation(20,150);
    	goto_ReceivePkg.setLocation(20,200);
    	goto_SearchPkgInformation.setLocation(20,250);
    	
    	//其他组件
		JLabel ordernum = new JLabel("订单编号：");
		ordernum.setSize((int)(16*5*1.07f), 16);
		ordernum.setFont(new Font("宋体", Font.BOLD, 15));
		ordernum.setLocation(CourierFrame.w/6+40, 128+80);
        order = new JTextField();
        order.setSize(150, 20);
        order.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f),128+80-3);
        
		JLabel l1 = new JLabel("收件人姓名：");
		l1.setSize((int)(16*6*1.07f), 16);
		l1.setFont(new Font("宋体", Font.BOLD, 15));
        l1.setLocation(CourierFrame.w/6+40, 128+80+50);
        r_name = new JTextField();
        r_name.setSize(110, 20);
        r_name.setLocation(CourierFrame.w/6+40+(int)(16*7*1.07f),128+80+50-3);
        
		JLabel l2 = new JLabel("收件人手机号：");
		l2.setSize((int)(16*7*1.07f), 16);
		l2.setFont(new Font("宋体", Font.BOLD, 15));
        l2.setLocation(CourierFrame.w/6+40, 128+80+100);
        r_phone = new JTextField();
        r_phone.setSize(110, 20);
        r_phone.setLocation(CourierFrame.w/6+40+(int)(16*7*1.07f),128+80+100-3);

		JLabel l3 = new JLabel("收件时间：");
		l3.setSize((int)(16*5*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(CourierFrame.w/6+40, 128+80+150);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date_);
		r_date = new JTextField(time);
		r_date.setSize(130, 20);
		r_date.setLocation(CourierFrame.w/6+40+(int)(16*7*1.07f),128+80+150-3);

    	String tip="日期格式：yyyy-MM-dd HH:mm:ss";
        JLabel tipLabel = new JLabel(tip);
        tipLabel.setSize((int)(16*tip.length()*1.07f), 16);
        tipLabel.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel.setForeground(Color.RED);
        tipLabel.setLocation(470,128+80+150);
        
        JLabel l21 = new JLabel("寄件人姓名：");
		l21.setSize((int)(16*6*1.07f), 16);
		l21.setFont(new Font("宋体", Font.BOLD, 15));
        l21.setLocation(CourierFrame.w/6+40, 128+80+150+50);
        name1Label = new JLabel();
        name1Label.setSize((int)(16*6*1.07f), 16);
        name1Label.setFont(new Font("宋体", Font.BOLD, 15));
        name1Label.setForeground(Color.RED);
        name1Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+150+50);
        
		JLabel l22 = new JLabel("寄件人手机：");
		l22.setSize((int)(16*6*1.07f), 16);
		l22.setFont(new Font("宋体", Font.BOLD, 15));
		l22.setLocation(CourierFrame.w/6+40, 128+80+150+100);
		phone1Label = new JLabel();
		phone1Label.setSize((int)(16*6*1.07f), 16);
		phone1Label.setFont(new Font("宋体", Font.BOLD, 15));
		phone1Label.setForeground(Color.RED);
		phone1Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+150+100);

		JLabel l23 = new JLabel("寄件人地址：");
		l23.setSize((int)(16*6*1.07f), 16);
		l23.setFont(new Font("宋体", Font.BOLD, 15));
		l23.setLocation(CourierFrame.w/6+40, 128+80+150+150);
        add1Label = new JLabel();
        add1Label.setSize((int)(16*44*1.07f), 16);
        add1Label.setFont(new Font("宋体", Font.BOLD, 15));
        add1Label.setForeground(Color.RED);
        add1Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+150+150);
        
        JLabel l24 = new JLabel("收件人姓名：");
		l24.setSize((int)(16*6*1.07f), 16);
		l24.setFont(new Font("宋体", Font.BOLD, 15));
        l24.setLocation(620, 128+80+150+50);
        name2Label = new JLabel();
        name2Label.setSize((int)(16*6*1.07f), 16);
        name2Label.setFont(new Font("宋体", Font.BOLD, 15));
        name2Label.setForeground(Color.RED);
        name2Label.setLocation(620+(int)(16*6*1.07f), 128+80+150+50);
        
		JLabel l25 = new JLabel("收件人手机：");
		l25.setSize((int)(16*6*1.07f), 16);
		l25.setFont(new Font("宋体", Font.BOLD, 15));
		l25.setLocation(620, 128+80+150+100);
		phone2Label = new JLabel();
		phone2Label.setSize((int)(16*6*1.07f), 16);
		phone2Label.setFont(new Font("宋体", Font.BOLD, 15));
		phone2Label.setForeground(Color.RED);
		phone2Label.setLocation(620+(int)(16*6*1.07f), 128+80+150+100);

		JLabel l26 = new JLabel("收件人地址：");
		l26.setSize((int)(16*6*1.07f), 16);
		l26.setFont(new Font("宋体", Font.BOLD, 15));
		l26.setLocation(CourierFrame.w/6+40, 128+80+150+200);
        add2Label = new JLabel();
        add2Label.setSize((int)(16*44*1.07f), 16);
        add2Label.setFont(new Font("宋体", Font.BOLD, 15));
        add2Label.setForeground(Color.RED);
        add2Label.setLocation(CourierFrame.w/6+40+(int)(16*6*1.07f), 128+80+150+200);


		JLabel l7 = new JLabel("内件品名：");
		l7.setSize((int)(16*5*1.07f), 16);
		l7.setFont(new Font("宋体", Font.BOLD, 15));
		l7.setLocation(CourierFrame.w/6+40, 128+80+150+250);
		nameLabel = new JLabel();
		nameLabel.setSize((int)(16*8*1.07f), 16);
		nameLabel.setFont(new Font("宋体", Font.BOLD, 15));
		nameLabel.setForeground(Color.RED);
		nameLabel.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f), 128+80+150+250);

		JLabel l8 = new JLabel("重量(Kg)：");
		l8.setSize((int)(16*5*1.07f), 16);
		l8.setFont(new Font("宋体", Font.BOLD, 15));
		l8.setLocation(450, 128+80+150+250);
		weightLabel = new JLabel();
		weightLabel.setSize((int)(16*6*1.07f), 16);
		weightLabel.setFont(new Font("宋体", Font.BOLD, 15));
		weightLabel.setForeground(Color.RED);
		weightLabel.setLocation(450+(int)(16*5*1.07f), 128+80+150+250);

		JLabel l9 = new JLabel("运费（元）：");
		l9.setSize((int)(16*6*1.07f), 16);
		l9.setFont(new Font("宋体", Font.BOLD, 15));
		l9.setLocation(720, 128+80+150+250);
		priceLabel = new JLabel();
		priceLabel.setSize((int)(16*6*1.07f), 16);
		priceLabel.setFont(new Font("宋体", Font.BOLD, 15));
		priceLabel.setForeground(Color.RED);
		priceLabel.setLocation(720+(int)(16*6*1.07f), 128+80+150+250);

		JLabel l10 = new JLabel("寄件时间：");
		l10.setSize((int)(16*5*1.07f), 16);
		l10.setFont(new Font("宋体", Font.BOLD, 15));
		l10.setLocation(CourierFrame.w/6+40, 128+80+150+300);
		senddateLabel = new JLabel();
		senddateLabel.setSize((int)(16*16*1.07f), 16);
		senddateLabel.setFont(new Font("宋体", Font.BOLD, 15));
		senddateLabel.setForeground(Color.RED);
		senddateLabel.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f), 128+80+150+300);
		
		selected.setLocation(480,128+80-5);
    	confirm.setLocation(CourierFrame.w-150,CourierFrame.h-80);
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_SendPkg);
    	add(goto_ReceivePkg);
    	add(goto_SearchPkgInformation);

    	add(ordernum);
    	add(order);
    	add(selected);
    	add(l1);
    	add(r_name);
    	add(l2);
    	add(r_phone);
    	add(l3);
    	add(r_date);
    	add(tipLabel);

    	add(l21);
    	add(name1Label);
    	add(l22);
    	add(phone1Label);
    	add(l23);
    	add(add1Label);
    	add(l24);
    	add(name2Label);
    	add(l25);
    	add(phone2Label);
    	add(l26);
    	add(add2Label);
    	
    	add(l7);
    	add(nameLabel);
    	add(l8);
    	add(weightLabel);
    	add(l9);
    	add(priceLabel);
    	add(l10);
    	add(senddateLabel);
    	
    	add(confirm);
    	
	}
	
	private void selecte(){
		String order_s = order.getText();

		result = CheckFormat.checkOrderNum(order_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}

		OrderListVO orderListVO = bl.findOrderlist(order_s);
		if(orderListVO==null){
			printMessage("此订单不存在！", Color.RED);
			return;
		}

		orderlist=order.getText();
		
		name1Label.setText(orderListVO.getSenderName());
		phone1Label.setText(orderListVO.getSenderTeleNumber());
		add1Label.setText(orderListVO.getSenderAddress());
		name2Label.setText(orderListVO.getReceiverName());
		phone2Label.setText(orderListVO.getReceiverTeleNumber());
		add2Label.setText(orderListVO.getReceiverAddress());
		nameLabel.setText(orderListVO.getName());
		weightLabel.setText(""+orderListVO.getWeight());
		priceLabel.setText(""+orderListVO.getPackPrice());
		senddateLabel.setText(orderListVO.getDepartTime());
	}
	private void receive(){
		if(orderlist.compareTo("")==0){
			printMessage("没有选择一个订单！", Color.RED);
			return;
		}
		
		String r_name_s = r_name.getText();
		String r_phone_s = r_phone.getText();
		String r_date_s = r_date.getText();
		
		if(r_name_s.compareTo("")==0){
			printMessage("没有输入收件人姓名！", Color.RED);
			return;
		}
		/*result = CheckFormat.checkTime(r_date_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}*/
		
		ReceiverVO receiverVO = new ReceiverVO(r_name_s, r_date_s, r_phone_s);
		//OrderListVO orderListVO = bl.findOrderlist(orderlist);010001201511230020
		
		ResultMessage resultMessage = bl.confirmRecieve(receiverVO, orderlist);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
		
		order.setText("");
		r_name.setText("");	
		r_phone.setText("");	
		name1Label.setText("");
		phone1Label.setText("");
		add1Label.setText("");
		name2Label.setText("");
		phone2Label.setText("");
		add2Label.setText("");
		nameLabel.setText("");
		weightLabel.setText("");
		priceLabel.setText("");
		senddateLabel.setText("");
	}
	private void clear(){
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date_);
		r_date.setText(time);
		order.setText("");
		r_name.setText("");	
		r_phone.setText("");	
		name1Label.setText("");//标签也设为空
		phone1Label.setText("");
		add1Label.setText("");
		name2Label.setText("");
		phone2Label.setText("");
		add2Label.setText("");
		nameLabel.setText("");
		weightLabel.setText("");
		priceLabel.setText("");
		senddateLabel.setText("");
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
