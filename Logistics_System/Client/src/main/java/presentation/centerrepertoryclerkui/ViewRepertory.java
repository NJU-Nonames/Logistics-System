/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.centerrepertoryclerkui;

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
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import businesslogic.logisticsbl.RepertoryManageBLImpl;
import presentation.centerclerkui.CenterClerkFrame;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import vo.RepertoryInVO;
import vo.RepertoryOutVO;

/**
 * @author 谭期友
 *
 */
public class ViewRepertory extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private RepertoryManageBLImpl bl;
	private CenterRepertoryClerkFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_InputRepertory;
	private MyButton goto_OutputRepertory;
	private MyButton goto_ViewRepertory;
	private MyButton goto_Inventory;
	
	private MyButton search;
	//详细操作按钮以及其他组件
	private JTextField _time1=new JTextField();
	private JTextField _time2=new JTextField();
	
	private DefaultTableModel repertoryInTableModel;
	private JTable repertoryInTable;
	
	private DefaultTableModel repertoryOutTableModel;
	private JTable repertoryOutTable;
	
	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色
	
	JLabel inCount;
	JLabel inMoney;
	JLabel outCount;
	JLabel outMoney;

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, CenterRepertoryClerkFrame.w/6, CenterRepertoryClerkFrame.h/6, CenterRepertoryClerkFrame.w, CenterRepertoryClerkFrame.h, null);
        g.drawImage(Img.BACKGROUND1, CenterRepertoryClerkFrame.w/6, 0, CenterRepertoryClerkFrame.w, CenterRepertoryClerkFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, CenterRepertoryClerkFrame.w/6, CenterRepertoryClerkFrame.h, null);
        g.drawLine(CenterRepertoryClerkFrame.w/6-1, 0, CenterRepertoryClerkFrame.w/6-1, CenterRepertoryClerkFrame.h);
        g.drawLine(CenterRepertoryClerkFrame.w/6, 0, CenterRepertoryClerkFrame.w/6, CenterRepertoryClerkFrame.h);
        g.drawLine(CenterRepertoryClerkFrame.w/6+1, 0, CenterRepertoryClerkFrame.w/6+1, CenterRepertoryClerkFrame.h);
        g.drawLine(CenterRepertoryClerkFrame.w/6, CenterRepertoryClerkFrame.h/6, CenterRepertoryClerkFrame.w, CenterRepertoryClerkFrame.h/6);
        g.drawLine(CenterRepertoryClerkFrame.w/6, CenterRepertoryClerkFrame.h/6+1, CenterRepertoryClerkFrame.w, CenterRepertoryClerkFrame.h/6+1);
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CenterRepertoryClerkFrame.h-50, CenterRepertoryClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CenterRepertoryClerkFrame.w/2, 13+CenterRepertoryClerkFrame.h-30);
        }
	}
	
	public ViewRepertory(CenterRepertoryClerkFrame frame, CurrentUser currentUser){
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
        goto_InputRepertory = new MyButton(170, 30, Img.GORUKU_0, Img.GORUKU_1, Img.GORUKU_2);
        goto_InputRepertory.addMouseListener(new MouseListener(){
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
        goto_OutputRepertory = new MyButton(170, 30, Img.GOCHUKU_0, Img.GOCHUKU_1, Img.GOCHUKU_2);
        goto_OutputRepertory.addMouseListener(new MouseListener(){
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
        goto_ViewRepertory = new MyButton(170, 30, Img.GOKUCUNCHAKAN_2, Img.GOKUCUNCHAKAN_2, Img.GOKUCUNCHAKAN_2);
        goto_ViewRepertory.addMouseListener(new MouseListener(){
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
        goto_Inventory = new MyButton(170, 30, Img.GOKUCUNPANDIAN_0, Img.GOKUCUNPANDIAN_1, Img.GOKUCUNPANDIAN_2);
        goto_Inventory.addMouseListener(new MouseListener(){
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

        String func="库存查看";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.DARK_GRAY);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="仓库管理员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.DARK_GRAY);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
        
        JLabel Stime = new JLabel("起始时间：");
        Stime.setSize((int)(16*"起始时间：".length()*1.07f), 16);
        Stime.setFont(new Font("宋体", Font.BOLD, 15));
        Stime.setLocation(CenterRepertoryClerkFrame.w/6+20+200,128+75);
        
        _time1.setSize((int)(90*1.07f), 20);
        _time1.setLocation(Stime.getX()+Stime.getWidth(),Stime.getY());
        
        JLabel Etime = new JLabel("结束时间：");
        Etime.setSize((int)(16*"结束时间：".length()*1.07f), 16);
        Etime.setFont(new Font("宋体", Font.BOLD, 15));
        Etime.setLocation(_time1.getX()+_time1.getWidth()+20,_time1.getY());
        
        _time2.setSize((int)(90*1.07f), 20);
        _time2.setLocation(Etime.getX()+Etime.getWidth(),Etime.getY());
    	Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        _time2.setText(format.format(date_));
        
        search = new MyButton(90, 30, Img.SEARCH_0, Img.SEARCH_1, Img.SEARCH_2);
        search.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_search();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        search.setLocation(_time2.getX()+_time2.getWidth(),_time2.getY()-5);
        
        JLabel in = new JLabel("入库信息表");
        in.setSize((int)(16*"入库信息表".length()*1.07f), 16);
        in.setFont(new Font("宋体", Font.BOLD, 15));
        in.setLocation(CenterRepertoryClerkFrame.w/6+20+350,128+120);
        
        Vector<String> vColumns1 = new Vector<String>();
      	vColumns1.add("入库时间");
      	vColumns1.add("订单编号");
      	vColumns1.add("区");
      	vColumns1.add("排");
      	vColumns1.add("架");
      	vColumns1.add("位");
      	Vector<String> vData1 = new Vector<String>();
      	repertoryInTableModel = new DefaultTableModel(vData1, vColumns1);
      	repertoryInTable = new JTable(repertoryInTableModel){
     		private static final long serialVersionUID = 1L;

     		public boolean isCellEditable(int row, int column){
     			return false;//不能修改
     		}
      	};
      	
      	repertoryInTable.setPreferredScrollableViewportSize(new Dimension(700,100));
      	repertoryInTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      	repertoryInTable.setSelectionBackground(Color.YELLOW);
      	JPanel jp1=new JPanel();
      	JScrollPane scrollPane1 = new JScrollPane();
      	scrollPane1.getViewport().add(repertoryInTable);
      	repertoryInTable.setFillsViewportHeight(true);
      	int[] width1={200,200,25,25,25,25};
      	repertoryInTable.setColumnModel(getColumnModel(repertoryInTable,width1));
      	repertoryInTable.getTableHeader().setReorderingAllowed(false);
      	repertoryInTable.getTableHeader().setResizingAllowed(false);
      	jp1.setSize(800, 150);
      	jp1.setLocation(CenterRepertoryClerkFrame.w/6+20+10, in.getY()+in.getHeight());
      	jp1.setOpaque(false);
      	jp1.add(scrollPane1,BorderLayout.CENTER);
        
        JLabel out = new JLabel("出库信息表");
        out.setSize((int)(16*"出库信息表".length()*1.07f), 16);
        out.setFont(new Font("宋体", Font.BOLD, 15));
        out.setLocation(in.getX(),128+270);
        
        Vector<String> vColumns2 = new Vector<String>();
      	vColumns2.add("出库时间");
      	vColumns2.add("订单编号");
      	vColumns2.add("目的地");
      	vColumns2.add("装运方式");
      	Vector<String> vData2 = new Vector<String>();
      	repertoryOutTableModel = new DefaultTableModel(vData2, vColumns2);
      	repertoryOutTable = new JTable(repertoryOutTableModel){
     		private static final long serialVersionUID = 1L;

     		public boolean isCellEditable(int row, int column){
     			return false;//不能修改
     		}
      	};
      	
      	repertoryOutTable.setPreferredScrollableViewportSize(new Dimension(700,100));
      	repertoryOutTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      	repertoryOutTable.setSelectionBackground(Color.YELLOW);
      	JPanel jp2=new JPanel();
      	JScrollPane scrollPane2 = new JScrollPane();
      	scrollPane2.getViewport().add(repertoryOutTable);
      	repertoryInTable.setFillsViewportHeight(true);
      	int[] width2={100,300,100,50};
      	repertoryOutTable.setColumnModel(getColumnModel(repertoryOutTable,width2));
      	repertoryOutTable.getTableHeader().setReorderingAllowed(false);
      	repertoryOutTable.getTableHeader().setResizingAllowed(false);
      	jp2.setSize(800, 150);
      	jp2.setLocation(CenterRepertoryClerkFrame.w/6+20+10, out.getY()+out.getHeight());
      	jp2.setOpaque(false);
      	jp2.add(scrollPane2,BorderLayout.CENTER);
      	
      	inCount = new JLabel("入库数量总计：");//联系逻辑层数据
      	inCount.setSize((int)(16*"入库数量总计：".length()*1.07f), 16);
      	inCount.setFont(new Font("宋体", Font.BOLD, 15));
      	inCount.setLocation(CenterRepertoryClerkFrame.w/6+20+150,128+440);
      	
      	outCount = new JLabel("出库数量总计：");//联系逻辑层数据
      	outCount.setSize((int)(16*"出库数量总计：".length()*1.07f), 16);
      	outCount.setFont(new Font("宋体", Font.BOLD, 15));
      	outCount.setLocation(CenterRepertoryClerkFrame.w/6+20+150+220,inCount.getY());
      	
      	inMoney = new JLabel("入库金额总计：");//联系逻辑层数据
      	inMoney.setSize((int)(16*"入库金额总计：".length()*1.07f), 16);
      	inMoney.setFont(new Font("宋体", Font.BOLD, 15));
      	inMoney.setLocation(inCount.getX(),inCount.getY()+40);
      	
      	outMoney = new JLabel("出库金额总计：");//联系逻辑层数据
      	outMoney.setSize((int)(16*"出库金额总计：".length()*1.07f), 16);
      	outMoney.setFont(new Font("宋体", Font.BOLD, 15));
      	outMoney.setLocation(outCount.getX(),outCount.getY()+40);
        //最基本按钮
    	close.setLocation(CenterRepertoryClerkFrame.w-30,0);
    	min.setLocation(CenterRepertoryClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_InputRepertory.setLocation(0,150);
    	goto_OutputRepertory.setLocation(0,200);
    	goto_ViewRepertory.setLocation(0,250);
    	goto_Inventory.setLocation(0,300);
    	
    	//其他组件

		
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        
        add(Stime);
        add(Etime);
        add(in);
        add(out);
        add(inCount);
        add(outCount);
        add(inMoney);
        add(outMoney);
        
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_InputRepertory);
    	add(goto_OutputRepertory);
    	add(goto_ViewRepertory);
    	add(goto_Inventory);
    	add(search);

    	add(_time1);
    	add(_time2);
    	
    	add(jp1);
    	add(jp2);
	}
	
	private TableColumnModel getColumnModel(JTable repertoryTable, int[] width) {
		 TableColumnModel columns = repertoryTable.getColumnModel();  
		 for (int i = 0; i < width.length; i++) {  
			 TableColumn column = columns.getColumn(i);  
		     column.setPreferredWidth(width[i]);  
		 }  
		 return columns;
	}
	private void _search() {
		// TODO 自动生成的方法存根
		String t1=_time1.getText();
		String t2=_time2.getText();
		
		result = CheckFormat.checkTime(t1);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		result = CheckFormat.checkTime(t2);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		inCount.setText(inCount.getText()+bl.searchRepertory(t1, t2).numberIn+"");
		outCount.setText(outCount.getText()+bl.searchRepertory(t1, t2).numberOut+"");
		inMoney.setText(inMoney.getText()+bl.searchRepertory(t1, t2).moneyIn+"");
		outMoney.setText(inCount.getText()+bl.searchRepertory(t1, t2).moneyOut+"");
	
		ArrayList<RepertoryInVO> rin = bl.searchRepertory(t1, t2).repertoryin;
		ArrayList<RepertoryOutVO> rout = bl.searchRepertory(t1, t2).repertoryout;
		
		while(repertoryInTableModel.getRowCount()!=0)//先清空原来的
			repertoryInTableModel.removeRow(0);
		
		for(int i = 0 ; i<rin.size(); i++){
			Vector<String> v = new Vector<String>();
    		v.add(rin.get(i).getTime());
    		v.add(rin.get(i).getNum());
    		v.add(rin.get(i).getAreacode());
    		v.add(rin.get(i).getRownumber());
    		v.add(rin.get(i).getFramenumber());
    		v.add(rin.get(i).getPlacenumber());
    		repertoryInTableModel.addRow(v);
        }
		
		while(repertoryOutTableModel.getRowCount()!=0)//先清空原来的
			repertoryOutTableModel.removeRow(0);
		
		for(int i = 0 ; i<rout.size(); i++){
			Vector<String> v = new Vector<String>();
    		v.add(rout.get(i).getTime());
    		v.add(rout.get(i).getCode());
    		v.add(rout.get(i).getDestination());
    		v.add(rout.get(i).getTransportation()+"");
    		repertoryInTableModel.addRow(v);
        }
	}
	private void clear(){
		_time1.setText("");
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		_time2.setText(format.format(date_));
		while(repertoryOutTable.getRowCount()!=0)
			repertoryOutTableModel.removeRow(0);
		while(repertoryInTable.getRowCount()!=0)
			repertoryInTableModel.removeRow(0);
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
