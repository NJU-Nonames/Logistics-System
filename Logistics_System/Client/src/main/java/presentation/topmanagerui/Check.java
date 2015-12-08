/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.topmanagerui;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import businesslogicservice.chartblservice.CheckBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.CostClause;
import utility.DocType;
import utility.ResultMessage;
import utility.TransportationType;
import vo.DeliveringListVO;
import vo.HallArrivalListVO;
import vo.LoadListVO;
import vo.MoneyInListVO;
import vo.MoneyOutListVO;
import vo.OrderListVO;
import vo.RepertoryInVO;
import vo.RepertoryOutVO;
import vo.TransArrivalListVO;
import vo.TransShipmentListVO;

/**
 * @author 谭期友
 *
 */
public class Check extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private CheckBLService bl;
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
	private MyButton search;
	private MyButton confirm1;
	private MyButton confirm2;
	private MyButton confirm3;
	private MyButton confirm4;
	
	private JTextField start_date;
	private JTextField end_date;
	private JComboBox<String> listkind;
	private DefaultTableModel ListTableModel;
	private JTable ListTable;
	private JPanel jp;
	private DefaultTableModel ListTableModel2;
	private JTable ListTable2;
	private JPanel jp2;
	private DefaultTableModel ListTableModel3;
	private JTable ListTable3;
	private JPanel jp3;
	private DefaultTableModel ListTableModel4;
	private JTable ListTable4;
	private JPanel jp4;
	private DefaultTableModel ListTableModel5;
	private JTable ListTable5;
	private JPanel jp5;
	private DefaultTableModel ListTableModel6;
	private JTable ListTable6;
	private JPanel jp6;
	private DefaultTableModel ListTableModel7;
	private JTable ListTable7;
	private JPanel jp7;
	private DefaultTableModel ListTableModel8;
	private JTable ListTable8;
	private JPanel jp8;
	private DefaultTableModel ListTableModel9;
	private JTable ListTable9;
	private JPanel jp9;
	private DefaultTableModel ListTableModel10;
	private JTable ListTable10;
	private JPanel jp10;
	
	
	
	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	private int state;
	private int stated;
	private JPanel j;
	private CardLayout card;
	private String time1;
	private String time2;

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
	
	public Check(TopManagerFrame frame,CheckBLService bl, CurrentUser currentUser){
		this.frame=frame;
		this.bl=bl;
		this.currentUser=currentUser;
		willprintMessage=false;
		result="";
		co=Color.RED;
		state=1;
		stated=1;
		time1="";
		time2="";
		this.setLayout(null);

		//初始化组件
		initComponent();
	}
	public Check(TopManagerFrame topManagerFrame, CurrentUser currentUser2) {
		// TODO 自动生成的构造函数存根
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
        confirm1 = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        confirm1.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm1();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	confirm1.setLocation(170+120,570);
        confirm2 = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        confirm2.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm2();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	confirm2.setLocation(170+120,570+40);
        confirm3 = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        confirm3.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm3();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	confirm3.setLocation(1024-100,570);
        confirm4 = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        confirm4.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm4();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	confirm4.setLocation(1024-100,570+40);
    	add(confirm1);
    	add(confirm2);
    	add(confirm3);
    	add(confirm4);
		JLabel l11 = new JLabel("全通过：");
		l11.setSize((int)(16*4*1.07f), 16);
		l11.setFont(new Font("宋体", Font.BOLD, 15));
        l11.setLocation(170+20, 570+7);
        add(l11);
		JLabel l22 = new JLabel("全不通过：");
		l22.setSize((int)(16*5*1.07f), 16);
		l22.setFont(new Font("宋体", Font.BOLD, 15));
        l22.setLocation(170+20, 570+40+7);
        add(l22);
		JLabel l33 = new JLabel("将选中的设为通过：");
		l33.setSize((int)(16*10*1.07f), 16);
		l33.setFont(new Font("宋体", Font.BOLD, 15));
        l33.setLocation(1024-100-(int)(16*10*1.07f),570+7);
        add(l33);
		JLabel l44 = new JLabel("将选中的设为未通过：");
		l44.setSize((int)(16*10*1.07f), 16);
		l44.setFont(new Font("宋体", Font.BOLD, 15));
        l44.setLocation(1024-100-(int)(16*10*1.07f),570+40+7);
        add(l44);
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="审批单据";
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
		card=new CardLayout();
		j = new JPanel();
		j.setSize(820, 290);
		j.setLocation(596-820/2, 128+80+50);
		j.setOpaque(false);
        j.setLayout(card);
        add(j);
        
		JLabel l1 = new JLabel("起始日期：");
		l1.setSize((int)(16*5*1.07f), 16);
		l1.setFont(new Font("宋体", Font.BOLD, 15));
		l1.setLocation(170+40, 128+80+20);
		start_date = new JTextField();
		start_date.setSize(110, 20);
		start_date.setLocation(170+40+(int)(16*5*1.07f),128+80+20-3);

		JLabel l2 = new JLabel("终止日期：");
		l2.setSize((int)(16*5*1.07f), 16);
		l2.setFont(new Font("宋体", Font.BOLD, 15));
		l2.setLocation(410, 128+80+20);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date_);
		end_date = new JTextField(time);
		end_date.setSize(110, 20);
		end_date.setLocation(410+(int)(16*5*1.07f),128+80+20-3);
		
		listkind=new JComboBox<String>();
		listkind.addItem("收款单");
		listkind.addItem("付款单");
		listkind.addItem("入库单");
		listkind.addItem("出库单");
		listkind.addItem("寄件单");
		listkind.addItem("装车单");
		listkind.addItem("营业厅到达单");
		listkind.addItem("派件单");
		listkind.addItem("中转中心到达单");
		listkind.addItem("中转单");
		listkind.setSize(150, 20);
		listkind.setLocation(610, 128+80+20-3);
		listkind.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent arg0) {
				// TODO 自动生成的方法存根
				clear();
				if(listkind.getSelectedItem().toString().compareTo("收款单")==0){
					stated=state;
					state=1;
					int a;
					if(state-stated>0)
						a=state-stated;
					else
						a=state+10-stated;
					for(int i=0;i<a;i++)
						card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("付款单")==0){
					stated=state;state=2;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("入库单")==0){
					stated=state;state=3;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("出库单")==0){
					stated=state;state=4;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("寄件单")==0){
					stated=state;state=5;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("装车单")==0){
					stated=state;state=6;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("营业厅到达单")==0){
					stated=state;state=7;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("派件单")==0){
					stated=state;state=8;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("中转中心到达单")==0){
					stated=state;state=9;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}else if(listkind.getSelectedItem().toString().compareTo("中转单")==0){
					stated=state;state=10;int a;if(state-stated>0)a=state-stated;
					else a=state+10-stated;for(int i=0;i<a;i++)card.next(j);
				}
			}
		});
		

		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("单号");
		vColumns.add("收款日期");
		vColumns.add("收款金额");
		vColumns.add("快递员工号");
		vColumns.add("审批状态");
		vColumns.add("选中");
		//数据
		Vector<String> vData = new Vector<String>();
		//模型
		ListTableModel = new DefaultTableModel(vData, vColumns);
		//表格
		ListTable = new JTable(ListTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
//				if(column==0||column==ListTable.getColumnCount()-1)
					return false;//不能修改
//				return true;
			}
		};
		ListTable.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable.setSelectionBackground(Color.YELLOW);
		jp=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(ListTable);
		ListTable.setFillsViewportHeight(true);
//      	int[] width2={140,70,320,180,60,30};//130像素对应18位数字，1个数字对应7.2222像素,考虑滚动条挤压，设为140.日期70比较合适
//      	ListTable.setColumnModel(getColumnModel(ListTable,width2));
      	ListTable.getTableHeader().setReorderingAllowed(false);
      	ListTable.getTableHeader().setResizingAllowed(false);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);
		j.add(jp);
		
		//表头
		Vector<String> vColumns2 = new Vector<String>();
		vColumns2.add("单号");
		vColumns2.add("付款日期");
		vColumns2.add("付款金额");
		vColumns2.add("付款人");
		vColumns2.add("付款银行账号");
		vColumns2.add("条目");
		vColumns2.add("审批状态");
		vColumns2.add("选中");
		//数据
		Vector<String> vData2 = new Vector<String>();
		//模型
		ListTableModel2 = new DefaultTableModel(vData2, vColumns2);
		//表格
		ListTable2 = new JTable(ListTableModel2){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable2.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable2.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable2.setSelectionBackground(Color.YELLOW);
		jp2=new JPanel();
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.getViewport().add(ListTable2);
		ListTable2.setFillsViewportHeight(true);
	  	int[] width2={170,150,100,80,150,60,60,30};//时间150，银行150，钱100，人名80
	  	ListTable2.setColumnModel(getColumnModel(ListTable2,width2));
      	ListTable2.getTableHeader().setReorderingAllowed(false);
      	ListTable2.getTableHeader().setResizingAllowed(false);
		jp2.setOpaque(false);
		jp2.add(scrollPane2,BorderLayout.CENTER);
		j.add(jp2);

		//表头
		Vector<String> vColumns3 = new Vector<String>();
		vColumns3.add("单号");
		vColumns3.add("快递编号");
		vColumns3.add("入库时间");
		vColumns3.add("目的地");
		vColumns3.add("区");
		vColumns3.add("排");
		vColumns3.add("架");
		vColumns3.add("位");
		vColumns3.add("审批状态");
		vColumns3.add("选中");
		//数据
		Vector<String> vData3 = new Vector<String>();
		//模型
		ListTableModel3 = new DefaultTableModel(vData3, vColumns3);
		//表格
		ListTable3 = new JTable(ListTableModel3){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable3.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable3.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable3.setSelectionBackground(Color.YELLOW);
		jp3=new JPanel();
		JScrollPane scrollPane3 = new JScrollPane();
		scrollPane3.getViewport().add(ListTable3);
		ListTable3.setFillsViewportHeight(true);
	  	int[] width3={90,145,145,250,20,20,20,20,60,30};//时间150，银行150，钱100，人名80
	  	ListTable3.setColumnModel(getColumnModel(ListTable3,width3));
      	ListTable3.getTableHeader().setReorderingAllowed(false);
      	ListTable3.getTableHeader().setResizingAllowed(false);
		jp3.setOpaque(false);
		jp3.add(scrollPane3,BorderLayout.CENTER);
		j.add(jp3);
		//表头
		Vector<String> vColumns4 = new Vector<String>();
		vColumns4.add("单号");
		vColumns4.add("快递编号");
		vColumns4.add("出库时间");
		vColumns4.add("目的地");
		vColumns4.add("装运方式");
		vColumns4.add("中转单编号");
		vColumns4.add("审批状态");
		vColumns4.add("选中");
		//数据
		Vector<String> vData4 = new Vector<String>();
		//模型
		ListTableModel4 = new DefaultTableModel(vData4, vColumns4);
		//表格
		ListTable4 = new JTable(ListTableModel4){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable4.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable4.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable4.setSelectionBackground(Color.YELLOW);
		jp4=new JPanel();
		JScrollPane scrollPane4 = new JScrollPane();
		scrollPane4.getViewport().add(ListTable4);
		ListTable4.setFillsViewportHeight(true);
	  	int[] width4={90,145,145,190,60,180,60,30};//时间150，银行150，钱100，人名80
	  	ListTable4.setColumnModel(getColumnModel(ListTable4,width4));
      	ListTable4.getTableHeader().setReorderingAllowed(false);
      	ListTable4.getTableHeader().setResizingAllowed(false);
		jp4.setOpaque(false);
		jp4.add(scrollPane4,BorderLayout.CENTER);
		j.add(jp4);
		//表头
		Vector<String> vColumns5 = new Vector<String>();
		vColumns5.add("单号");
		vColumns5.add("寄件人姓名");
		vColumns5.add("寄件人手机");
		vColumns5.add("寄件人地址");
		vColumns5.add("内件品名");
		vColumns5.add("费用");
		vColumns5.add("审批状态");
		vColumns5.add("选中");
		//数据
		Vector<String> vData5 = new Vector<String>();
		//模型
		ListTableModel5 = new DefaultTableModel(vData5, vColumns5);
		//表格
		ListTable5 = new JTable(ListTableModel5){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable5.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable5.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable5.setSelectionBackground(Color.YELLOW);
		jp5=new JPanel();
		JScrollPane scrollPane5 = new JScrollPane();
		scrollPane5.getViewport().add(ListTable5);
		ListTable5.setFillsViewportHeight(true);
	  	int[] width5={150,80,100,370,60,50,60,30};
	  	ListTable5.setColumnModel(getColumnModel(ListTable5,width5));
      	ListTable5.getTableHeader().setReorderingAllowed(false);
      	ListTable5.getTableHeader().setResizingAllowed(false);
		jp5.setOpaque(false);
		jp5.add(scrollPane5,BorderLayout.CENTER);
		j.add(jp5);
		//表头
		Vector<String> vColumns6 = new Vector<String>();
		vColumns6.add("单号");
		vColumns6.add("装车日期");
		vColumns6.add("营业厅编号");
		vColumns6.add("目的地");
		vColumns6.add("车辆代号");
		vColumns6.add("监装员");
		vColumns6.add("押运员");
		vColumns6.add("审批状态");
		vColumns6.add("选中");
		//数据
		Vector<String> vData6 = new Vector<String>();
		//模型
		ListTableModel6 = new DefaultTableModel(vData6, vColumns6);
		//表格
		ListTable6 = new JTable(ListTableModel6){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable6.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable6.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable6.setSelectionBackground(Color.YELLOW);
		jp6=new JPanel();
		JScrollPane scrollPane6 = new JScrollPane();
		scrollPane6.getViewport().add(ListTable6);
		ListTable6.setFillsViewportHeight(true);
	  	int[] width6={150,150,80,130,80,60,60,60,30};
	  	ListTable6.setColumnModel(getColumnModel(ListTable6,width6));
      	ListTable6.getTableHeader().setReorderingAllowed(false);
      	ListTable6.getTableHeader().setResizingAllowed(false);
		jp6.setOpaque(false);
		jp6.add(scrollPane6,BorderLayout.CENTER);
		j.add(jp6);
		//表头
		Vector<String> vColumns7 = new Vector<String>();
		vColumns7.add("单号");
		vColumns7.add("到达日期");
		vColumns7.add("中转单编号");
		vColumns7.add("出发地");//到达状态先不加，这个vo有问题
		vColumns7.add("审批状态");
		vColumns7.add("选中");
		//数据
		Vector<String> vData7 = new Vector<String>();
		//模型
		ListTableModel7 = new DefaultTableModel(vData7, vColumns7);
		//表格
		ListTable7 = new JTable(ListTableModel7){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable7.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable7.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable7.setSelectionBackground(Color.YELLOW);
		jp7=new JPanel();
		JScrollPane scrollPane7 = new JScrollPane();
		scrollPane7.getViewport().add(ListTable7);
		ListTable7.setFillsViewportHeight(true);
	  	int[] width7={150,150,180,230,60,30};
	  	ListTable7.setColumnModel(getColumnModel(ListTable7,width7));
      	ListTable7.getTableHeader().setReorderingAllowed(false);
      	ListTable7.getTableHeader().setResizingAllowed(false);
		jp7.setOpaque(false);
		jp7.add(scrollPane7,BorderLayout.CENTER);
		j.add(jp7);
		//表头
		Vector<String> vColumns8 = new Vector<String>();
		vColumns8.add("单号");
		vColumns8.add("货物到达日期");
		vColumns8.add("派件员");
		vColumns8.add("审批状态");
		vColumns8.add("选中");
		//数据
		Vector<String> vData8 = new Vector<String>();
		//模型
		ListTableModel8 = new DefaultTableModel(vData8, vColumns8);
		//表格
		ListTable8 = new JTable(ListTableModel8){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable8.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable8.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable8.setSelectionBackground(Color.YELLOW);
		jp8=new JPanel();
		JScrollPane scrollPane8 = new JScrollPane();
		scrollPane8.getViewport().add(ListTable8);
		ListTable8.setFillsViewportHeight(true);
      	ListTable8.getTableHeader().setReorderingAllowed(false);
      	ListTable8.getTableHeader().setResizingAllowed(false);
		jp8.setOpaque(false);
		jp8.add(scrollPane8,BorderLayout.CENTER);
		j.add(jp8);
		//表头
		Vector<String> vColumns9 = new Vector<String>();
		vColumns9.add("单号");
		vColumns9.add("中转单编号");
		vColumns9.add("中转中心编号");
		vColumns9.add("货物到达日期");
		vColumns9.add("审批状态");
		vColumns9.add("选中");
		//数据
		Vector<String> vData9 = new Vector<String>();
		//模型
		ListTableModel9 = new DefaultTableModel(vData9, vColumns9);
		//表格
		ListTable9 = new JTable(ListTableModel9){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable9.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable9.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable9.setSelectionBackground(Color.YELLOW);
		jp9=new JPanel();
		JScrollPane scrollPane9 = new JScrollPane();
		scrollPane9.getViewport().add(ListTable9);
		ListTable9.setFillsViewportHeight(true);
	  	int[] width9={180,190,180,160,60,30};
	  	ListTable9.setColumnModel(getColumnModel(ListTable9,width9));
      	ListTable9.getTableHeader().setReorderingAllowed(false);
      	ListTable9.getTableHeader().setResizingAllowed(false);
		jp9.setOpaque(false);
		jp9.add(scrollPane9,BorderLayout.CENTER);
		j.add(jp9);
		//表头
		Vector<String> vColumns10 = new Vector<String>();
		vColumns10.add("单号");
		vColumns10.add("装车日期");
		vColumns10.add("航班号");
		vColumns10.add("出发地");
		vColumns10.add("到达地");
		vColumns10.add("货柜号");
		vColumns10.add("监装员");
		vColumns10.add("运费");
		vColumns10.add("审批状态");
		vColumns10.add("选中");
		//数据
		Vector<String> vData10 = new Vector<String>();
		//模型
		ListTableModel10 = new DefaultTableModel(vData10, vColumns10);
		//表格
		ListTable10 = new JTable(ListTableModel10){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		ListTable10.setPreferredScrollableViewportSize(new Dimension(800,260));
		ListTable10.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		ListTable10.setSelectionBackground(Color.YELLOW);
		jp10=new JPanel();
		JScrollPane scrollPane10 = new JScrollPane();
		scrollPane10.getViewport().add(ListTable10);
		ListTable10.setFillsViewportHeight(true);
	  	int[] width10={160,140,50,105,105,50,50,50,60,30};
	  	ListTable10.setColumnModel(getColumnModel(ListTable10,width10));
      	ListTable10.getTableHeader().setReorderingAllowed(false);
      	ListTable10.getTableHeader().setResizingAllowed(false);
		jp10.setOpaque(false);
		jp10.add(scrollPane10,BorderLayout.CENTER);
		j.add(jp10);
		

		ListTable.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable.getRowCount()!=0 && ListTable.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable.getValueAt(ListTable.getSelectedRow(), ListTable.getColumnCount()-1)  )==0)
						ListTable.setValueAt("是", ListTable.getSelectedRow(), ListTable.getColumnCount()-1);
					else
						ListTable.setValueAt("否", ListTable.getSelectedRow(), ListTable.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable2.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable2.getRowCount()!=0 && ListTable2.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable2.getValueAt(ListTable2.getSelectedRow(), ListTable2.getColumnCount()-1)  )==0)
						ListTable2.setValueAt("是", ListTable2.getSelectedRow(), ListTable2.getColumnCount()-1);
					else
						ListTable2.setValueAt("否", ListTable2.getSelectedRow(), ListTable2.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable3.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable3.getRowCount()!=0 && ListTable3.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable3.getValueAt(ListTable3.getSelectedRow(), ListTable3.getColumnCount()-1)  )==0)
						ListTable3.setValueAt("是", ListTable3.getSelectedRow(), ListTable3.getColumnCount()-1);
					else
						ListTable3.setValueAt("否", ListTable3.getSelectedRow(), ListTable3.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable4.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable4.getRowCount()!=0 && ListTable4.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable4.getValueAt(ListTable4.getSelectedRow(), ListTable4.getColumnCount()-1)  )==0)
						ListTable4.setValueAt("是", ListTable4.getSelectedRow(), ListTable4.getColumnCount()-1);
					else
						ListTable4.setValueAt("否", ListTable4.getSelectedRow(), ListTable4.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable5.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable5.getRowCount()!=0 && ListTable5.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable5.getValueAt(ListTable5.getSelectedRow(), ListTable5.getColumnCount()-1)  )==0)
						ListTable5.setValueAt("是", ListTable5.getSelectedRow(), ListTable5.getColumnCount()-1);
					else
						ListTable5.setValueAt("否", ListTable5.getSelectedRow(), ListTable5.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable6.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable6.getRowCount()!=0 && ListTable6.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable6.getValueAt(ListTable6.getSelectedRow(), ListTable6.getColumnCount()-1)  )==0)
						ListTable6.setValueAt("是", ListTable6.getSelectedRow(), ListTable6.getColumnCount()-1);
					else
						ListTable6.setValueAt("否", ListTable6.getSelectedRow(), ListTable6.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable7.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable7.getRowCount()!=0 && ListTable7.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable7.getValueAt(ListTable7.getSelectedRow(), ListTable7.getColumnCount()-1)  )==0)
						ListTable7.setValueAt("是", ListTable7.getSelectedRow(), ListTable7.getColumnCount()-1);
					else
						ListTable7.setValueAt("否", ListTable7.getSelectedRow(), ListTable7.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable8.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable8.getRowCount()!=0 && ListTable8.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable8.getValueAt(ListTable8.getSelectedRow(), ListTable8.getColumnCount()-1)  )==0)
						ListTable8.setValueAt("是", ListTable8.getSelectedRow(), ListTable8.getColumnCount()-1);
					else
						ListTable8.setValueAt("否", ListTable8.getSelectedRow(), ListTable8.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable9.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable9.getRowCount()!=0 && ListTable9.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable9.getValueAt(ListTable9.getSelectedRow(), ListTable9.getColumnCount()-1)  )==0)
						ListTable9.setValueAt("是", ListTable9.getSelectedRow(), ListTable9.getColumnCount()-1);
					else
						ListTable9.setValueAt("否", ListTable9.getSelectedRow(), ListTable9.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
		ListTable10.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent e) {
				// TODO 自动生成的方法存根
				int clickCount = e.getClickCount();
				if (clickCount == 1 && ListTable10.getRowCount()!=0 && ListTable10.getSelectedRow()!=-1){
					if("否".compareTo(  (String) ListTable10.getValueAt(ListTable10.getSelectedRow(), ListTable10.getColumnCount()-1)  )==0)
						ListTable10.setValueAt("是", ListTable10.getSelectedRow(), ListTable10.getColumnCount()-1);
					else
						ListTable10.setValueAt("否", ListTable10.getSelectedRow(), ListTable10.getColumnCount()-1);
				}
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
			});
        

		
		

    	search.setLocation(596+300, 128+80+20);
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

    	add(l1);
    	add(start_date);
    	add(l2);
    	add(end_date);
    	add(listkind);
    	
    	add(search);
	}

	private void _search(){
		String start_date_s = start_date.getText();
		String end_date_s = end_date.getText();

		result = CheckFormat.checkTime(start_date_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkTime(end_date_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		
		String s1 = (String) listkind.getSelectedItem();
		DocType type = null;
		if(s1.compareTo("收款单")==0){//1
			type=DocType.MONEY_IN_NOTE;
			while(ListTable.getRowCount()!=0)
				ListTableModel.removeRow(0);
			ArrayList<MoneyInListVO> arr = (ArrayList<MoneyInListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有收款单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(MoneyInListVO vo:arr){
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getId());
	    		v.add(vo.getDate());
	    		v.add(vo.getMoneySum()+"");
	    		v.add(vo.getStaffId());
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel.addRow(v);
	        }
		}else if(s1.compareTo("付款单")==0){//2
			type=DocType.MONET_OUT_NOTE;
			while(ListTable2.getRowCount()!=0)
				ListTableModel2.removeRow(0);
			ArrayList<MoneyOutListVO> arr = (ArrayList<MoneyOutListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有付款单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(MoneyOutListVO vo:arr){
//				vColumns2.add("单号");
//				vColumns2.add("付款日期");
//				vColumns2.add("付款金额");
//				vColumns2.add("付款人");
//				vColumns2.add("付款银行账号");
//				vColumns2.add("条目");
//				vColumns2.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getId());
	    		v.add(vo.getDate());
	    		v.add(vo.getMoney()+"");
	    		v.add(vo.getPayer());
	    		v.add(vo.getAccountNum());
	    		if(vo.getClause()==CostClause.rentfare){
	        		v.add("租金");
	    		}else if(vo.getClause()==CostClause.shipmentfare){
	    			v.add("运费");
	    		}else if(vo.getClause()==CostClause.salary){
	    			v.add("工资");
	    		}else if(vo.getClause()==CostClause.bonus){
	    			v.add("奖励");
	    		}
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel2.addRow(v);
	        }
		}else if(s1.compareTo("入库单")==0){//3
			type=DocType.IN_STOREAGE_NOTE;
			while(ListTable3.getRowCount()!=0)
				ListTableModel3.removeRow(0);
			ArrayList<RepertoryInVO> arr = (ArrayList<RepertoryInVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有入库单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(RepertoryInVO vo:arr){
//				vColumns3.add("单号")
//				vColumns3.add("快递编号");
//				vColumns3.add("入库时间");
//				vColumns3.add("目的地");
//				vColumns3.add("区号");
//				vColumns3.add("排号");
//				vColumns3.add("架号");
//				vColumns3.add("位号");
//				vColumns3.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getId());
	    		v.add(vo.getNum());
	    		v.add(vo.getTime());
	    		v.add(vo.getDestination());
	    		v.add(vo.getAreacode());
	    		v.add(vo.getRownumber());
	    		v.add(vo.getFramenumber());
	    		v.add(vo.getPlacenumber());
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel3.addRow(v);
	        }
		}else if(s1.compareTo("出库单")==0){
			type=DocType.OUT_STOREAGE_NOTE;
			while(ListTable4.getRowCount()!=0)
				ListTableModel4.removeRow(0);
			ArrayList<RepertoryOutVO> arr = (ArrayList<RepertoryOutVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有出库单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(RepertoryOutVO vo:arr){
//				vColumns4.add("单号");
//				vColumns4.add("快递编号");
//				vColumns4.add("出库时间");
//				vColumns4.add("目的地");
//				vColumns4.add("装运方式");
//				vColumns4.add("中转单编号");
//				vColumns4.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getId());
	    		v.add(vo.getCode());
	    		v.add(vo.getTime());
	    		v.add(vo.getDestination());
	    		if(vo.getTransportation()==TransportationType.TURCK){
	        		v.add("货车");
	    		}else if(vo.getTransportation()==TransportationType.TRAIN){
	    			v.add("火车");
	    		}else if(vo.getTransportation()==TransportationType.AIRPLANE){
	    			v.add("飞机");
	    		}
	    		v.add(vo.getTransCode());
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel4.addRow(v);
	        }
		}else if(s1.compareTo("寄件单")==0){
			type=DocType.SENDING_NOTE;
			while(ListTable5.getRowCount()!=0)
				ListTableModel5.removeRow(0);
			ArrayList<OrderListVO> arr = (ArrayList<OrderListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有寄件单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(OrderListVO vo:arr){
//				vColumns5.add("单号");
//				vColumns5.add("寄件人姓名");
//				vColumns5.add("寄件人手机");
//				vColumns5.add("寄件人地址");
//				vColumns5.add("内件品名");
//				vColumns5.add("费用");
//				vColumns5.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getBarCode());
	    		v.add(vo.getSenderName());
	    		v.add(vo.getSenderTeleNumber());
	    		v.add(vo.getSenderAddress());
	    		v.add(vo.getName());
	    		v.add(vo.getPackPrice()+"");
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel5.addRow(v);
	        }
		}else if(s1.compareTo("装车单")==0){
			type=DocType.LOADING_NOTE;
			while(ListTable6.getRowCount()!=0)
				ListTableModel6.removeRow(0);
			ArrayList<LoadListVO> arr = (ArrayList<LoadListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有装车单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(LoadListVO vo:arr){
//				vColumns6.add("单号");
//				vColumns6.add("装车日期");
//				vColumns6.add("营业厅编号");
//				vColumns6.add("目的地");
//				vColumns6.add("车辆代号");
//				vColumns6.add("监装员");
//				vColumns6.add("押运员")
//				vColumns6.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getTranspotationNumber());
	    		v.add(vo.getDate());
	    		v.add(vo.getHallNumber());
	    		v.add(vo.getDestination());
	    		v.add(vo.getCarNumber());
	    		v.add(vo.getGuardMan());
	    		v.add(vo.getSupercargoMan());
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel6.addRow(v);
	        }
		}else if(s1.compareTo("营业厅到达单")==0){
			type=DocType.BUSINESSHALL_ARRIVAL_NOTE;
			while(ListTable7.getRowCount()!=0)
				ListTableModel7.removeRow(0);
			ArrayList<HallArrivalListVO> arr = (ArrayList<HallArrivalListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有营业厅到达单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(HallArrivalListVO vo:arr){
//				vColumns7.add("单号");
//				vColumns7.add("到达日期");
//				vColumns7.add("中转单编号");
//				vColumns7.add("出发地");//到达状态先不加，这个vo有问题
//				vColumns7.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getId());
	    		v.add(vo.getDate());
	    		v.add(vo.getTransferNumber());
	    		v.add(vo.getDepartureplace());
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel7.addRow(v);
	        }
		}else if(s1.compareTo("派件单")==0){
			type=DocType.DELIVERYING_NOTE;
			while(ListTable8.getRowCount()!=0)
				ListTableModel8.removeRow(0);
			ArrayList<DeliveringListVO> arr = (ArrayList<DeliveringListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有派件单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(DeliveringListVO vo:arr){
//				vColumns8.add("单号");
//				vColumns8.add("货物到达日期");
//				vColumns8.add("派件员");
//				vColumns8.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getId());
	    		v.add(vo.getDate());
	    		v.add(vo.getDeliveryMan());
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel8.addRow(v);
	        }
		}else if(s1.compareTo("中转中心到达单")==0){
			type=DocType.CENTER_ARRIVAL_NOTE;
			while(ListTable9.getRowCount()!=0)
				ListTableModel9.removeRow(0);
			ArrayList<TransArrivalListVO> arr = (ArrayList<TransArrivalListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有中转中心到达单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(TransArrivalListVO vo:arr){
//				vColumns9.add("单号");
//				vColumns9.add("中转单编号");
//				vColumns9.add("中转中心编号");
//				vColumns9.add("货物到达日期");
//				vColumns9.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getId());
	    		v.add(vo.getTransferNumber());
	    		v.add(vo.getCenterNumber());
	    		v.add(vo.getDate());
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel9.addRow(v);
	        }
		}else if(s1.compareTo("中转单")==0){
			type=DocType.TRANSIT_NOTE;
			while(ListTable10.getRowCount()!=0)
				ListTableModel10.removeRow(0);
			ArrayList<TransShipmentListVO> arr = (ArrayList<TransShipmentListVO>) bl.getAll(type, start_date_s, end_date_s);
			if(arr==null){
				printMessage("没有中转单！", Color.RED);
				return;
			}

			time1=start_date_s;
			time2=end_date_s;
			for(TransShipmentListVO vo:arr){
//				vColumns10.add("单号");
//				vColumns10.add("装车日期");
//				vColumns10.add("航班号");
//				vColumns10.add("出发地");
//				vColumns10.add("到达地");
//				vColumns10.add("货柜号");
//				vColumns10.add("监装员");
//				vColumns10.add("运费");
//				vColumns10.add("审批状态");
	    		Vector<String> v = new Vector<String>();
	    		v.add(vo.getTransitDocNumber());
	    		v.add(vo.getDate());
	    		v.add(vo.getFlightNumber());
	    		v.add(vo.getDeparturePlace());
	    		v.add(vo.getDesitination());
	    		v.add(vo.getContainerNumber());
	    		v.add(vo.getSupercargoMan());
	    		v.add(vo.getPrice()+"");
	    		if(vo.getCheckType()==CheckType.UNDERCHECK){
	        		v.add("未审批");
	    		}else if(vo.getCheckType()==CheckType.PASS){
	    			v.add("通过");
	    		}else if(vo.getCheckType()==CheckType.NOTPASS){
	    			v.add("未通过");
	    		}
	    		v.add("否");
	    		ListTableModel10.addRow(v);
	        }
		}
	}
	private void _confirm1(){
		switch(state){
		case 1:
			if(ListTable.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<MoneyInListVO> arr = (ArrayList<MoneyInListVO>) bl.getAll(DocType.MONEY_IN_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.MONEY_IN_NOTE, arr);
			for(int i=0;i<ListTable.getRowCount();i++)
				ListTable.setValueAt("通过", i, ListTable.getColumnCount()-2);
			break;
		case 2:
			if(ListTable2.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<MoneyOutListVO> arr2 = (ArrayList<MoneyOutListVO>) bl.getAll(DocType.MONET_OUT_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.MONET_OUT_NOTE, arr2);
			for(int i=0;i<ListTable2.getRowCount();i++)
				ListTable2.setValueAt("通过", i, ListTable2.getColumnCount()-2);
			break;
		case 3:
			if(ListTable3.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<RepertoryInVO> arr3 = (ArrayList<RepertoryInVO>) bl.getAll(DocType.IN_STOREAGE_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.IN_STOREAGE_NOTE, arr3);
			for(int i=0;i<ListTable3.getRowCount();i++)
				ListTable3.setValueAt("通过", i, ListTable3.getColumnCount()-2);
			break;
		case 4:
			if(ListTable4.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<RepertoryOutVO> arr4 = (ArrayList<RepertoryOutVO>) bl.getAll(DocType.OUT_STOREAGE_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.OUT_STOREAGE_NOTE, arr4);
			for(int i=0;i<ListTable4.getRowCount();i++)
				ListTable4.setValueAt("通过", i, ListTable4.getColumnCount()-2);
			break;
		case 5:
			if(ListTable5.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<OrderListVO> arr5 = (ArrayList<OrderListVO>) bl.getAll(DocType.SENDING_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.SENDING_NOTE, arr5);
			for(int i=0;i<ListTable5.getRowCount();i++)
				ListTable5.setValueAt("通过", i, ListTable5.getColumnCount()-2);
			break;
		case 6:
			if(ListTable6.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<LoadListVO> arr6 = (ArrayList<LoadListVO>) bl.getAll(DocType.LOADING_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.LOADING_NOTE, arr6);
			for(int i=0;i<ListTable6.getRowCount();i++)
				ListTable6.setValueAt("通过", i, ListTable6.getColumnCount()-2);
			break;
		case 7:
			if(ListTable7.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<HallArrivalListVO> arr7 = (ArrayList<HallArrivalListVO>) bl.getAll(DocType.BUSINESSHALL_ARRIVAL_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.BUSINESSHALL_ARRIVAL_NOTE, arr7);
			for(int i=0;i<ListTable7.getRowCount();i++)
				ListTable7.setValueAt("通过", i, ListTable7.getColumnCount()-2);
			break;
		case 8:
			if(ListTable8.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<DeliveringListVO> arr8 = (ArrayList<DeliveringListVO>) bl.getAll(DocType.DELIVERYING_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.DELIVERYING_NOTE, arr8);
			for(int i=0;i<ListTable8.getRowCount();i++)
				ListTable8.setValueAt("通过", i, ListTable8.getColumnCount()-2);
			break;
		case 9:
			if(ListTable9.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<TransArrivalListVO> arr9 = (ArrayList<TransArrivalListVO>) bl.getAll(DocType.CENTER_ARRIVAL_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.CENTER_ARRIVAL_NOTE, arr9);
			for(int i=0;i<ListTable9.getRowCount();i++)
				ListTable9.setValueAt("通过", i, ListTable9.getColumnCount()-2);
			break;
		case 10:
			if(ListTable10.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<TransShipmentListVO> arr10 = (ArrayList<TransShipmentListVO>) bl.getAll(DocType.TRANSIT_NOTE, time1, time2);
			bl.passSelectedDoc(DocType.TRANSIT_NOTE, arr10);
			for(int i=0;i<ListTable10.getRowCount();i++)
				ListTable10.setValueAt("通过", i, ListTable10.getColumnCount()-2);
			break;
		}
	}
	private void _confirm2(){
		switch(state){
		case 1:
			if(ListTable.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<MoneyInListVO> arr = (ArrayList<MoneyInListVO>) bl.getAll(DocType.MONEY_IN_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.MONEY_IN_NOTE, arr);
			for(int i=0;i<ListTable.getRowCount();i++)
				ListTable.setValueAt("未通过", i, ListTable.getColumnCount()-2);
			break;
		case 2:
			if(ListTable2.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<MoneyOutListVO> arr2 = (ArrayList<MoneyOutListVO>) bl.getAll(DocType.MONET_OUT_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.MONET_OUT_NOTE, arr2);
			for(int i=0;i<ListTable2.getRowCount();i++)
				ListTable2.setValueAt("未通过", i, ListTable2.getColumnCount()-2);
			break;
		case 3:
			if(ListTable3.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<RepertoryInVO> arr3 = (ArrayList<RepertoryInVO>) bl.getAll(DocType.IN_STOREAGE_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.IN_STOREAGE_NOTE, arr3);
			for(int i=0;i<ListTable3.getRowCount();i++)
				ListTable3.setValueAt("未通过", i, ListTable3.getColumnCount()-2);
			break;
		case 4:
			if(ListTable4.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<RepertoryOutVO> arr4 = (ArrayList<RepertoryOutVO>) bl.getAll(DocType.OUT_STOREAGE_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.OUT_STOREAGE_NOTE, arr4);
			for(int i=0;i<ListTable4.getRowCount();i++)
				ListTable4.setValueAt("未通过", i, ListTable4.getColumnCount()-2);
			break;
		case 5:
			if(ListTable5.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<OrderListVO> arr5 = (ArrayList<OrderListVO>) bl.getAll(DocType.SENDING_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.SENDING_NOTE, arr5);
			for(int i=0;i<ListTable5.getRowCount();i++)
				ListTable5.setValueAt("未通过", i, ListTable5.getColumnCount()-2);
			break;
		case 6:
			if(ListTable6.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<LoadListVO> arr6 = (ArrayList<LoadListVO>) bl.getAll(DocType.LOADING_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.LOADING_NOTE, arr6);
			for(int i=0;i<ListTable6.getRowCount();i++)
				ListTable6.setValueAt("未通过", i, ListTable6.getColumnCount()-2);
			break;
		case 7:
			if(ListTable7.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<HallArrivalListVO> arr7 = (ArrayList<HallArrivalListVO>) bl.getAll(DocType.BUSINESSHALL_ARRIVAL_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.BUSINESSHALL_ARRIVAL_NOTE, arr7);
			for(int i=0;i<ListTable7.getRowCount();i++)
				ListTable7.setValueAt("未通过", i, ListTable7.getColumnCount()-2);
			break;
		case 8:
			if(ListTable8.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<DeliveringListVO> arr8 = (ArrayList<DeliveringListVO>) bl.getAll(DocType.DELIVERYING_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.DELIVERYING_NOTE, arr8);
			for(int i=0;i<ListTable8.getRowCount();i++)
				ListTable8.setValueAt("未通过", i, ListTable8.getColumnCount()-2);
			break;
		case 9:
			if(ListTable9.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<TransArrivalListVO> arr9 = (ArrayList<TransArrivalListVO>) bl.getAll(DocType.CENTER_ARRIVAL_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.CENTER_ARRIVAL_NOTE, arr9);
			for(int i=0;i<ListTable9.getRowCount();i++)
				ListTable9.setValueAt("未通过", i, ListTable9.getColumnCount()-2);
			break;
		case 10:
			if(ListTable10.getRowCount()==0){
				printMessage("列表为空！", Color.RED);
				return;
			}
			ArrayList<TransShipmentListVO> arr10 = (ArrayList<TransShipmentListVO>) bl.getAll(DocType.TRANSIT_NOTE, time1, time2);
			bl.failSelectedDoc(DocType.TRANSIT_NOTE, arr10);
			for(int i=0;i<ListTable10.getRowCount();i++)
				ListTable10.setValueAt("未通过", i, ListTable10.getColumnCount()-2);
			break;
		}
	}
	private void _confirm3(){
		if(state==1){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable.getRowCount();i++){
				if("是".compareTo(  (String) ListTable.getValueAt(i, ListTable.getColumnCount()-1)  )==0){
					id.add((String) ListTable.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.MONEY_IN_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable.setValueAt("通过", index, ListTable.getColumnCount()-2);
				ListTable.setValueAt("否", index, ListTable.getColumnCount()-1);
			}
			
		}else if(state==2){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable2.getRowCount();i++){
				if("是".compareTo(  (String) ListTable2.getValueAt(i, ListTable2.getColumnCount()-1)  )==0){
					id.add((String) ListTable2.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.MONET_OUT_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable2.setValueAt("通过", index, ListTable2.getColumnCount()-2);
				ListTable2.setValueAt("否", index, ListTable2.getColumnCount()-1);
			}
			
		}else if(state==3){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable3.getRowCount();i++){
				if("是".compareTo(  (String) ListTable3.getValueAt(i, ListTable3.getColumnCount()-1)  )==0){
					id.add((String) ListTable3.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.IN_STOREAGE_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable3.setValueAt("通过", index, ListTable3.getColumnCount()-2);
				ListTable3.setValueAt("否", index, ListTable3.getColumnCount()-1);
			}
			
		}else if(state==4){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable4.getRowCount();i++){
				if("是".compareTo(  (String) ListTable4.getValueAt(i, ListTable4.getColumnCount()-1)  )==0){
					id.add((String) ListTable4.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.OUT_STOREAGE_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable4.setValueAt("通过", index, ListTable4.getColumnCount()-2);
				ListTable4.setValueAt("否", index, ListTable4.getColumnCount()-1);
			}
			
		}else if(state==5){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable5.getRowCount();i++){
				if("是".compareTo(  (String) ListTable5.getValueAt(i, ListTable5.getColumnCount()-1)  )==0){
					id.add((String) ListTable5.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.SENDING_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable5.setValueAt("通过", index, ListTable5.getColumnCount()-2);
				ListTable5.setValueAt("否", index, ListTable5.getColumnCount()-1);
			}
			
		}else if(state==6){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable6.getRowCount();i++){
				if("是".compareTo(  (String) ListTable6.getValueAt(i, ListTable6.getColumnCount()-1)  )==0){
					id.add((String) ListTable6.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.LOADING_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable6.setValueAt("通过", index, ListTable6.getColumnCount()-2);
				ListTable6.setValueAt("否", index, ListTable6.getColumnCount()-1);
			}
			
		}else if(state==7){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable7.getRowCount();i++){
				if("是".compareTo(  (String) ListTable7.getValueAt(i, ListTable7.getColumnCount()-1)  )==0){
					id.add((String) ListTable7.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.BUSINESSHALL_ARRIVAL_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable7.setValueAt("通过", index, ListTable7.getColumnCount()-2);
				ListTable7.setValueAt("否", index, ListTable7.getColumnCount()-1);
			}
			
		}else if(state==8){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable8.getRowCount();i++){
				if("是".compareTo(  (String) ListTable8.getValueAt(i, ListTable8.getColumnCount()-1)  )==0){
					id.add((String) ListTable8.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.DELIVERYING_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable8.setValueAt("通过", index, ListTable8.getColumnCount()-2);
				ListTable8.setValueAt("否", index, ListTable8.getColumnCount()-1);
			}
			
		}else if(state==9){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable9.getRowCount();i++){
				if("是".compareTo(  (String) ListTable9.getValueAt(i, ListTable9.getColumnCount()-1)  )==0){
					id.add((String) ListTable9.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.CENTER_ARRIVAL_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable9.setValueAt("通过", index, ListTable9.getColumnCount()-2);
				ListTable9.setValueAt("否", index, ListTable9.getColumnCount()-1);
			}
			
		}else if(state==10){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable10.getRowCount();i++){
				if("是".compareTo(  (String) ListTable10.getValueAt(i, ListTable10.getColumnCount()-1)  )==0){
					id.add((String) ListTable10.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.passAllSelected(DocType.TRANSIT_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable10.setValueAt("通过", index, ListTable10.getColumnCount()-2);
				ListTable10.setValueAt("否", index, ListTable10.getColumnCount()-1);
			}
			
		}
	}
	private void _confirm4(){
		if(state==1){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable.getRowCount();i++){
				if("是".compareTo(  (String) ListTable.getValueAt(i, ListTable.getColumnCount()-1)  )==0){
					id.add((String) ListTable.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.MONEY_IN_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable.setValueAt("未通过", index, ListTable.getColumnCount()-2);
				ListTable.setValueAt("否", index, ListTable.getColumnCount()-1);
			}
			
		}else if(state==2){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable2.getRowCount();i++){
				if("是".compareTo(  (String) ListTable2.getValueAt(i, ListTable2.getColumnCount()-1)  )==0){
					id.add((String) ListTable2.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.MONET_OUT_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable2.setValueAt("未通过", index, ListTable2.getColumnCount()-2);
				ListTable2.setValueAt("否", index, ListTable2.getColumnCount()-1);
			}
			
		}else if(state==3){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable3.getRowCount();i++){
				if("是".compareTo(  (String) ListTable3.getValueAt(i, ListTable3.getColumnCount()-1)  )==0){
					id.add((String) ListTable3.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.IN_STOREAGE_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable3.setValueAt("未通过", index, ListTable3.getColumnCount()-2);
				ListTable3.setValueAt("否", index, ListTable3.getColumnCount()-1);
			}
			
		}else if(state==4){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable4.getRowCount();i++){
				if("是".compareTo(  (String) ListTable4.getValueAt(i, ListTable4.getColumnCount()-1)  )==0){
					id.add((String) ListTable4.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.OUT_STOREAGE_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable4.setValueAt("未通过", index, ListTable4.getColumnCount()-2);
				ListTable4.setValueAt("否", index, ListTable4.getColumnCount()-1);
			}
			
		}else if(state==5){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable5.getRowCount();i++){
				if("是".compareTo(  (String) ListTable5.getValueAt(i, ListTable5.getColumnCount()-1)  )==0){
					id.add((String) ListTable5.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.SENDING_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable5.setValueAt("未通过", index, ListTable5.getColumnCount()-2);
				ListTable5.setValueAt("否", index, ListTable5.getColumnCount()-1);
			}
			
		}else if(state==6){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable6.getRowCount();i++){
				if("是".compareTo(  (String) ListTable6.getValueAt(i, ListTable6.getColumnCount()-1)  )==0){
					id.add((String) ListTable6.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.LOADING_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable6.setValueAt("未通过", index, ListTable6.getColumnCount()-2);
				ListTable6.setValueAt("否", index, ListTable6.getColumnCount()-1);
			}
			
		}else if(state==7){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable7.getRowCount();i++){
				if("是".compareTo(  (String) ListTable7.getValueAt(i, ListTable7.getColumnCount()-1)  )==0){
					id.add((String) ListTable7.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.BUSINESSHALL_ARRIVAL_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable7.setValueAt("未通过", index, ListTable7.getColumnCount()-2);
				ListTable7.setValueAt("否", index, ListTable7.getColumnCount()-1);
			}
			
		}else if(state==8){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable8.getRowCount();i++){
				if("是".compareTo(  (String) ListTable8.getValueAt(i, ListTable8.getColumnCount()-1)  )==0){
					id.add((String) ListTable8.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.DELIVERYING_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable8.setValueAt("未通过", index, ListTable8.getColumnCount()-2);
				ListTable8.setValueAt("否", index, ListTable8.getColumnCount()-1);
			}
			
		}else if(state==9){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable9.getRowCount();i++){
				if("是".compareTo(  (String) ListTable9.getValueAt(i, ListTable9.getColumnCount()-1)  )==0){
					id.add((String) ListTable9.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.CENTER_ARRIVAL_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable9.setValueAt("未通过", index, ListTable9.getColumnCount()-2);
				ListTable9.setValueAt("否", index, ListTable9.getColumnCount()-1);
			}
			
		}else if(state==10){
			ArrayList<String> id = new ArrayList<String>();
			ArrayList<String> RowNum = new ArrayList<String>();//存储对应的序数
			for(int i=0;i<ListTable10.getRowCount();i++){
				if("是".compareTo(  (String) ListTable10.getValueAt(i, ListTable10.getColumnCount()-1)  )==0){
					id.add((String) ListTable10.getValueAt(i, 0));
					RowNum.add(i+"");
				}
			}
			if(id.size() == 0){
				printMessage("请选中一个或多个单据！", Color.RED);
				return;
			}
			
			ResultMessage resultMessage=bl.failAllSelected(DocType.TRANSIT_NOTE, id);
			if(!resultMessage.isPass()){
				printMessage(resultMessage.getMessage(), Color.RED);
				return;
			}else{
				printMessage(resultMessage.getMessage(), Color.GREEN);
			}
			
			for(int i=0;i<RowNum.size();i++){
				int index;
				try{
					index = Integer.parseInt(RowNum.get(i));
				}catch(NumberFormatException e){
					return;
				}
				ListTable10.setValueAt("未通过", index, ListTable10.getColumnCount()-2);
				ListTable10.setValueAt("否", index, ListTable10.getColumnCount()-1);
			}
			
		}
	}
	private void clear(){
		start_date.setText("");
		while(ListTable.getRowCount()!=0)
			ListTableModel.removeRow(0);
		while(ListTable2.getRowCount()!=0)
			ListTableModel2.removeRow(0);
		while(ListTable3.getRowCount()!=0)
			ListTableModel3.removeRow(0);
		while(ListTable4.getRowCount()!=0)
			ListTableModel4.removeRow(0);
		while(ListTable5.getRowCount()!=0)
			ListTableModel5.removeRow(0);
		while(ListTable6.getRowCount()!=0)
			ListTableModel6.removeRow(0);
		while(ListTable7.getRowCount()!=0)
			ListTableModel7.removeRow(0);
		while(ListTable8.getRowCount()!=0)
			ListTableModel8.removeRow(0);
		while(ListTable9.getRowCount()!=0)
			ListTableModel9.removeRow(0);
		while(ListTable10.getRowCount()!=0)
			ListTableModel10.removeRow(0);
		willprintMessage=false;
		repaint();
	}
	private TableColumnModel getColumnModel(JTable repertoryTable, int[] width) {
		 TableColumnModel columns = repertoryTable.getColumnModel();  
		 for (int i = 0; i < width.length; i++) {  
			 TableColumn column = columns.getColumn(i);  
		     column.setPreferredWidth(width[i]);  
		 }  
		 return columns;
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
