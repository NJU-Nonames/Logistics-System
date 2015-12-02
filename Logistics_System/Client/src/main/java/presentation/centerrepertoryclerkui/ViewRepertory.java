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

import presentation.centerclerkui.CenterClerkFrame;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;

/**
 * @author 谭期友
 *
 */
public class ViewRepertory extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	//private AccountBLService bl;
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

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(CenterRepertoryClerkFrame.w/6, 10, CenterRepertoryClerkFrame.w/6, CenterRepertoryClerkFrame.h-10);
        g.drawLine(CenterRepertoryClerkFrame.w/6+10, CenterRepertoryClerkFrame.h/6, CenterRepertoryClerkFrame.w, CenterRepertoryClerkFrame.h/6);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+80, CenterClerkFrame.w-100, CenterClerkFrame.h/6+80);
        
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CenterRepertoryClerkFrame.h-50, CenterRepertoryClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CenterRepertoryClerkFrame.w/2, 13+CenterRepertoryClerkFrame.h-30);
        }
	}
	
	public ViewRepertory(CenterRepertoryClerkFrame frame, CurrentUser currentUser){
		this.frame=frame;
		//this.bl=bl;
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
        goto_InputRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_InputRepertory.addMouseListener(new MouseListener(){
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
        goto_OutputRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_OutputRepertory.addMouseListener(new MouseListener(){
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
        goto_ViewRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_ViewRepertory.addMouseListener(new MouseListener(){
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
        goto_Inventory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_Inventory.addMouseListener(new MouseListener(){
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
    	//详细操作按钮
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="库存查看";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        String s="仓库管理员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(CenterRepertoryClerkFrame.w/6,128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(CenterRepertoryClerkFrame.w/6+(int)(30*s.length()*1.07f),128-30);
    	
        String str=currentUser.getAgencyName()+"       "+"编号："+currentUser.getAgencyNum();
        JLabel agencyNameLabel = new JLabel(str);
        agencyNameLabel.setSize((int)(16*str.length()*1.07f), 16);
        agencyNameLabel.setFont(new Font("宋体", Font.BOLD, 15));
        agencyNameLabel.setLocation(CenterClerkFrame.w/6+20,128+50);
        
        Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time_="时间:   "+format.format(date_);
		JLabel timeLabel = new JLabel(time_);
        timeLabel.setSize((int)(16*time_.length()*1.07f), 16);
        timeLabel.setFont(new Font("宋体", Font.BOLD, 15));
        timeLabel.setLocation(CenterClerkFrame.w-timeLabel.getWidth()+80,128+50);
        
        JLabel Stime = new JLabel("起始时间：");
        Stime.setSize((int)(16*"起始时间：".length()*1.07f), 16);
        Stime.setFont(new Font("宋体", Font.BOLD, 15));
        Stime.setLocation(agencyNameLabel.getX()+200,128+100);
        
        _time1.setSize((int)(90*1.07f), 20);
        _time1.setLocation(Stime.getX()+Stime.getWidth(),Stime.getY());
        
        JLabel Etime = new JLabel("结束时间：");
        Etime.setSize((int)(16*"结束时间：".length()*1.07f), 16);
        Etime.setFont(new Font("宋体", Font.BOLD, 15));
        Etime.setLocation(_time1.getX()+_time1.getWidth()+20,_time1.getY());
        
        _time2.setSize((int)(90*1.07f), 20);
        _time2.setLocation(Etime.getX()+Etime.getWidth(),Etime.getY());
        _time2.setText(format.format(date_));
        
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
        search.setLocation(_time2.getX()+_time2.getWidth(),_time2.getY()-5);
        
        JLabel in = new JLabel("入库信息表");
        in.setSize((int)(16*"入库信息表".length()*1.07f), 16);
        in.setFont(new Font("宋体", Font.BOLD, 15));
        in.setLocation(agencyNameLabel.getX()+350,128+120);
        
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
      	int[] width1={100,300,25,25,25,25};
      	repertoryInTable.setColumnModel(getColumnModel(repertoryInTable,width1));
      	repertoryInTable.getTableHeader().setReorderingAllowed(false);
      	repertoryInTable.getTableHeader().setResizingAllowed(false);
      	jp1.setSize(800, 150);
      	jp1.setLocation(agencyNameLabel.getX()+10, in.getY()+in.getHeight());
      	jp1.setOpaque(false);
      	jp1.add(scrollPane1,BorderLayout.CENTER);
      	
      	_time2.setSize((int)(90*1.07f), 20);
        _time2.setLocation(Etime.getX()+Etime.getWidth(),Etime.getY());
        _time2.setText(format.format(date_));
        
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
      	jp2.setLocation(agencyNameLabel.getX()+10, out.getY()+out.getHeight());
      	jp2.setOpaque(false);
      	jp2.add(scrollPane2,BorderLayout.CENTER);
      	
      	JLabel inCount = new JLabel("入库数量总计：");//联系逻辑层数据
      	inCount.setSize((int)(16*"入库数量总计：".length()*1.07f), 16);
      	inCount.setFont(new Font("宋体", Font.BOLD, 15));
      	inCount.setLocation(agencyNameLabel.getX()+150,128+440);
      	
      	JLabel outCount = new JLabel("出库数量总计：");//联系逻辑层数据
      	outCount.setSize((int)(16*"出库数量总计：".length()*1.07f), 16);
      	outCount.setFont(new Font("宋体", Font.BOLD, 15));
      	outCount.setLocation(inCount.getX()+inCount.getWidth(),inCount.getY());
      	
      	JLabel inMoney = new JLabel("入库金额总计：");//联系逻辑层数据
      	inMoney.setSize((int)(16*"入库金额总计：".length()*1.07f), 16);
      	inMoney.setFont(new Font("宋体", Font.BOLD, 15));
      	inMoney.setLocation(inCount.getX(),inCount.getY()+40);
      	
      	JLabel outMoney = new JLabel("出库金额总计：");//联系逻辑层数据
      	outMoney.setSize((int)(16*"出库金额总计：".length()*1.07f), 16);
      	outMoney.setFont(new Font("宋体", Font.BOLD, 15));
      	outMoney.setLocation(outCount.getX(),outCount.getY()+40);
        //最基本按钮
    	close.setLocation(CenterRepertoryClerkFrame.w-30,0);
    	min.setLocation(CenterRepertoryClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_InputRepertory.setLocation(20,150);
    	goto_OutputRepertory.setLocation(20,200);
    	goto_ViewRepertory.setLocation(20,250);
    	goto_Inventory.setLocation(20,300);
    	
    	//其他组件

		
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        add(agencyNameLabel);
        add(timeLabel);
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
		
	}
	private void clear(){
//		.setText("");
//		.setText("");
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
