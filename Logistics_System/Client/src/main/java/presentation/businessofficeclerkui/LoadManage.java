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

import businesslogicservice.logisticsblservice.LoadBLService;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.ResultMessage;
import vo.DeliveringListVO;
import vo.LoadListVO;
import vo.OrderListVO;

/**
 * @author 谭期友
 *
 */
public class LoadManage extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private LoadBLService bl;
	private SearchPkgInformationBLService bl2;
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
	private MyButton confirm;

	private JTextField date;
	private JTextField hallNumber;
	private JTextField transpotationNumber;
	private JTextField Destination;
	private JTextField carNumber;
	private JTextField guardMan;
	private JTextField supercargoMan;
	private JTextField barCode;
	private DefaultTableModel barCodeTableModel;
	private JTable barCodeTable;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
        g.drawLine(BusinessOfficeClerkFrame.w/6, 10, BusinessOfficeClerkFrame.w/6, BusinessOfficeClerkFrame.h-10);
        g.drawLine(BusinessOfficeClerkFrame.w/6+10, BusinessOfficeClerkFrame.h/6, BusinessOfficeClerkFrame.w, BusinessOfficeClerkFrame.h/6);

        if(willprintMessage){
        	g.drawImage(Img.BLACK_BG, 0, BusinessOfficeClerkFrame.h-50, BusinessOfficeClerkFrame.w, 50, null);
        	
            g.setColor(co);
            g.setFont(new Font("宋体", Font.BOLD, 26));
            g.drawString(result, -result.length()*13+BusinessOfficeClerkFrame.w/2, 13+BusinessOfficeClerkFrame.h-30);
        }
	}
	
	public LoadManage(BusinessOfficeClerkFrame frame, LoadBLService bl, SearchPkgInformationBLService bl2, CurrentUser currentUser){
		this.frame=frame;
		this.bl=bl;
		this.bl2=bl2;
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
        goto_LoadManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_Receive = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_Deliver = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_CheckList = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_TruckManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
        goto_DriverManage = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
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
    	add = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	add.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_add();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	add.setLocation(170+20+330,128+80+40+40+40+40+120-7);
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
    	remove.setLocation(596+220,128+80+40+40+40+40-7);
    	confirm = new MyButton(30, 30, Img.CLOSE_0, Img.CLOSE_1, Img.CLOSE_2);
    	confirm.addMouseListener(new MouseListener(){
			public void mouseClicked(MouseEvent arg0) {
				_confirm();
			}
			public void mouseEntered(MouseEvent arg0) {}
			public void mouseExited(MouseEvent arg0) {}
			public void mousePressed(MouseEvent arg0) {}
			public void mouseReleased(MouseEvent arg0) {}
        });
    	confirm.setLocation(596-15,128+80+40+40+40+160+50);
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="车辆装车管理";
        JLabel funLabel = new JLabel(func);
        funLabel.setSize((int)(40*func.length()*1.07f), 40);
        funLabel.setFont(new Font("宋体", Font.BOLD, 40));
        funLabel.setLocation(596-(int)(40*func.length()*1.07f)/2,128+10);

        JLabel currentuserAgencyNameLabel = new JLabel(currentUser.getAgencyName());
        currentuserAgencyNameLabel.setSize((int)(30*currentUser.getAgencyName().length()*1.07f), 30);
        currentuserAgencyNameLabel.setFont(new Font("宋体", Font.BOLD, 30));
        currentuserAgencyNameLabel.setForeground(Color.RED);
        currentuserAgencyNameLabel.setLocation(170,128-30);

        String s="营业厅业务员";
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
    	close.setLocation(BusinessOfficeClerkFrame.w-30,0);
    	min.setLocation(BusinessOfficeClerkFrame.w-80,0);
    	_return.setLocation(20,50);
    	//功能按钮
    	goto_LoadManage.setLocation(20,150);
    	goto_Receive.setLocation(20,200);
    	goto_Deliver.setLocation(20,250);
    	goto_CheckList.setLocation(20,300);
    	goto_TruckManage.setLocation(20,350);
    	goto_DriverManage.setLocation(20,400);
    	
    	//其他组件
		JLabel l5 = new JLabel("装车日期：");
		l5.setSize((int)(16*5*1.07f), 16);
		l5.setFont(new Font("宋体", Font.BOLD, 15));
		l5.setLocation(170+20, 128+80);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd");
		String time=format.format(date_);
		date = new JTextField(time);
		date.setSize(150, 20);
		date.setLocation(170+20+(int)(16*7*1.07f),128+80-3);

		JLabel l3 = new JLabel("本营业厅编号：");
		l3.setSize((int)(16*7*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(170+20, 128+80+40);
		hallNumber = new JTextField(currentUser.getAgencyNum());
		hallNumber.setSize(150, 20);
		hallNumber.setLocation(170+20+(int)(16*7*1.07f),128+80+40-3);

		JLabel l4 = new JLabel("汽运编号：");
		l4.setSize((int)(16*5*1.07f), 16);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(170+20, 128+80+40+40);
		transpotationNumber = new JTextField();
		transpotationNumber.setSize(150, 20);
		transpotationNumber.setLocation(170+20+(int)(16*7*1.07f),128+80+40+40-3);

		JLabel l6 = new JLabel("到达地：");
		l6.setSize((int)(16*4*1.07f), 16);
		l6.setFont(new Font("宋体", Font.BOLD, 15));
		l6.setLocation(170+20, 128+80+40+40+40);
		Destination = new JTextField();
		Destination.setSize(150, 20);
		Destination.setLocation(170+20+(int)(16*7*1.07f),128+80+40+40+40-3);
		
		JLabel l9 = new JLabel("车辆代号：");
		l9.setSize((int)(16*5*1.07f), 16);
		l9.setFont(new Font("宋体", Font.BOLD, 15));
		l9.setLocation(170+20, 128+80+40+40+40+40);
		carNumber = new JTextField();
		carNumber.setSize(150, 20);
		carNumber.setLocation(170+20+(int)(16*7*1.07f),128+80+40+40+40+40-3);
		
		JLabel l10 = new JLabel("监装员：");
		l10.setSize((int)(16*4*1.07f), 16);
		l10.setFont(new Font("宋体", Font.BOLD, 15));
		l10.setLocation(170+20, 128+80+40+40+40+80);
		guardMan = new JTextField();
		guardMan.setSize(150, 20);
		guardMan.setLocation(170+20+(int)(16*7*1.07f),128+80+40+40+40+80-3);
		
		JLabel l11 = new JLabel("押运员：");
		l11.setSize((int)(16*4*1.07f), 16);
		l11.setFont(new Font("宋体", Font.BOLD, 15));
		l11.setLocation(170+20, 128+80+40+40+40+120);
		supercargoMan = new JTextField();
		supercargoMan.setSize(150, 20);
		supercargoMan.setLocation(170+20+(int)(16*7*1.07f),128+80+40+40+40+120-3);
		
		JLabel l7 = new JLabel("订单条形码：");
		l7.setSize((int)(16*6*1.07f), 16);
		l7.setFont(new Font("宋体", Font.BOLD, 15));
		l7.setLocation(170+20, 128+80+40+40+40+40+120);
		barCode = new JTextField();
		barCode.setSize(150, 20);
		barCode.setLocation(170+20+(int)(16*7*1.07f),128+80+40+40+40+40+120-3);
		

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
		barCodeTable.setPreferredScrollableViewportSize(new Dimension(380,120));
		barCodeTable.getSelectionModel().setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		barCodeTable.setSelectionBackground(Color.YELLOW);
		JPanel jp=new JPanel();
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.getViewport().add(barCodeTable);
		barCodeTable.setFillsViewportHeight(true);
		jp.setSize(400, 150);
		jp.setLocation(596+20, 128+80);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);


		JLabel l8 = new JLabel("生成装车单：");
		l8.setSize((int)(16*9*1.07f), 16);
		l8.setFont(new Font("宋体", Font.BOLD, 15));
		l8.setLocation(596-250,128+80+40+40+40+160+50+7);
        

		
		
		
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

    	add(l5);
    	add(date);
    	add(l3);
    	add(hallNumber);
    	add(l4);
    	add(transpotationNumber);
    	add(l6);
    	add(Destination);
    	add(l9);
    	add(carNumber);
    	add(l10);
    	add(guardMan);
    	add(l11);
    	add(supercargoMan);
    	add(l7);
    	add(barCode);
    	
    	add(jp);
    	add(l8);

		add(add);
		add(remove);
		add(confirm);
	}

	private void _add(){
		String barCode_s = barCode.getText();

		result = CheckFormat.checkOrderNum(barCode_s);
		if(result.compareTo("格式正确")!=0){
			printMessage(result, Color.RED);
			return;
		}
		
		OrderListVO orderListVO = bl2.searchPkgInformation(barCode_s);
		if(orderListVO==null){
			printMessage("此订单不存在！", Color.RED);
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
		
		
		Vector<String> v = new Vector<String>();
		v.add(barCode_s);
		barCodeTableModel.addRow(v);
		
		barCode.setText("");
	}
	private void _remove(){
		int index = barCodeTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个订单！", Color.RED);
			return;
		}
		barCodeTableModel.removeRow(index);
	}
	private void _confirm(){
		String date_s = date.getText();
		String hallNumber_s = hallNumber.getText();
		String transpotationNumber_s = transpotationNumber.getText();
		String Destination_s = Destination.getText();
		String carNumber_s = carNumber.getText();
		String guardMan_s = guardMan.getText();
		String supercargoMan_s = supercargoMan.getText();

		if(CheckFormat.checkTime(date_s).compareTo("格式正确")!=0){
			printMessage(CheckFormat.checkTime(date_s), Color.RED);
			return;
		}
		if(CheckFormat.checkHallNum(hallNumber_s).compareTo("格式正确")!=0){
			printMessage(CheckFormat.checkHallNum(hallNumber_s), Color.RED);
			return;
		}
		if(CheckFormat.checkTruckTransNum(transpotationNumber_s).compareTo("格式正确")!=0){
			printMessage(CheckFormat.checkTruckTransNum(transpotationNumber_s), Color.RED);
			return;
		}
		if(Destination_s.compareTo("")==0){
			printMessage("没有输入到达地！", Color.RED);
			return;
		}
		if(carNumber_s.compareTo("")==0){
			printMessage("没有输入车辆代号！", Color.RED);
			return;
		}
		if(guardMan_s.compareTo("")==0){
			printMessage("没有输入监装员！", Color.RED);
			return;
		}
		if(supercargoMan_s.compareTo("")==0){
			printMessage("没有输入押运员！", Color.RED);
			return;
		}
		if(barCodeTable.getRowCount()==0){
			printMessage("未包含订单！", Color.RED);
			return;
		}
		
		ArrayList<String> _barcodes=new ArrayList<String>();
		for(int i=0;i<barCodeTable.getRowCount();i++){
			String s=(String) barCodeTable.getValueAt(i, 0)+"";
			_barcodes.add(s);
		}
		
		LoadListVO loadListVO = new LoadListVO("?", date_s, hallNumber_s, transpotationNumber_s, Destination_s, carNumber_s, guardMan_s, supercargoMan_s, _barcodes, CheckType.UNDERCHECK);
		ResultMessage resultMessage = bl.createLoadlist(loadListVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.BLUE);
		}

		transpotationNumber.setText("");
		Destination.setText("");
		carNumber.setText("");
		guardMan.setText("");
		supercargoMan.setText("");
		barCode.setText("");
		while(barCodeTable.getRowCount()!=0)
			barCodeTableModel.removeRow(0);
	}
	private void clear(){
		transpotationNumber.setText("");
		Destination.setText("");
		carNumber.setText("");
		guardMan.setText("");
		supercargoMan.setText("");
		barCode.setText("");
		while(barCodeTable.getRowCount()!=0)
			barCodeTableModel.removeRow(0);
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
