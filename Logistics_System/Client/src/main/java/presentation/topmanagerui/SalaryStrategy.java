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

import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.Position;
import utility.PriceType;
import utility.ResultMessage;

/**
 * @author 谭期友
 *
 */
public class SalaryStrategy extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private PeopleAgencyBLService bl;
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
	private MyButton change;
	
	private JComboBox<String> position;
	private JTextField meiri;
	private JTextField ticheng;

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
	
	public SalaryStrategy(TopManagerFrame frame, PeopleAgencyBLService bl, CurrentUser currentUser){
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
        goto_SalaryStrategy = new MyButton(frame.getWidth()/6, 30, Img.GOXINSHUI_2, Img.GOXINSHUI_2, Img.GOXINSHUI_2);
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
    	change = new MyButton(90, 30, Img.UPDATE_0, Img.UPDATE_1, Img.UPDATE_2);
    	change.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	change.setLocation(170+20,128+80+40+40+40);
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="制定薪水策略";
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
		JLabel l5 = new JLabel("职位：");
		l5.setSize((int)(16*3*1.07f), 16);
		l5.setFont(new Font("宋体", Font.BOLD, 15));
		l5.setLocation(170+20, 128+80);
		position=new JComboBox<String>();
		position.addItem("快递员");
		position.addItem("营业厅业务员");
		position.addItem("中转中心业务员");
		position.addItem("中转中心仓库管理员");
		position.addItem("低权限财务人员");
		position.addItem("高权限财务人员");
		position.addItem("总经理");
		position.addItem("系统管理员");
		position.addItem("司机");
		position.setSize(150, 20);
		position.setLocation(170+20+(int)(16*3*1.07f), 128+80-3);
		position.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				
			}
		});
        
		JLabel l3 = new JLabel("每日工资：");
		l3.setSize((int)(16*5*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(170+20, 128+80+40);
		meiri = new JTextField();
		meiri.setSize(60, 20);
		meiri.setLocation(170+20+(int)(16*5*1.07f),128+80+40-3);

		JLabel l4 = new JLabel("提成比例：");
		l4.setSize((int)(16*5*1.07f), 16);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(170+20, 128+80+40+40);
		ticheng = new JTextField();
		ticheng.setSize(60, 20);
		ticheng.setLocation(170+20+(int)(16*5*1.07f),128+80+40+40-3);
		JLabel l9 = new JLabel("%");
		l9.setSize((int)(20*1*1.07f), 20);
		l9.setFont(new Font("宋体", Font.BOLD, 20));
		l9.setLocation(170+20+(int)(16*5*1.07f)+60, 128+80+40+40-3);
		add(l9);
		
		
		
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

    	add(l5);
    	add(position);
    	add(l3);
    	add(meiri);
    	add(l4);
    	add(ticheng);
		add(change);
    	
	}

	private void _change(){
		String meiri_s = (String) meiri.getText();
		String ticheng_s = (String) ticheng.getText();

		double meiri_s_double;
		try{
			meiri_s_double = Double.parseDouble(meiri_s);
		}catch(NumberFormatException e){
			printMessage("请输入正确每日工资！", Color.RED);
			return;
		}
		double ticheng_s_double;
		try{
			ticheng_s_double = Double.parseDouble(ticheng_s);
		}catch(NumberFormatException e){
			printMessage("请输入正确提成！", Color.RED);
			return;
		}

		String s1 = (String) position.getSelectedItem();
		Position _position_=null;
		if(s1.compareTo("快递员")==0){
			_position_=Position.COURIER;
		}else if(s1.compareTo("营业厅业务员")==0){
			_position_=Position.BUSINESS_OFFICE_CLERK;
		}else if(s1.compareTo("中转中心业务员")==0){
			_position_=Position.CENTER_CLERK;
		}else if(s1.compareTo("中转中心仓库管理员")==0){
			_position_=Position.CENTER_REPERTORY_CLERK;
		}else if(s1.compareTo("低权限财务人员")==0){
			_position_=Position.FINANCIAL_STAFF_LOW;
		}else if(s1.compareTo("高权限财务人员")==0){
			_position_=Position.FINANCIAL_STAFF_HIGH;
		}else if(s1.compareTo("总经理")==0){
			_position_=Position.TOP_MANAGER;
		}else if(s1.compareTo("系统管理员")==0){
			_position_=Position.ADMIN;
		}else if(s1.compareTo("司机")==0){
			_position_=Position.DRIVER;
		}
		
		ResultMessage resultMessage = bl.salaryManage(_position_, meiri_s+":"+ticheng_s);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
	}
	private void clear(){
		meiri.setText("");
		ticheng.setText("");
		position.setSelectedIndex(0);
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
