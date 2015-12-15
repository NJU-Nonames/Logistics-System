/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.topmanagerui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import businesslogicservice.informationchangeblservice.ConstantManageBLService;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.PkgType;
import utility.PriceType;
import utility.ResultMessage;
import vo.DistanceChartVO;
import vo.PriceChartVO;

/**
 * @author 谭期友
 *
 */
public class ConstantManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private ConstantManageBLService bl;
	private TopManagerFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_Statistic;
	private MyButton goto_Check;
	private MyButton goto_PeopleAgencyManage;
	private MyButton goto_SalaryStrategy;
	private MyButton goto_ConstantManage;
	private MyButton goto_SystemLog;
	//详细操作按钮以及其他组件
	private MyButton changePrice;
	private MyButton changeDistance;
	private MyButton addcity;

	private JComboBox<String> Price;
	private JTextField priceField;
	private JTextField newcity;
	private JComboBox<String> city1;
	private JComboBox<String> city2;
	private JTextField distanceField;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, TopManagerFrame.w/6, TopManagerFrame.h/6, TopManagerFrame.w, TopManagerFrame.h, null);
        g.drawImage(Img.BACKGROUND1, TopManagerFrame.w/6, 0, TopManagerFrame.w, TopManagerFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, TopManagerFrame.w/6, TopManagerFrame.h, null);
        g.drawLine(TopManagerFrame.w/6-1, 0, TopManagerFrame.w/6-1, TopManagerFrame.h);
        g.drawLine(TopManagerFrame.w/6, 0, TopManagerFrame.w/6, TopManagerFrame.h);
        g.drawLine(TopManagerFrame.w/6+1, 0, TopManagerFrame.w/6+1, TopManagerFrame.h);
        g.drawLine(TopManagerFrame.w/6, TopManagerFrame.h/6, TopManagerFrame.w, TopManagerFrame.h/6);
        g.drawLine(TopManagerFrame.w/6, TopManagerFrame.h/6+1, TopManagerFrame.w, TopManagerFrame.h/6+1);
        
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, TopManagerFrame.h-50, TopManagerFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+TopManagerFrame.w/2, 13+TopManagerFrame.h-30);
        }
	}
	
	public ConstantManage(TopManagerFrame frame, ConstantManageBLService bl, CurrentUser currentUser){
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
        goto_Statistic = new MyButton(frame.getWidth()/6, 30, Img.GOTONGJIBAOBIAO_0, Img.GOTONGJIBAOBIAO_1, Img.GOTONGJIBAOBIAO_2);
        goto_Statistic.addMouseListener(new MouseListener(){
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
        goto_Check = new MyButton(frame.getWidth()/6, 30, Img.GOSHENPAN_0, Img.GOSHENPAN_1, Img.GOSHENPAN_2);
        goto_Check.addMouseListener(new MouseListener(){
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
        goto_PeopleAgencyManage = new MyButton(frame.getWidth()/6, 30, Img.GORENYUAN_0, Img.GORENYUAN_1, Img.GORENYUAN_2);
        goto_PeopleAgencyManage.addMouseListener(new MouseListener(){
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
        goto_SalaryStrategy = new MyButton(frame.getWidth()/6, 30, Img.GOXINSHUI_0, Img.GOXINSHUI_1, Img.GOXINSHUI_2);
        goto_SalaryStrategy.addMouseListener(new MouseListener(){
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
    	goto_ConstantManage = new MyButton(frame.getWidth()/6, 30, Img.GOCHANGLIANG_0, Img.GOCHANGLIANG_1, Img.GOCHANGLIANG_2);
    	goto_ConstantManage.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(5);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	goto_SystemLog = new MyButton(frame.getWidth()/6, 30, Img.GOXITONG_0, Img.GOXITONG_1, Img.GOXITONG_2);
    	goto_SystemLog.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				clear();
				frame.setStated(frame.getState());
				frame.setState(6);
				frame.setChanged(true);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	//详细操作按钮
    	changePrice = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	changePrice.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_changePrice();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	changeDistance = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	changeDistance.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_changeDistance();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	addcity = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	addcity.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_addcity();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	changePrice.setLocation(720, 128+80-3);
    	changeDistance.setLocation(720,128+80+250-3);
    	addcity.setLocation(170+10+(int)(16*4*1.07f)+70,128+80+210-3);
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="制定价格距离常量";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.DARK_GRAY);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="总经理";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.DARK_GRAY);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
    	//最基本按钮
    	close.setLocation(TopManagerFrame.w-30,0);
    	min.setLocation(TopManagerFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_Statistic.setLocation(0,150);
    	goto_Check.setLocation(0,200);
    	goto_PeopleAgencyManage.setLocation(0,250);
    	goto_SalaryStrategy.setLocation(0,300);
    	goto_ConstantManage.setLocation(0,350);
    	goto_SystemLog.setLocation(0,400);
    	
    	//其他组件
    	priceField = new JTextField(bl.showPriceChart().getEconomic()+"");
    	priceField.setSize(60, 20);
    	priceField.setLocation(450, 128+80-3);
    	distanceField = new JTextField("0");
    	distanceField.setSize(60, 20);
    	distanceField.setLocation(450, 128+80+250-3);
		
    	Price=new JComboBox<String>();
    	Price.addItem("经济快递");
    	Price.addItem("标准快递");
    	Price.addItem("次晨特快");
    	Price.addItem("火车每公里每吨运费价格");
    	Price.addItem("货车每公里每吨运费价格");
    	Price.addItem("飞机每公里每吨运费价格");
    	Price.setSize(150, 20);
    	Price.setLocation(170+100, 128+80-3);
    	Price.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				if(Price.getSelectedItem().toString().compareTo("经济快递")==0)
					priceField.setText(bl.showPriceChart().getEconomic()+"");
				else if(Price.getSelectedItem().toString().compareTo("标准快递")==0)
					priceField.setText(bl.showPriceChart().getStandard()+"");
				else if(Price.getSelectedItem().toString().compareTo("次晨特快")==0)
					priceField.setText(bl.showPriceChart().getExpress()+"");
				else if(Price.getSelectedItem().toString().compareTo("火车每公里每吨运费价格")==0)
					priceField.setText(bl.showPriceChart().getTrain_kilo_t()+"");
				else if(Price.getSelectedItem().toString().compareTo("货车每公里每吨运费价格")==0)
					priceField.setText(bl.showPriceChart().getTruck_kilo_t()+"");
				else if(Price.getSelectedItem().toString().compareTo("飞机每公里每吨运费价格")==0)
					priceField.setText(bl.showPriceChart().getAirplane_kilo_t()+"");
			}
		});

    	JLabel l1 = new JLabel("单位：元每公里每吨");
		l1.setSize((int)(16*9*1.07f), 16);
		l1.setFont(new Font("宋体", Font.BOLD, 15));
		l1.setLocation(520, 128+80);
		
    	JLabel l2 = new JLabel("新城市：");
		l2.setSize((int)(16*4*1.07f), 16);
		l2.setFont(new Font("宋体", Font.BOLD, 15));
		l2.setLocation(170+10, 128+80+210);
		newcity = new JTextField();
		newcity.setSize(60, 20);
		newcity.setLocation(170+10+(int)(16*4*1.07f),128+80+210-3);

    	JLabel l3 = new JLabel("城市1：");
		l3.setSize((int)(16*4*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(170+100, 128+80+250);
		city1=new JComboBox<String>();
		city1.setSize(100, 20);
		city1.setLocation(170+100+(int)(16*4*1.07f), 128+80+250-3);
    	JLabel l4 = new JLabel("城市2：");
		l4.setSize((int)(16*4*1.07f), 16);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(170+100, 128+80+250+30);
		city2=new JComboBox<String>();
		
		DistanceChartVO distanceChartVO=bl.showDistanceChart();
		for(int i=1;i<distanceChartVO.getDistanceChart().length;i++){
			city1.addItem(distanceChartVO.getDistanceChart()[0][i]);
			city2.addItem(distanceChartVO.getDistanceChart()[0][i]);
		}
		
		city2.setSize(100, 20);
		city2.setLocation(170+100+(int)(16*4*1.07f), 128+80+250-3+30);
		city2.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String s1 = (String) city1.getSelectedItem();
				String s2 = (String) city2.getSelectedItem();
				int i1=0, i2=0;
				for(;s1.compareTo(bl.showDistanceChart().getDistanceChart()[0][i1])!=0;i1++);
				for(;s2.compareTo(bl.showDistanceChart().getDistanceChart()[i2][0])!=0;i2++);
				distanceField.setText(bl.showDistanceChart().getDistanceChart()[i2][i1]);
			}
		});
		city1.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				String s1 = (String) city1.getSelectedItem();
				String s2 = (String) city2.getSelectedItem();
				int i1=0, i2=0;
				for(;s1.compareTo(bl.showDistanceChart().getDistanceChart()[0][i1])!=0;i1++);
				for(;s2.compareTo(bl.showDistanceChart().getDistanceChart()[i2][0])!=0;i2++);
				distanceField.setText(bl.showDistanceChart().getDistanceChart()[i2][i1]);
			}
		});
    	JLabel l5 = new JLabel("单位：公里");
		l5.setSize((int)(16*9*1.07f), 16);
		l5.setFont(new Font("宋体", Font.BOLD, 15));
		l5.setLocation(520, 128+80+250);
        


		JLabel ll1 = new JLabel("价格常量：");
		ll1.setSize((int)(16*5*1.07f), 16);
		ll1.setFont(new Font("宋体", Font.BOLD, 15));
		ll1.setLocation(170+10, 128+80);
		JLabel ll2 = new JLabel("距离常量：");
		ll2.setSize((int)(16*5*1.07f), 16);
		ll2.setFont(new Font("宋体", Font.BOLD, 15));
		ll2.setLocation(170+10, 128+80+250);
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_Statistic);
    	add(goto_Check);
    	add(goto_PeopleAgencyManage);
    	add(goto_SalaryStrategy);
    	add(goto_ConstantManage);
    	add(goto_SystemLog);

    	add(Price);
    	add(priceField);
    	add(l1);
    	add(l2);
    	add(newcity);
    	
    	add(l3);
    	add(city1);
    	add(l4);
    	add(city2);
    	add(distanceField);
    	add(l5);
    	
    	add(ll1);
    	add(ll2);
    	add(changePrice);
    	add(changeDistance);
    	add(addcity);
	}

	private void _changePrice(){
		String priceField_s = priceField.getText();
		double priceField_s_double;
		try{
			priceField_s_double = Double.parseDouble(priceField_s);
		}catch(NumberFormatException e){
			printMessage("请输入正确价格常量！", Color.RED);
			return;
		}

		
		String s1 = (String) Price.getSelectedItem();
		PriceType type = PriceType.ECONOMIC;
		if(s1.compareTo("经济快递")==0){
			type=PriceType.ECONOMIC;
		}else if(s1.compareTo("标准快递")==0){
			type=PriceType.STANDARD;
		}else if(s1.compareTo("次晨特快")==0){
			type=PriceType.EXPRESS;
		}else if(s1.compareTo("火车每公里每吨运费价格")==0){
			type=PriceType.TRAIN_KILO_T;
		}else if(s1.compareTo("货车每公里每吨运费价格")==0){
			type=PriceType.TRUCK_KILO_T;
		}else if(s1.compareTo("飞机每公里每吨运费价格")==0){
			type=PriceType.AIRPLANE_KILO_T;
		}
		
		ResultMessage resultMessage = bl.submitPrice(priceField_s_double, type);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
	}
	private void _changeDistance(){
		String s1 = (String) city1.getSelectedItem();
		String s2 = (String) city2.getSelectedItem();
		
		String distanceField_s = (String) distanceField.getText();
		double distanceField_s_double;
		try{
			distanceField_s_double = Double.parseDouble(distanceField_s);
		}catch(NumberFormatException e){
			printMessage("请输入正确距离！", Color.RED);
			return;
		}

		ResultMessage resultMessage = bl.submitDistance(distanceField_s, s1, s2);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
	}
	private void _addcity(){
		String newcity_s = newcity.getText();
		
		if(newcity_s.compareTo("")==0){
			printMessage("没有输入城市！", Color.RED);
			return;
		}

		ResultMessage resultMessage = bl.addCity(newcity_s);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
		
		newcity.setText("");
	}
	private void clear(){
		newcity.setText("");
		Price.setSelectedIndex(0);
		city1.setSelectedIndex(0);
		city2.setSelectedIndex(0);
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
