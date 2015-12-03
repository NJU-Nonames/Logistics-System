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
import businesslogicservice.logisticsblservice.RepertoryManageBLService;
import presentation.centerclerkui.CenterClerkFrame;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.ResultMessage;
import vo.RepertoryInfoVO;
import vo.RepertoryInformationVO;

/**
 * @author 谭期友
 *
 */
public class Inventory extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private RepertoryManageBLService bl;
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
	private MyButton adjust;
	private MyButton refresh;
	//详细操作按钮以及其他组件
	private DefaultTableModel repertoryTableModel;
	private JTable repertoryTable;
	
	
	private JTextField searchField= new JTextField();
	private JTextField _orderId= new JTextField();
	private JTextField _q= new JTextField();
	private JTextField _p= new JTextField();
	private JTextField _j= new JTextField();
	private JTextField _w= new JTextField();
	
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
	
	public Inventory(CenterRepertoryClerkFrame frame, CurrentUser currentUser){
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
        search.setLocation(CenterClerkFrame.w/3*2+25,128+84);
        
        refresh = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        refresh.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_refresh();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        refresh.setLocation(CenterClerkFrame.w/3*2+25,128+184);
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="库存盘点";
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
        
        String s1="分区A占比："+bl.showRepertory().percentA;
        JLabel partA = new JLabel(s1);//要联系逻辑层给的数据
        partA.setSize((int)(16*s1.length()*1.07f), 16);
        partA.setFont(new Font("宋体", Font.BOLD, 15));
        partA.setLocation(agencyNameLabel.getX()+10,CenterClerkFrame.h/6+110+300+10);
        
        String s2="分区B占比："+bl.showRepertory().percentB;
        JLabel partB= new JLabel(s2);//要联系逻辑层给的数据
        partB.setSize((int)(16*s2.length()*1.07f), 16);
        partB.setFont(new Font("宋体", Font.BOLD, 15));
        partB.setLocation(partA.getX()+partA.getWidth()+60,partA.getY());
        
        String s3="分区C占比："+bl.showRepertory().percentC;
        JLabel partC = new JLabel(s3);//要联系逻辑层给的数据
        partC.setSize((int)(16*s3.length()*1.07f), 16);
        partC.setFont(new Font("宋体", Font.BOLD, 15));
        partC.setLocation(partB.getX()+partB.getWidth()+60,partA.getY());
        
        String s4="分区D占比："+bl.showRepertory().percentD;
        JLabel partD = new JLabel(s4);//要联系逻辑层给的数据
        partD.setSize((int)(16*s4.length()*1.07f), 16);
        partD.setFont(new Font("宋体", Font.BOLD, 15));
        partD.setLocation(partC.getX()+partC.getWidth()+60,partA.getY());
        
        JLabel tiaozhengfenqu = new JLabel("调整分区:");
        tiaozhengfenqu.setSize((int)(16*"调整分区:".length()*1.07f), 16);
        tiaozhengfenqu.setFont(new Font("宋体", Font.BOLD, 15));
        tiaozhengfenqu.setLocation(agencyNameLabel.getX()+10,partA.getY()+30);
        
        JLabel orderId = new JLabel("订单");
        orderId.setSize((int)(16*"订单".length()*1.07f), 16);
        orderId.setFont(new Font("宋体", Font.BOLD, 15));
        orderId.setLocation(tiaozhengfenqu.getX()+tiaozhengfenqu.getWidth(),tiaozhengfenqu.getY());
        
        _orderId.setSize((int)(200*1.07f), 20);
        _orderId.setLocation(orderId.getX()+orderId.getWidth(),orderId.getY()-3);
        
        JLabel tiaozhengzhi = new JLabel("调整至");
        tiaozhengzhi.setSize((int)(16*"调整至".length()*1.07f), 16);
        tiaozhengzhi.setFont(new Font("宋体", Font.BOLD, 15));
        tiaozhengzhi.setLocation(_orderId.getX()+_orderId.getWidth()+10,_orderId.getY());
        
        _q.setSize((int)(20*1.07f), 20);
        _q.setLocation(tiaozhengzhi.getX()+tiaozhengzhi.getWidth(),tiaozhengzhi.getY()-3);
        
        JLabel q=new JLabel("区");
        q.setSize((int)(16*1.07f),16);
        q.setFont(new Font("宋体", Font.BOLD, 15));
        q.setLocation(_q.getX()+_q.getWidth()+10,tiaozhengzhi.getY());
        
        _p.setSize((int)(20*1.07f), 20);
        _p.setLocation(q.getX()+q.getWidth()+20,tiaozhengzhi.getY()-3);
        
        JLabel p=new JLabel("排");
        p.setSize((int)(16*1.07f), 16);
        p.setFont(new Font("宋体", Font.BOLD, 15));
        p.setLocation(_p.getX()+_p.getWidth()+10,tiaozhengzhi.getY());
        
        _j.setSize((int)(20*1.07f), 20);
        _j.setLocation(p.getX()+p.getWidth()+20,tiaozhengzhi.getY()-3);
        
        JLabel j=new JLabel("架");
        j.setSize((int)(16*1.07f), 16);
        j.setFont(new Font("宋体", Font.BOLD, 15));
        j.setLocation(_j.getX()+_j.getWidth()+10,tiaozhengzhi.getY());
        
        _w.setSize((int)(20*1.07f), 20);
        _w.setLocation(j.getX()+j.getWidth()+20,tiaozhengzhi.getY()-3);
        
        JLabel w=new JLabel("位");
        w.setSize((int)(16*1.07f), 16);
        w.setFont(new Font("宋体", Font.BOLD, 15));
        w.setLocation(_w.getX()+_w.getWidth()+10,tiaozhengzhi.getY());
        
        adjust = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        adjust.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_adjust();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        adjust.setLocation(w.getX()+w.getWidth()+20,w.getY()-9);
        
        Vector<String> vColumns = new Vector<String>();
        vColumns.add("入库日期");
        vColumns.add("目的地");
      	vColumns.add("区");
      	vColumns.add("排");
      	vColumns.add("架");
      	vColumns.add("位");
      	vColumns.add("订单编号");
      	Vector<String> vData = new Vector<String>();
      	repertoryTableModel = new DefaultTableModel(vData, vColumns);
      	RepertoryInfoVO repertoryInfoVO = bl.showRepertory();
      	ArrayList<RepertoryInformationVO> repertoryInfomationList = repertoryInfoVO.repertoryinformation;
      	for(RepertoryInformationVO info : repertoryInfomationList){
      		Vector<String> v = new Vector<String>();
      		v.add(info.time);
      		v.add(info.destination);
      		v.add(info.areaNumber);
      		v.add(info.rowNumber);
      		v.add(info.frameNumber);
      		v.add(info.placeNumber );
      		v.add(info.orderId);
      		repertoryTableModel.addRow(v);
      	}
      	repertoryTable = new JTable(repertoryTableModel){
     		private static final long serialVersionUID = 1L;

     		public boolean isCellEditable(int row, int column){
     			return false;//不能修改
     		}
      	};
      	
      	repertoryTable.setPreferredScrollableViewportSize(new Dimension(700,250));
      	repertoryTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      	repertoryTable.setSelectionBackground(Color.YELLOW);
      	JPanel jp=new JPanel();
      	JScrollPane scrollPane = new JScrollPane();
      	scrollPane.getViewport().add(repertoryTable);
      	repertoryTable.setFillsViewportHeight(true);
      	int[] width={200,150,25,25,25,25,200};
      	repertoryTable.setColumnModel(getColumnModel(repertoryTable,width));
      	repertoryTable.getTableHeader().setReorderingAllowed(false);
      	repertoryTable.getTableHeader().setResizingAllowed(false);
      	jp.setSize(800, 300);
      	jp.setLocation(agencyNameLabel.getX()+10, CenterClerkFrame.h/6+110);
      	jp.setOpaque(false);
      	jp.add(scrollPane,BorderLayout.CENTER);
      	
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
    	searchField.setSize((int)(200*1.07f), 20);
    	searchField.setLocation(search.getX()-searchField.getWidth()-30,search.getY()+5);

		
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        add(agencyNameLabel);
        add(timeLabel);
        add(partA);
        add(partB);
        add(partC);
        add(partD);
        add(tiaozhengfenqu);
        add(orderId);
        add(tiaozhengzhi);
        add(q);
        add(p);
        add(j);
        add(w);
    
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_InputRepertory);
    	add(goto_OutputRepertory);
    	add(goto_ViewRepertory);
    	add(goto_Inventory);
    	add(search);
    	add(adjust);
    	add(refresh);
    	
    	add(searchField);
    	add(_orderId);
    	add(_q);
    	add(_p);
    	add(_j);
    	add(_w);
    	
    	add(jp);
	}

	private TableColumnModel getColumnModel(JTable repertoryTable, int[] width) {
		 TableColumnModel columns = repertoryTable.getColumnModel();  
		 for (int i = 0; i < width.length; i++) {  
			 TableColumn column = columns.getColumn(i);  
		     column.setPreferredWidth(width[i]);  
		 }  
		 return columns;
	}

	private void clear(){
		searchField.setText("");
		_orderId.setText("");
		_q.setText("");
		_p.setText("");
		_j.setText("");
		_w.setText("");
		willprintMessage=false;
		repaint();
	}
	private void _search(){
		if(searchField.getText().compareTo("")==0){
			printMessage("未输入订单编号！", Color.RED);
			return;
		}
		String input=searchField.getText();
		int i=0;
		while(repertoryTable.getValueAt(i, 6)!=null){
			if(repertoryTable.getValueAt(i, 6).equals(input)){
				repertoryTable.setRowSelectionInterval(i, i);
				return;
			}
			i++;
		}
		printMessage("查无此订单！", Color.RED);
	}
	
	private void _adjust() {
		// TODO 自动生成的方法存根
		RepertoryInformationVO data = new RepertoryInformationVO(currentUser.getAgencyNum(), _q.getText(), _p.getText(), _j.getText(), _w.getText(), null, null, _orderId.getText());
		ResultMessage message = bl.repertoryAdjust(data);
		if(!message.isPass()){
			 printMessage(message.getMessage(), Color.RED);
		}
		else{
			printMessage(message.getMessage(), Color.GREEN);
		}
	
	}
	//不知道对不对
	private void _refresh() {
		// TODO 自动生成的方法存根
		clear();
		initComponent();
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
