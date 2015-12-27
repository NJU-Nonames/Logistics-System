/**
 * 2015年11月19日
 *author:
 *description:
 */
package presentation.centerclerkui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.DateFormat;
import java.text.NumberFormat;
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

import businesslogic.logisticsbl.TransShipmentBLImpl;
import businesslogicservice.logisticsblservice.TransShipmentBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.ResultMessage;
import vo.OrderListVO;
import vo.TransShipmentListVO;

/**
 * @author 谭期友
 *
 */
public class TransShipment extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private TransShipmentBLService bl;
	private CenterClerkFrame frame;
	private CurrentUser currentUser;
	
	//最基本按钮
	private MyButton close;
	private MyButton min;
	private MyButton _return;
	//功能按钮
	private JLabel shipId;
	private MyButton goto_TransferCenterReceive;
	private MyButton goto_TransShipment;
	private MyButton goto_InputRepertory;
	private MyButton goto_LoadManage;
	private MyButton add;
	private MyButton remove;
	private MyButton confirm;
	private MyButton cancel;
	private JRadioButton _plane;
	private JRadioButton _trains;
	private  JRadioButton _trucks;
	private JTextField _transId=new JTextField() ;
	private JTextField _arrivePlace=new JTextField() ;
	private JTextField _counterId=new JTextField() ;
	private JTextField _supervisor=new JTextField() ;
	private JTextField barCode=new JTextField();
	private JTextField _price=new JTextField();
	
	private DefaultTableModel barCodeTableModel;
	private JTable barCodeTable;
	//详细操作按钮以及其他组件=

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色


	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawImage(Img.BACKGROUND2, CenterClerkFrame.w/6, CenterClerkFrame.h/6, CenterClerkFrame.w, CenterClerkFrame.h, null);
        g.drawImage(Img.BACKGROUND1, CenterClerkFrame.w/6, 0, CenterClerkFrame.w, CenterClerkFrame.h/6, null);
        g.drawImage(Img.BACKGROUND0, 0, 0, CenterClerkFrame.w/6, CenterClerkFrame.h, null);
        g.drawLine(CenterClerkFrame.w/6-1, 0, CenterClerkFrame.w/6-1, CenterClerkFrame.h);
        g.drawLine(CenterClerkFrame.w/6, 0, CenterClerkFrame.w/6, CenterClerkFrame.h);
        g.drawLine(CenterClerkFrame.w/6+1, 0, CenterClerkFrame.w/6+1, CenterClerkFrame.h);
        g.drawLine(CenterClerkFrame.w/6, CenterClerkFrame.h/6, CenterClerkFrame.w, CenterClerkFrame.h/6);
        g.drawLine(CenterClerkFrame.w/6, CenterClerkFrame.h/6+1, CenterClerkFrame.w, CenterClerkFrame.h/6+1);
       
        
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+168, CenterClerkFrame.w-100, CenterClerkFrame.h/6+168);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+218, CenterClerkFrame.w-100, CenterClerkFrame.h/6+218);
        g.drawLine(CenterClerkFrame.w/6+100, CenterClerkFrame.h/6+268, CenterClerkFrame.w-100, CenterClerkFrame.h/6+268);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, CenterClerkFrame.h-50, CenterClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+CenterClerkFrame.w/2, 13+CenterClerkFrame.h-30);
        }
	}
	
	public TransShipment(CenterClerkFrame frame, CurrentUser currentUser){
		this.frame=frame;
		this.bl=new TransShipmentBLImpl(currentUser);
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
        goto_TransferCenterReceive = new MyButton(frame.getWidth()/6, 30, Img.GOZHONGZHUAN_0, Img.GOZHONGZHUAN_1, Img.GOZHONGZHUAN_2);
        goto_TransferCenterReceive.addMouseListener(new MouseListener(){
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
        goto_TransShipment = new MyButton(frame.getWidth()/6, 30, Img.GOZHUANGYUN_2, Img.GOZHUANGYUN_2, Img.GOZHUANGYUN_2);
        goto_TransShipment.addMouseListener(new MouseListener(){
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
        goto_InputRepertory = new MyButton(frame.getWidth()/6, 30, Img.GORUKU_0, Img.GORUKU_1, Img.GORUKU_2);
        goto_InputRepertory.addMouseListener(new MouseListener(){
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
        
        goto_LoadManage=new MyButton(frame.getWidth()/6, 30, Img.GOLOAD_0, Img.GOLOAD_1, Img.GOLOAD_2);
        goto_LoadManage.addMouseListener(new MouseListener(){
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
        add = new MyButton(90, 30, Img.ADD_0, Img.ADD_1, Img.ADD_2);
    	add.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_add();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	add.setLocation(CenterClerkFrame.w/6+265+50,CenterClerkFrame.h/6+278);
    	remove = new MyButton(90, 30, Img.DELETE_0, Img.DELETE_1, Img.DELETE_2);
    	remove.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_remove();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	remove.setLocation(CenterClerkFrame.w/6+20+190,CenterClerkFrame.h/6+308+150+10);
    	
    	confirm=new MyButton(90, 30, Img.CONFIRM_0, Img.CONFIRM_1, Img.CONFIRM_2);
        confirm.setLocation(CenterClerkFrame.w/2-50,remove.getY()+remove.getHeight()+50);
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
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="装运管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.DARK_GRAY);
        currentuserAgencyNameLabel.setLocation(170,128-30);
        
        String s="中转中心业务员";
        JLabel currentuserLabel = new JLabel(s);
        currentuserLabel.setSize((int)(30*s.length()*1.07f), 30);
        currentuserLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f),128-30);
        
        JLabel currentusernameLabel = new JLabel(currentUser.getname());
        currentusernameLabel.setSize((int)(30*currentUser.getname().length()*1.07f), 30);
        currentusernameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentusernameLabel.setForeground(Color.DARK_GRAY);
        currentusernameLabel.setLocation(170+(int)(30*currentUser.getAgencyName().length()*1.07f)+(int)(30*s.length()*1.07f),128-30);
       
        JLabel transWays=new JLabel("装运方式:");
        transWays.setSize((int)(16*"装运方式:".length()*1.07f), 16);
        transWays.setFont(new Font("宋体", Font.BOLD, 15));
        transWays.setLocation(CenterClerkFrame.w/6+20,128+100);
        
        shipId=new JLabel("本中转单编号："+bl.createTransShipmentListId());
        shipId.setSize((int)(16*("本中转单编号："+bl.createTransShipmentListId()).length()*1.07f), 16);
        shipId.setFont(new Font("宋体", Font.BOLD, 15));
        shipId.setLocation(CenterClerkFrame.w/6+20,128+60);
        
        JLabel transId=new JLabel("运输编号: ");
        transId.setSize((int)(16*"运输编号： ".length()*1.07f), 16);
        transId.setFont(new Font("宋体", Font.BOLD, 15));
        transId.setLocation(CenterClerkFrame.w/6+20,128+140);
        
        String _tip1="提示：请在此输入相应的运输编号，如航运则输入航运编号";
        JLabel tip1=new JLabel(_tip1);
        tip1.setSize((int)(16*_tip1.length()*1.07f), 16);
        tip1.setFont(new Font("宋体", Font.BOLD, 15));
        tip1.setForeground(Color.RED);
        tip1.setLocation(CenterClerkFrame.w-tip1.getWidth(),128+140);
        
        String _departPlace="出发地:"+currentUser.getAgencyName();
        JLabel departPlace=new JLabel(_departPlace);
        departPlace.setSize((int)(16*_departPlace.length()*1.07f), 16);
        departPlace.setFont(new Font("宋体", Font.BOLD, 15));
        departPlace.setLocation(CenterClerkFrame.w/6+20,128+188);
        
        JLabel arrivePlace = new JLabel("到达地：");
        arrivePlace.setSize((int)(16*"到达地：".length()*1.07f), 16);
        arrivePlace.setFont(new Font("宋体", Font.BOLD, 15));
        arrivePlace.setLocation(departPlace.getX()+departPlace.getWidth()+120,128+188);
        
        JLabel counterId = new JLabel("货柜号/车厢号：");
        counterId.setSize((int)(16*"货柜号/车厢号：".length()*1.07f), 16);
        counterId.setFont(new Font("宋体", Font.BOLD, 15));
        counterId.setLocation(CenterClerkFrame.w/6+20,128+238);
        
        JLabel supervisor = new JLabel("监装员:");
        supervisor.setSize((int)(16*"监装员:".length()*1.07f), 16);
        supervisor.setFont(new Font("宋体", Font.BOLD, 15));
        supervisor.setLocation(arrivePlace.getX(),128+238);
        
        JLabel price = new JLabel("运费:");
        price.setSize((int)(16*"运费:".length()*1.07f), 16);
        price.setFont(new Font("宋体", Font.BOLD, 15));
        price.setLocation(CenterClerkFrame.w/6+20+400+80+30, CenterClerkFrame.h/6+308+58);
        
        //表头
      	Vector<String> vColumns = new Vector<String>();
      	vColumns.add("所包含的所有订单编号");
      
      	//数据
      	Vector<String> vData = new Vector<String>();
  		//模型
      	barCodeTableModel = new DefaultTableModel(vData, vColumns);
      	//表格
     	barCodeTable = new JTable(barCodeTableModel){
     		private static final long serialVersionUID = 1L;

     		public boolean isCellEditable(int row, int column){
     			return false;//不能修改
     		}
      	};
      	barCodeTable.setPreferredScrollableViewportSize(new Dimension(450,120));
      	barCodeTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
     	barCodeTable.setSelectionBackground(Color.YELLOW);
      	JPanel jp=new JPanel();
      	JScrollPane scrollPane = new JScrollPane();
      	scrollPane.getViewport().add(barCodeTable);
      	barCodeTable.setFillsViewportHeight(true);
      	jp.setSize(500, 150);
      	jp.setLocation(CenterClerkFrame.w/6+20, CenterClerkFrame.h/6+308);
      	jp.setOpaque(false);
      	jp.add(scrollPane,BorderLayout.CENTER);
      		
      		
        //最基本按钮
    	close.setLocation(CenterClerkFrame.w-30,0);
    	min.setLocation(CenterClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_InputRepertory.setLocation(0,250);
    	goto_TransferCenterReceive.setLocation(0,150);
    	goto_TransShipment.setLocation(0,200);
    	goto_LoadManage.setLocation(0,300);
    	//其他组件
        _plane=new JRadioButton("航运",true);
        _plane.setSize((int)(100*1.07f), 20);
        _plane.setFont(new Font("宋体", Font.BOLD, 17));
        _plane.setLocation(transWays.getX()+transWays.getWidth(),transWays.getY()-3);
        _plane.setOpaque(false);
        _trains=new JRadioButton("铁运",true);
        _trains.setSize((int)(100*1.07f), 20);
        _trains.setFont(new Font("宋体", Font.BOLD, 17));
        _trains.setLocation(_plane.getX()+_plane.getWidth(),transWays.getY()-3);
        _trains.setOpaque(false);
        _trucks=new JRadioButton("汽运",true);
        _trucks.setSize((int)(100*1.07f), 20);
        _trucks.setFont(new Font("宋体", Font.BOLD, 17));
        _trucks.setLocation(_trains.getX()+_trains.getWidth(),transWays.getY()-3);
        _trucks.setOpaque(false);
        
        ButtonGroup group1 = new ButtonGroup();
        group1.add(_plane);group1.add(_trains);group1.add(_trucks);
		
        _transId.setSize((int)(170*1.07f), 20);
        _transId.setLocation(transId.getX()+transId.getWidth(),transId.getY()-3);
		
        _arrivePlace.setSize((int)(210*1.07f), 20);
        _arrivePlace.setLocation(arrivePlace.getX()+arrivePlace.getWidth(),arrivePlace.getY()-3);
        
        _counterId.setSize((int)(120*1.07f), 20);
        _counterId.setLocation(counterId.getX()+counterId.getWidth(),counterId.getY()-3);
        
        _supervisor.setSize((int)(120*1.07f), 20);
        _supervisor.setLocation(supervisor.getX()+supervisor.getWidth(),supervisor.getY()-3);
        
        barCode.setSize(150, 20);
		barCode.setLocation(add.getX()-barCode.getWidth()-30,add.getY()+5);
        
		_price.setText("0");
		_price.setSize(80,20);
		_price.setLocation(price.getX()+price.getWidth(), price.getY());
        
		add(titleLabel);
        add(funLabel);
        add(currentuserAgencyNameLabel);
        add(currentuserLabel);
        add(currentusernameLabel);
        add(transWays);
        add(shipId);
        add(transId);
        add(tip1);
        add(departPlace);
        add(arrivePlace);
        add(counterId);
        add(supervisor);
        add(price);
        
        add(_plane);
        add(_trains);
        add(_trucks);
        
        add(_transId);
        add(_arrivePlace);
        add(_counterId);
        add(_supervisor);
        add(barCode);
        add(_price);
    	
    	add(close);
    	add(min);
    	add(_return);
    	add(goto_TransferCenterReceive);
    	add(goto_TransShipment);
    	add(goto_InputRepertory);
    	add(goto_LoadManage);
    	add(add);
    	add(remove);
    	add(confirm);
    	add(cancel);
    	
    	add(jp);
	}

	private void clear(){

		_plane.setSelected(true);
		_trains.setSelected(false);
		_trucks.setSelected(false);
		_transId.setText("");
		_arrivePlace.setText("");
		_counterId.setText("");
		_supervisor.setText("");
		barCode.setText("");
		_price.setText("0");
        shipId.setText("本中转单编号："+bl.createTransShipmentListId());
		while(barCodeTable.getRowCount()!=0)
			barCodeTableModel.removeRow(0);
		willprintMessage=false;
		repaint();
	}
	private void _add(){
		String barCode_s = barCode.getText();

		result = CheckFormat.checkOrderNum(barCode_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}		
		int i;
		String s;
		for(i=0;i<barCodeTable.getRowCount();i++){
			s=(String) barCodeTable.getValueAt(i, 0);
			if(s.compareTo(barCode_s)==0){
				printMessage("不能包含重复订单！", Color.RED);
				return;
			}
		}
		
		if(bl.createOrderFare(barCode_s)==0){
			printMessage("该订单不存在!",Color.red);
			return;
		}
		
		Vector<String> v = new Vector<String>();
		v.add(barCode_s);
		barCodeTableModel.addRow(v);
		_price.setText(Double.parseDouble(_price.getText())+bl.createOrderFare(barCode_s)+"");
		
		barCode.setText("");
	}
	
	private void _remove(){
		int index = barCodeTable.getSelectedRow();
		System.out.println(index);
		if(index == -1){
			printMessage("请选中一个订单！", Color.RED);
			return;
		}
		String barCode_s=(String) barCodeTable.getValueAt(index, 0);
		NumberFormat f=NumberFormat.getInstance();
		f.setMaximumFractionDigits(1);
		String price=f.format(Double.parseDouble(_price.getText())-bl.createOrderFare(barCode_s));
		_price.setText(price);
		barCodeTableModel.removeRow(index);
	}
	private void _confirm(){
		String time="";
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		time=format.format(date_);
		
		String transitDocNumber = bl.createTransShipmentListId();
		
		String flightNumber = _transId.getText();
		
		String departurePlace = currentUser.getAgencyName();
		
		String desitination = _arrivePlace.getText();
		
		String containerNumber =_counterId.getText();
		
		String supercargoMan = _supervisor.getText();
		
		ArrayList<String> barcodes = new ArrayList<String>();
		for(int i=0;i<barCodeTable.getRowCount();i++){
			barcodes.add(barCodeTable.getValueAt(i, 0)+"");		
		}
		
		String price = _price.getText();
		
		if(flightNumber.compareTo("")==0||desitination.compareTo("")==0
				||containerNumber.compareTo("")==0||supercargoMan.compareTo("")==0
				||barcodes.size()==0||price.compareTo("")==0){
			printMessage("信息录入不完整！", Color.RED);
			return;
		}
		else{
			TransShipmentListVO vo = new TransShipmentListVO(time, transitDocNumber, flightNumber, departurePlace, desitination, containerNumber, supercargoMan, barcodes,Double.parseDouble(price),CheckType.UNDERCHECK);
			ResultMessage message = bl.createShiplist(vo);
			clear();
			printMessage(message.getMessage(), Color.GREEN);
		}
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
