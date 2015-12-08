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

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;

import businesslogicservice.chartblservice.FormBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import vo.MoneyInformationListVO;
import vo.MoneyItemVO;

/**
 * @author 谭期友
 *
 */
public class Statistic extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private FormBLService bl;
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
	private MyButton search2;
	private MyButton confirm1;
	private MyButton confirm2;
	private String time1;
	private String time2;
	private String time3;
	private String time4;
	
	private JTextField start_date;
	private JTextField end_date;
	private DefaultTableModel CostandBenefitChartTableModel;
	private JTable CostandBenefitChartTable;//成本收益表
	private JTextField start_date2;
	private JTextField end_date2;
	private DefaultTableModel BusinessCircumstanceChartTableModel;
	private JTable BusinessCircumstanceChartTable;//经营情况表

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
	
	public Statistic(TopManagerFrame frame, FormBLService bl, CurrentUser currentUser){
		this.frame=frame;
		this.bl=bl;
		this.currentUser=currentUser;
		willprintMessage=false;
		result="";
		time1="";
		time2="";
		time3="";
		time4="";
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
    	search2 = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	search2.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_search2();
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
    	confirm1.setLocation(170+20+(int)(16*8*1.07f),690);
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
    	confirm2.setLocation(596+(int)(16*8*1.07f),690);
    	add(confirm1);
    	add(confirm2);
		JLabel l11 = new JLabel("导出成本收益表：");
		l11.setSize((int)(16*8*1.07f), 16);
		l11.setFont(new Font("宋体", Font.BOLD, 15));
        l11.setLocation(170+20, 690+7);
        add(l11);
		JLabel l22 = new JLabel("导出经营情况表：");
		l22.setSize((int)(16*8*1.07f), 16);
		l22.setFont(new Font("宋体", Font.BOLD, 15));
        l22.setLocation(596, 690+7);
        add(l22);
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="统计报表";
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
		JLabel l1 = new JLabel("起始日期：");
		l1.setSize((int)(16*5*1.07f), 16);
		l1.setFont(new Font("宋体", Font.BOLD, 15));
		l1.setLocation(596-220, 128+80);
		start_date = new JTextField();
		start_date.setSize(110, 20);
		start_date.setLocation(596-220+(int)(16*5*1.07f),128+80-3);

		JLabel l2 = new JLabel("终止日期：");
		l2.setSize((int)(16*5*1.07f), 16);
		l2.setFont(new Font("宋体", Font.BOLD, 15));
		l2.setLocation(596+20, 128+80);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date_);
		end_date = new JTextField(time);
		end_date.setSize(110, 20);
		end_date.setLocation(596+20+(int)(16*5*1.07f),128+80-3);

		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("日期");
		vColumns.add("收入");
		vColumns.add("支出");;
		vColumns.add("利润");
		//数据
		Vector<String> vData = new Vector<String>();
		//模型
		CostandBenefitChartTableModel = new DefaultTableModel(vData, vColumns);
		//表格
		CostandBenefitChartTable = new JTable(CostandBenefitChartTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		CostandBenefitChartTable.setPreferredScrollableViewportSize(new Dimension(600,180));
		CostandBenefitChartTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		CostandBenefitChartTable.setSelectionBackground(Color.YELLOW);
		JPanel jp=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(CostandBenefitChartTable);
		CostandBenefitChartTable.getTableHeader().setReorderingAllowed(false);
		CostandBenefitChartTable.getTableHeader().setResizingAllowed(false);
		CostandBenefitChartTable.setFillsViewportHeight(true);
		jp.setSize(620, 210);
		jp.setLocation(596-620/2, 128+80+20);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);

		

		JLabel l3 = new JLabel("起始日期：");
		l3.setSize((int)(16*5*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(596-220, 128+80+250);
		start_date2 = new JTextField();
		start_date2.setSize(110, 20);
		start_date2.setLocation(596-220+(int)(16*5*1.07f),128+80+250-3);

		JLabel l4 = new JLabel("终止日期：");
		l4.setSize((int)(16*5*1.07f), 16);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(596+20, 128+80+250);
		end_date2 = new JTextField(time);
		end_date2.setSize(110, 20);
		end_date2.setLocation(596+20+(int)(16*5*1.07f),128+80+250-3);

		//表头
		Vector<String> vColumns2 = new Vector<String>();
		vColumns2.add("日期");
		vColumns2.add("单号");
		vColumns2.add("金额");
		//数据
		Vector<String> vData2 = new Vector<String>();
		//模型
		BusinessCircumstanceChartTableModel = new DefaultTableModel(vData2, vColumns2);
		//表格
		BusinessCircumstanceChartTable = new JTable(BusinessCircumstanceChartTableModel){
			private static final long serialVersionUID = 1L;

			public boolean isCellEditable(int row, int column){
				return false;//不能修改
			}
		};
		BusinessCircumstanceChartTable.setPreferredScrollableViewportSize(new Dimension(600,180));
		BusinessCircumstanceChartTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		BusinessCircumstanceChartTable.setSelectionBackground(Color.YELLOW);
		JPanel jp2=new JPanel();
		JScrollPane scrollPane2 = new JScrollPane();
		scrollPane2.getViewport().add(BusinessCircumstanceChartTable);
		BusinessCircumstanceChartTable.getTableHeader().setReorderingAllowed(false);
		BusinessCircumstanceChartTable.getTableHeader().setResizingAllowed(false);
		BusinessCircumstanceChartTable.setFillsViewportHeight(true);
		jp2.setSize(620, 210);
		jp2.setLocation(596-620/2, 128+80+250+20);
		jp2.setOpaque(false);
		jp2.add(scrollPane2,BorderLayout.CENTER);

		

    	search.setLocation(596+300, 128+80-10);
    	search2.setLocation(596+300, 128+80+250-10);
        


		JLabel ll1 = new JLabel("成本收益表：");
		ll1.setSize((int)(16*6*1.07f), 16);
		ll1.setFont(new Font("宋体", Font.BOLD, 15));
		ll1.setLocation(170+10, 128+80+20+210/2);
		JLabel ll2 = new JLabel("经营情况表：");
		ll2.setSize((int)(16*6*1.07f), 16);
		ll2.setFont(new Font("宋体", Font.BOLD, 15));
		ll2.setLocation(170+10, 128+80+250+20+210/2);
		
		
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
    	add(jp);
    	add(search);
    	
    	add(l3);
    	add(start_date2);
    	add(l4);
    	add(end_date2);
    	add(jp2);
    	add(search2);
    	
    	add(ll1);
    	add(ll2);
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
		
		ArrayList<MoneyInformationListVO> arr=bl.getCostandBenefitChart(start_date_s, end_date_s);

		if(arr==null){
			printMessage("找不到相关信息！", Color.RED);
			return;
		}
		time1=start_date_s;
		time2=end_date_s;
		while(CostandBenefitChartTable.getRowCount()!=0)//先清空原来的
			CostandBenefitChartTableModel.removeRow(0);
		
		for(int i = 0 ; i<arr.size(); i++){
			Vector<String> v = new Vector<String>();
    		v.add(arr.get(i).getTime());
    		v.add(arr.get(i).getMoneyIn()+"");
    		v.add(arr.get(i).getMoneyOut()+"");
    		v.add(arr.get(i).getProfit()+"");
    		CostandBenefitChartTableModel.addRow(v);
        }
	}
	private void _search2(){
		String start_date2_s = start_date2.getText();
		String end_date2_s = end_date2.getText();

		result = CheckFormat.checkTime(start_date2_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkTime(end_date2_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		ArrayList<MoneyItemVO> arr=bl.getBusinessCircumstanceChart(start_date2_s, end_date2_s);

		if(arr==null){
			printMessage("找不到相关信息！", Color.RED);
			return;
		}

		time3=start_date2_s;
		time4=end_date2_s;
		while(BusinessCircumstanceChartTable.getRowCount()!=0)//先清空原来的
			BusinessCircumstanceChartTableModel.removeRow(0);
		
		for(int i = 0 ; i<arr.size(); i++){
			Vector<String> v = new Vector<String>();
    		v.add(arr.get(i).getDate());
    		v.add(arr.get(i).getId());
    		v.add(arr.get(i).getMoney()+"");
    		BusinessCircumstanceChartTableModel.addRow(v);
        }
		
	}
	private void _confirm1(){
		if(time1.compareTo("")==0){
			printMessage("成本收益表未初始化！", Color.RED);
			return;
		}
		bl.exportCostandBenefitChart(time1, time2,  "D:/");
		printMessage("成本收益表已导出！", Color.GREEN);
	}
	private void _confirm2(){
		if(time3.compareTo("")==0){
			printMessage("经营情况表未初始化！", Color.RED);
			return;
		}
		bl.exportBusinessCircumstanceChart(time3, time4,  "D:/");
		printMessage("经营情况表已导出！", Color.GREEN);
	}
	private void clear(){
		time1="";
		time2="";
		time3="";
		time4="";
		
		start_date.setText("");
		start_date2.setText("");
		while(CostandBenefitChartTable.getRowCount()!=0)
			CostandBenefitChartTableModel.removeRow(0);
		while(BusinessCircumstanceChartTable.getRowCount()!=0)
			BusinessCircumstanceChartTableModel.removeRow(0);
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
