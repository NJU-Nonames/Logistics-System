/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.businessofficeclerkui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import businesslogicservice.logisticsblservice.DriverManageBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.ResultMessage;
import vo.DriverVO;

/**
 * @author 谭期友
 *
 */
public class DriverManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private DriverManageBLService bl;
	private BusinessOfficeClerkFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_LoadManage;
	private MyButton goto_Receive;
	private MyButton goto_Deliver;
	private MyButton goto_CheckList;
	private MyButton goto_TruckManage;
	private MyButton goto_DriverManage;
	//详细操作按钮以及其他组件
	private MyButton add;
	private MyButton remove;
	private MyButton change;
	private MyButton search;
	
	private DefaultTableModel driverTableModel;
	private JTable driverTable;
	private JTextField driverNum;
	private JTextField name;
	private JTextField IDNum;
	private JTextField phoneNum;
	private JTextField sex;
	private JTextField drivingLicencePeriod;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
      //画出界面背景图
        g.drawImage(Img.BACKGROUND2, BusinessOfficeClerkFrame.w/6, BusinessOfficeClerkFrame.h/6, BusinessOfficeClerkFrame.w, BusinessOfficeClerkFrame.h, null);
        g.drawImage(Img.BACKGROUND1, BusinessOfficeClerkFrame.w/6, 0, BusinessOfficeClerkFrame.w, BusinessOfficeClerkFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, BusinessOfficeClerkFrame.w/6, BusinessOfficeClerkFrame.h, null);
        g.drawLine(BusinessOfficeClerkFrame.w/6-1, 0, BusinessOfficeClerkFrame.w/6-1, BusinessOfficeClerkFrame.h);
        g.drawLine(BusinessOfficeClerkFrame.w/6, 0, BusinessOfficeClerkFrame.w/6, BusinessOfficeClerkFrame.h);
        g.drawLine(BusinessOfficeClerkFrame.w/6+1, 0, BusinessOfficeClerkFrame.w/6+1, BusinessOfficeClerkFrame.h);
        g.drawLine(BusinessOfficeClerkFrame.w/6, BusinessOfficeClerkFrame.h/6, BusinessOfficeClerkFrame.w, BusinessOfficeClerkFrame.h/6);
        g.drawLine(BusinessOfficeClerkFrame.w/6, BusinessOfficeClerkFrame.h/6+1, BusinessOfficeClerkFrame.w, BusinessOfficeClerkFrame.h/6+1);
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, BusinessOfficeClerkFrame.h-50, BusinessOfficeClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+BusinessOfficeClerkFrame.w/2, 13+BusinessOfficeClerkFrame.h-30);
        }
	}
	
	public DriverManage(BusinessOfficeClerkFrame frame, DriverManageBLService bl, CurrentUser currentUser){
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
        goto_LoadManage = new MyButton(frame.getWidth()/6, 30,  Img.GOLOAD_0,  Img.GOLOAD_1,  Img.GOLOAD_2);
        goto_LoadManage.addMouseListener(new MouseListener(){
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
        goto_Receive = new MyButton(frame.getWidth()/6, 30, Img.GORECEIVE_0, Img.GORECEIVE_1, Img.GORECEIVE_2);
        goto_Receive.addMouseListener(new MouseListener(){
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
        goto_Deliver = new MyButton(frame.getWidth()/6, 30, Img.GODELIVER_0, Img.GODELIVER_1, Img.GODELIVER_2);
        goto_Deliver.addMouseListener(new MouseListener(){
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
        goto_CheckList = new MyButton(frame.getWidth()/6, 30, Img.GOGETMONEY_0, Img.GOGETMONEY_1, Img.GOGETMONEY_2);
        goto_CheckList.addMouseListener(new MouseListener(){
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
        goto_TruckManage = new MyButton(frame.getWidth()/6, 30, Img.GOTRUCK_0,Img.GOTRUCK_1, Img.GOTRUCK_2);
        goto_TruckManage.addMouseListener(new MouseListener(){
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
        goto_DriverManage = new MyButton(frame.getWidth()/6, 30,Img.GODELIVER_2,Img.GODELIVER_2,Img.GODELIVER_2);
    	goto_DriverManage.addMouseListener(new MouseListener(){
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
    	add = new MyButton(30, 30, Img.BG, Img.CLOSE_1, Img.CLOSE_2);
    	add.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_add();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	remove = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	remove.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_remove();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	change = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	change.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_change();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	search = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	search.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_search();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	add.setLocation(170+20,128+290+40+30);
    	remove.setLocation(170+20+240,128+290+40+30);
    	change.setLocation(170+20+480,128+290+40+30);
    	search.setLocation(170+20+720,128+290+40+30);
    	
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="司机信息管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.DARK_GRAY);
        currentuserAgencyNameLabel.setLocation(170,128-30);

        String s="营业厅业务员";
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
    	close.setLocation(BusinessOfficeClerkFrame.w-30,0);
    	min.setLocation(BusinessOfficeClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_LoadManage.setLocation(0,150);
    	goto_Receive.setLocation(0,200);
    	goto_Deliver.setLocation(0,250);
    	goto_CheckList.setLocation(0,300);
    	goto_TruckManage.setLocation(0,350);
    	goto_DriverManage.setLocation(0,400);
    	
    	//其他组件
    	//表头
    	Vector<String> vColumns = new Vector<String>();
    	vColumns.add("司机编号");
    	vColumns.add("姓名");
    	vColumns.add("身份证号");
    	vColumns.add("手机");
    	vColumns.add("性别");
    	vColumns.add("行驶证期至");
    	//数据
    	Vector<String> vData = new Vector<String>();
    	//模型
    	driverTableModel = new DefaultTableModel(vData, vColumns);
    	ArrayList<DriverVO> a = bl.show(currentUser.getAgencyNum());
        for(int i =0 ; i<a.size(); i++){
    		Vector<String> v = new Vector<String>();
    		v.add(a.get(i).getDriverNum());
    		v.add(a.get(i).getName());
    		v.add(a.get(i).getIDNum());
    		v.add(a.get(i).getPhoneNum());
    		v.add(a.get(i).getSex());
    		v.add(a.get(i).getDrivingLicencePeriod());
    		driverTableModel.addRow(v);
        }
    	//表格
    	driverTable = new JTable(driverTableModel){
    		private static final long serialVersionUID = 1L;

    		public boolean isCellEditable(int row, int column){
    			return false;//不能修改
    		}
    	};
    	driverTable.setPreferredScrollableViewportSize(new Dimension(830,150));
    	driverTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	driverTable.setSelectionBackground(Color.YELLOW);
    	JPanel jp=new JPanel();
    	JScrollPane scrollPane = new JScrollPane();
    	scrollPane.getViewport().add(driverTable);
    	driverTable.setFillsViewportHeight(true);
    	driverTable.getTableHeader().setReorderingAllowed(false);
    	driverTable.getTableHeader().setResizingAllowed(false);
		jp.setSize(850, 180);
		jp.setLocation(596-850/2, 128+80);
    	jp.setOpaque(false);
    	jp.add(scrollPane,BorderLayout.CENTER);

    	JLabel l1 = new JLabel("司机编号：");
    	l1.setSize((int)(16*5*1.07f), 16);
    	l1.setFont(new Font("宋体", Font.BOLD, 15));
    	l1.setLocation(170+20, 128+290);
    	driverNum = new JTextField();
    	driverNum.setSize(150, 20);
    	driverNum.setLocation(170+20+(int)(16*5*1.07f), 128+290-3);
    	
    	JLabel l2 = new JLabel("姓名：");
    	l2.setSize((int)(16*3*1.07f), 16);
    	l2.setFont(new Font("宋体", Font.BOLD, 15));
    	l2.setLocation(170+20+(int)(16*5*1.07f)+150, 128+290);
    	name = new JTextField();
    	name.setSize(150, 20);
    	name.setLocation(170+20+(int)(16*5*1.07f)+150+(int)(16*3*1.07f), 128+290-3);
    	
    	JLabel l3 = new JLabel("身份证号：");
    	l3.setSize((int)(16*5*1.07f), 16);
    	l3.setFont(new Font("宋体", Font.BOLD, 15));
    	l3.setLocation(170+20+(int)(16*5*1.07f)+150+(int)(16*3*1.07f)+150, 128+290);
    	IDNum = new JTextField();
    	IDNum.setSize(150, 20);
    	IDNum.setLocation(170+20+(int)(16*5*1.07f)+150+(int)(16*3*1.07f)+150+(int)(16*5*1.07f), 128+290-3);
    	
    	JLabel l4 = new JLabel("手机：");
    	l4.setSize((int)(16*3*1.07f), 16);
    	l4.setFont(new Font("宋体", Font.BOLD, 15));
    	l4.setLocation(170+20, 128+290+30);
    	phoneNum = new JTextField();
    	phoneNum.setSize(150, 20);
    	phoneNum.setLocation(170+20+(int)(16*3*1.07f), 128+290-3+30);
    	
    	JLabel l5 = new JLabel("性别：");
    	l5.setSize((int)(16*3*1.07f), 16);
    	l5.setFont(new Font("宋体", Font.BOLD, 15));
    	l5.setLocation(170+20+(int)(16*3*1.07f)+150, 128+290+30);
    	sex = new JTextField();
    	sex.setSize(150, 20);
    	sex.setLocation(170+20+(int)(16*3*1.07f)+150+(int)(16*3*1.07f), 128+290-3+30);
    	
    	JLabel l6 = new JLabel("行驶证开始期：");
    	l6.setSize((int)(16*7*1.07f), 16);
    	l6.setFont(new Font("宋体", Font.BOLD, 15));
    	l6.setLocation(170+20+(int)(16*3*1.07f)+150+(int)(16*3*1.07f)+150, 128+290+30);
    	drivingLicencePeriod = new JTextField();
    	drivingLicencePeriod.setSize(150, 20);
    	drivingLicencePeriod.setLocation(170+20+(int)(16*3*1.07f)+150+(int)(16*3*1.07f)+150+(int)(16*6*1.07f), 128+290-3+30);

    	String tip="查找：“司机编号”里输入编号，再点击按钮即可查找";
        JLabel tipLabel = new JLabel(tip);
        tipLabel.setSize((int)(16*tip.length()*1.07f), 16);
        tipLabel.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel.setForeground(Color.RED);
        tipLabel.setLocation(596-(int)(15*tip.length()*1.07f)/2,128+290+120+30);
    	String tip2="修改：先选中一行，在除“司机编号”的5个方框里输入新信息，再点击按钮即可修改";
        JLabel tipLabel2 = new JLabel(tip2);
        tipLabel2.setSize((int)(16*tip2.length()*1.07f), 16);
        tipLabel2.setFont(new Font("宋体", Font.BOLD, 15));
        tipLabel2.setForeground(Color.RED);
        tipLabel2.setLocation(596-(int)(15*tip2.length()*1.07f)/2,128+290+120+40+30);
        

		
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_LoadManage);
    	add(goto_Receive);
    	add(goto_Deliver);
    	add(goto_CheckList);
    	add(goto_TruckManage);
    	add(goto_DriverManage);

    	add(jp);
    	add(l1);
    	add(driverNum);
    	add(l2);
    	add(name);
    	add(l3);
    	add(IDNum);
    	add(l4);
    	add(phoneNum);
    	add(l5);
    	add(sex);
    	add(l6);
    	add(drivingLicencePeriod);
    	
    	add(add);
    	add(remove);
    	add(change);
    	add(search);

    	add(tipLabel);
    	add(tipLabel2);
	}

	private void _add(){
		String driverNum_s = driverNum.getText();
		String name_s = name.getText();
		String IDNum_s = IDNum.getText();
		String phoneNum_s = phoneNum.getText();
		String sex_s = sex.getText();
		String drivingLicencePeriod_s = drivingLicencePeriod.getText();

		result = CheckFormat.checkDriverNum(driverNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		if(name_s.compareTo("")==0){
			printMessage("没有输入司机姓名！", Color.RED);
			return;
		}
		result = CheckFormat.checkIDCardNum(IDNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkPhoneNum(phoneNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		if(sex_s.compareTo("")==0){
			printMessage("没有输入司机性别！", Color.RED);
			return;
		}
		result = CheckFormat.checkTime(drivingLicencePeriod_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		DriverVO driverVO=new DriverVO(driverNum_s, name_s, sex_s, IDNum_s, phoneNum_s, drivingLicencePeriod_s);
		ResultMessage resultMessage = bl.add(driverVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}
		
		Vector<String> v = new Vector<String>();
		v.add(driverNum_s);
		v.add(name_s);
		v.add(IDNum_s);
		v.add(phoneNum_s);
		v.add(sex_s);
		v.add(driverVO.getDrivingLicencePeriod());
		driverTableModel.addRow(v);
		
		driverNum.setText("");
		name.setText("");
		IDNum.setText("");
		phoneNum.setText("");
		sex.setText("");
		drivingLicencePeriod.setText("");
	}
	private void _remove(){
		int index = driverTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一行！", Color.RED);
			return;
		}
		ResultMessage resultMessage = bl.delete(
				new DriverVO((String) driverTable.getValueAt(index, 0), 
						(String) driverTable.getValueAt(index, 1), 
						(String) driverTable.getValueAt(index, 4), 
						(String) driverTable.getValueAt(index, 2), 
						(String) driverTable.getValueAt(index, 3), 
						(String) driverTable.getValueAt(index, 5))
				);
		printMessage(resultMessage.getMessage(), Color.GREEN);
		driverTableModel.removeRow(index);
	}
	private void _change(){
		int index = driverTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一行！", Color.RED);
			return;
		}
		
		String name_s = name.getText();
		String IDNum_s = IDNum.getText();
		String phoneNum_s = phoneNum.getText();
		String sex_s = sex.getText();
		String drivingLicencePeriod_s = drivingLicencePeriod.getText();

		if(name_s.compareTo("")==0){
			printMessage("没有输入司机姓名！", Color.RED);
			return;
		}
		result = CheckFormat.checkIDCardNum(IDNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkPhoneNum(phoneNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		if(sex_s.compareTo("")==0){
			printMessage("没有输入司机性别！", Color.RED);
			return;
		}
		result = CheckFormat.checkTime(drivingLicencePeriod_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		DriverVO driverVO=new DriverVO((String) driverTable.getValueAt(index, 0), name_s, sex_s, IDNum_s, phoneNum_s, drivingLicencePeriod_s);
		ResultMessage resultMessage = bl.update(driverVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.GREEN);
		}

		driverTable.setValueAt(name_s, index, 1);
		driverTable.setValueAt(IDNum_s, index, 2);
		driverTable.setValueAt(phoneNum_s, index, 3);
		driverTable.setValueAt(sex_s, index, 4);
		driverTable.setValueAt(driverVO.getDrivingLicencePeriod(), index, 5);
		
		driverNum.setText("");
		name.setText("");
		IDNum.setText("");
		phoneNum.setText("");
		sex.setText("");
		drivingLicencePeriod.setText("");
	}
	private void _search(){
		String driverNum_s = driverNum.getText();

		result = CheckFormat.checkDriverNum(driverNum_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		DriverVO driverVO=bl.find(driverNum_s);
		if(driverVO==null){
			printMessage("查无此司机！", Color.RED);
			return;
		}
		
		int i=0;
		String s=(String) driverTable.getValueAt(0, 0);
		while(s.compareTo(driverNum_s)!=0){
			i++;
			s=(String) driverTable.getValueAt(i, 0);
		}
		driverTable.setRowSelectionInterval(i, i);
	}
	private void clear(){
		driverNum.setText("");
		name.setText("");
		IDNum.setText("");
		phoneNum.setText("");
		sex.setText("");
		drivingLicencePeriod.setText("");
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
