/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.topmanagerui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Vector;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import businesslogicservice.informationchangeblservice.PeopleAgencyBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.Position;
import utility.ResultMessage;
import vo.AgencyVO;
import vo.StaffVO;

/**
 * @author 谭期友
 *
 */
public class PeopleAgencyManage extends JPanel{

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
	private MyButton searchAgency;
	private MyButton add;
	private MyButton remove;
	private MyButton change;
//	private MyButton viewPeople;
	
	private JTextField AgencyField;
	private DefaultTableModel AgencyTableModel;
	private JTable AgencyTable;
	private JTextField newAgencyField;
	private JTextField newAgencyNum;

	private DefaultTableModel PeopleTableModel;
	private JTable PeopleTable;
	
	private JTextField name;
	private JTextField sex;
	private JComboBox<String> position;
	private JTextField IDNum;//身份证
	private JTextField workingstarttime;
	private JTextField phoneNum;
	private JTextField wage;
	private JTextField id;

	private MyButton addPeople;
	private MyButton removePeople;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色
	
	private int index1;
	private int index2;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.p17, 0, 0, 1366, 768, null);
        g.drawLine(TopManagerFrame.w/6, 10, TopManagerFrame.w/6, TopManagerFrame.h-10);
        g.drawLine(TopManagerFrame.w/6+10, TopManagerFrame.h/6, TopManagerFrame.w, TopManagerFrame.h/6);
        g.drawLine(596,128+70,596,128+70+270);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, TopManagerFrame.h-50, TopManagerFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+TopManagerFrame.w/2, 13+TopManagerFrame.h-30);
        }
	}
	
	public PeopleAgencyManage(TopManagerFrame frame, PeopleAgencyBLService bl, CurrentUser currentUser){
		this.frame=frame;
		this.bl=bl;
		this.currentUser=currentUser;
		willprintMessage=false;
		result="";
		co=Color.RED;
		this.setLayout(null);
		index1=0;
		index2=0;

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
        goto_Statistic = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_Check = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_PeopleAgencyManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_SalaryStrategy = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
    	goto_ConstantManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
    	goto_SystemLog = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
    	searchAgency = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	searchAgency.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_searchAgency();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	add = new MyButton(30, 30, Img.BG, Img.CLOSE_1, Img.CLOSE_2);
    	add.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_addAgency();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	remove = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	remove.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_removeAgency();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	change = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	change.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_changeAgency();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
//    	viewPeople = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
//    	viewPeople.addMouseListener(new MouseListener(){
//			public void mouseClicked(MouseEvent arg0) {
//				_viewPeople();
//			}
//			public void mouseEntered(MouseEvent arg0) {}
//			public void mouseExited(MouseEvent arg0) {}
//			public void mousePressed(MouseEvent arg0) {}
//			public void mouseReleased(MouseEvent arg0) {}
//        });
    	addPeople = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	addPeople.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_addPeople();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	removePeople = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	removePeople.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_removePeople();
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

        String func="人员机构管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.RED);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="总经理";
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
    	close.setLocation(TopManagerFrame.w-30,0);
    	min.setLocation(TopManagerFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_Statistic.setLocation(20,150);
    	goto_Check.setLocation(20,200);
    	goto_PeopleAgencyManage.setLocation(20,250);
    	goto_SalaryStrategy.setLocation(20,300);
    	goto_ConstantManage.setLocation(20,350);
    	goto_SystemLog.setLocation(20,400);
    	
    	//其他组件
        JLabel AccountLabel = new JLabel("机构编号：");
        AccountLabel.setSize((int)(16*5*1.07f), 16);
        AccountLabel.setFont(new Font("宋体", Font.BOLD, 15));
        AccountLabel.setLocation(170+20,128+60);
        
        AgencyField = new JTextField();
        AgencyField.setSize(110, 20);
        AgencyField.setLocation(170+20+(int)(16*5*1.07f),128+60);
        
        searchAgency.setLocation(170+20+(int)(16*5*1.07f)+110+20,128+60-3);
        

        
		
		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("机构名称");
		vColumns.add("机构编号");
		//数据
		Vector<String> vData = new Vector<String>();
		//模型
		AgencyTableModel = new DefaultTableModel(vData, vColumns);
		ArrayList<AgencyVO> arr = bl.showAgency();
        for(int i =0 ; i<arr.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(arr.get(i).getAgencyName());
    		v.add(arr.get(i).getAgencyNum());
    		AgencyTableModel.addRow(v);
        }
		//表格
		AgencyTable = new JTable(AgencyTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		AgencyTable.setPreferredScrollableViewportSize(new Dimension(380,120));
		AgencyTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		AgencyTable.setSelectionBackground(Color.YELLOW);
		JPanel jp=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(AgencyTable);
		AgencyTable.setFillsViewportHeight(true);
		jp.setSize(400, 150);
		jp.setLocation(170+20, 128+90);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);
//		AgencyTable.setRowSelectionInterval(0, 0);


		JLabel l1 = new JLabel("新机构名：");
		l1.setSize((int)(16*5*1.07f), 16);
		l1.setFont(new Font("宋体", Font.BOLD, 15));
		l1.setLocation(170+20, 128+245);
		newAgencyField = new JTextField();
		newAgencyField.setSize(110, 20);
		newAgencyField.setLocation(170+20+(int)(16*5*1.07f),128+245-3);

		JLabel l2 = new JLabel("新机构编号：");
		l2.setSize((int)(16*6*1.07f), 16);
		l2.setFont(new Font("宋体", Font.BOLD, 15));
		l2.setLocation(170+20+(int)(16*5*1.07f)+110+10, 128+245);
		newAgencyNum = new JTextField();
		newAgencyNum.setSize(80, 20);
		newAgencyNum.setLocation(170+20+(int)(16*5*1.07f)+110+10+(int)(16*6*1.07f),128+245-3);
		

    	add.setLocation(170+20, 128+245+20);
    	remove.setLocation(170+20+(int)(16*5*1.07f)+110+10,128+245+20);
    	change.setLocation(170+20,128+245+60);
//    	viewPeople.setLocation(170+20+(int)(16*5*1.07f)+110+10,128+245+60);

//    	String tip="提示：若要查看某一机构里的人员，先选中表格一行，点击按钮即可查看。";
//        JLabel tipLabel = new JLabel(tip);
//        tipLabel.setSize((int)(16*tip.length()*1.07f), 16);
//        tipLabel.setFont(new Font("宋体", Font.BOLD, 15));
//        tipLabel.setForeground(Color.RED);
//        tipLabel.setLocation(596-(int)(16*tip.length()*1.07f)/2,128+500);
    	String tip2="提示：若要修改机构名，先选中表格一行，再在“新机构名”里输入新机构名，最后点击修改按钮即可修改。";
        JLabel tipLabel2 = new JLabel(tip2);
        tipLabel2.setSize((int)(16*tip2.length()*1.07f), 16);
        tipLabel2.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel2.setForeground(Color.RED);
        tipLabel2.setLocation(596-(int)(16*tip2.length()*1.07f)/2,128+500+20);
    	String tip3="提示：若要修改机构里的人员资料，可以编辑其人员表格，最后点击修改按钮即可修改。(也要求你输入新机构名)";
        JLabel tipLabel3 = new JLabel(tip3);
        tipLabel3.setSize((int)(16*tip3.length()*1.07f), 16);
        tipLabel3.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel3.setForeground(Color.RED);
        tipLabel3.setLocation(596-(int)(16*tip3.length()*1.07f)/2+40,128+500+40);
    	String tip4="注意：机构编号不能修改，所以以上两种修改都不要求输入新机构编号。";
        JLabel tipLabel4 = new JLabel(tip4);
        tipLabel4.setSize((int)(16*tip4.length()*1.07f), 16);
        tipLabel4.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel4.setForeground(Color.RED);
        tipLabel4.setLocation(596-(int)(16*tip4.length()*1.07f)/2+40,128+500+60);


		//表头
		Vector<String> vColumns2 = new Vector<String>();
		vColumns2.add("姓名");
		vColumns2.add("性别");
		vColumns2.add("职位");
		vColumns2.add("身份证");
		vColumns2.add("工作起始时间");
		vColumns2.add("手机");
		vColumns2.add("工资");
		vColumns2.add("机构名称");
		vColumns2.add("编号");
		vColumns2.add("机构编号");
		//数据
		Vector<String> vData2 = new Vector<String>();
		//模型
		PeopleTableModel = new DefaultTableModel(vData2, vColumns2);
		//表格
		PeopleTable = new JTable(PeopleTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		PeopleTable.setPreferredScrollableViewportSize(new Dimension(830,120));
		PeopleTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		PeopleTable.setSelectionBackground(Color.YELLOW);
		JPanel jp2=new JPanel();
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.getViewport().add(PeopleTable);
		PeopleTable.setFillsViewportHeight(true);
		jp2.setSize(850, 150);
		jp2.setLocation(596-850/2, 128+245+60+40);
		jp2.setOpaque(false);
		jp2.add(scrollPane2,BorderLayout.CENTER);
        
		
		JLabel l3 = new JLabel("姓名：");
		l3.setSize((int)(16*3*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(596+10, 128+60);
		name = new JTextField();
		name.setSize(60, 20);
		name.setLocation(596+10+(int)(16*3*1.07f),128+60-3);

		JLabel l4 = new JLabel("性别：");
		l4.setSize((int)(16*3*1.07f), 16);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(596+10+(int)(16*3*1.07f)+60, 128+60);
		sex = new JTextField();
		sex.setSize(20, 20);
		sex.setLocation(596+10+(int)(16*3*1.07f)+60+(int)(16*3*1.07f),128+60-3);

		JLabel l5 = new JLabel("职位：");
		l5.setSize((int)(16*3*1.07f), 16);
		l5.setFont(new Font("宋体", Font.BOLD, 15));
		l5.setLocation(596+10+(int)(16*3*1.07f)+60+(int)(16*3*1.07f)+20, 128+60);
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
		position.setLocation(596+10+(int)(16*3*1.07f)+60+(int)(16*3*1.07f)+20+(int)(16*3*1.07f), 128+60-3);

		JLabel l6 = new JLabel("身份证：");
		l6.setSize((int)(16*4*1.07f), 16);
		l6.setFont(new Font("宋体", Font.BOLD, 15));
		l6.setLocation(596+10, 128+100);
		IDNum = new JTextField();
		IDNum.setSize(120, 20);
		IDNum.setLocation(596+10+(int)(16*4*1.07f),128+100-3);

		JLabel l7 = new JLabel("工作时间：");
		l7.setSize((int)(16*7*1.07f), 16);
		l7.setFont(new Font("宋体", Font.BOLD, 15));
		l7.setLocation(596+10+(int)(16*4*1.07f)+120, 128+100);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date_);
		workingstarttime = new JTextField(time);
		workingstarttime.setSize(70, 20);
		workingstarttime.setLocation(596+10+(int)(16*4*1.07f)+120+(int)(16*7*1.07f),128+100-3);
		
		JLabel l8 = new JLabel("手机：");
		l8.setSize((int)(16*3*1.07f), 16);
		l8.setFont(new Font("宋体", Font.BOLD, 15));
		l8.setLocation(596+10, 128+140);
		phoneNum = new JTextField();
		phoneNum.setSize(80, 20);
		phoneNum.setLocation(596+10+(int)(16*3*1.07f),128+140-3);

		JLabel l9 = new JLabel("工资：");
		l9.setSize((int)(16*3*1.07f), 16);
		l9.setFont(new Font("宋体", Font.BOLD, 15));
		l9.setLocation(596+10+(int)(16*3*1.07f)+80, 128+140);
		wage = new JTextField();
		wage.setSize(70, 20);
		wage.setLocation(596+10+(int)(16*3*1.07f)+80+(int)(16*3*1.07f),128+140-3);
		
		JLabel l10 = new JLabel("编号：");
		l10.setSize((int)(16*3*1.07f), 16);
		l10.setFont(new Font("宋体", Font.BOLD, 15));
		l10.setLocation(596+10, 128+180);
		id = new JTextField();
		id.setSize(120, 20);
		id.setLocation(596+10+(int)(16*3*1.07f),128+180-3);

		addPeople.setLocation(596+10, 128+245+60);
		removePeople.setLocation(596+120, 128+245+60);

		
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
    	
    	
    	add(AccountLabel);
    	add(AgencyField);
    	add(searchAgency);
		add(jp);
    	add(l1);
    	add(newAgencyField);
    	add(l2);
    	add(newAgencyNum);
		add(add);
		add(remove);
		add(change);
//		add(viewPeople);

		add(jp2);
		

//		add(tipLabel);
		add(tipLabel2);
		add(tipLabel3);
		add(tipLabel4);
		
    	add(l3);
    	add(name);
    	add(l4);
    	add(sex);
    	add(l5);
    	add(position);
    	add(l6);
    	add(IDNum);
    	add(l7);
    	add(workingstarttime);
    	add(l8);
    	add(phoneNum);
    	add(l9);
    	add(wage);
    	add(l10);
    	add(id);
    	
    	add(addPeople);
    	add(removePeople);
    	

		//System.out.println(AgencyTable.getSelectedRow());
		_viewPeople();
		new Thread(new Runnable(){
//	    	int i=0;
			public void run() {
				while(true){
					index2=AgencyTable.getSelectedRow();
					if(index1!=index2){
//						System.out.println(index1+":"+index2);
						index1=index2;
//						i++;
//						System.out.println("主线"+i);
						_viewPeople();
					}
				}
			}
		}).start();
	}

	private void _searchAgency(){
		String AgencyField_s = (String) AgencyField.getText();
		if(AgencyField_s.length()!=6){
			printMessage("请输入6位机构编号！", Color.RED);
			return;
		}
		AgencyVO agencyVO = bl.findAgency(AgencyField_s);
		if(agencyVO==null){
			printMessage("查无此机构！", Color.RED);
			return;
		}
		int i=0;
		String s=(String) AgencyTable.getValueAt(0, 1);
		while(s.compareTo(AgencyField_s)!=0){
			i++;
			s=(String) AgencyTable.getValueAt(i, 1);
		}
		AgencyTable.setRowSelectionInterval(i, i);
	}
	private void _addAgency(){
		String newAgencyField_s = (String) newAgencyField.getText();
		String newAgencyNum_s = (String) newAgencyNum.getText();
		if(newAgencyField_s.compareTo("")==0){
			printMessage("请输入新机构名！", Color.RED);
			return;
		}
		if(newAgencyNum_s.length()!=6){
			printMessage("请输入6位机构编号！", Color.RED);
			return;
		}
		
		AgencyVO agencyVO=new AgencyVO(newAgencyField_s, newAgencyNum_s, null);
		
		ResultMessage resultMessage = bl.addAgency(agencyVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}

		Vector<String> v = new Vector<String>();
		v.add(newAgencyField_s);
		v.add(newAgencyNum_s);
		AgencyTableModel.addRow(v);
		
		newAgencyField.setText("");
		newAgencyNum.setText("");
	}
	private void _removeAgency(){
		int index = AgencyTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个机构！", Color.RED);
			return;
		}
		ResultMessage resultMessage = bl.deleteAgency((String) AgencyTable.getValueAt(index, 1));
		printMessage(resultMessage.getMessage(), Color.GREEN);
		
		AgencyTableModel.removeRow(index);//肯定能成功==
	}
	private void _changeAgency(){
		int index = AgencyTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个机构！", Color.RED);
			return;
		}

		String newAgencyField_s = (String) newAgencyField.getText();
		if(newAgencyField_s.compareTo("")==0){
			printMessage("请输入新机构名！", Color.RED);
			return;
		}

		
		ArrayList<StaffVO> staffList=new ArrayList<StaffVO>();
		
		for(int i=0;i<PeopleTable.getRowCount();i++){
			String s1 = (String) PeopleTable.getValueAt(i, 2);
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
			
			
			staffList.add(new StaffVO(
					(String) PeopleTable.getValueAt(i, 0), 
					(String) PeopleTable.getValueAt(i, 1), 
					_position_, 
					(String) PeopleTable.getValueAt(i, 3), 
					(String) PeopleTable.getValueAt(i, 4), 
					(String) PeopleTable.getValueAt(i, 5), 
					(String) PeopleTable.getValueAt(i, 6), 
					newAgencyField_s, 
					(String) PeopleTable.getValueAt(i, 8), 
					(String) PeopleTable.getValueAt(i, 9)));
		}
		
		AgencyVO agencyVO=new AgencyVO(newAgencyField_s, (String) AgencyTable.getValueAt(index, 1), staffList);
		ResultMessage resultMessage = bl.updateAgency(agencyVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.BLUE);
		}

		AgencyTable.setValueAt(newAgencyField_s, index, 0);
	}
	private void _viewPeople(){
		int index = AgencyTable.getSelectedRow();
		
		while(PeopleTable.getRowCount()!=0)
			PeopleTableModel.removeRow(0);
		
		if(index == -1)return;
		AgencyVO agencyVO = bl.findAgency((String) AgencyTable.getValueAt(index, 1));
		
		while(PeopleTable.getRowCount()!=0)
			PeopleTableModel.removeRow(0);

		if(agencyVO.getStaffList()==null){
			printMessage("此机构没有人员！", Color.BLUE);
			return;
		}
		
        for(int i =0 ; i<agencyVO.getStaffList().size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(agencyVO.getStaffList().get(i).getName());
    		v.add(agencyVO.getStaffList().get(i).getSex());
    		

    		if(agencyVO.getStaffList().get(i).getPostion()==Position.COURIER){
        		v.add("快递员");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.BUSINESS_OFFICE_CLERK){
    			v.add("营业厅业务员");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.CENTER_CLERK){
    			v.add("中转中心业务员");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.CENTER_REPERTORY_CLERK){
    			v.add("中转中心仓库管理员");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.FINANCIAL_STAFF_LOW){
    			v.add("低权限财务人员");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.FINANCIAL_STAFF_HIGH){
    			v.add("高权限财务人员");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.TOP_MANAGER){
    			v.add("总经理");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.ADMIN){
    			v.add("系统管理员");
    		}else if(agencyVO.getStaffList().get(i).getPostion()==Position.DRIVER){
    			v.add("司机");
    		}
    		
    		
    		v.add(agencyVO.getStaffList().get(i).getIDNum());
    		v.add(agencyVO.getStaffList().get(i).getWorkingtime());
    		v.add(agencyVO.getStaffList().get(i).getPhoneNum());
    		v.add(agencyVO.getStaffList().get(i).getWage());
    		v.add(agencyVO.getStaffList().get(i).getAgencyName());
    		v.add(agencyVO.getStaffList().get(i).getId());
    		v.add(agencyVO.getStaffList().get(i).getAgencyId());
    		PeopleTableModel.addRow(v);
        }
	}
	private void _addPeople(){
		int index = AgencyTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个机构！", Color.RED);
			return;
		}
		
		
		String name_s = (String) name.getText();
		String sex_s = (String) sex.getText();
		String IDNum_s = (String) IDNum.getText();
		String workingstarttime_s = (String) workingstarttime.getText();
		String phoneNum_s = (String) phoneNum.getText();
		String wage_s = (String) wage.getText();
		String id_s = (String) id.getText();

		if(name_s.compareTo("")==0){
			printMessage("没有输入姓名！", Color.RED);
			return;
		}
		if(sex_s.compareTo("")==0){
			printMessage("没有输入性别！", Color.RED);
			return;
		}
		result = CheckFormat.checkIDCardNum(IDNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkTime(workingstarttime_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkPhoneNum(phoneNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		double wage_s_double;
		try{
			wage_s_double = Double.parseDouble(wage_s);
		}catch(NumberFormatException e){
			printMessage("请输入正确工资！", Color.RED);
			return;
		}
		if(id_s.compareTo("")==0){
			printMessage("没有输入编号！", Color.RED);
			return;
		}

		int i;
		String s;
		for(i=0;i<PeopleTable.getRowCount();i++){
			s=(String) PeopleTable.getValueAt(i, 3);
			if(s.compareTo(IDNum_s)==0){
				printMessage("员工身份证重复！", Color.RED);
				return;
			}
		}
		for(i=0;i<PeopleTable.getRowCount();i++){
			s=(String) PeopleTable.getValueAt(i, 5);
			if(s.compareTo(phoneNum_s)==0){
				printMessage("员工手机重复！", Color.RED);
				return;
			}
		}
		for(i=0;i<PeopleTable.getRowCount();i++){
			s=(String) PeopleTable.getValueAt(i, 8);
			if(s.compareTo(id_s)==0){
				printMessage("员工编号重复！", Color.RED);
				return;
			}
		}

		Vector<String> v = new Vector<String>();
		v.add(name_s);
		v.add(sex_s);
		v.add((String) position.getSelectedItem());
		v.add(IDNum_s);
		v.add(workingstarttime_s);
		v.add(phoneNum_s);
		v.add(wage_s);
		v.add((String) AgencyTable.getValueAt(index, 0));
		v.add(id_s);
		v.add((String) AgencyTable.getValueAt(index, 1));
		PeopleTableModel.addRow(v);
	}
	private void _removePeople(){
		int index = PeopleTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个人员！", Color.RED);
			return;
		}
		PeopleTableModel.removeRow(index);
	}
	private void clear(){
		AgencyField.setText("");
		newAgencyField.setText("");
		newAgencyNum.setText("");
		name.setText("");
		sex.setText("");
		IDNum.setText("");
		phoneNum.setText("");
		wage.setText("");
		id.setText("");
		position.setSelectedIndex(0);
		AgencyTable.setRowSelectionInterval(0, 0);
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
