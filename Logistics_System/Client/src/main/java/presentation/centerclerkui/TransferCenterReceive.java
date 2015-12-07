/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.centerclerkui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
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

import javax.swing.ButtonGroup;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

import businesslogic.logisticsbl.TransferCenterReceiveBLImpl;
import businesslogicservice.logisticsblservice.TransferCenterReceiveBLService;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.GoodsState;
import utility.ResultMessage;
import vo.GoodsInfoVO;
import vo.TransArrivalListVO;
import vo.TransArrivalVO;

/**
 * @author 谭期友
 *
 */
public class TransferCenterReceive extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private static final Component recieveId = null;
	private TransferCenterReceiveBLService bl;
	private CenterClerkFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private MyButton goto_TransferCenterReceive;
	private MyButton goto_TransShipment;
	private MyButton goto_InputRepertory;
	private MyButton goto_LoadManage;
	//详细操作按钮以及其他组件

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色
	
	private JLabel receiveId;
	private JLabel placeName;
	private JTextField id1=new JTextField();
	private JTextField id2=new JTextField();
	private JRadioButton jb1 ;
	private JRadioButton jb2 ;
	private JRadioButton j1 ;
	private JRadioButton j2 ;
	private JRadioButton j3 ;
	
	private MyButton show;
	private MyButton update;
	private MyButton confirm;
	private MyButton cancel;
	
	private DefaultTableModel orderTableModel;
	private JTable orderTable;
	
	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(CenterClerkFrame.w/6, 10, CenterClerkFrame.w/6, CenterClerkFrame.h-10);
        g.drawLine(CenterClerkFrame.w/6+10, CenterClerkFrame.h/6, CenterClerkFrame.w, CenterClerkFrame.h/6);        
        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CenterClerkFrame.h-50, CenterClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CenterClerkFrame.w/2, 13+CenterClerkFrame.h-30);
        }
	}
	
	public TransferCenterReceive(CenterClerkFrame frame, CurrentUser currentUser){
		this.frame=frame;
		this.currentUser=currentUser;
		this.bl=new TransferCenterReceiveBLImpl(this.currentUser);
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
        goto_TransferCenterReceive = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_TransferCenterReceive.addMouseListener(new MouseListener(){
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
        goto_TransShipment = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_TransShipment.addMouseListener(new MouseListener(){
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
        goto_InputRepertory = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_InputRepertory.addMouseListener(new MouseListener(){
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
        goto_LoadManage=new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        goto_LoadManage.addMouseListener(new MouseListener(){
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

        String func="中转接收";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.RED);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="中转中心业务员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.RED);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
        

        
        jb1 = new JRadioButton("货物中转单号：",true);
        jb2 = new JRadioButton("货物装车单号：",false);
        jb1.setSize((int)(170*1.07f), 20);
        jb1.setFont(new Font("宋体", Font.BOLD, 17));
        jb1.setLocation(CenterClerkFrame.w/6+20,128+100);
        jb1.setOpaque(false);
        jb2.setSize((int)(170*1.07f), 20);
        jb2.setFont(new Font("宋体", Font.BOLD, 17));
        jb2.setLocation(CenterClerkFrame.w/6+20,128+150);
        jb2.setOpaque(false);
        ButtonGroup group = new ButtonGroup();
        group.add(jb1);group.add(jb2);
        jb1.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				id1.setEditable(true);
				id2.setText("");
				id2.setEditable(false);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        jb2.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				id2.setEditable(true);
				id1.setText("");
				id1.setEditable(false);
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        
        id1.setSize((int)(170*1.07f), 20);
        id1.setLocation(jb1.getX()+jb1.getWidth(),128+100);
        
        id2.setSize((int)(170*1.07f), 20);
        id2.setLocation(jb2.getX()+jb2.getWidth(),128+150);
        
        
        
        show=new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        show.setLocation(id1.getX()+id1.getWidth()+80,id1.getY()+id1.getHeight());
    	show.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_show();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
        
        confirm=new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        confirm.setLocation(CenterClerkFrame.w/2,CenterClerkFrame.w/3*2-50);
    	confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	
    	cancel=new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	cancel.setLocation(CenterClerkFrame.w/3*2,confirm.getY());
     	cancel.addMouseListener(new MouseListener(){
 			public void mouseClicked(MouseEvent arg0) {
 				_cancel();
 			}
 			public void mouseEntered(MouseEvent arg0) {}
 			public void mouseExited(MouseEvent arg0) {}
 			public void mousePressed(MouseEvent arg0) {}
 			public void mouseReleased(MouseEvent arg0) {}
         });
     	
     	 Vector<String> vColumns = new Vector<String>();
     	 vColumns.add("订单编号");
     	 vColumns.add("货物状态");
     	 Vector<String> vData = new Vector<String>();
      	 orderTableModel = new DefaultTableModel(vData, vColumns);
      	 orderTable = new JTable(orderTableModel){
     		private static final long serialVersionUID = 1L;

     		public boolean isCellEditable(int row, int column){
     			return false;//不能修改
     		}
      	};
      	orderTable.setPreferredScrollableViewportSize(new Dimension(600,250));
      	orderTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
      	orderTable.setSelectionBackground(Color.YELLOW);
      	JPanel jp=new JPanel();
      	JScrollPane scrollPane = new JScrollPane();
      	scrollPane.getViewport().add(orderTable);
      	orderTable.setFillsViewportHeight(true);
      	int[] width={350,150};
      	orderTable.setColumnModel(getColumnModel(orderTable,width));
      	orderTable.getTableHeader().setReorderingAllowed(false);
      	orderTable.getTableHeader().setResizingAllowed(false);
      	jp.setSize(700, 300);
      	jp.setLocation(CenterClerkFrame.w/6+20-50, jb2.getY()+jb2.getHeight()+10);
      	jp.setOpaque(false);
      	jp.add(scrollPane,BorderLayout.CENTER);
      	
      	JLabel placeName = new JLabel("货物出发地："); 
      	placeName.setSize((int)(350*1.07f), 16);
      	placeName.setFont(new Font("宋体", Font.BOLD, 15));
      	placeName.setLocation(jp.getX()+50,jp.getY()+jp.getHeight()+5);
    	
      	JLabel pkgState = new JLabel("货物到达状态："); 
    	pkgState.setSize((int)(180*1.07f), 16);
    	pkgState.setFont(new Font("宋体", Font.BOLD, 15));
    	pkgState.setLocation(jp.getX()+jp.getWidth()-20,jp.getY()+5);
		
    	j1 = new JRadioButton("完好",true);
        j2 = new JRadioButton("缺损",false);
        j3 = new JRadioButton("丢失",false);
        j1.setSize((int)(100*1.07f), 20);
        j1.setFont(new Font("宋体", Font.BOLD, 17));
        j1.setLocation(pkgState.getX(),pkgState.getY()+pkgState.getHeight()+10);
        j1.setOpaque(false);
        j2.setSize((int)(100*1.07f), 20);
        j2.setFont(new Font("宋体", Font.BOLD, 17));
        j2.setLocation(j1.getX(),j1.getY()+j1.getHeight()+10);
        j2.setOpaque(false);
        j3.setSize((int)(100*1.07f), 20);
        j3.setFont(new Font("宋体", Font.BOLD, 17));
        j3.setLocation(j2.getX(),j2.getY()+j2.getHeight()+10);
        j3.setOpaque(false);
        ButtonGroup group2 = new ButtonGroup();
        group2.add(j1);group2.add(j2);group2.add(j3);
        
        update=new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
        update.setLocation(j3.getX()+j3.getWidth()/5,j3.getY()+j3.getHeight()+20);
        update.addMouseListener(new MouseListener(){
 			public void mouseClicked(MouseEvent arg0) {
 				_update();
 			}
			public void mouseEntered(MouseEvent arg0) {}
 			public void mouseExited(MouseEvent arg0) {}
 			public void mousePressed(MouseEvent arg0) {}
 			public void mouseReleased(MouseEvent arg0) {}
         });
        
        receiveId = new JLabel("本中转接收单编号："+bl.createTransArrivalListId()); 
        receiveId.setSize((int)(16*("本中转接收单编号："+bl.createTransArrivalListId()).length()*1.07f), 16);
        receiveId.setFont(new Font("宋体", Font.BOLD, 15));
        receiveId.setLocation(jp.getX()+50,128+55);
        //最基本按钮
    	close.setLocation(CenterClerkFrame.w-30,0);
    	min.setLocation(CenterClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_TransferCenterReceive.setLocation(20,150);
    	goto_TransShipment.setLocation(20,200);
    	goto_InputRepertory.setLocation(20,250);
    	goto_LoadManage.setLocation(20,300);
    	
    	//其他组件
        
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
    	add(receiveId);
    	add(placeName);
    
    	
    	add(jb1);
    	add(jb2);
    	add(j1);
    	add(j2);
    	add(j3);
    	add(id1);
    	add(id2);
    	add(pkgState);
    	add (confirm);
    	add (cancel);
    	add(show);
    	add(update);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_TransferCenterReceive);
    	add(goto_TransShipment);
    	add(goto_InputRepertory);
    	add(goto_LoadManage);

    	add(jp);
	}

	private TableColumnModel getColumnModel(JTable orderTable2, int[] width) {
		TableColumnModel columns = orderTable2.getColumnModel();  
		 for (int i = 0; i < width.length; i++) {  
			 TableColumn column = columns.getColumn(i);  
		     column.setPreferredWidth(width[i]);  
		 }  
		 return columns;
	}

	private void clear(){
		jb1.setSelected(true);
		id1.setEditable(true);
		id1.setText("");
		
		jb2.setSelected(false);
		id2.setEditable(false);
		id2.setText("");
		
		j1.setSelected(true);
		j2.setSelected(false);
		j3.setSelected(false);
		
		while(orderTable.getRowCount()!=0)
			orderTableModel.removeRow(0);
		
        receiveId.setText("本中转接收单编号："+bl.createTransArrivalListId()); 
        placeName.setText("货物出发地：");
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
	void _confirm(){
		String id=bl.createTransArrivalListId();
		
		String transferNumber=id1.getText()+id2.getText();
		
		String  centerNumber = currentUser.getAgencyNum();
		
		String time="";
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=format.format(date_);
		
		ArrayList<GoodsInfoVO> GoodsInfoVOs =new ArrayList<GoodsInfoVO>();
		for(int i=0;i<orderTable.getRowCount();i++){
			String barcode=orderTable.getValueAt(i, 0)+"";
			
			GoodsState state = GoodsState.COMPLETE;
			if(((String)orderTable.getValueAt(i, 2)).compareTo("缺损")==0){
				state=GoodsState.BREAK;
			}
			else if(((String)orderTable.getValueAt(i, 2)).compareTo("丢失")==0){
				state=GoodsState.LOST;
			}
			
			GoodsInfoVOs.add(new GoodsInfoVO(barcode, state));
		}
		
		String departurePlace = orderTable.getValueAt(0, 1)+"";
		
		if(transferNumber.compareTo("")==0||GoodsInfoVOs.size()==0){
			printMessage("信息录入不完整！", Color.RED);
			return;
		}
		
		TransArrivalListVO vo = new TransArrivalListVO(id, transferNumber, centerNumber, time, GoodsInfoVOs,departurePlace, CheckType.UNDERCHECK);
		ResultMessage message = bl.createTransArrivalList(vo);
		printMessage(message.getMessage(), Color.GREEN);
		clear();
	}
	void _cancel(){
		clear();
	}
	private void _show() {
		// TODO 自动生成的方法存根
		if(jb1.isSelected()){
			if(id1.getText().compareTo("")!=0){
				TransArrivalVO vo=bl.getTransShipmentList(id1.getText());
				if(vo!=null){
					while(orderTableModel.getRowCount()!=0)//先清空原来的
						orderTableModel.removeRow(0);
					for(int i=0;i<vo.barcodes.size();i++){
						Vector<String> v = new Vector<String>();
						v.add(vo.barcodes.get(i));
						v.add("");
						orderTableModel.addRow(v);
					}
				}
				else{
					printMessage("未找到中转单！", Color.RED);
					return;
				}
			}
			else{
				printMessage("未输入中转单编号！", Color.RED);
			}
		}
		else{
			if(id2.getText().compareTo("")!=0){
				TransArrivalVO vo=bl.getLoadList(id2.getText());
				if(vo!=null){
					while(orderTableModel.getRowCount()!=0)//先清空原来的
						orderTableModel.removeRow(0);
					for(int i=0;i<vo.barcodes.size();i++){
						Vector<String> v = new Vector<String>();
						v.add(vo.barcodes.get(i));
						v.add("");
						orderTableModel.addRow(v);
					}
					placeName.setText("货物出发地："+vo.depatureplace);
				}
				else{
					printMessage("未找到装车单！", Color.RED);
				}
			}
			else{
				printMessage("未输入装车单编号！", Color.RED);
			}
		}
	}
	private void _update() {
		// TODO 自动生成的方法存根
		int index = orderTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个订单！", Color.RED);
			return;
		}
		String s="";
		if(j1.isSelected()){
			s="完好";
		}
		else if(j2.isSelected()){
			s="缺损";
		}
		else{
			s="丢失";
		}
		orderTable.setValueAt(s, index, 2);
		j1.setSelected(true);
		j2.setSelected(false);
		j3.setSelected(false);
	}
}
