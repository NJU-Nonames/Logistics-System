/**
 * 2015年11月15日
 *author:
 *description:
 */
package presentation.financialstaffhighui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JTextArea;

import businesslogicservice.financeblservice.CostManagementBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.CostClause;
import utility.ResultMessage;
import vo.MoneyOutListVO;

/**成本管理
 * @author 谭期友
 *
 */
public class CostManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private CostManagementBLService bl;
	private FinacialStaffHighFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_AccountManage;//账户管理
	private MyButton goto_CostManage;//成本管理
	private MyButton goto_SettlementManage;//结算管理
	private MyButton goto_Statistic;//统计报表
	private MyButton goto_BaseDataSetting;//期初建账
	private MyButton goto_SystemLog;//查看系统日志
	//详细操作按钮以及其他组件
	private MyButton confirm;
	
	private JLabel id;
	private JTextField pay_man;
	private JTextField pay_date;
	private JTextField money;
	private JTextField bankcard;
	private JTextArea note;
	private JRadioButton rent;
	private JRadioButton deli_price;
	private JRadioButton salary;
	private JRadioButton reward;
	private ButtonGroup buttonGroup;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        //g.drawImage(Img.cao2, -200, 0, 1366, 768, null);
        g.drawLine(FinacialStaffHighFrame.w/6, 10, FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h-10);
        g.drawLine(FinacialStaffHighFrame.w/6+10, FinacialStaffHighFrame.h/6, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h/6);
        g.drawImage(Img.BACKGROUND2, FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h/6, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h, null);
        g.drawImage(Img.BACKGROUND1, FinacialStaffHighFrame.w/6, 0, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h, null);
        g.drawLine(FinacialStaffHighFrame.w/6-1, 0, FinacialStaffHighFrame.w/6-1, FinacialStaffHighFrame.h);
        g.drawLine(FinacialStaffHighFrame.w/6, 0, FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h);
        g.drawLine(FinacialStaffHighFrame.w/6+1, 0, FinacialStaffHighFrame.w/6+1, FinacialStaffHighFrame.h);
        g.drawLine(FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h/6, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h/6);
        g.drawLine(FinacialStaffHighFrame.w/6, FinacialStaffHighFrame.h/6+1, FinacialStaffHighFrame.w, FinacialStaffHighFrame.h/6+1);
        
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, FinacialStaffHighFrame.h-50, FinacialStaffHighFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+FinacialStaffHighFrame.w/2, 13+FinacialStaffHighFrame.h-30);
        }
	}
	
	public CostManage(FinacialStaffHighFrame frame, CostManagementBLService bl, CurrentUser currentUser){
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
        goto_AccountManage = new MyButton(frame.getWidth()/6, 30, Img.GOZHANGHU_0, Img.GOZHANGHU_1, Img.GOZHANGHU_2);
        goto_AccountManage.addMouseListener(new MouseListener(){
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
    	goto_CostManage = new MyButton(frame.getWidth()/6, 30, Img.GOCHENGBEN_2, Img.GOCHENGBEN_2, Img.GOCHENGBEN_2);
    	goto_CostManage.addMouseListener(new MouseListener(){
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
    	goto_SettlementManage = new MyButton(frame.getWidth()/6, 30, Img.GOJIESUAN_0, Img.GOJIESUAN_1, Img.GOJIESUAN_2);
    	goto_SettlementManage.addMouseListener(new MouseListener(){
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
    	goto_Statistic = new MyButton(frame.getWidth()/6, 30, Img.GOTONGJIBAOBIAO_0,Img.GOTONGJIBAOBIAO_1,Img.GOTONGJIBAOBIAO_2);
    	goto_Statistic.addMouseListener(new MouseListener(){
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
    	goto_BaseDataSetting = new MyButton(frame.getWidth()/6, 30, Img.GOQICHU_0, Img.GOQICHU_1, Img.GOQICHU_2);
    	goto_BaseDataSetting.addMouseListener(new MouseListener(){
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
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="成本管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.DARK_GRAY);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="财务人员";
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
    	close.setLocation(FinacialStaffHighFrame.w-30,0);
    	min.setLocation(FinacialStaffHighFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_AccountManage.setLocation(0,150);
    	goto_CostManage.setLocation(0,200);
    	goto_SettlementManage.setLocation(0,250);
    	goto_Statistic.setLocation(0,300);
    	goto_BaseDataSetting.setLocation(0,350);
    	goto_SystemLog.setLocation(0,400);
    	
    	//其他组件
    	id=new JLabel("付款单单号：   "+bl.createMoneyOutListId());
    	id.setSize((int)(16*20*1.07f), 16);
    	id.setFont(new Font("宋体", Font.BOLD, 15));
    	id.setLocation(FinacialStaffHighFrame.w/6+40, 128+30);
    	
    	JLabel l1 = new JLabel("付款人：");
		l1.setSize((int)(16*4*1.07f), 16);
		l1.setFont(new Font("宋体", Font.BOLD, 15));
        l1.setLocation(FinacialStaffHighFrame.w/6+40, 128+80);
        pay_man = new JTextField();
        pay_man.setSize(150, 20);
        pay_man.setLocation(FinacialStaffHighFrame.w/6+40+(int)(16*5*1.07f),128+80-3);
        
		JLabel l2 = new JLabel("付款日期：");
		l2.setSize((int)(16*5*1.07f), 16);
		l2.setFont(new Font("宋体", Font.BOLD, 15));
		l2.setLocation(FinacialStaffHighFrame.w/6+40, 128+80+50);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date_);
		pay_date = new JTextField(time);
		pay_date.setSize(150, 20);
		pay_date.setLocation(FinacialStaffHighFrame.w/6+40+(int)(16*5*1.07f),128+80+50-3);

		JLabel l3 = new JLabel("付款金额：");
		l3.setSize((int)(16*5*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(FinacialStaffHighFrame.w/6+40, 128+80+100);
		money = new JTextField();
		money.setSize(150, 20);
		money.setLocation(FinacialStaffHighFrame.w/6+40+(int)(16*5*1.07f),128+80+100-3);
		
		JLabel l4 = new JLabel("付款账号：");
		l4.setSize((int)(16*5*1.07f), 16);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(FinacialStaffHighFrame.w/6+40, 128+80+150);
		bankcard = new JTextField();
		bankcard.setSize(150, 20);
		bankcard.setLocation(FinacialStaffHighFrame.w/6+40+(int)(16*5*1.07f),128+80+150-3);
		
		JLabel l5 = new JLabel("备注：");
		l5.setSize((int)(16*3*1.07f), 16);
		l5.setFont(new Font("宋体", Font.BOLD, 15));
		l5.setLocation(FinacialStaffHighFrame.w/6+40, 128+80+200);
		note = new JTextArea();
		note.setSize(200, 100);
		note.setBorder(BorderFactory.createEtchedBorder());
		note.setLocation(FinacialStaffHighFrame.w/6+40+(int)(16*5*1.07f),128+80+200-3);
		
		JLabel l6 = new JLabel("付款条目：");
		l6.setSize((int)(16*5*1.07f), 16);
		l6.setFont(new Font("宋体", Font.BOLD, 15));
		l6.setLocation(600, 128+80);

		rent=new JRadioButton("租金", true);
		rent.setSize((int)(20*3*1.07f), 20);
		rent.setFont(new Font("宋体", Font.BOLD, 16));
		rent.setLocation(600+(int)(16*5*1.07f), 128+80);
		rent.setOpaque(false);
		
		deli_price=new JRadioButton("运费", false);
		deli_price.setSize((int)(20*3*1.07f), 20);
		deli_price.setFont(new Font("宋体", Font.BOLD, 16));
		deli_price.setLocation(600+(int)(16*5*1.07f), 128+80+30);
		deli_price.setOpaque(false);
		
		salary=new JRadioButton("人员工资", false);
		salary.setSize((int)(20*5*1.07f), 20);
		salary.setFont(new Font("宋体", Font.BOLD, 16));
		salary.setLocation(600+(int)(16*5*1.07f), 128+80+60);
		salary.setOpaque(false);
		
		reward=new JRadioButton("奖励", false);
		reward.setSize((int)(20*3*1.07f), 20);
		reward.setFont(new Font("宋体", Font.BOLD, 16));
		reward.setLocation(600+(int)(16*5*1.07f), 128+80+90);
		reward.setOpaque(false);
		
		buttonGroup=new ButtonGroup();
		buttonGroup.add(rent);
		buttonGroup.add(deli_price);
		buttonGroup.add(salary);
		buttonGroup.add(reward);

		
		JLabel l7 = new JLabel("新建付款单：");
		l7.setSize((int)(16*6*1.07f), 16);
		l7.setFont(new Font("宋体", Font.BOLD, 15));
		l7.setLocation(596-30/2-(int)(16*6*1.07f),600+5);
    	confirm.setLocation(596-30/2,600);
		
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_AccountManage);
    	add(goto_CostManage);
    	add(goto_SettlementManage);
    	add(goto_Statistic);
    	add(goto_BaseDataSetting);
    	add(goto_SystemLog);

    	add(id);
    	add(l1);
    	add(pay_man);
    	add(l2);
    	add(pay_date);
    	add(l3);
    	add(money);
    	add(l4);
    	add(bankcard);
    	add(l5);
    	add(note);
    	add(l6);

    	add(rent);
		add(deli_price);
		add(salary);
		add(reward);
		
		add(l7);
		add(confirm);
	}

	private void _create(){
		String pay_man_s = pay_man.getText();
		String pay_date_s = pay_date.getText();
		String money_s = money.getText();
		String bankcard_s = bankcard.getText();
		String note_s = note.getText();

		if(pay_man_s.compareTo("")==0){
			printMessage("没有输入付款人！", Color.RED);
			return;
		}
		result = CheckFormat.checkCreateTime(pay_date_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		if(money_s.compareTo("")==0){
			printMessage("没有输入付款金额！", Color.RED);
			return;
		}
		double money_s_double;
		try{
			money_s_double = Double.parseDouble(money_s);
		}catch(NumberFormatException e){
			printMessage("请输入正确付款金额！", Color.RED);
			return;
		}
		result = CheckFormat.checkBankAccountNum(bankcard_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		CostClause costClause=null;
		if(rent.isSelected())
			costClause=CostClause.rentfare;
		else if(deli_price.isSelected())
			costClause=CostClause.shipmentfare;
		else if(salary.isSelected())
			costClause=CostClause.salary;
		else if(reward.isSelected())
			costClause=CostClause.bonus;
		
		
		MoneyOutListVO moneyOutListVO=new MoneyOutListVO(bl.createMoneyOutListId(), pay_date_s, money_s_double, pay_man_s, bankcard_s, costClause, note_s, CheckType.UNDERCHECK);
		ResultMessage resultMessage = bl.createMoneyOutlist(moneyOutListVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
				
		
		pay_man.setText("");
		money.setText("");
		bankcard.setText("");
		note.setText("");
		rent.setSelected(true);
	}
	private void clear(){
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date_);
		id.setText("付款单单号：   "+bl.createMoneyOutListId());
		pay_man.setText("");
		money.setText("");
		bankcard.setText("");
		note.setText("");
		rent.setSelected(true);
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
