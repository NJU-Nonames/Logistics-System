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

import businesslogicservice.financeblservice.SettlementManageBLService;
import businesslogicservice.logisticsblservice.SearchPkgInformationBLService;
import presentation.img.Img;
import presentation.mainui.CheckFormat;
import presentation.mainui.CurrentUser;
import presentation.mainui.MainFrame;
import presentation.mainui.MyButton;
import utility.CheckType;
import utility.ResultMessage;
import vo.MoneyInListVO;
import vo.OrderListVO;

/**
 * @author 谭期友
 *
 */
public class CheckList extends JPanel{

	private static final long serialVersionUID = -1194559040892610991L;
	private SettlementManageBLService bl;
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
	private JTextField staffId;
	private JTextField barCode;
	private JTextField accountNum;
	private DefaultTableModel barCodeTableModel;
	private JTable barCodeTable;
	private JLabel moneySum;

	private boolean willprintMessage;//是否将要打印消息
	private String result;//打印的消息
	private Color co;//消息的颜色

	protected void paintComponent(Graphics g){
        super.paintComponent(g);
        setBackground(Color.WHITE);
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
	
	public CheckList(BusinessOfficeClerkFrame frame, SettlementManageBLService bl, SearchPkgInformationBLService bl2, CurrentUser currentUser){
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
    	add.setLocation(170+20+330,128+80+40+40-7);
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
    	confirm.setLocation(596-15,128+80+40+40+40+160);
    	
    	//最基本元素
        JLabel titleLabel = new JLabel("物流信息管理系统");
        titleLabel.setSize((int)(50*8*1.07f), 50);
        titleLabel.setFont(new Font("宋体", Font.BOLD, 50));
        titleLabel.setForeground(Color.BLUE);
        titleLabel.setLocation(596-(int)(50*8*1.07f)/2,20);

        String func="核对收款单";
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
    	
		JLabel l5 = new JLabel("收款日期：");
		l5.setSize((int)(16*6*1.07f), 16);
		l5.setFont(new Font("宋体", Font.BOLD, 15));
		l5.setLocation(170+20, 128+80);
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time=format.format(date_);
		date = new JTextField(time);
		date.setSize(150, 20);
		date.setLocation(170+20+(int)(16*7*1.07f),128+80-3);

		JLabel l3 = new JLabel("快递员工号：");
		l3.setSize((int)(16*7*1.07f), 16);
		l3.setFont(new Font("宋体", Font.BOLD, 15));
		l3.setLocation(170+20, 128+80+40);
		staffId = new JTextField();
		staffId.setSize(150, 20);
		staffId.setLocation(170+20+(int)(16*7*1.07f),128+80+40-3);
		
		JLabel l7 = new JLabel("订单条形码：");
		l7.setSize((int)(16*6*1.07f), 16);
		l7.setFont(new Font("宋体", Font.BOLD, 15));
		l7.setLocation(170+20, 128+80+40+40);
		barCode = new JTextField();
		barCode.setSize(150, 20);
		barCode.setLocation(170+20+(int)(16*7*1.07f),128+80+40+40-3);	
		
		JLabel accountNumLabel=new JLabel("收款账户");
        accountNumLabel.setSize((int)(30*4*1.07f),30);
        accountNumLabel.setFont(new Font("宋体",Font.BOLD,30));
        accountNumLabel.setLocation(120+80,120+80+40+40+40);
        accountNum=new JTextField();
        accountNum.setSize(150,20);
        accountNum.setLocation(170+20+(int)(16*7*1.07f),120+80+40+40+40-3);
         

		JLabel l4 = new JLabel("总额：");
		l4.setSize((int)(16*3*1.07f), 16);
		l4.setFont(new Font("宋体", Font.BOLD, 15));
		l4.setLocation(170+20, 128+80+40+40+40+40);
		moneySum = new JLabel(0+"元");
		moneySum.setSize((int)(16*8*1.07f), 16);
		moneySum.setFont(new Font("宋体", Font.BOLD, 15));
		moneySum.setForeground(Color.RED);
		moneySum.setLocation(170+20+(int)(16*3*1.07f), 128+80+40+40+40);
		

		//表头
		Vector<String> vColumns = new Vector<String>();
		vColumns.add("所包含的所有订单编号");
		vColumns.add("所收费用（元）");
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
		int[] width={100,100};
		barCodeTable.setColumnModel(getColumnModel(barCodeTable,width));
		barCodeTable.getTableHeader().setReorderingAllowed(false);
		barCodeTable.getTableHeader().setResizingAllowed(false);
		jp.setSize(400, 150);
		jp.setLocation(596+20, 128+80);
		jp.setOpaque(false);
		jp.add(scrollPane,BorderLayout.CENTER);


		JLabel l8 = new JLabel("生成收款单：");
		l8.setSize((int)(16*9*1.07f), 16);
		l8.setFont(new Font("宋体", Font.BOLD, 15));
		l8.setLocation(596-250,128+80+40+40+40+160+7);
        

		
		
		
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
    	add(accountNumLabel);
    	add(accountNum);
    	add(l3);
    	add(staffId);
    	add(l7);
    	add(barCode);
    	add(l4);
    	add(moneySum);
    	
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
		v.add(""+orderListVO.getPackPrice());
		barCodeTableModel.addRow(v);
		
		String moneySum_s=moneySum.getText();
		String moneySum_ss=moneySum_s.substring(0, moneySum_s.length()-1);
		double sum=Double.parseDouble(moneySum_ss);
		sum+=orderListVO.getPackPrice();
		String aa=new java.text.DecimalFormat("#.00").format(sum);
		moneySum.setText(aa+"元");
		
		barCode.setText("");
	}
	private void _remove(){
		int index = barCodeTable.getSelectedRow();
		if(index == -1){
			printMessage("请选中一个订单！", Color.RED);
			return;
		}
		
		String moneySum_s=moneySum.getText();
		String moneySum_ss=moneySum_s.substring(0, moneySum_s.length()-1);
		double sum=Double.parseDouble(moneySum_ss);
		String price=(String)barCodeTable.getValueAt(index, 1);
		System.out.println(price);
		sum-=Double.parseDouble(price);
		String aa=new java.text.DecimalFormat("#.00").format(sum);
		moneySum.setText(aa+"元");
		
		barCodeTableModel.removeRow(index);
		if(barCodeTable.getRowCount()==0){
			moneySum.setText(0+"元");
		}
	}
	private void _confirm(){
		String date_s = date.getText();
		String staffId_s = staffId.getText();
		String accountNum_s=accountNum.getText();

//		if(CheckFormat.checkTime(date_s).compareTo("格式正确")!=0){
//			printMessage(CheckFormat.checkTime(date_s), Color.RED);
//			return;
//		}
		if(staffId_s.compareTo("")==0){
			printMessage("没有输入快递员工号！", Color.RED);
			return;
		}
		if(barCodeTable.getRowCount()==0){
			printMessage("未包含订单！", Color.RED);
			return;
		}
		if(accountNum_s.compareTo("")==0){
			printMessage("没有输入收款的银行账号!", Color.red);
			return;
		}
		

		String moneySum_s=moneySum.getText();
		String moneySum_ss=moneySum_s.substring(0, moneySum_s.length()-1);
		double sum=Double.parseDouble(moneySum_ss);
		
		ArrayList<String> _barcodes=new ArrayList<String>();
		for(int i=0;i<barCodeTable.getRowCount();i++){
			String s=(String) barCodeTable.getValueAt(i, 0)+"";
			_barcodes.add(s);
		}
		
		MoneyInListVO moneyInListVO=new MoneyInListVO("?", date_s, sum, staffId_s, _barcodes,accountNum_s, CheckType.UNDERCHECK);
		ResultMessage resultMessage = bl.createMoneyInList(moneyInListVO);
		if(!resultMessage.isPass()){
			printMessage(resultMessage.getMessage(), Color.RED);
			return;
		}else{
			printMessage(resultMessage.getMessage(), Color.BLUE);
		}

		staffId.setText("");
		barCode.setText("");
		accountNum.setText("");
		moneySum.setText(0+"元");
		while(barCodeTable.getRowCount()!=0)
			barCodeTableModel.removeRow(0);
	}
	private void clear(){
		Date date_=new Date();
		DateFormat format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time=format.format(date_);
		date.setText(time);

		staffId.setText("");
		barCode.setText("");
		accountNum.setText("");
		moneySum.setText(0+"元");
		while(barCodeTable.getRowCount()!=0)
			barCodeTableModel.removeRow(0);
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
