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
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogicservice.logisticsblservice.SendPkgBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.ExpressType;
import utility.PkgType;
import utility.ResultMessage;
import vo.OrderListVO;

/**
 * @author 谭期友
 *
 */
public class SendPkg extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private SendPkgBLService bl;
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
	private MyButton review;
	private MyButton confirm;
	
	private JTextField name1;	
	private JTextField phone1;	
	private JTextField address1;
	private JTextField name2;	
	private JTextField phone2;
	private JTextField address2;
	private JTextField weight;
	private JTextField volume;	
	private JTextField date;
	private JComboBox<String> pkgType;
	private JTextField num;
	private JTextField name;
	private JComboBox<String> expressType;
	private JLabel pre_date;
	private JLabel money;
	private JLabel barCode;


	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        //背景界面
        g.drawImage(Img.BACKGROUND2, CourierFrame.w/6, CourierFrame.h/6, CourierFrame.w, CourierFrame.h, null);
        g.drawImage(Img.BACKGROUND1, CourierFrame.w/6, 0, CourierFrame.w, CourierFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, CourierFrame.w/6, CourierFrame.h, null);
        g.drawLine(CourierFrame.w/6-1, 0, CourierFrame.w/6-1, CourierFrame.h);
        g.drawLine(CourierFrame.w/6, 0, CourierFrame.w/6, CourierFrame.h);
        g.drawLine(CourierFrame.w/6+1, 0, CourierFrame.w/6+1, CourierFrame.h);
        g.drawLine(CourierFrame.w/6, CourierFrame.h/6, CourierFrame.w, CourierFrame.h/6);
        g.drawLine(CourierFrame.w/6, CourierFrame.h/6+1, CourierFrame.w, CourierFrame.h/6+1);
        
        
        g.drawLine(CourierFrame.w/6+20, 128+80+100, CourierFrame.w-20, 128+80+100);
        g.drawLine(CourierFrame.w/6+20, 128+80+240, CourierFrame.w-20, 128+80+240);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CourierFrame.h-50, CourierFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CourierFrame.w/2, 13+CourierFrame.h-30);
        }
	}
	
	public SendPkg(CourierFrame frame,SendPkgBLService bl, CurrentUser currentUser){
		this.frame=frame;
		this.bl=bl;
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
        goto_ReceivePkg = new MyButton(frame.getWidth()/6, 30, Img.GOTORECEIVE_0, Img.GOTORECEIVE_1, Img.GOTORECEIVE_2);
        goto_ReceivePkg.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(2);
				frame.setChanged(true);
				goto_ReceivePkg.setState(2);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {
			}
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
        review = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        review.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_review();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        review.setLocation(CourierFrame.w-80,170+60);
        confirm = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_create();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	confirm.setLocation(CourierFrame.w-80,CourierFrame.h-80);
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="寄件";
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
		JLabel l1 = new JLabel("寄件人姓名：");
		l1.setSize((int)(15*6*1.07f), 15);
		l1.setFont(new Font("宋体", Font.BOLD, 15));
        l1.setLocation(CourierFrame.w/6+40, 128+80);
        name1 = new JTextField();
        name1.setSize(80, 20);
        name1.setLocation(CourierFrame.w/6+40+(int)(15*6*1.07f),128+80-3);
        
        barCode=new JLabel("订单号:"+bl.createOrderId());
        barCode.setSize((int)(15*18*1.07f), 16);
        barCode.setFont(new Font("宋体", Font.BOLD, 15));
        barCode.setLocation(CourierFrame.w/6+500, 128+80);
        
		JLabel l2 = new JLabel("手机：");
		l2.setSize((int)(16*3*1.07f), 16);
		l2.setFont(new Font("宋体", Font.BOLD, 15));
        l2.setLocation(450, 128+80);
        phone1 = new JTextField();
        phone1.setSize(110, 20);
        phone1.setLocation(450+(int)(15*3*1.07f),128+80-3);

		JLabel l3 = new JLabel("地址：");
		l3.setSize((int)(15*3*1.07f), 15);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(CourierFrame.w/6+40, 128+80+50);
		address1 = new JTextField();
		address1.setSize(500, 20);
		address1.setLocation(CourierFrame.w/6+40+(int)(15*3*1.07f),128+80+50-3);

		JLabel l4 = new JLabel("收件人姓名：");
		l4.setSize((int)(15*6*1.07f), 15);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(CourierFrame.w/6+40, 128+80+140);
        name2 = new JTextField();
        name2.setSize(80, 20);
        name2.setLocation(CourierFrame.w/6+40+(int)(15*6*1.07f),128+80-3+140);
        
		JLabel l5 = new JLabel("手机：");
		l5.setSize((int)(16*3*1.07f), 16);
		l5.setFont(new Font("宋体", Font.BOLD, 15));
		l5.setLocation(450, 128+80+140);
        phone2 = new JTextField();
        phone2.setSize(110, 20);
        phone2.setLocation(450+(int)(15*3*1.07f),128+80-3+140);

		JLabel l6 = new JLabel("地址：");
		l6.setSize((int)(15*3*1.07f), 15);
		l6.setFont(new Font("宋体", Font.BOLD, 15));
		l6.setLocation(CourierFrame.w/6+40, 128+80+50+140);
		address2 = new JTextField();
		address2.setSize(500, 20);
		address2.setLocation(CourierFrame.w/6+40+(int)(15*3*1.07f),128+80+50-3+140);
		
		JLabel l7 = new JLabel("重量(Kg)：");
		l7.setSize((int)(16*5*1.07f), 16);
		l7.setFont(new Font("宋体", Font.BOLD, 15));
		l7.setLocation(CourierFrame.w/6+40, 128+80+280);
		weight = new JTextField();
		weight.setSize(80, 20);
		weight.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f),128+80-3+280);
        
		JLabel l8 = new JLabel("体积(m^3)：");
		l8.setSize((int)(16*6*1.07f), 16);
		l8.setFont(new Font("宋体", Font.BOLD, 15));
		l8.setLocation(450, 128+80+280);
		volume = new JTextField();
		volume.setSize(110, 20);
		volume.setLocation(450+(int)(16*6*1.07f),128+80-3+280);

		JLabel l9 = new JLabel("寄件时间：");
		l9.setSize((int)(16*5*1.07f), 16);
		l9.setFont(new Font("宋体", Font.BOLD, 15));
		l9.setLocation(720, 128+80+280);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date_);
		date = new JTextField(time);
		date.setSize(150, 20);
		date.setLocation(720+(int)(16*5*1.07f),128+80-3+280);
		
		JLabel l10 = new JLabel("包装类型：");
		l10.setSize((int)(16*5*1.07f), 16);
		l10.setFont(new Font("宋体", Font.BOLD, 15));
		l10.setLocation(CourierFrame.w/6+40, 128+80+280+45);
		pkgType=new JComboBox<String>();
		pkgType.addItem("木箱");
		pkgType.addItem("纸箱");
		pkgType.addItem("纸袋");
		pkgType.setSize(120, 20);
		pkgType.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f), 128+80+280+45-3);

		JLabel l11 = new JLabel("寄件件数：");
		l11.setSize((int)(16*5*1.07f), 16);
		l11.setFont(new Font("宋体", Font.BOLD, 15));
		l11.setLocation(450, 128+80+280+45);
		num = new JTextField(1+"");
		num.setSize(120, 20);
		num.setLocation(450+(int)(16*5*1.07f),128+80+280+45);

		JLabel l12 = new JLabel("货物内件品名：");
		l12.setSize((int)(16*7*1.07f), 16);
		l12.setFont(new Font("宋体", Font.BOLD, 15));
		l12.setLocation(720, 128+80+280+45);
		name = new JTextField();
		name.setSize(120, 20);
		name.setLocation(720+(int)(16*7*1.07f),128+80+280+45);
		
		JLabel l13 = new JLabel("快递类型：");
		l13.setSize((int)(16*5*1.07f), 16);
		l13.setFont(new Font("宋体", Font.BOLD, 15));
		l13.setLocation(CourierFrame.w/6+40, 128+80+280+90);
		expressType=new JComboBox<String>();
		expressType.addItem("标准快递");
		expressType.addItem("经济快递");
		expressType.addItem("次晨特快");
		expressType.setSize(120, 20);
		expressType.setLocation(CourierFrame.w/6+40+(int)(16*5*1.07f), 128+80+280+90-3);
        
		JLabel l14 = new JLabel("预计送达天数：");
		l14.setSize((int)(16*7*1.07f), 16);
		l14.setFont(new Font("宋体", Font.BOLD, 15));
		l14.setLocation(450, 128+80+280+90);
		pre_date = new JLabel();
		pre_date.setSize((int)(16*16*1.07f), 16);
		pre_date.setFont(new Font("宋体", Font.BOLD, 15));
		pre_date.setForeground(Color.RED);
		pre_date.setLocation(450+(int)(16*7*1.07f), 128+80+280+90);

		JLabel l15 = new JLabel("运费：");
		l15.setSize((int)(16*3*1.07f), 16);
		l15.setFont(new Font("宋体", Font.BOLD, 15));
		l15.setLocation(720, 128+80+280+90);
		money = new JLabel();
		money.setSize((int)(16*8*1.07f), 16);
		money.setFont(new Font("宋体", Font.BOLD, 15));
		money.setForeground(Color.RED);
		money.setLocation(720+(int)(16*3*1.07f), 128+80+280+90);
		


		
		
		
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

    	add(l1);
    	add(name1);
    	add(barCode);
    	add(l2);
    	add(phone1);
    	add(l3);
    	add(address1);

    	add(l4);
    	add(name2);
    	add(l5);
    	add(phone2);
    	add(l6);
    	add(address2);

    	add(l7);
    	add(weight);
    	add(l8);
    	add(volume);
    	add(l9);
    	add(date);

    	add(l10);
    	add(pkgType);
    	add(l11);
    	add(num);
    	add(l12);
    	add(name);
    	
    	add(l13);
    	add(expressType);
    	add(l14);
    	add(pre_date);
    	add(l15);
    	add(money);
    	add(confirm);
    	add(review);
	}
	
	private void _review(){
		String _address1 = address1.getText();
		String _address2 = address2.getText();
		String _weight = weight.getText();
		if(
				_address1.compareTo("")==0
				||_address2.compareTo("")==0
				||_weight.compareTo("")==0){
			printMessage("已有信息不够！", Color.RED);
			return;
		}


		double _weight_double;
		try{
			_weight_double = Double.parseDouble(_weight);
		}catch(NumberFormatException e){
			printMessage("请输入正确重量！", Color.RED);
			return;
		}
		
		
		
		String s1 = (String) pkgType.getSelectedItem();
		PkgType type = null;
		if(s1.compareTo("木箱")==0){
			type=PkgType.WOODEN;
		}else if(s1.compareTo("纸箱")==0){
			type=PkgType.PAPER;
		}else if(s1.compareTo("纸袋")==0){
			type=PkgType.PLASTIC;
		}
		
		String s2 = (String) expressType.getSelectedItem();
		ExpressType category = null;
		if(s2.compareTo("标准快递")==0){
			category=ExpressType.STANDARD;
		}else if(s2.compareTo("经济快递")==0){
			category=ExpressType.ECONOMIC;
		}else if(s2.compareTo("次晨特快")==0){
			category=ExpressType.EXPRESS;
		}
		
		
		
		OrderListVO orderListVO = 
				new OrderListVO("aa", _address1, "aa", 
						"aa", _address2, "aa", 
						"aa", _weight_double, 12, "aa", category, 
						null, 10.0, "111", type, "aa", "aa", CheckType.UNDERCHECK,"-","-");

		bl.createMoneyAndDate(orderListVO);
		pre_date.setText(orderListVO.getArriveTime()+"天");
		money.setText(orderListVO.getPackPrice()+"元");
	}
	private void _create(){
		String _name1 = name1.getText();
		String _phone1 = phone1.getText();
		String _address1 = address1.getText();
		String _name2 = name2.getText();
		String _phone2 = phone2.getText();
		String _address2 = address2.getText();
		String _weight = weight.getText();
		String _volume = volume.getText();
		String _date = date.getText();
		String _num = num.getText();
		String _name = name.getText();
		if(_name1.compareTo("")==0
				||_address1.compareTo("")==0
				||_name2.compareTo("")==0
				||_address2.compareTo("")==0
				||_weight.compareTo("")==0
				||_volume.compareTo("")==0
				||_num.compareTo("")==0
				||_name.compareTo("")==0){
			printMessage("寄件单输入不完整！", Color.RED);
			return;
		}

		result = CheckFormat.checkPhoneNum(_phone1);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkPhoneNum(_phone2);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
//		result = CheckFormat.checkTime(_date);
//		if(result.compareTo("格式正确")!=0){
//			printMessage(result, Color.RED);
//			return;
//		}

		double _weight_double;
		try{
			_weight_double = Double.parseDouble(_weight);
		}catch(NumberFormatException e){
			printMessage("请输入正确重量！", Color.RED);
			return;
		}
		double _volume_double;
		try{
			_volume_double = Double.parseDouble(_volume);
		}catch(NumberFormatException e){
			printMessage("请输入正确体积！", Color.RED);
			return;
		}
		int _num_int;
		try{
			_num_int = Integer.parseInt(_num);
		}catch(NumberFormatException e){
			printMessage("请输入正确寄件件数！", Color.RED);
			return;
		}
		
		
		
		String s1 = (String) pkgType.getSelectedItem();
		PkgType type = null;
		if(s1.compareTo("木箱")==0){
			type=PkgType.WOODEN;
		}else if(s1.compareTo("纸箱")==0){
			type=PkgType.PAPER;
		}else if(s1.compareTo("纸袋")==0){
			type=PkgType.PLASTIC;
		}
		
		String s2 = (String) expressType.getSelectedItem();
		ExpressType category = null;
		if(s2.compareTo("标准快递")==0){
			category=ExpressType.STANDARD;
		}else if(s2.compareTo("经济快递")==0){
			category=ExpressType.ECONOMIC;
		}else if(s2.compareTo("次晨特快")==0){
			category=ExpressType.EXPRESS;
		}
		
		
		OrderListVO orderListVO = 
				new OrderListVO(_name1, _address1, _phone1, 
						_name2, _address2, _phone2, 
						_num, _weight_double, _volume_double, _name, category, 
						null, 10.0, bl.createOrderId(), type, _date, "2000-1-1 0:00:00", CheckType.UNDERCHECK,"-","-");

		bl.createMoneyAndDate(orderListVO);//自动改变orderListVO的运费和ArriveTime
						
		orderListVO.setArriveTime("2000-1-1 0:00:00");
		ResultMessage resultMessage = bl.createOrderList(orderListVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.BLUE);
		}
						

		name1.setText("");	
		phone1.setText("");	
		address1.setText("");
		name2.setText("");	
		phone2.setText("");
		address2.setText("");
		weight.setText("");
		volume.setText("");
		DateFormat format3=new SimpleDateFormat("yyyy-MM-dd");
		//String time3=format3.format(date_);
		//date.setText(time3);
		num.setText(1+"");
		name.setText("");
		pre_date.setText("");
		money.setText("");
		pkgType.setSelectedIndex(0);
		expressType.setSelectedIndex(0);
						
	}
	private void clear(){
		barCode.setText("订单号:"+bl.createOrderId());
		name1.setText("");	
		phone1.setText("");	
		address1.setText("");
		name2.setText("");	
		phone2.setText("");
		address2.setText("");
		weight.setText("");
		volume.setText("");	
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date_);
		date.setText(time);
		num.setText(1+"");
		name.setText("");
		pre_date.setText("");
		money.setText("");
		pkgType.setSelectedIndex(0);
		expressType.setSelectedIndex(0);
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
