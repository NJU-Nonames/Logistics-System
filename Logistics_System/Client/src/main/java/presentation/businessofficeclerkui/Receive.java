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

import businesslogicservice.logisticsblservice.DeliverAndReceiveBLService;
import presentation.centerclerkui.CenterClerkFrame;
import presentation.img.Img;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.GoodsState;
import utility.ResultMessage;
import vo.GoodsInfoVO;
import vo.HallArrivalListVO;
import vo.TransArrivalVO;

/**
 * @author 谭期友
 *
 */
public class Receive extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private DeliverAndReceiveBLService bl;
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
	private MyButton show;
	private MyButton update;
	private MyButton confirm;
	private MyButton cancel;
	private JRadioButton j1 ;
	private JRadioButton j2 ;
	private JRadioButton j3 ;
	
	private JLabel receiveId;
	private JLabel placeName;
	private JTextField _loadId = new JTextField();
	//详细操作按钮以及其他组件

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
    private String departureplace;
	private Color co;//消息的颜色
	
	private DefaultTableModel orderTableModel;
	private JTable orderTable;

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
	
	public Receive(BusinessOfficeClerkFrame frame, DeliverAndReceiveBLService bl, CurrentUser currentUser){
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
        min = new MyButton(30, 30,Img.MINI_0, Img.MINI_1, Img.MINI_2);
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
        goto_Receive = new MyButton(frame.getWidth()/6, 30, Img.GORECEIVE_2, Img.GORECEIVE_2,Img.GORECEIVE_2);
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
        goto_Deliver = new MyButton(frame.getWidth()/6, 30,Img.GODELIVER_0, Img.GODELIVER_1, Img.GODELIVER_2);
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
        goto_CheckList = new MyButton(frame.getWidth()/6, 30,Img.GOGETMONEY_0, Img.GOGETMONEY_1,Img.GOGETMONEY_2);
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
        goto_TruckManage = new MyButton(frame.getWidth()/6, 30, Img.GOTRUCK_0, Img.GOTRUCK_1, Img.GOTRUCK_2);
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
        goto_DriverManage = new MyButton(frame.getWidth()/6, 30, Img.GODRIVER_0, Img.GODRIVER_1, Img.GODRIVER_2);
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
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLACK);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="接收";
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
    	
        receiveId = new JLabel("本中转接收单编号："+bl.createHallArrivalListId()); 
        receiveId.setSize((int)(16*("本中转接收单编号："+bl.createHallArrivalListId()).length()*1.07f), 16);
        receiveId.setFont(new Font("宋体", Font.BOLD, 15));
        receiveId.setLocation(BusinessOfficeClerkFrame.w/6+20,128+55);
        
        JLabel loadId = new JLabel("装车单编号：");
        loadId.setSize((int)(16*"装车单编号：".length()*1.07f), 16);
        loadId.setFont(new Font("宋体", Font.BOLD, 15));
        loadId.setLocation(receiveId.getX(),128+110);
        
        _loadId.setSize((int)(170*1.07f), 20);
        _loadId.setLocation(loadId.getX()+loadId.getWidth(),loadId.getY());
        
        show=new MyButton(90, 30, Img.CONFIRM_0, Img.CONFIRM_1, Img.CONFIRM_2);
        show.setLocation(_loadId.getX()+_loadId.getWidth()+50,_loadId.getY()-6);
    	show.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_show();
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
     	jp.setLocation(CenterClerkFrame.w/6+20-50, loadId.getY()+loadId.getHeight()+80);
     	jp.setOpaque(false);
     	jp.add(scrollPane,BorderLayout.CENTER);
    	
     	JLabel pkgState = new JLabel("货物到达状态："); 
    	pkgState.setSize((int)(180*1.07f), 16);
    	pkgState.setFont(new Font("宋体", Font.BOLD, 15));
    	pkgState.setLocation(jp.getX()+jp.getWidth()-20,jp.getY()+5);
		
    	j1 = new JRadioButton("完好",true);
        j2 = new JRadioButton("缺损",false);
        j3 = new JRadioButton("丢失",false);
        j1.setSize((int)(100*1.07f), 20);
        j1.setFont(new Font("宋体", Font.BOLD, 17));
        j1.setLocation(pkgState.getX(),pkgState.getY()+pkgState.getHeight()+60);
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
        
        update=new MyButton(90, 30, Img.UPDATE_0, Img.UPDATE_1, Img.UPDATE_2);
        update.setLocation(j3.getX()+j3.getWidth()/5-30,j3.getY()+j3.getHeight()+20);
        update.addMouseListener(new MouseListener(){
 			public void mouseClicked(MouseEvent arg0) {
 				_update();
 			}
			public void mouseEntered(MouseEvent arg0) {}
 			public void mouseExited(MouseEvent arg0) {}
 			public void mousePressed(MouseEvent arg0) {}
 			public void mouseReleased(MouseEvent arg0) {}
         });
        
        placeName=new JLabel("货物出发地：");
        placeName.setSize((int)(16*20*1.07f), 16);
        placeName.setFont(new Font("宋体", Font.BOLD, 15));
        placeName.setLocation(CenterClerkFrame.w/6+20,128+170);
        
        confirm=new MyButton(90, 30, Img.CONFIRM_0, Img.CONFIRM_1, Img.CONFIRM_2);
        confirm.setLocation(CenterClerkFrame.w/2-50,CenterClerkFrame.w/3*2-50);
    	confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	
    	cancel=new MyButton(90, 30, Img.CANCEL_0, Img.CANCEL_1, Img.CANCEL_2);
    	cancel.setLocation(CenterClerkFrame.w/3*2-50,confirm.getY());
     	cancel.addMouseListener(new MouseListener(){
 			public void mouseClicked(MouseEvent arg0) {
 				_cancel();
 			}
 			public void mouseEntered(MouseEvent arg0) {}
 			public void mouseExited(MouseEvent arg0) {}
 			public void mousePressed(MouseEvent arg0) {}
 			public void mouseReleased(MouseEvent arg0) {}
         });
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


		
		
		
        add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        add(receiveId);
        add(loadId);
        add(_loadId);
        add(j1);
    	add(j2);
    	add(j3);
    	add(pkgState);
    	add(update);
    	add(placeName);
    	add(confirm);
    	add(cancel);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_LoadManage);
    	add(goto_Receive);
    	add(goto_Deliver);
    	add(goto_CheckList);
    	add(goto_TruckManage);
    	add(goto_DriverManage);
    	add(show);
    	
    	add(jp);
	}
	private TableColumnModel getColumnModel(JTable orderTable, int[] width) {
		TableColumnModel columns = orderTable.getColumnModel();  
		 for (int i = 0; i < width.length; i++) {  
			 TableColumn column = columns.getColumn(i);  
		     column.setPreferredWidth(width[i]);  
		 }  
		 return columns;
	}

	private void clear(){
		_loadId.setText("");
		
		j1.setSelected(true);
		j2.setSelected(false);
		j3.setSelected(false);
		
		while(orderTable.getRowCount()!=0)
			orderTableModel.removeRow(0);
		
        receiveId.setText("装车单编号："+bl.createHallArrivalListId()); 
        placeName.setText("货物出发地：");
		willprintMessage=false;
		willprintMessage=false;
		repaint();
	}
	
	private void _show() {
		TransArrivalVO vo = null;
		if(_loadId.getText().compareTo("")!=0){
			vo=bl.getLoadList(_loadId.getText());
			if(vo!=null){
				while(orderTableModel.getRowCount()!=0)//先清空原来的
					orderTableModel.removeRow(0);
				for(int i=0;i<vo.barcodes.size();i++){
					Vector<String> v = new Vector<String>();
					v.add(vo.barcodes.get(i));
					v.add("");
					orderTableModel.addRow(v);
				}
				System.out.println(vo.depatureplace);
				placeName.setText("货物出发地："+vo.depatureplace);
			}
			else{
				printMessage("未找到装车单！", Color.RED);
			}
		}
		else{
			printMessage("未输入装车单编号！", Color.RED);
		}
		departureplace=vo.depatureplace;
	}
	private void _update() {

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
		orderTable.setValueAt(s, index, 1);
		j1.setSelected(true);
		j2.setSelected(false);
		j3.setSelected(false);
	}
	private void _confirm(){
		String id=bl.createHallArrivalListId();
		
		String loadNumber=_loadId.getText();
		
		String time="";
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=format.format(date_);
		
		ArrayList<GoodsInfoVO> GoodsInfoVOs =new ArrayList<GoodsInfoVO>();
		for(int i=0;i<orderTable.getRowCount();i++){
			String barcode=orderTable.getValueAt(i, 0)+"";
			
			GoodsState state = GoodsState.COMPLETE;
			if(((String)orderTable.getValueAt(i, 1)).compareTo("缺损")==0){
				state=GoodsState.BREAK;
			}
			else if(((String)orderTable.getValueAt(i, 1)).compareTo("丢失")==0){
				state=GoodsState.LOST;
			}
			
			GoodsInfoVOs.add(new GoodsInfoVO(barcode, state));
		}
				
		if(loadNumber.compareTo("")==0||GoodsInfoVOs.size()==0){
			printMessage("信息录入不完整！", Color.RED);
			return;
		}
		
		ResultMessage message = bl.createHallArrivalList(new HallArrivalListVO(id, time, loadNumber, departureplace, GoodsInfoVOs, CheckType.UNDERCHECK));
		clear();
		printMessage(message.getMessage(), Color.GREEN);
	}
	private void _cancel(){
		clear();
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
